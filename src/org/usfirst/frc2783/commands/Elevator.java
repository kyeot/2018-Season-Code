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

	double speed;

	public Elevator() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		// sets the requires subsystem
		requires(Robot.elevatorBase);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		
		speed = OI.manipulator.getRawAxis(1);

		if(!Robot.yesso){
			if (Math.abs(OI.manipulator.getRawAxis(1)) < 0.1) {
				if (Robot.isHigh) {
					if(Robot.isClimb){
						speed = 0.15;
					}
					else{
						speed = -0.1;
					}
				}
				else {
					speed = -0.15;
				}
				
			}
			if(OI.manipulator.getRawButton(6)){
				Robot.elevatorBase.elevator(-speed*0.75);		
			}
			else{
				Robot.elevatorBase.elevator(-speed);		
			}
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
