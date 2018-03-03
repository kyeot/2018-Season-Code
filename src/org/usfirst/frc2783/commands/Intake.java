package org.usfirst.frc2783.commands;

import org.usfirst.frc2783.robot.Constants;
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
    	//Sets the required Subsystem
        requires(Robot.intake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {    	
    	
    	double speed = OI.manipulator.getRawAxis(5);
    	
    	if(OI.manipulator.getRawAxis(2) > 0.1){
    		speed = OI.manipulator.getRawAxis(2);
    	}
    	
    	else if(OI.manipulator.getRawAxis(3) > 0.05){
    		speed = -OI.manipulator.getRawAxis(3);
    	}
    	
    	else{
    		if(Robot.isSucking){
        		speed = 0.5;
    		}
    		else{
    			speed = 0;
    		}
    	}
    	
    	if(OI.manipulator.getRawButton(Constants.kIntakeSpinnerID)){
    		Robot.intake.spinAdjust();
    	}
    	else{
    		Robot.intake.intake(speed);
    	}
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
