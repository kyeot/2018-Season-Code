package org.usfirst.frc2783.commands;

import org.usfirst.frc2783.robot.Constants;
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
    	
    	//Sets variables to equal inputs from the controller
    	lMot = OI.driver.getRawAxis(Constants.LeftJoyUpDownID);
    	rMot = OI.driver.getRawAxis(Constants.RIghtJoyUpDownID);
    	
    	//Drives the robot with previously gained inputs from the controller
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
