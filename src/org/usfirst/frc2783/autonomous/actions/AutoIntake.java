package org.usfirst.frc2783.autonomous.actions;

import org.usfirst.frc2783.robot.Robot;

public class AutoIntake extends Action{

	double speed;
	
	public AutoIntake(double speed, double time) {
		super("AutoIntake", time);
		
		this.speed = speed;
		
	}
	
	@Override
	public void perform(){
		Robot.intake.intake(speed);
	}

}