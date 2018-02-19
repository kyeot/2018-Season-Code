package org.usfirst.frc2783.autonomous;

import org.usfirst.frc2783.autonomous.actions.ActionGroup;
import org.usfirst.frc2783.autonomous.actions.AutoElevator;
import org.usfirst.frc2783.autonomous.actions.AutoIntake;
import org.usfirst.frc2783.autonomous.actions.DriveWithGyroAndByDistance;
import org.usfirst.frc2783.autonomous.actions.RotateTankAction;
import org.usfirst.frc2783.util.Bearing;

public class SwitchFromLeft extends ActionGroup{
	
	public SwitchFromLeft() {
		super();
		
		addAction(new DriveWithGyroAndByDistance(0.5, 120, 120));
		addAction(new RotateTankAction(new Bearing(290), 3));
		
		addAction(new AutoElevator(-1, 1));
		addAction(new AutoIntake(0.75, 1));
		
	}
	
}