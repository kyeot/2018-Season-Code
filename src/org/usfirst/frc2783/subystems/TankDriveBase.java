package org.usfirst.frc2783.subystems;

import org.usfirst.frc2783.commands.TankDrive;
import org.usfirst.frc2783.robot.Constants;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class TankDriveBase extends Subsystem {
	
	//Creates the motor controller objects
	TalonSRX leftSide1;
	TalonSRX leftSide2;
	TalonSRX rightSide1;
	TalonSRX rightSide2;
	
	public TankDriveBase(){
		
		//Instantiates the motor controllers with ID's
		leftSide1 = new TalonSRX(Constants.kLeftSide1ID);
		leftSide2 = new TalonSRX(Constants.kLeftSide2ID);
		rightSide1 = new TalonSRX(Constants.kRightSide1ID);
		rightSide2 = new TalonSRX(Constants.kRightSide2ID);
		
		//Sets the secondary controllers to follow the primary ones
		leftSide2.follow(leftSide1);
		rightSide2.follow(rightSide1);
		
	}

	public void tankDrive(double lSpeed, double rSpeed){

		//Sets the left motors to given speed if it's above 0.2
		if(Math.abs(lSpeed) > 0.2){
			leftSide1.set(ControlMode.PercentOutput, lSpeed);
		}
		
		//Sets the right motors to given speed if it's above 0.2
		if(Math.abs(rSpeed) > 0.2){
			rightSide1.set(ControlMode.PercentOutput, rSpeed);
		}
		
	}
	
	//Initiates TankDrive as the default command of this subsystem
    public void initDefaultCommand() {
    	setDefaultCommand(new TankDrive());
    }
}

