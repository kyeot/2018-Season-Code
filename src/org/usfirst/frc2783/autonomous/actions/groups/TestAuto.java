package org.usfirst.frc2783.autonomous.actions.groups;

import org.usfirst.frc2783.autonomous.actions.ActionGroup;
import org.usfirst.frc2783.autonomous.actions.DriveWithGyroAndByDistance;
import org.usfirst.frc2783.autonomous.actions.RotateTankAction;
import org.usfirst.frc2783.util.Bearing;

public class TestAuto extends ActionGroup {
	
	public TestAuto() {
		super();
		
		addAction(new DriveWithGyroAndByDistance(0.5, 180, 180, 0));
		addAction(new RotateTankAction(new Bearing(0), 2));
		
	}

}