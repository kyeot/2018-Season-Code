package org.usfirst.frc2783.autonomous;

import org.usfirst.frc2783.autonomous.actions.ActionGroup;
import org.usfirst.frc2783.autonomous.actions.AutoDrive;

public class TestAuto extends ActionGroup {
	
	public TestAuto() {
		super();

		addAction(new AutoDrive(0.5, 0.5, 2));
		
//		addAction(new DriveByDistance(-0.5, (21*12)+6, (21*12)+6));
//		addAction(new DriveByDistance(-0.5, 17, -17));
//		addAction(new DriveByDistance(-0.5, (14*12)+6, (14*12)+6));
	}

}