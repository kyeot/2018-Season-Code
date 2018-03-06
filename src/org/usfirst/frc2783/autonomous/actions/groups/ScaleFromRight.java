package org.usfirst.frc2783.autonomous.actions.groups;

import org.usfirst.frc2783.autonomous.actions.ActionGroup;
import org.usfirst.frc2783.autonomous.actions.AutoDrive;
import org.usfirst.frc2783.autonomous.actions.AutoElevator;
import org.usfirst.frc2783.autonomous.actions.AutoIntake;
import org.usfirst.frc2783.autonomous.actions.DriveWithGyroAndByDistance;
import org.usfirst.frc2783.autonomous.actions.RotateTankAction;
import org.usfirst.frc2783.robot.Robot;
import org.usfirst.frc2783.util.Bearing;
import org.usfirst.frc2783.util.Logger;

public class ScaleFromRight extends ActionGroup{

	public ScaleFromRight(){
		super();
		
		try{
			if(!Robot.isScaleLeft()){
				addAction(new DriveWithGyroAndByDistance(0.5, 24.5*12, 24.5*12, 0));
				addAction(new RotateTankAction(new Bearing(90), 1));
				addAction(new AutoDrive(-0.25, -0.25, 0.8));
				addAction(new AutoElevator(-1, 2.7));
				addAction(new AutoDrive(0.25, 0.25, 1.2));
				addAction(new AutoIntake(0.75, 1));
			}
			else{
				addAction(new DriveWithGyroAndByDistance(0.5, 18.8*12, 18.8*12, 0));
				addAction(new RotateTankAction(new Bearing(89), 1));
				addAction(new DriveWithGyroAndByDistance(0.5, 38.5*12, 38.5*12, 270));
				addAction(new AutoDrive(0.5, 0, 0.5));
				addAction(new RotateTankAction(new Bearing(0), 1));
				addAction(new AutoElevator(-1, 2.7));
				addAction(new AutoDrive(0.3, 0.3, 3.5));
				addAction(new AutoIntake(0.75, 1));
			}
			
		}
		catch(NullPointerException n){
			Logger.error("Game Data Not Recieved, Crossing Baseline");
        	
			addAction(new AutoDrive(0.5, 0.5, 5));
		
		}
		
		
		
	}
	
}