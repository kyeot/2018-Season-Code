package org.usfirst.frc2783.autonomous.actions;

import org.usfirst.frc2783.robot.FieldTransform;
import org.usfirst.frc2783.robot.Robot;
import org.usfirst.frc2783.util.Bearing;

public class RotateToTarget extends Action{

	Bearing b;
	
	public RotateToTarget(double time) {
		super("RotateTankAction", time);
		
	}
	
	@Override
	public void start(){
		b = new Bearing(FieldTransform.getInstance().targetHistory.getSmoothTarget().dir().getTheta());
//		b.rotate(new Bearing(180));
	}
	
	@Override
	public void perform(){
		Robot.tankDrive.setRobotPose(b);
	}

}
