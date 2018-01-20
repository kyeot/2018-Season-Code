package org.usfirst.frc2783.subsystems;

import org.usfirst.frc2783.robot.OI;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class IntakeBase extends Subsystem {

	VictorSPX right = new VictorSPX(10);
	VictorSPX left = new VictorSPX(11);
	
	public void intake(double leftSpeed, double rightSpeed) {
		
		if (OI.controller.getRawAxis(2) > 0.1) {
			
			right.set(ControlMode.PercentOutput, rightSpeed);
			
		}
		
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
