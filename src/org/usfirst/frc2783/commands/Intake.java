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

    public Intake() {
        requires(Robot.intake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//No need invert trigger because speeds are already inverted in base
    	Robot.intake.intake(OI.manipulator.getRawAxis(3), OI.manipulator.getRawAxis(3));
    	Robot.intake.intake(OI.manipulator.getRawAxis(2), OI.manipulator.getRawAxis(2));
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
