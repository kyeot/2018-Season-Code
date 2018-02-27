package org.usfirst.frc2783.autonomous.paths;

import org.usfirst.frc2783.autonomous.actions.WaitForPathMarkerAction;
import org.usfirst.frc2783.autonomous.paths.Path;
import org.usfirst.frc2783.autonomous.paths.PathSegment;
import org.usfirst.frc2783.calculation.RigidTransform2d;
import org.usfirst.frc2783.calculation.Rotation2d;
import org.usfirst.frc2783.calculation.Translation2d;

import java.util.List;

/**
 * Class used to convert a list of Waypoints into a Path object consisting of arc and line PathSegments
 * 
 * @see Waypoint
 * @see Path
 * @see PathSegment
 */
public class PathBuilder {
    private static final double kEpsilon = 1E-9;
    private static final double kReallyBigNumber = 1E9;
    
    /**
     * Takes a list of waypoints and converts them into
     * a buiult path
     * 
     * @param w
     * @return Path created by list w
     */
    public static Path buildPathFromWaypoints(List<Waypoint> w) {
        Path p = new Path();
        
        //Makes sure path has enough waypoints
        if (w.size() < 2) {
            throw new Error("Path must contain at least 2 waypoints");
        }
        
        //Uses index i to create curved path
        int i = 0;
        if (w.size() > 2) {
        	
        	/*
        	 * Loops through list of waypoints and creates an arc
        	 * out of every three points
        	 */
            do {
                new Arc(getPoint(w, i), getPoint(w, i + 1), getPoint(w, i + 2)).addToPath(p);
                i++;
            } while (i < w.size() - 2);
        }
        
        //Creates line at the end with leftover points
        new Line(w.get(w.size() - 2), w.get(w.size() - 1)).addToPath(p, 0);
        p.extrapolateLast();
        p.verifySpeeds();
        // System.out.println(p);
        return p;
    }
    
    /**
     * This method accesses waypoints in a list of waypoints
     * with a given index of i
     * 
     * @param w
     * @param i
     * @return Waypoint requested at index i
     */
    private static Waypoint getPoint(List<Waypoint> w, int i) {
        if (i > w.size())
            return w.get(w.size() - 1);
        return w.get(i);
    }
    
    /**
     * Creates a setpoint with location x, y
     * 
     * @author Adam Ma
     * @version 02/21/2018
     */
    public static class Setpoint {
    	
    	Translation2d position;
    	
    	public Setpoint(Translation2d position) {
    		
    		this.position = position;
    		
    	}
    	public Setpoint(double x, double y) {
    		position = new Translation2d(x, y);
    	}
    	
    	public Translation2d getPosition(Setpoint s) {
    		return position;
    	}
    	
    }
    
    /**
     * A waypoint along a path. Contains a position, radius (for creating curved paths), and speed. The information from
     * these waypoints is used by the PathBuilder class to generate Paths. Waypoints also contain an optional marker
     * that is used by the WaitForPathMarkerAction.
     *
     * @see PathBuilder
     * @see WaitForPathMarkerAction
     */
    public static class Waypoint extends Setpoint {
        
        double radius;
        double speed;
        String marker;

        public Waypoint(Waypoint other) {
            this(other.position.x(), other.position.y(), other.radius, other.speed, other.marker);
        }

        public Waypoint(double x, double y, double r, double s) {
            super(new Translation2d(x, y));
            radius = r;
            speed = s;
        }

        public Waypoint(Translation2d pos, double r, double s) {
            super(pos);
            radius = r;
            speed = s;
        }

        public Waypoint(double x, double y, double r, double s, String m) {
        	super(new Translation2d(x, y));
            radius = r;
            speed = s;
            marker = m;
        }
        
        public Waypoint setpointToWaypoint(Setpoint point, double r, double s) {
        	return new Waypoint(getPosition(point), r, s);
        }
    }

    /**
     * A Line object is formed by two Waypoints. Contains a start and end position, slope, and speed.
     */
    static class Line {
        Waypoint a;
        Waypoint b;
        Translation2d start;
        Translation2d end;
        Translation2d slope;
        double speed;
        
        /**
         * Constructs a line with 2 given waypoints
         * 
         * @param a
         * @param b
         */
        public Line(Waypoint a, Waypoint b) {
            this.a = a;
            this.b = b;
            slope = new Translation2d(a.position, b.position);
            speed = b.speed;
            start = a.position.translateBy(slope.scale(a.radius / slope.norm()));
            end = b.position.translateBy(slope.scale(-b.radius / slope.norm()));
        }
        
        /**
         * Adds line to path p with a given end speed
         * 
         * @param p
         * @param endSpeed
         */
        void addToPath(Path p, double endSpeed) {
            double pathLength = new Translation2d(end, start).norm();
            if (pathLength > kEpsilon) {
                if (b.marker != null) {
                    p.addSegment(new PathSegment(start.x(), start.y(), end.x(), end.y(), b.speed,
                            p.getLastMotionState(), endSpeed, b.marker));
                } else {
                    p.addSegment(new PathSegment(start.x(), start.y(), end.x(), end.y(), b.speed,
                            p.getLastMotionState(), endSpeed));
                }
            }

        }
    }

    /**
     * An Arc object is formed by two Lines that share a common Waypoint. Contains a center position, radius, and speed.
     */
    static class Arc {
        Line a;
        Line b;
        Translation2d center;
        double radius;
        double speed;

        public Arc(Waypoint a, Waypoint b, Waypoint c) {
            this(new Line(a, b), new Line(b, c));
        }

        public Arc(Line a, Line b) {
            this.a = a;
            this.b = b;
            this.speed = (a.speed + b.speed) / 2;
            this.center = intersect(a, b);
            this.radius = new Translation2d(center, a.end).norm();
        }

        private void addToPath(Path p) {
            a.addToPath(p, speed);
            if (radius > kEpsilon && radius < kReallyBigNumber) {
                p.addSegment(new PathSegment(a.end.x(), a.end.y(), b.start.x(), b.start.y(), center.x(), center.y(),
                        speed, p.getLastMotionState(), b.speed));
            }
        }

        private static Translation2d intersect(Line l1, Line l2) {
            final RigidTransform2d lineA = new RigidTransform2d(l1.end, new Rotation2d(l1.slope, true).normal());
            final RigidTransform2d lineB = new RigidTransform2d(l2.start, new Rotation2d(l2.slope, true).normal());
            return lineA.intersection(lineB);
        }
    }
}
