package org.usfirst.frc2783.autonomous.actions;

import org.usfirst.frc2783.robot.Robot;
/**
 * 
 * Give it a PercentOutPut on both sides and give it a time to run
 * 
 * @author 2783
 *
 */
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
		Robot.tankDrive.tankDrive(-left, -right);
	}
	
}