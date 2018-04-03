package org.usfirst.frc2783.autonomous.actions.groups;

import org.usfirst.frc2783.autonomous.actions.ActionGroup;
import org.usfirst.frc2783.autonomous.actions.DrivePathAction;
import org.usfirst.frc2783.autonomous.paths.PathContainer;
import org.usfirst.frc2783.autonomous.paths.toNodeAndBackTest;

public class WaypointTest extends ActionGroup {
	public WaypointTest() {
		super();
		PathContainer testPath = new toNodeAndBackTest();
		addAction(new DrivePathAction(testPath));
	}
}
