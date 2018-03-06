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

public class SwitchFromCenter extends ActionGroup{

	public SwitchFromCenter(){
		super();
		
		try{
			if(Robot.isSwitchesLeft()){
				addAction(new DriveWithGyroAndByDistance(0.5, 4*12, 4*12, 0));
				addAction(new RotateTankAction(new Bearing(90), 1));
				addAction(new DriveWithGyroAndByDistance(0.5, 10*12, 10*12, 90));
				addAction(new RotateTankAction(new Bearing(0), 1));
				addAction(new AutoElevator(-1, 1.25));
				addAction(new AutoDrive(0.5, 0.5, 1.5));
				addAction(new AutoIntake(1, 1));
			}
			else{
				addAction(new DriveWithGyroAndByDistance(0.5, 4*12, 4*12, 0));
				addAction(new RotateTankAction(new Bearing(270), 1));
				addAction(new DriveWithGyroAndByDistance(0.5, 10*12, 10*12, 270));
				addAction(new RotateTankAction(new Bearing(0), 1));
				addAction(new AutoElevator(-1, 1.25));
				addAction(new AutoDrive(0.5, 0.5, 1.5));
				addAction(new AutoIntake(1, 1));
			}
			
		}
		catch(NullPointerException n){
			Logger.error("Game Data Not Recieved, Crossing Baseline");
        	
			addAction(new AutoDrive(0.5, 0.5, 5));
		
		}
		
		
		
	}
	
}
