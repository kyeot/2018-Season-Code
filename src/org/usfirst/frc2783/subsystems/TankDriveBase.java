package org.usfirst.frc2783.subsystems;

import org.usfirst.frc2783.robot.OI;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class TankDriveBase extends Subsystem {
		
		VictorSPX right1 = new VictorSPX(14);
		VictorSPX right2 = new VictorSPX(15);
		VictorSPX left1 = new VictorSPX(12);
		VictorSPX left2 = new VictorSPX(13);
	
	public void tankDrive(double leftSpeed, double rightSpeed) {
		
		if (OI.controller.getRawAxis(1) > 0.15) {
			
			right1.set(ControlMode.PercentOutput, rightSpeed);
			right2.set(ControlMode.PercentOutput, rightSpeed);
			
		}
		else {
			
			right1.set(ControlMode.PercentOutput, 0);
			right2.set(ControlMode.PercentOutput, 0);
			
		}
		
		if (OI.controller.getRawAxis(1) > 0.15) {
			
			left1.set(ControlMode.PercentOutput, rightSpeed);
			left2.set(ControlMode.PercentOutput, rightSpeed);
			
		}
		else {
			
			left1.set(ControlMode.PercentOutput, 0);
			left2.set(ControlMode.PercentOutput, 0);
			
		}
		
	}
	
	@Override
	protected void initDefaultCommand() {
		
		
		
	}

}
