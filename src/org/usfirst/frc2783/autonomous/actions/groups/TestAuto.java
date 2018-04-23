package org.usfirst.frc2783.autonomous.actions.groups;

import org.usfirst.frc2783.autonomous.actions.ActionGroup;
import org.usfirst.frc2783.autonomous.actions.DriveWithGyroAndByDistance;

public class TestAuto extends ActionGroup {
	
	public TestAuto() {
		super();
		
		addAction(new DriveWithGyroAndByDistance(0.8, 300, 300, 0));
		
	}

}