package org.usfirst.frc2783.autonomous.actions.groups;

import org.usfirst.frc2783.autonomous.actions.ActionGroup;
import org.usfirst.frc2783.autonomous.actions.DrivePathAction;
import org.usfirst.frc2783.autonomous.paths.PathContainer;
import org.usfirst.frc2783.segments.StageRight;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class StageRightWaypoint extends ActionGroup {
	
	public StageRightWaypoint() {
		super();
		PathContainer testPath = new StageRight();
		addAction(new DrivePathAction(testPath, "Test"));
		//SmartDashboard.putString("DB/String 1", "Hi");
	}
	
}
