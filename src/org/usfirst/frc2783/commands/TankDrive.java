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
	
	NavSensor navSensor = NavSensor.getInstance();
	
    public TankDrive() {
    	//sets requirement system
        requires(Robot.tankDrive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double leftSpeed = OI.driver.getRawAxis(1);
    	double rightSpeed = OI.driver.getRawAxis(5);
    	
    	if(OI.driver.getRawButton(5)){
    		leftSpeed = leftSpeed/2;
    		rightSpeed = rightSpeed/2;
    	}
    	
    	else if(OI.driver.getRawButton(6)){
    		leftSpeed = leftSpeed*2;
    		rightSpeed = rightSpeed*2;
    	}
    	
    	if(Math.abs(leftSpeed) < 0.15){
    		leftSpeed = 0;
    	}
 
    	if(Math.abs(rightSpeed) < 0.15){
    		rightSpeed = 0;
    	}
    	
    	if(OI.driver.getRawButton(4)){
    		navSensor.resetGyroNorth(0, 0);
    	}
    	
    	if(OI.driver.getRawButton(1)) {
    		Robot.tankDrive.setRobotPose(new Bearing(0));
//    		if(fieldTransform.targetHistory.getLatestTarget() != null){
//    			Robot.tankDrive.setRobotPose(fieldTransform.targetHistory.getSmoothTarget().dir());
//    		}
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
