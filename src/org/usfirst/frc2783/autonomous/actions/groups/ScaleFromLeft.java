package org.usfirst.frc2783.autonomous.actions.groups;

import org.usfirst.frc2783.autonomous.actions.ActionGroup;
import org.usfirst.frc2783.autonomous.actions.AutoDrive;
import org.usfirst.frc2783.autonomous.actions.AutoElevator;
import org.usfirst.frc2783.autonomous.actions.AutoIntake;
import org.usfirst.frc2783.autonomous.actions.DriveWithGyro;
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
				addAction(new AutoElevator(-0.8, 0.5));
				addAction(new DriveWithGyroAndByDistance(0.65, 25*12, 25*12, 0));
				addAction(new RotateTankAction(new Bearing(270), 1));
				addAction(new AutoDrive(-0.25, -0.25, 1.2));
				addAction(new GoToTopAction());
				addAction(new AutoDrive(0.25, 0.25, 1.6));
				addAction(new AutoIntake(0.75, 1));
				addAction(new AutoDrive(-0.2, -0.2, 1.2));
			}
			else{
				addAction(new AutoElevator(-0.75, 0.5));
				addAction(new DriveWithGyroAndByDistance(0.5, 18.77*12, 18.77*12, 0));
				addAction(new RotateTankAction(new Bearing(276), 1));
				addAction(new DriveWithGyroAndByDistance(0.5, 36*12, 36*12, 276));
				addAction(new RotateTankAction(new Bearing(5), 1));
				addAction(new GoToTopAction());
				addAction(new AutoDrive(0.32, 0.62, 1));
				addAction(new AutoIntake(0.6, 1));
				addAction(new AutoDrive(-0.2, -0.2, 1.2));
			}
			
		}
		catch(Exception n){
			Logger.error("Game Data Not Recieved, Crossing Baseline");
        	
			addAction(new AutoDrive(0.5, 0.5, 5));
			
		}
		
	}
	
}