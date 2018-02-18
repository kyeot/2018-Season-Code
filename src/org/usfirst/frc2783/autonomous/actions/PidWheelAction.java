package org.usfirst.frc2783.autonomous.actions;

import org.usfirst.frc2783.robot.Robot;

public class PidWheelAction extends Action{

	public PidWheelAction() {
		super("PidWheelAction");
		
	}
	
	@Override
	public void perform(){
		Robot.tankDrive.setLeftSidePose(90);
	}

}
