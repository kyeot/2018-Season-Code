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

public class ScaleFromLeftFarOut extends ActionGroup{

	public ScaleFromLeftFarOut(){
		super();
		
		try{
			if(Robot.isScaleLeft()){
				addAction(new AutoElevator(-0.8, 0.5));
				addAction(new DriveWithGyroAndByDistance(0.65, 25*12, 25*12, 0));
				addAction(new RotateTankAction(new Bearing(270), 1));
				addAction(new AutoDrive(-0.25, -0.25, 1.2));
				addAction(new GoToTopAction());
				addAction(new AutoDrive(0.25, 0.25, 1.6));
				addAction(new AutoIntake(1, 1));
				addAction(new AutoDrive(-0.2, -0.2, 1.2));
			}
			else{
				
				if(Robot.isSwitchesLeft()){
					addAction(new AutoElevator(-0.5, 0.5));
					addAction(new DriveWithGyroAndByDistance(0.5, 12.5*12, 12.5*12, 0));
					addAction(new ParallelAction(Arrays.asList(new Action[] {
						new RotateTankAction(new Bearing(270), 1),
						new AutoIntake(-0.2, 1)
					})));
						
					addAction(new AutoElevator(-1, 1)); 
					addAction(new AutoDrive(0.3, 0.3, 1));
					addAction(new AutoIntake(1, 1));
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