package org.usfirst.frc2783.subsystems;

import org.usfirst.frc2783.commands.TankDrive;
import org.usfirst.frc2783.robot.Constants;
import org.usfirst.frc2783.robot.OI;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class TankDriveBase extends Subsystem {
		
	VictorSPX right1 = new VictorSPX(Constants.kRightDrive1);
	VictorSPX right2 = new VictorSPX(Constants.kRightDrive2);
	VictorSPX left1 = new VictorSPX(Constants.kLeftDrive1);
	VictorSPX left2 = new VictorSPX(Constants.kLeftDrive2);
		
	public TankDriveBase(){
		right2.follow(right1);
		left2.follow(left1);
		
	}
	
	// moves robot with left and right drive sticks
	public void tankDrive(double leftSpeed, double rightSpeed) {
		left1.set(ControlMode.PercentOutput, -leftSpeed);
		right1.set(ControlMode.PercentOutput, rightSpeed);
		
	}
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new TankDrive());
		
	}

}
