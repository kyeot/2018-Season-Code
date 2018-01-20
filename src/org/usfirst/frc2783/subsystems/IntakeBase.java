package org.usfirst.frc2783.subsystems;

/**
 * @purpose: The base for the Intake manipulator
 * @author Adam Ma
 * @version 1/20/2017
 */

import org.usfirst.frc2783.robot.OI;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class IntakeBase extends Subsystem {
	
	//Creates 2 Victor objects
	VictorSPX right = new VictorSPX(10);
	VictorSPX left = new VictorSPX(11);
	
	//Method to use intake base
	public void intake(double leftSpeed, double rightSpeed) {
		
		//If-Else statement to fix dead band on right trigger
		//Right trigger is in
		if (OI.manipulator.getRawAxis(3) > 0.1) {
			
			right.set(ControlMode.PercentOutput, rightSpeed);
			left.set(ControlMode.PercentOutput, -leftSpeed);
			
		}
		else {
			
			right.set(ControlMode.PercentOutput, 0);
			left.set(ControlMode.PercentOutput, 0);
			
		}
		
		//If-Else statement to fix dead band on left trigger
		//Left trigger is out
		//Speeds are inverted to invert direction
		if (OI.manipulator.getRawAxis(2) > 0.1) {
			
			right.set(ControlMode.PercentOutput, -rightSpeed);
			left.set(ControlMode.PercentOutput, leftSpeed);
			
		}
		else { 
			
			right.set(ControlMode.PercentOutput, 0);
			left.set(ControlMode.PercentOutput, 0);
			
		}
		
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
