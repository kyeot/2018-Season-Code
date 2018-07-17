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
				
				addAction(new AutoElevator(-0.5, 0.5));
				addAction(new DriveWithGyroAndByDistance(0.8, 19*12, 19*12, 0));
				addAction(new RotateTankAction(new Bearing(305), 1));
				addAction(new GoToTopAction());
				addAction(new AutoDrive(0.3, 0.3, 0.5));
				addAction(new AutoIntake(1, 1));
				addAction(new AutoElevator(1, 1.5));
				addAction(new RotateTankAction(new Bearing(211), 1));
				addAction(new ParallelAction(Arrays.asList(new Action[] {
					new AutoDrive(0.4, 0.35, 2.5),	
					new AutoIntake(-0.8, 2.5)
				})));
				addAction(new AutoElevator(-0.5, 0.5));	
				addAction(new ParallelAction(Arrays.asList(new Action[] {
					new AutoDrive(-0.5, -0.5, 0.5),
				})));
				addAction(new ParallelAction(Arrays.asList(new Action[] {
					new RotateTankAction(new Bearing(340), 1),
					new AutoIntake(-0.2, 1)
				})));
				
				addAction(new AutoElevator(-1, 1.65));
				addAction(new AutoDrive(0.4, 0.37, 1.5));
				
				addAction(new AutoIntake(1, 1));
				addAction(new AutoDrive(-0.4, -0.4, 1.5));
				
			}
			else{
				if(Robot.scaleAutoWillFar){
					addAction(new AutoElevator(-0.75, 0.5));
					addAction(new DriveWithGyroAndByDistance(0.5, 18.8*12, 18.8*12, 0));
					addAction(new ParallelAction(Arrays.asList(new Action[] {
						new RotateTankAction(new Bearing(272), 1),
						new AutoIntake(-0.2, 1)
					})));
					addAction(new DriveWithGyroAndByDistance(0.5, 35*12, 35*12, 272));
					addAction(new ParallelAction(Arrays.asList(new Action[] {
						new RotateTankAction(new Bearing(15), 1),
						new AutoIntake(-0.2, 1)
					})));
					addAction(new GoToTopAction());
					addAction(new AutoDrive(0.45, 0.45, 1.2));
					addAction(new AutoIntake(0.65, 1));
					addAction(new AutoDrive(-0.2, -0.2, 1.2));
				}
				else{
					addAction(new DriveWithGyroAndByDistance(0.5, 13*12, 13*12, 0));
				}
					
			}
			
		}
		catch(Exception n){
			Logger.error("Game Data Not Recieved, Crossing Baseline");
        	
			addAction(new AutoDrive(0.5, 0.5, 5));
			
		}
		
	}
	
}