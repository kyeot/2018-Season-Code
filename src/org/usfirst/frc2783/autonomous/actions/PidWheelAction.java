package org.usfirst.frc2783.autonomous.actions;

import org.usfirst.frc2783.robot.Robot;

public class PidWheelAction extends Action{

	public PidWheelAction() {
		super("PidWheelAction");
		
	}
	
	@Override
	public void perform(){
<<<<<<< HEAD
		Robot.tankDriveBase.setLeftSidePose(90);
=======
		Robot.tankDrive.setLeftSidePose(90);
>>>>>>> eec6a3416388300c7828cdec2354e14acf17a54a
	}

}
