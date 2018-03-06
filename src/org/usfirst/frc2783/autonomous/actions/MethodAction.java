package org.usfirst.frc2783.autonomous.actions;

import org.usfirst.frc2783.robot.Robot;

public class MethodAction extends Action {

	public MethodAction(String id, double left, double right) {
		super(id);
		Robot.tankDrive.setVelocitySetpoint(left, right);
		//Robot.tankDrive.isExisting();
	}

}
