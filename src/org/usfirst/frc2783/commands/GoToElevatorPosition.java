package org.usfirst.frc2783.commands;

import org.usfirst.frc2783.loops.ElevatorEncoderCounter;
import org.usfirst.frc2783.robot.Robot;
import org.usfirst.frc2783.util.EncoderPosition;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GoToElevatorPosition extends Command {

	boolean isUp = true;
	
	EncoderPosition encPos;
	
    public GoToElevatorPosition(EncoderPosition encPos) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.elevatorBase);
    	
    	this.encPos = encPos;
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {

   		if(Robot.elEncCounter.getRotations() < encPos.getRotations()){
       		isUp = true;
       	}
   		else if(Robot.elEncCounter.getRotations() > encPos.getRotations()){
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
   	
   		if(isUp = true){
   	    	Robot.elevatorBase.elevator(-1);
   		}
   		else{
   	    	Robot.elevatorBase.elevator(1);
   		}
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(isUp){
    		return Robot.elEncCounter.getRotations() > encPos.getRotations() && Robot.elevatorAbsEnc.getValue() > encPos.getDegrees();
    	}
    	else{
    		return Robot.elEncCounter.getRotations() < encPos.getRotations() && Robot.elevatorAbsEnc.getValue() < encPos.getDegrees();
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
