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
<<<<<<< HEAD
		Robot.tankDriveBase.setRobotPose(b);
=======
		Robot.tankDrive.setRobotPose(b);
>>>>>>> eec6a3416388300c7828cdec2354e14acf17a54a
		SmartDashboard.putString("DB/String 0", "" + Math.floor(b.getTheta()));
	}
	

}
