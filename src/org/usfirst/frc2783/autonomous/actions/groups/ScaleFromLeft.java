package org.usfirst.frc2783.autonomous.actions.groups;

import org.usfirst.frc2783.autonomous.actions.ActionGroup;
import org.usfirst.frc2783.autonomous.actions.AutoDrive;
import org.usfirst.frc2783.autonomous.actions.AutoElevator;
import org.usfirst.frc2783.autonomous.actions.AutoIntake;
import org.usfirst.frc2783.autonomous.actions.DriveWithGyroAndByDistance;
import org.usfirst.frc2783.autonomous.actions.GoToTopAction;
import org.usfirst.frc2783.autonomous.actions.RotateTankAction;
import org.usfirst.frc2783.robot.Robot;
import org.usfirst.frc2783.util.Bearing;
import org.usfirst.frc2783.util.Logger;

public class ScaleFromLeft extends ActionGroup{

	public ScaleFromLeft(){
		super();
		
		try{
			if(Robot.isScaleLeft()){
				addAction(new DriveWithGyroAndByDistance(0.5, 25*12, 25*12, 0));
				addAction(new RotateTankAction(new Bearing(270), 1));
				addAction(new AutoElevator(-0.5, 0.5));
				addAction(new AutoDrive(-0.25, -0.25, 0.8));
				addAction(new GoToTopAction());
				addAction(new AutoDrive(0.25, 0.25, 1.2));
				addAction(new AutoIntake(0.75, 1));
			}
			else{
				addAction(new DriveWithGyroAndByDistance(0.5, 18.8*12, 18.8*12, 0));
				addAction(new RotateTankAction(new Bearing(269), 1));
				addAction(new DriveWithGyroAndByDistance(0.5, 36*12, 36*12, 270));
				addAction(new RotateTankAction(new Bearing(0), 1));
				addAction(new GoToTopAction());
				addAction(new AutoDrive(0.3, 0.3, 2));
				addAction(new AutoIntake(0.75, 1));
			}
			
		}
		catch(NullPointerException n){
			Logger.error("Game Data Not Recieved, Crossing Baseline");
        	
			addAction(new AutoDrive(0.5, 0.5, 5));
			
		}
		
	}
	
}