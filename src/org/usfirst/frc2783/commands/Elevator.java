package org.usfirst.frc2783.commands;

import org.usfirst.frc2783.robot.OI;
import org.usfirst.frc2783.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * @purpose: Command class for Elevator
 * @author Owen Atkins
 * @version 1/20/2017
 */
public class Elevator extends Command {

    public Elevator() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	//sets the requires subsystem
    	requires(Robot.elevatorBase);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//Sets the elevator speed to the left toggle axis on the manipulator
    	Robot.elevatorBase.elevator(OI.manipulator.getRawAxis(1));
    	Robot.elevatorBase.elevator(OI.manipulator.getRawAxis(2));
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
