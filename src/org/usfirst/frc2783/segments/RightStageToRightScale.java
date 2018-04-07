package org.usfirst.frc2783.segments;

import java.util.ArrayList;

import org.usfirst.frc2783.autonomous.StaticSetpoints;
import org.usfirst.frc2783.autonomous.paths.Path;
import org.usfirst.frc2783.autonomous.paths.PathBuilder;
import org.usfirst.frc2783.autonomous.paths.PathBuilder.Waypoint;
import org.usfirst.frc2783.autonomous.paths.PathContainer;
import org.usfirst.frc2783.calculation.RigidTransform2d;
import org.usfirst.frc2783.calculation.Rotation2d;

public class RightStageToRightScale implements PathContainer{

	@Override
	public Path buildPath() {
		ArrayList<Waypoint> sWaypoints = new ArrayList<Waypoint>();
		sWaypoints.add(new Waypoint(StaticSetpoints.rightOfSwitch, 0, 0));
		sWaypoints.add(new Waypoint(StaticSetpoints.platformRight, 10, 60));
		sWaypoints.add(new Waypoint(StaticSetpoints.preScaleRight, 10, 60));
		sWaypoints.add(new Waypoint(StaticSetpoints.scaleRight, 0, 60));
		
		return PathBuilder.buildPathFromWaypoints(sWaypoints);
	}

	@Override
	public RigidTransform2d getStartPose() {
		return new RigidTransform2d(StaticSetpoints.rightOfSwitch, Rotation2d.fromDegrees(0));
	}

	@Override
	public boolean isReversed() {
		return false;
	}

}