package org.usfirst.frc2783.autonomous.actions;

import org.usfirst.frc2783.robot.Robot;

public class DoTheThing extends Action {

	
	double speed;
	
	public DoTheThing(double speed, double time) {
		super("DoTheThing", time);
		
		this.speed = speed;
		
	}
	
	@Override
	public void perform() {
		Robot.tankDrive.tankDrive(speed, speed);
	}
}
