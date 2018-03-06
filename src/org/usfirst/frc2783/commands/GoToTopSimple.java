package org.usfirst.frc2783.commands;

import org.usfirst.frc2783.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GoToTopSimple extends Command {

    public GoToTopSimple() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.yesso = true;
    	Robot.elevatorBase.elevator(0.8);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.elEncCounter.getRotations() >= 12;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.elevatorBase.elevator(0);
    	Robot.yesso = false;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
