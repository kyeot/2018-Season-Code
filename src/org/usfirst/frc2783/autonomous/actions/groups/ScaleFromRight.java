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

public class ScaleFromRight extends ActionGroup{

	public ScaleFromRight(){
		super();
		
		try{
			if(!Robot.isScaleLeft()){
				addAction(new AutoElevator(-0.8, 0.5));
				addAction(new DriveWithGyroAndByDistance(0.65, 19.5*12, 19.5*12, 0));
				addAction(new RotateTankAction(new Bearing(55), 1));
				addAction(new GoToTopAction());
				addAction(new AutoDrive(0.25, 0.25, 1.5));
				addAction(new AutoIntake(1, 1));
				addAction(new AutoDrive(-0.2, -0.2, 1.2));
			}
			else{
				
				if(Robot.scaleAutoWillFar){
					addAction(new AutoElevator(-0.75, 0.5));
					addAction(new DriveWithGyroAndByDistance(0.5, 18.8*12, 18.8*12, 0));
					addAction(new ParallelAction(Arrays.asList(new Action[] {
						new RotateTankAction(new Bearing(88), 1),
						new AutoIntake(-0.2, 1)
					})));
					addAction(new DriveWithGyroAndByDistance(0.5, 35*12, 35*12, 88));
					addAction(new ParallelAction(Arrays.asList(new Action[] {
						new RotateTankAction(new Bearing(0), 1),
						new AutoIntake(-0.2, 1)
					})));
					addAction(new GoToTopAction());
					addAction(new AutoDrive(0.45, 0.55, 1.2));
					addAction(new AutoIntake(0.75, 1));
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