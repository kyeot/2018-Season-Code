package org.usfirst.frc2783.autonomous.actions;

import org.usfirst.frc2783.robot.Robot;
import org.usfirst.frc2783.util.Bearing;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class RotateTankAction extends Action{

	Bearing b;
	
	public RotateTankAction(Bearing b, double time) {
		super("RotateTankAction", time);
		
		this.b = b;
	}
	
	@Override
	public void perform(){
		Robot.tankDrive.setRobotPose(b);
		SmartDashboard.putString("DB/String 0", "" + Math.floor(b.getTheta()));
	}
	

}
