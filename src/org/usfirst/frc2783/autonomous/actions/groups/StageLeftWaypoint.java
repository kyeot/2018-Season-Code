package org.usfirst.frc2783.autonomous.actions.groups;

import org.usfirst.frc2783.autonomous.actions.ActionGroup;
import org.usfirst.frc2783.autonomous.actions.DrivePathAction;
import org.usfirst.frc2783.autonomous.paths.PathContainer;
import org.usfirst.frc2783.segments.StageLeft;;

public class StageLeftWaypoint extends ActionGroup {
	
	public StageLeftWaypoint() {
		super();
		PathContainer testPath = new StageLeft();
		addAction(new DrivePathAction(testPath, "Test"));
		//SmartDashboard.putString("DB/String 1", "Hi");
	}
	
}

