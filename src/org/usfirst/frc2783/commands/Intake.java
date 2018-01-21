package org.usfirst.frc2783.commands;

import org.usfirst.frc2783.robot.OI;
import org.usfirst.frc2783.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * @purpose Command class for intake
 * @author Adam Ma
 * @version 1/20/2017
 */
public class Intake extends Command {

	int dir = 2;
	
    public Intake() {
    	//Sets the required Subsystem
        requires(Robot.intake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	//Stops it from trying to run both directions at once
    	if(OI.manipulator.getRawAxis(3) > 0.15) {
    		dir = 3;
    	}
    	else if(OI.manipulator.getRawAxis(2) > 0.15) {
    		dir = 2;
    	}
    	
    	//Sets intake wheels based on direction
    	Robot.intake.intake(OI.manipulator.getRawAxis(dir));
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
