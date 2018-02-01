package org.usfirst.frc2783.subsystems;

import org.usfirst.frc2783.robot.Constants;
import org.usfirst.frc2783.robot.OI;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class TankDriveBase extends Subsystem {
		// adds driving motors
		
		VictorSPX right1 = new VictorSPX(Constants.kRightDrive1);
		VictorSPX right2 = new VictorSPX(Constants.kRightDrive2);
		VictorSPX left1 = new VictorSPX(Constants.kLeftDrive1);
		VictorSPX left2 = new VictorSPX(Constants.kLeftDrive2);
	
	// moves robot with left and right drive sticks
	public void tankDrive(double leftSpeed, double rightSpeed) {
		
		if (OI.driver.getRawAxis(1) > 0.15) {
			
			right1.set(ControlMode.PercentOutput, rightSpeed);
			right2.set(ControlMode.PercentOutput, rightSpeed);
			
		}	
		else {
			
			right1.set(ControlMode.PercentOutput, 0);
			right2.set(ControlMode.PercentOutput, 0);
			
		}
		
		if (OI.driver.getRawAxis(1) > 0.15) {
			
			left1.set(ControlMode.PercentOutput, leftSpeed);
			left2.set(ControlMode.PercentOutput, leftSpeed);
			
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