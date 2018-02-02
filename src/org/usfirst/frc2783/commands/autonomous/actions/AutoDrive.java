package org.usfirst.frc2783.commands.autonomous.actions;

import org.usfirst.frc2783.robot.Robot;

public class AutoDrive extends Action {
	
	double left;
	double right;
	
	public AutoDrive(double left, double right, double time) {
		super("AutoDrive", time);
		
		this.left = left;
		this.right = right;
	}
	
	@Override
	public void perform() {
		Robot.tankDriveBase.tankDrive(left, right);
	}
	
}