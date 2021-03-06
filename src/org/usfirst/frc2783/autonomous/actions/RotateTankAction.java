package org.usfirst.frc2783.autonomous.actions;

import org.usfirst.frc2783.robot.Robot;
import org.usfirst.frc2783.util.Bearing;

public class RotateTankAction extends Action{

	Bearing b;
	
	public RotateTankAction(Bearing b, double time) {
		super("RotateTankAction", time);
		
		this.b = b;
	}
	
	@Override
	public void perform(){
		Robot.tankDrive.setRobotPose(b);
		
	}

}
