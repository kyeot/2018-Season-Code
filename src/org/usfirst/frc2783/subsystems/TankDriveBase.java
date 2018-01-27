package org.usfirst.frc2783.subsystems;

import org.usfirst.frc2783.robot.Constants;
import org.usfirst.frc2783.robot.OI;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class TankDriveBase extends Subsystem {
		// adds driving motors
		
		TalonSRX right1 = new TalonSRX(Constants.kRightDrive1);
		TalonSRX right2 = new TalonSRX(Constants.kRightDrive2);
		TalonSRX left1 = new TalonSRX(Constants.kLeftDrive1);
		TalonSRX left2 = new TalonSRX(Constants.kLeftDrive2);
	
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
