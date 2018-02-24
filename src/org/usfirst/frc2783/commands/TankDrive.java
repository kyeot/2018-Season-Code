package org.usfirst.frc2783.commands;

import org.usfirst.frc2783.robot.FieldTransform;
import org.usfirst.frc2783.robot.OI;
import org.usfirst.frc2783.robot.Robot;
import org.usfirst.frc2783.util.Bearing;
import org.usfirst.frc2783.util.NavSensor;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TankDrive extends Command {

	FieldTransform fieldTransform = FieldTransform.getInstance();

	double lastLeftSpeed;
	double lastRightSpeed;

	double angle;

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
		return rTrigger - lTrigger;
	}
	
	public boolean isNegative(double value) {
		return value < 0;
	}
	
	public double scaleSide(char side, double initialOutput, double angularValue) {
		boolean biggerRight = isNegative(angularValue);
		boolean goingForward = !isNegative(angularValue);
		if (goingForward) {
			if (biggerRight) {
				if (side == 'r') {
					return initialOutput;
				} else {
					return (initialOutput + initialOutput*angularValue);
				}
			} else {
				if (side == 'r') {
					return initialOutput - initialOutput*angularValue;
				} else {
					return initialOutput;
				}
			}
		} else {
			if (biggerRight) {
				if (side == 'r') {
					return initialOutput;
				} else {
					return (initialOutput - initialOutput*angularValue);
				}
			} else {
				if (side == 'r') {
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
	 
	double leftSpeed;
	double rightSpeed;
	
	protected void execute() {
//		leftSpeed = OI.driver.getRawAxis(1);
//		rightSpeed = OI.driver.getRawAxis(5);
		double scale;
		
		if (OI.driver.getRawButton(5)) {
			scale = .25;
		} 
		
		else if (OI.driver.getRawButton(6)) {
			scale = 1;
		} 
		
		else {
			scale = .5;
		}
		
		setSpeeds(scale);
		
		if (Math.abs(leftSpeed) < 0.15) {
			leftSpeed = 0;
		}

		if (Math.abs(rightSpeed) < 0.15) {
			rightSpeed = 0;
		}

		if (OI.driver.getRawButton(4)) {
			navSensor.resetGyroNorth(0, 0);
		}

		if (OI.driver.getRawButton(2)) {
			if (fieldTransform.targetHistory.getLatestTarget() != null) {
				angle = fieldTransform.targetHistory.getSmoothTarget().dir().getTheta();
			}
		}

		if (OI.driver.getRawButton(1)) {
			// Robot.tankDrive.setRobotPose(new Bearing(0));
			Robot.tankDrive.setRobotPose(new Bearing(angle));
		} else {
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

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
