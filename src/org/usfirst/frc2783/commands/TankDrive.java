package org.usfirst.frc2783.commands;

import org.usfirst.frc2783.robot.OI;
import org.usfirst.frc2783.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TankDrive extends Command {

	double lMot;
	double rMot;
	
    public TankDrive() {
    	//Sets the main subsystem used by this command
    	requires(Robot.tankDriveBase);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	if(OI.driver.getRawAxis(1) > 0.15){
    		Robot.isLeftForward = true;
    	}
    	
    	else if(OI.driver.getRawAxis(1) < -0.15){
    		Robot.isLeftForward = false;
    	}
    	
    	if(OI.driver.getRawAxis(5) > 0.15){
    		Robot.isRightForward = true;
    	}
    	
    	else if(OI.driver.getRawAxis(5) < -0.15){
    		Robot.isRightForward = false;
    	}
    	
    	lMot = OI.leftJoy.getRawAxis(1)/2;
    	rMot = OI.rightJoy.getRawAxis(1)/2;
    	
    	lMot = OI.driver.getRawAxis(1)/2;
    	rMot = OI.driver.getRawAxis(5)/2;
    	
    	if(OI.driver.getRawButton(5)){
    		lMot = lMot*0.5;
    		rMot = rMot*0.5;
    	}
    	else if(OI.driver.getRawButton(6)){
    		lMot = lMot*2;
    		rMot = rMot*2;
    	}
   
    	if(Math.abs(lMot) < 0.15){
    		lMot = 0;
    	}
    	
    	if(Math.abs(rMot) < 0.15){
    		rMot = 0;
    	}
    	
    	Robot.tankDriveBase.tankDrive(lMot, rMot);
    	
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
