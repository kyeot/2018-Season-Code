package org.usfirst.frc2783.subystems;

import org.usfirst.frc2783.commands.TankDrive;
import org.usfirst.frc2783.robot.Constants;
import org.usfirst.frc2783.util.MagEncoderSource;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class TankDriveBase extends Subsystem {
	
	PIDController leftPIDCont;
	PIDController rightPIDCont;
	PIDOutputClass leftPIDOut;
	PIDOutputClass rightPIDOut;
	
	double leftEncVal;
	double rightEncVal;
	
	double leftDegrees;
	double rightDegrees;
	
	double currentLeftAng;
	double currentRightAng;
	
	//Creates the motor controller objects
	public static TalonSRX leftSide1;
	public static TalonSRX leftSide2;
	public static TalonSRX rightSide1;
	public static TalonSRX rightSide2;
	
	MagEncoderSource leftMagEnc;
	MagEncoderSource rightMagEnc;
	
//	SensorCollection leftSideMagEnc;
//	SensorCollection rightSideMagEnc;
	
	public class PIDOutputClass implements PIDOutput {
		private TalonSRX motor;
		
		public PIDOutputClass(TalonSRX motor) {
			this.motor = motor;
		}
		
		@Override
		public void pidWrite(double output) {
			motor.set(ControlMode.PercentOutput, output);
		}
	}
	
	public TankDriveBase(){
		
		leftMagEnc = new MagEncoderSource("left");
		rightMagEnc = new MagEncoderSource("right");
		
		leftSide1.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, 0, 0);
		rightSide1.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, 0, 0);
		
		//Instantiates the motor controllers with ID's
		leftSide1 = new TalonSRX(Constants.kLeftSide1ID);
		leftSide2 = new TalonSRX(Constants.kLeftSide2ID);
		rightSide1 = new TalonSRX(Constants.kRightSide1ID);
		rightSide2 = new TalonSRX(Constants.kRightSide2ID);
		
		//Sets the secondary controllers to follow the primary ones
		leftSide2.follow(leftSide1);
		rightSide2.follow(rightSide1);	
		
//		leftSideMagEnc = new SensorCollection(leftSide1);
//		rightSideMagEnc = new SensorCollection(rightSide2);
		
		leftPIDOut = new PIDOutputClass(leftSide1);
		rightPIDOut = new PIDOutputClass(rightSide1);
		
		leftPIDCont = new PIDController(
							Constants.kLeftTankP, 
							Constants.kLeftTankI, 
							Constants.kLeftTankD,
							leftMagEnc,
							leftPIDOut);

		leftPIDCont = new PIDController(
							Constants.kRightTankP, 
							Constants.kRightTankI, 
							Constants.kRightTankD,
							rightMagEnc,
							rightPIDOut);
		
	}
	
	public void setSideAngle(double leftAngle, double rightAngle){
		leftPIDCont.enable();
		leftPIDCont.setSetpoint(leftAngle);
			
		rightPIDCont.enable();
		rightPIDCont.setSetpoint(rightAngle);
		
	}
	
	public void moveSideByDistance(double leftDistance, double rightDistance){
		
		currentLeftAng = leftSide1.getSelectedSensorPosition(0)/11.377777777778;
		currentRightAng = rightSide1.getSelectedSensorPosition(0)/11.377777777778;
		
		leftDegrees = ((leftDistance/(Constants.wheelDiameterByInches*(Math.PI))/4096)/11.377777777778);
		rightDegrees = ((rightDistance/(Constants.wheelDiameterByInches*(Math.PI))/4096)/11.377777777778);
		
		setSideAngle(currentLeftAng + leftDegrees, currentRightAng + rightDegrees);
		
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

