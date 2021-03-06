package org.usfirst.frc2783.subsystems;
import org.usfirst.frc2783.commands.Intake;
/**
 * @purpose: Sets base for intake of cubes
 * @author Adam Ma
 * @version 1/20/2017
 */
import org.usfirst.frc2783.robot.Constants;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class IntakeBase extends Subsystem {
	
	//Creates 2 Victor objects
	VictorSPX right = new VictorSPX(Constants.kIntakeRight);
	VictorSPX left;
	
	public IntakeBase(){
		
		left = new VictorSPX(Constants.kIntakeLeft);
		right = new VictorSPX(Constants.kIntakeRight);
		
		left.setNeutralMode(NeutralMode.Brake);
		right.setNeutralMode(NeutralMode.Brake);
		
	}
	
	//Method to use intake base
	public void intake(double speed) {
		right.set(ControlMode.PercentOutput, speed);
		left.set(ControlMode.PercentOutput, -speed);
		
	}
	
	public void spinAdjust(double speed){
		left.set(ControlMode.PercentOutput, -.8*speed);
		right.set(ControlMode.PercentOutput, speed);
	}
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new Intake());
		
	}

}
