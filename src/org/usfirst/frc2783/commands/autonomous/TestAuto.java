package org.usfirst.frc2783.commands.autonomous;

import org.usfirst.frc2783.commands.autonomous.actions.ActionGroup;
import org.usfirst.frc2783.commands.autonomous.actions.AutoDrive;
import org.usfirst.frc2783.commands.autonomous.actions.DriveByDistance;

public class TestAuto extends ActionGroup {
	
	public TestAuto() {
		super();
		
		addAction(new DriveByDistance(0.5, 20, 20));
	}

}