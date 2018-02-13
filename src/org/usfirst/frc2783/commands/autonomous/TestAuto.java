package org.usfirst.frc2783.commands.autonomous;

import org.usfirst.frc2783.commands.autonomous.actions.ActionGroup;
import org.usfirst.frc2783.commands.autonomous.actions.AutoDrive;
import org.usfirst.frc2783.commands.autonomous.actions.DriveByDistance;
import org.usfirst.frc2783.commands.autonomous.actions.DriveForwardByDistance;

public class TestAuto extends ActionGroup {
	
	public TestAuto() {
		super();
		
		//1 = 3 inches
		addAction(new DriveByDistance(-0.5, 50, 50));
	}

}