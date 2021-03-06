package org.usfirst.frc2783.commands;

import org.usfirst.frc2783.robot.Robot;
import org.usfirst.frc2783.util.Bearing;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class FaceNorthEast extends Command {

    public FaceNorthEast() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.tankDrive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.tankDrive.setRobotPose(new Bearing(315));
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
