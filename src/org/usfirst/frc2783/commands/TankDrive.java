package org.usfirst.frc2783.commands;

import org.usfirst.frc2783.robot.OI;
import org.usfirst.frc2783.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TankDrive extends Command {

	public enum ControlType {
		XBOX_CONTROLLER(1, 5, 5, 6),
		JOYSTICKS(1, 4, 1, 11);
		
		int leftAxis;
		int rightAxis;
		
		int fastButton;
		int slowButton;
		
		private ControlType(int leftAxis, int rightAxis, int fastButton, int slowButton) {
			
			this.leftAxis = leftAxis;
			this.rightAxis = rightAxis;
		}
		
		public double getLeftAxis() {
			return OI.driver.getRawAxis(leftAxis);
		}
		
		public double getRightAxis() {
			return OI.driver.getRawAxis(rightAxis);
		}
		
		public boolean getFastButton() {
			return OI.driver.getRawButton(fastButton);
		}
		
		public boolean getSlowButton() {
			return OI.driver.getRawButton(slowButton);
		}
		
	}
	
	private ControlType controlType;
	
    public TankDrive(ControlType controlType) {
    	//sets requirement system
        requires(Robot.tankDrive);
        this.controlType = controlType;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double leftSpeed = controlType.getLeftAxis();
    	double rightSpeed = controlType.getRightAxis();
    	
    	if(controlType.getSlowButton()){
    		leftSpeed = leftSpeed/2;
    		rightSpeed = rightSpeed/2;
    	}
    	
    	else if(controlType.getFastButton()){
    		leftSpeed = leftSpeed*2;
    		rightSpeed = rightSpeed*2;
    	}
    	
    	if(Math.abs(leftSpeed) < 0.15){
    		leftSpeed = 0;
    	}
 
    	if(Math.abs(rightSpeed) < 0.15){
    		rightSpeed = 0;
    	}
    	
    	Robot.tankDrive.tankDrive(leftSpeed, rightSpeed);
    	
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
