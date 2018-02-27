package org.usfirst.frc2783.commands;

import org.usfirst.frc2783.robot.Robot;
import org.usfirst.frc2783.util.ElevatorEncoderCounter;
import org.usfirst.frc2783.util.EncoderPosition;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GoToElevatorPosition extends Command {

	boolean isUp = true;
	
	EncoderPosition encPos;
	
	static ElevatorEncoderCounter elevatorCounter = ElevatorEncoderCounter.getInstance();
	
    public GoToElevatorPosition(EncoderPosition encPos) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.elevatorBase);
    	
    	this.encPos = encPos;
    	
    	if(elevatorCounter.getRotations() < encPos.getRotations()){
    		isUp = true;
    	}
    	
    	else if(elevatorCounter.getRotations() > encPos.getRotations()){
    		isUp = false;
    	}
    	
    	else{
    		if(Robot.elevatorAbsEnc.getValue() < encPos.getDegrees()){
    			isUp = true;
    		}
    		else if(Robot.elevatorAbsEnc.getValue() > encPos.getDegrees()){
    			isUp = false;
    		}
    	}
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.elevatorBase.elevator(1);
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(isUp){
    		return elevatorCounter.getRotations() > encPos.getRotations() && Robot.elevatorAbsEnc.getValue() > encPos.getDegrees();
    	}
    	else{
    		return elevatorCounter.getRotations() < encPos.getRotations() && Robot.elevatorAbsEnc.getValue() < encPos.getDegrees();
    	}
        
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.elevatorBase.elevator(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
