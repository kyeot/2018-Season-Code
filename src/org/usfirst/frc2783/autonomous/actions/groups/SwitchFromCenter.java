package org.usfirst.frc2783.autonomous.actions.groups;

import java.util.Arrays;

import org.usfirst.frc2783.autonomous.actions.Action;
import org.usfirst.frc2783.autonomous.actions.ActionGroup;
import org.usfirst.frc2783.autonomous.actions.AutoDrive;
import org.usfirst.frc2783.autonomous.actions.AutoElevator;
import org.usfirst.frc2783.autonomous.actions.AutoIntake;
import org.usfirst.frc2783.autonomous.actions.DriveWithGyro;
import org.usfirst.frc2783.autonomous.actions.DriveWithGyroAndByDistance;
import org.usfirst.frc2783.autonomous.actions.ParallelAction;
import org.usfirst.frc2783.autonomous.actions.RotateTankAction;
import org.usfirst.frc2783.robot.Robot;
import org.usfirst.frc2783.util.Bearing;
import org.usfirst.frc2783.util.Logger;

public class SwitchFromCenter extends ActionGroup{

	public SwitchFromCenter(){
		super();
		
		try{
			if(Robot.isSwitchesLeft()){
				addAction(new AutoElevator(-0.5, 0.5));
				addAction(new DriveWithGyroAndByDistance(0.5, 3.5*12, 3.5*12, 0));
				
				addAction(new ParallelAction(Arrays.asList(new Action[] {
					new RotateTankAction(new Bearing(90), 1),
					new AutoIntake(-0.2, 1)
				})));
				
				addAction(new DriveWithGyroAndByDistance(0.5, 10*12, 10*12, 90));
				
				addAction(new ParallelAction(Arrays.asList(new Action[] {
					new RotateTankAction(new Bearing(0), 1),
					new AutoIntake(-0.2, 1)
				})));
				
				addAction(new ParallelAction(Arrays.asList(new Action[] {
					new AutoElevator(-0.6, 2),
					new DriveWithGyro(0.5, 2)
				})));
				
				addAction(new AutoIntake(1, 1));
		 	}
			else{
				addAction(new AutoElevator(-0.5, 0.5));
				addAction(new DriveWithGyroAndByDistance(0.5, 3.5*12, 3.5*12, 0));
				
				addAction(new ParallelAction(Arrays.asList(new Action[] {
					new RotateTankAction(new Bearing(270), 1),
					new AutoIntake(-0.2, 1)
				})));
				
				addAction(new DriveWithGyroAndByDistance(0.5, 9.2*12, 9.2*12, 270));
				
				addAction(new ParallelAction(Arrays.asList(new Action[] {
					new RotateTankAction(new Bearing(0), 1),
					new AutoIntake(-0.2, 1)
				})));
				
				addAction(new ParallelAction(Arrays.asList(new Action[] {
					new AutoElevator(-0.6, 2),
					new DriveWithGyro(0.5, 2)
				})));
				
				addAction(new AutoIntake(1, 1));
			}
			
		}
		catch(Exception n){
			Logger.error("Game Data Not Recieved, Crossing Baseline");
        	
			addAction(new AutoDrive(0.5, 0.5, 5));
		
		}
		
		
		
	}
	
}
