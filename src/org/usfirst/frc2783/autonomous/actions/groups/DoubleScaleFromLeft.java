package org.usfirst.frc2783.autonomous.actions.groups;

import java.util.Arrays;

import org.usfirst.frc2783.autonomous.actions.Action;
import org.usfirst.frc2783.autonomous.actions.ActionGroup;
import org.usfirst.frc2783.autonomous.actions.AutoDrive;
import org.usfirst.frc2783.autonomous.actions.AutoElevator;
import org.usfirst.frc2783.autonomous.actions.AutoIntake;
import org.usfirst.frc2783.autonomous.actions.DriveWithGyroAndByDistance;
import org.usfirst.frc2783.autonomous.actions.GoToTopAction;
import org.usfirst.frc2783.autonomous.actions.ParallelAction;
import org.usfirst.frc2783.autonomous.actions.RotateTankAction;
import org.usfirst.frc2783.robot.Robot;
import org.usfirst.frc2783.util.Bearing;
import org.usfirst.frc2783.util.Logger;

public class DoubleScaleFromLeft extends ActionGroup{

	public DoubleScaleFromLeft(){
		super();
		
		try{
			if(Robot.isScaleLeft()){
//				addAction(new AutoElevator(-0.75, 0.5));
				addAction(new DriveWithGyroAndByDistance(0.8, 19*12, 19*12, 0));
				addAction(new RotateTankAction(new Bearing(305), 1));
//				addAction(new GoToTopAction());
				addAction(new AutoIntake(1, 1));
//				addAction(new AutoElevator(0.5, 3));
				addAction(new RotateTankAction(new Bearing(210), 1));
				addAction(new ParallelAction(Arrays.asList(new Action[] {
					new AutoDrive(0.5, 0.5, 1.3),	
					new AutoIntake(-1, 1.3)
				})));
				addAction(new ParallelAction(Arrays.asList(new Action[] {
					new AutoDrive(-0.5, -0.3, 1.25),	
//					new AutoElevator(-0.5, 1.25)
				})));
				addAction(new RotateTankAction(new Bearing(320), 1));
//				addAction(new GoToTopAction());
				addAction(new AutoDrive(0.4, 0.4, 1));
				addAction(new AutoIntake(0.75, 1));
			}
			else{
				
			}
			
		}
		catch(Exception n){
			Logger.error("Game Data Not Recieved, Crossing Baseline");
        	
			addAction(new AutoDrive(0.5, 0.5, 5));
			
		}
		
	}
	
}