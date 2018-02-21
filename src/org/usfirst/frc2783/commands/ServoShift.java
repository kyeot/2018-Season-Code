package org.usfirst.frc2783.commands;

import org.usfirst.frc2783.robot.Constants;
import org.usfirst.frc2783.robot.OI;
import org.usfirst.frc2783.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ServoShift extends Command {
	
	boolean isHigh;
	
    public ServoShift() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.elevatorBase);
    	isHigh = true;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	isHigh = !isHigh;
    	if(OI.manipulator.getRawButton(Constants.kGearShiftID)){
    		if(isHigh){
            	Robot.elevatorBase.lowGear();
    		}
    		else if(!isHigh){
            	Robot.elevatorBase.highGear();
    		}
    	}
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
