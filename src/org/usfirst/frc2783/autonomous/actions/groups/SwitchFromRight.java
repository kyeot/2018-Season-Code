package org.usfirst.frc2783.autonomous.actions.groups;

import java.util.Arrays;

import org.usfirst.frc2783.autonomous.actions.Action;
import org.usfirst.frc2783.autonomous.actions.ActionGroup;
import org.usfirst.frc2783.autonomous.actions.AutoDrive;
import org.usfirst.frc2783.autonomous.actions.AutoElevator;
import org.usfirst.frc2783.autonomous.actions.AutoIntake;
import org.usfirst.frc2783.autonomous.actions.DriveWithGyroAndByDistance;
import org.usfirst.frc2783.autonomous.actions.ParallelAction;
import org.usfirst.frc2783.autonomous.actions.RotateTankAction;
import org.usfirst.frc2783.robot.Robot;
import org.usfirst.frc2783.util.Bearing;
import org.usfirst.frc2783.util.Logger;

public class SwitchFromRight extends ActionGroup {
	
	public SwitchFromRight() {
		super();
			
		try{
			if(Robot.switchAutoIsFront){
				if(!Robot.isSwitchesLeft()){
					addAction(new AutoElevator(-0.5, 0.5)); //Lower elevator
					addAction(new DriveWithGyroAndByDistance(0.5, 12.5*12, 12.5*12, 0)); // Drive foward at 0.5 speed
					addAction(new RotateTankAction(new Bearing(90), 1)); 
					addAction(new AutoIntake(-0.5, 0.5));
					addAction(new AutoElevator(-1, 1)); 
					addAction(new AutoDrive(0.25, 0.25, 1));
					addAction(new AutoIntake(0.75, 1));
				}
				else{
					addAction(new AutoElevator(-0.5, 0.5));
					addAction(new DriveWithGyroAndByDistance(0.5, 4.8*12, 4.8*12, 0));
					addAction(new RotateTankAction(new Bearing(95), 1));
					addAction(new DriveWithGyroAndByDistance(0.5, 21*12, 21*12, 270));
					addAction(new RotateTankAction(new Bearing(0), 1));
					addAction(new AutoElevator(-1, 1.5)); 
					addAction(new AutoDrive(0.5, 0.5, 2.5));
					addAction(new AutoIntake(0.75, 1));
				}
			}
			else{
				if(!Robot.isSwitchesLeft()){		
					addAction(new AutoElevator(-0.5, 0.5));
					addAction(new DriveWithGyroAndByDistance(0.5, 12.5*12, 12.5*12, 0));
					addAction(new ParallelAction(Arrays.asList(new Action[] {
						new RotateTankAction(new Bearing(90), 1),
						new AutoIntake(-0.2, 1)
					})));
						
					addAction(new AutoElevator(-1, 1)); 
					addAction(new AutoDrive(0.3, 0.3, 1));
					addAction(new AutoIntake(1, 1));
				}
				
				else{
					addAction(new AutoElevator(-0.75, 0.5));
					addAction(new DriveWithGyroAndByDistance(0.5, 18.8*12, 18.8*12, 0));
					addAction(new RotateTankAction(new Bearing(88), 1));
					addAction(new DriveWithGyroAndByDistance(0.55, 37.5*12, 37.5*12, 88));
					addAction(new RotateTankAction(new Bearing(80), 1));
					addAction(new AutoDrive(0.5, 0.5, 1));
					addAction(new AutoElevator(-0.75, 0.5));
					
					addAction(new ParallelAction(Arrays.asList(new Action[] {
						new RotateTankAction(new Bearing(270), 1),
						new AutoIntake(-0.2, 1)
					})));
					
					addAction(new AutoDrive(0.4, 0.3, 1));
					addAction(new AutoIntake(0.75, 1));
				}
			}
			
		}
		catch(Exception n){
			Logger.error("Game Data Not Recieved, Crossing Baseline");
        	
			addAction(new AutoDrive(0.5, 0.5, 5));
		
		}
		
	}

}