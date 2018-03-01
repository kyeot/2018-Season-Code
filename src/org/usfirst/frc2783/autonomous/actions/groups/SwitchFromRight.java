package org.usfirst.frc2783.autonomous.actions.groups;

import java.util.ArrayList;
import java.util.List;

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
			if(!Robot.isSwitchesLeft()){		
				addAction(new DriveWithGyroAndByDistance(0.5, 13*12, 13*12, 0));
				addAction(new RotateTankAction(new Bearing(90), 4));
				List<Action> test = new ArrayList<Action>();
				test.add(new AutoElevator(-0.75, 0.75)); test.add(new AutoDrive(0.25, 0.25, 2));
				addAction(new ParallelAction(test));
				addAction(new AutoIntake(0.75, 1));
			}
			else{
				addAction(new DriveWithGyroAndByDistance(0.5, 4.8*12, 4.8*12, 0));
				addAction(new RotateTankAction(new Bearing(90), 3));
				addAction(new DriveWithGyroAndByDistance(0.5, 21*12, 21*12, 270));
				addAction(new RotateTankAction(new Bearing(0), 3));
				addAction(new AutoElevator(-0.75, 0.75)); 
				addAction(new AutoDrive(0.25, 0.25, 2.5));
				addAction(new AutoIntake(0.75, 1));
			}
			
		}
		catch(NullPointerException n){
			Logger.error("Game Data Not Recieved, Crossing Baseline");
        	
			addAction(new AutoDrive(0.5, 0.5, 5));
		
		}
		
	}

}