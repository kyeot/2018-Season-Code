package org.usfirst.frc2783.commands;

import org.usfirst.frc2783.robot.Constants;
import org.usfirst.frc2783.robot.FieldTransform;
import org.usfirst.frc2783.robot.OI;
import org.usfirst.frc2783.robot.Robot;
import org.usfirst.frc2783.util.Bearing;
import org.usfirst.frc2783.util.NavSensor;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class TankDrive extends Command {

	FieldTransform fieldTransform = FieldTransform.getInstance();

	double lastLeftSpeed;
	double lastRightSpeed;

	Bearing startAngle;
	Bearing endAngle;

	NavSensor navSensor = NavSensor.getInstance();

	public TankDrive() {
		// sets requirement system
		requires(Robot.tankDrive);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	public double averageWheelOutput(double lTrigger, double rTrigger) {
		return -(rTrigger - lTrigger);
	}
	
	public boolean isNegative(double value) {
		return value < 0;
	}
	
	boolean biggerRight;
	boolean goingForward;
	
	public double scaleSide(char side, double initialOutput, double angularValue) {
		angularValue = -angularValue;
		biggerRight = isNegative(angularValue);
		goingForward = isNegative(initialOutput);
		if (goingForward) {
			if (biggerRight) {
				if (side == 'l') {
					return initialOutput;
				} else {
					return (initialOutput + initialOutput*angularValue);
				}
			} else {
				if (side == 'l') {
					return initialOutput - initialOutput*angularValue;
				} else {
					return initialOutput;
				}
			}
		} else {
			if (biggerRight) {
				if (side == 'l') {
					return initialOutput;
				} else {
					return (initialOutput - initialOutput*angularValue);
				}
			} else {
				if (side == 'l') {
					return initialOutput + initialOutput*angularValue;
				} else {
					return initialOutput;
				}
			}
		}
	}
	
	
	
	public void setSpeeds(double scale) {
		leftSpeed = scale*scaleSide('l', averageWheelOutput(OI.driver.getRawAxis(2), OI.driver.getRawAxis(3)), OI.driver.getRawAxis(0));
		rightSpeed = scale*scaleSide('r', averageWheelOutput(OI.driver.getRawAxis(2), OI.driver.getRawAxis(3)), OI.driver.getRawAxis(0));
	}	
	
	public void checkStationaryRotation(double scale) {
		if (scale == .6) {
			scale = .5;
		}
		if (/*Math.abs(OI.driver.getRawAxis(0)) > .25 &&*/ OI.driver.getRawAxis(3) < .15 && OI.driver.getRawAxis(2) < .15) {
			leftSpeed = scale*OI.driver.getRawAxis(1);
			rightSpeed = scale*OI.driver.getRawAxis(5);
			if (Math.abs(OI.driver.getRawAxis(5)) < .25 && Math.abs(OI.driver.getRawAxis(1)) < .4 && Math.abs(OI.driver.getRawAxis(0)) > .25) {
				leftSpeed = -scale*OI.driver.getRawAxis(0);
				rightSpeed = scale*OI.driver.getRawAxis(0);
			}
		}	
	}
	
	double leftSpeed;
	double rightSpeed;
	boolean lastButton1State = false;
	boolean reverseButton1Toggle = false;
	
	public boolean toggleInput(boolean value) {
		return value ? false : true;
	}
	
	protected void execute() {
		double scale;
		
		if (OI.driver.getRawButton(Constants.kFastModeID)) {
			//Quarter speed
			scale = .25;
		
		} 
		
		else if (OI.driver.getRawButton(Constants.kSlowModeID)) {
			//Full speed
			scale = 1;
		} 
		
		else {
			//Default speed of .6
			scale = .6;
		}
		
		//Rotation in place supersedes regular driving but has a higher deadband
		setSpeeds(scale);
		checkStationaryRotation(scale);
		
		
		
		if (Math.abs(leftSpeed) < 0.15) {
			leftSpeed = 0;
		}

		if (Math.abs(rightSpeed) < 0.15) {
			rightSpeed = 0;
		}

		if (OI.driver.getRawButton(Constants.kGyroResetID)) {
			navSensor.resetGyroNorth(0, 0);
		}

//		if (OI.driver.getRawButton(2)) {
//			if (fieldTransform.targetHistory.getLatestTarget() != null) {
//				startAngle = new Bearing(fieldTransform.targetHistory.getSmoothTarget().dir().getTheta());
//				endAngle = startAngle.rotate(new Bearing(180));
//				SmartDashboard.putString("DB/String 0", "" + endAngle.getTheta());
//				
//			}
//		}
//
//		if (OI.driver.getRawButton(3)) {
//			// Robot.tankDrive.setRobotPose(new Bearing(0));
//			Robot.tankDrive.setRobotPose(endAngle);
//		} 
		
		
		if(OI.driver.getRawButton(1) == true && lastButton1State == false) {
			reverseButton1Toggle = toggleInput(reverseButton1Toggle);
			lastButton1State = true;
		} else if (OI.driver.getRawButton(1) == false) {
			lastButton1State = false;
		}
		
		if(reverseButton1Toggle) {
			Robot.tankDrive.tankDrive(-rightSpeed, -leftSpeed);
		}
		else{
			Robot.tankDrive.tankDrive(leftSpeed, rightSpeed);
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same\
	
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
