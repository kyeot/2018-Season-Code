package org.usfirst.frc2783.autonomous.actions.groups;

import org.usfirst.frc2783.autonomous.actions.ActionGroup;
import org.usfirst.frc2783.autonomous.actions.AutoDrive;
import org.usfirst.frc2783.autonomous.actions.AutoElevator;
import org.usfirst.frc2783.autonomous.actions.AutoIntake;
import org.usfirst.frc2783.autonomous.actions.DriveWithGyroAndByDistance;
import org.usfirst.frc2783.autonomous.actions.RotateTankAction;
import org.usfirst.frc2783.robot.Robot;
import org.usfirst.frc2783.util.Bearing;

public class SwitchFromLeft extends ActionGroup{
	
	public SwitchFromLeft() {
		super();
		
		try{
			if(Robot.isSwitchesLeft()){		
				addAction(new DriveWithGyroAndByDistance(0.5, 13*12, 13*12, 0));
				addAction(new RotateTankAction(new Bearing(270), 4));
				addAction(new AutoElevator(-0.75, 0.75));
				addAction(new AutoDrive(0.25, 0.25, 2));
				addAction(new AutoIntake(0.75, 1));
			}
			else{
				addAction(new DriveWithGyroAndByDistance(0.5, 5*12, 5*12, 0));
				addAction(new RotateTankAction(new Bearing(270), 4));
				addAction(new DriveWithGyroAndByDistance(0.5, 21*12, 21*12, 270));
				addAction(new RotateTankAction(new Bearing(0), 4));
				addAction(new AutoElevator(-0.75, 0.75));
				addAction(new AutoDrive(0.4, 0.4, 3));
				addAction(new AutoIntake(0.75, 1));
			}
			
		}
		catch(NullPointerException n) {
			addAction(new AutoDrive(0.5, 0.5, 5));
		}
		
	}
	
}