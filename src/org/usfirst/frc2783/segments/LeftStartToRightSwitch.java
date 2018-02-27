package org.usfirst.frc2783.segments;

import java.util.ArrayList;

import org.usfirst.frc2783.autonomous.StaticSetpoints;
import org.usfirst.frc2783.autonomous.paths.Path;
import org.usfirst.frc2783.autonomous.paths.PathBuilder;
import org.usfirst.frc2783.autonomous.paths.PathBuilder.Waypoint;
import org.usfirst.frc2783.autonomous.paths.PathContainer;
import org.usfirst.frc2783.calculation.RigidTransform2d;
import org.usfirst.frc2783.calculation.Rotation2d;

public class LeftStartToRightSwitch implements PathContainer{

	@Override
	public Path buildPath() {
		ArrayList<Waypoint> sWaypoints = new ArrayList<Waypoint>();
		sWaypoints.add(new Waypoint(StaticSetpoints.leftCornerStart, 0, 0));
		sWaypoints.add(new Waypoint(StaticSetpoints.leftOfSwitch, 0, 60));
		sWaypoints.add(new Waypoint(StaticSetpoints.platformLeft, 10, 60));
		sWaypoints.add(new Waypoint(StaticSetpoints.switchCubeRight, 10, 60));
		sWaypoints.add(new Waypoint(StaticSetpoints.switchRight, 0, 60));
		
		return PathBuilder.buildPathFromWaypoints(sWaypoints);
	}

	@Override
	public RigidTransform2d getStartPose() {
		return new RigidTransform2d(StaticSetpoints.leftCornerStart, Rotation2d.fromDegrees(0));
	}

	@Override
	public boolean isReversed() {
		return false;
	}

}