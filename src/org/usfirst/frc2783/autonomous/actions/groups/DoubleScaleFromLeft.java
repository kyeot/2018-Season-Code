package org.usfirst.frc2783.autonomous.actions.groups;

import java.util.Arrays;

import org.usfirst.frc2783.autonomous.actions.Action;
import org.usfirst.frc2783.autonomous.actions.ActionGroup;
import org.usfirst.frc2783.autonomous.actions.AutoDrive;
import org.usfirst.frc2783.autonomous.actions.AutoElevator;
import org.usfirst.frc2783.autonomous.actions.AutoIntake;
import org.usfirst.frc2783.autonomous.actions.DriveWithGyro;
import org.usfirst.frc2783.autonomous.actions.DriveWithGyroAndByDistance;
import org.usfirst.frc2783.autonomous.actions.GoToTopAction;
import org.usfirst.frc2783.autonomous.actions.ParallelAction;
import org.usfirst.frc2783.autonomous.actions.RotateTankAction;
import org.usfirst.frc2783.autonomous.actions.WaitForEndTandem;
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
					new RotateTankAction(new Bearing(344), 1),
					new AutoIntake(-0.2, 1)
				})));
				addAction(new AutoElevator(-1, 1.75));
				addAction(new AutoDrive(0.4, 0.37, 1.5));
				addAction(new AutoIntake(0.75, 1));
				
//				addTandemAction(new AutoElevator(-0.5, 0.5));
////				addAction(new WaitForEndTandem(true));
//				addAction(new DriveWithGyroAndByDistance(0.8, 19*12, 19*12, 0));
//				addTandemAction(new AutoIntake(-.25, 1));
//				addAction(new RotateTankAction(new Bearing(300), 1));
//				addTandemAction(new GoToTopAction());
//				addAction(new AutoDrive(-0.4, -0.4, 0.25));
////				addAction(new GoToTopAction());
//				addAction(new AutoDrive(0.3, 0.3, 1));
//				addAction(new AutoIntake(1, 1));
//				addTandemAction(new AutoElevator(1, 1.5));
//				addAction(new AutoDrive(-0.3, -0.3, 0.25));
//				addAction(new RotateTankAction(new Bearing(205), 1));
//				addTandemAction(new AutoIntake(-1, 2.5));
//				addAction(new AutoDrive(0.35, 0.35, 2.5));
//				addAction(new AutoDrive(-0.5, -0.5, 0.5));
//				addTandemAction(new AutoElevator(-.5, 2));
//				addAction(new AutoDrive(-0.5, -0.5, 1));
//				addAction(new RotateTankAction(new Bearing(320), 1));
//				addTandemAction(new AutoElevator(-1, 1));
//				addAction(new AutoDrive(0.25, 0.25, 1.5));
//				addAction(new AutoIntake(0.75, 1));
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