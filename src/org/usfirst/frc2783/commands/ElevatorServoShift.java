package org.usfirst.frc2783.commands;

import org.usfirst.frc2783.robot.Constants;
import org.usfirst.frc2783.robot.OI;
import org.usfirst.frc2783.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ElevatorServoShift extends Command {
	
    public ElevatorServoShift() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.elevatorBase);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.isHigh = !Robot.isHigh;
    	if(Robot.isHigh){
           	Robot.elevatorBase.lowGear();
    	}
    	else if(!Robot.isHigh){
           	Robot.elevatorBase.highGear();
    	}
		SmartDashboard.putString("DB/String 4", "" + Robot.isHigh);
    	
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
