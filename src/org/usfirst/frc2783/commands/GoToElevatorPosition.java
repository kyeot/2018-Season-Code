package org.usfirst.frc2783.commands;

import org.usfirst.frc2783.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GoToElevatorPosition extends Command {
	
	double wantedRot;
	double wantedDeg;
	
    public GoToElevatorPosition(double wantedRot, double wantedDeg) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.elevatorBase);
    	
    	this.wantedRot = wantedRot;
    	this.wantedDeg = wantedDeg;
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {

   		if(Robot.elevatorBase.elevator1Mot.getMotorOutputPercent() > 0.1){
       		Robot.isUp = true;
       	}
   		else if(Robot.elevatorBase.elevator1Mot.getMotorOutputPercent() < -0.1){
       		Robot.isUp = false;
       	}
   		else{
   			if(Robot.elevatorAbsEnc.getValue() > wantedDeg){
   				Robot.isUp = false;
   			}
   			else if(Robot.elevatorAbsEnc.getValue() > wantedDeg){
   				Robot.isUp = true;
   			}
   		}
           	
   		if(Robot.isUp = true){
   	    	Robot.elevatorBase.elevator(1);
   		}
   		else{
   	    	Robot.elevatorBase.elevator(-1);
   		}
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(Robot.isUp){
    		return Robot.elEncCounter.getRotations() >= wantedRot && Robot.elevatorAbsEnc.getValue() < wantedDeg;
    	}
    	else{
    		return Robot.elEncCounter.getRotations() <= wantedRot && Robot.elevatorAbsEnc.getValue() > wantedDeg;
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
