package org.usfirst.frc2783.autonomous.actions.groups;

import java.util.Arrays;

import org.usfirst.frc2783.autonomous.actions.Action;
import org.usfirst.frc2783.autonomous.actions.ActionGroup;
import org.usfirst.frc2783.autonomous.actions.AutoElevator;
import org.usfirst.frc2783.autonomous.actions.DrivePathAction;
import org.usfirst.frc2783.autonomous.actions.ParallelAction;
import org.usfirst.frc2783.autonomous.paths.PathContainer;
import org.usfirst.frc2783.segments.LeftStartToRightScale;
import org.usfirst.frc2783.segments.StageLeft;

public class WaypointTest extends ActionGroup {
	public WaypointTest() {
		super();
		PathContainer testPath = new StageLeft();
		addAction(new DrivePathAction(new LeftStartToRightScale()));
		
	}
}
