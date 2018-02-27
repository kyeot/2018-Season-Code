package org.usfirst.frc2783.autonomous;

import org.usfirst.frc2783.autonomous.actions.ActionGroup;
import org.usfirst.frc2783.autonomous.actions.AutoElevator;
import org.usfirst.frc2783.autonomous.actions.AutoIntake;
import org.usfirst.frc2783.autonomous.actions.DriveByDistance;
import org.usfirst.frc2783.autonomous.actions.DriveWithGyroAndByDistance;
import org.usfirst.frc2783.autonomous.actions.RotateTankAction;
import org.usfirst.frc2783.robot.Robot;
import org.usfirst.frc2783.util.Bearing;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SwitchFromRight extends ActionGroup {
	
	public SwitchFromRight() {
		super();
				
		if(Robot.switchVal == "L"){
			
//			addAction(new DriveByDistance(0.5, 11*12, 12*12));
//			addAction(new AutoElevator(-1, 1));
//			addAction(new AutoIntake(0.75, 1));
			
			addAction(new DriveWithGyroAndByDistance(0.5, 14*12, 14*12, 0));
			addAction(new RotateTankAction(new Bearing(90), 3));
			addAction(new AutoElevator(-1, 1));
			addAction(new AutoIntake(0.75, 1));
		}
		else if(Robot.switchVal == "R"){
			addAction(new DriveWithGyroAndByDistance(0.5, 7*12, 7*12, 0));
			addAction(new RotateTankAction(new Bearing(270), 3));
			addAction(new DriveWithGyroAndByDistance(0.5, 15*12, 15*12, 270));
			addAction(new RotateTankAction(new Bearing(0), 3));
			addAction(new AutoElevator(-1, 1));
			addAction(new AutoIntake(0.75, 1));
		}
		else{
			addAction(new DriveWithGyroAndByDistance(0.5, 12*12, 12*12, 0));
		}
		
	}

}