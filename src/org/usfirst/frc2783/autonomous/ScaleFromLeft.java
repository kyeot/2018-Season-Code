package org.usfirst.frc2783.autonomous;

import org.usfirst.frc2783.autonomous.actions.ActionGroup;
import org.usfirst.frc2783.autonomous.actions.AutoElevator;
import org.usfirst.frc2783.autonomous.actions.AutoIntake;
import org.usfirst.frc2783.autonomous.actions.DriveWithGyroAndByDistance;
import org.usfirst.frc2783.autonomous.actions.RotateTankAction;
import org.usfirst.frc2783.util.Bearing;

public class ScaleFromLeft extends ActionGroup{

	public ScaleFromLeft(){
		super();

		addAction(new AutoElevator(-0.5, 0.5));
		addAction(new DriveWithGyroAndByDistance(0.5, 23*12, 23*12));
		addAction(new RotateTankAction(new Bearing(280), 4));
		addAction(new AutoElevator(-1, 2.5));
		addAction(new AutoIntake(1, 1));
		
	}
	
}
