package org.usfirst.frc2783.autonomous.actions.groups;

import org.usfirst.frc2783.autonomous.actions.ActionGroup;
import org.usfirst.frc2783.autonomous.actions.DrivePathAction;
import org.usfirst.frc2783.autonomous.paths.PathContainer;
import org.usfirst.frc2783.segments.LeftScaleToLeftStage;

public class WaypointTest extends ActionGroup {
	
	public WaypointTest() {
		super();
		PathContainer testPath = new LeftScaleToLeftStage();
		addAction(new DrivePathAction(testPath, "Test"));
	}
	
}
