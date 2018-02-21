package org.usfirst.frc2783.autonomous;

import org.usfirst.frc2783.autonomous.actions.ActionGroup;
import org.usfirst.frc2783.autonomous.actions.DriveWithGyro;
import org.usfirst.frc2783.autonomous.actions.RotateTankAction;
import org.usfirst.frc2783.util.Bearing;

public class DriveGyroTest extends ActionGroup{
	
	public DriveGyroTest() {
		super();
		
		addAction(new DriveWithGyro(0.5, 12));
		addAction(new RotateTankAction(new Bearing(315), 5));
		
	}
	
}
