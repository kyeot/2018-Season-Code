package org.usfirst.frc2783.autonomous.actions;

import org.usfirst.frc2783.robot.Robot;

public class AutoElevator extends Action {

	double speed;
	
	public AutoElevator(double speed, double time) {
		super("AutoElevator", time);
		
		this.speed = speed;
		
	}
	
	@Override
	public void perform(){
		Robot.elevatorBase.elevator(-speed);
	}

}