package org.usfirst.frc2783.autonomous.actions.groups;

import org.usfirst.frc2783.autonomous.actions.ActionGroup;
import org.usfirst.frc2783.autonomous.actions.AutoElevator;
import org.usfirst.frc2783.autonomous.actions.AutoIntake;
import org.usfirst.frc2783.autonomous.actions.DriveWithGyroAndByDistance;
import org.usfirst.frc2783.autonomous.actions.RotateTankAction;
import org.usfirst.frc2783.robot.Robot;
import org.usfirst.frc2783.util.Bearing;

public class ScaleFromRight extends ActionGroup{

	public ScaleFromRight(){
		super();
		
		if(Robot.scaleVal == "R"){
			addAction(new DriveWithGyroAndByDistance(0.5, 24*12, 24*12, 0));
			addAction(new RotateTankAction(new Bearing(80), 3));
			addAction(new DriveWithGyroAndByDistance(0.5, 36, 36, 270));
			addAction(new AutoElevator(-1, 2.5));
			addAction(new AutoIntake(0.75, 1));
		}
		else if(Robot.scaleVal == "R"){
			addAction(new DriveWithGyroAndByDistance(0.5, 17*12, 17*12, 0));
			addAction(new RotateTankAction(new Bearing(90), 3));
			addAction(new DriveWithGyroAndByDistance(0.5, 17*12, 17*12, 270));
			addAction(new RotateTankAction(new Bearing(0), 3));
			addAction(new DriveWithGyroAndByDistance(0.5, 24, 24, 0));
			addAction(new AutoElevator(-1, 2.5));
			addAction(new AutoIntake(0.75, 1));
		}
		else{
			addAction(new DriveWithGyroAndByDistance(0.5, 12*12, 12*12, 0));
		}
		
	}
	
}