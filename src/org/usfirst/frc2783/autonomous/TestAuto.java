package org.usfirst.frc2783.autonomous;

import org.usfirst.frc2783.autonomous.actions.ActionGroup;
import org.usfirst.frc2783.autonomous.actions.DriveWithGyroAndByDistance;

public class TestAuto extends ActionGroup {
	
	public TestAuto() {
		super();
		
		addAction(new DriveWithGyroAndByDistance(0.5, 100, 100));
		
	}

}