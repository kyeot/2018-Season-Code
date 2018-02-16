package org.usfirst.frc2783.autonomous.actions;

import org.usfirst.frc2783.robot.Robot;
import org.usfirst.frc2783.util.Bearing;
import org.usfirst.frc2783.util.NavSensor;

public class RotateTankAction extends Action{

	Bearing b;
	
	public RotateTankAction(Bearing b) {
		super("RotateTankAction");
		
		this.b = b;
	}
	
	public double startAngle;
	
	@Override
	public void start(){
		
	}
	
	@Override
	public void perform(){
		Robot.tankDrive.setRobotPose(b);
		
	}
	
	@Override
	public boolean done(){
		return NavSensor.getInstance().getAngle(false) - 1 < b.getTheta() && NavSensor.getInstance().getAngle(false) + 1 > b.getTheta();
		
	}

}
