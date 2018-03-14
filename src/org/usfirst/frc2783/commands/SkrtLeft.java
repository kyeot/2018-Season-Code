package org.usfirst.frc2783.commands;

import org.usfirst.frc2783.autonomous.actions.ActionScheduler;
import org.usfirst.frc2783.autonomous.actions.groups.SkrtLeftGroup;
import org.usfirst.frc2783.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SkrtLeft extends Command {

	ActionScheduler yes = Robot.autoScheduler;
	
    public SkrtLeft() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.tankDrive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	yes.setGroup(new SkrtLeftGroup());
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
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
