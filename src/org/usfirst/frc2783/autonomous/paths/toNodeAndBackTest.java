package org.usfirst.frc2783.autonomous.paths;

import java.util.ArrayList;

import org.usfirst.frc2783.autonomous.StaticSetpoints;
import org.usfirst.frc2783.autonomous.paths.PathBuilder.Waypoint;
import org.usfirst.frc2783.calculation.RigidTransform2d;
import org.usfirst.frc2783.calculation.Rotation2d;

public class toNodeAndBackTest implements PathContainer {
	

	@Override
	public Path buildPath() {
		ArrayList<Waypoint> sWaypoints = new ArrayList<Waypoint>();
		sWaypoints.add(new Waypoint(StaticSetpoints.leftOfSwitch, 0, 10));
		sWaypoints.add(new Waypoint(StaticSetpoints.leftCornerStart, 0, 10));
		
		return PathBuilder.buildPathFromWaypoints(sWaypoints);
	}

	@Override
	public RigidTransform2d getStartPose() {
		return new RigidTransform2d(StaticSetpoints.leftCornerStart, Rotation2d.fromDegrees(0));
	}

	@Override
	public boolean isReversed() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
