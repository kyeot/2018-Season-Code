package org.usfirst.frc2783.subystems;

import org.usfirst.frc2783.commands.TankDrive;
import org.usfirst.frc2783.robot.Constants;
import org.usfirst.frc2783.robot.Robot;

import com.ctre.phoenix.ParamEnum;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class TankDriveBase extends Subsystem {
	
	//Creates the PID controllers for each side
	PIDController leftPIDCont;
	PIDController rightPIDCont;
	
	//Creates the PID Outut classes for each side
	PIDOutputClass leftPIDOut;
	PIDOutputClass rightPIDOut;

	double leftEncVal;
	double rightEncVal;
	double leftDegreesForwards;
	double rightDegreesForwards;
	double currentLeftAng;
	double currentRightAng;
	double desiredLeftAng;
	double desiredRightAng;
	
	//Creates the motor controller objects
	public static VictorSPX leftSide1;
	public static VictorSPX leftSide2;
	public static VictorSPX rightSide1;
	public static VictorSPX rightSide2;
	
	public class PIDOutputClass implements PIDOutput {
		private VictorSPX motor;
		
		public PIDOutputClass(VictorSPX motor) {
			this.motor = motor;
		}
		
		@Override
		public void pidWrite(double output) {
			motor.set(ControlMode.PercentOutput, output);
		}
	}
	
	public TankDriveBase(){
	
		//Instantiates the motor controllers with ID's
		leftSide1 = new VictorSPX(Constants.kLeftSide1ID);
		leftSide2 = new VictorSPX(Constants.kLeftSide2ID);
		rightSide1 = new VictorSPX(Constants.kRightSide1ID);
		rightSide2 = new VictorSPX(Constants.kRightSide2ID);
		
		leftSide1.configSelectedFeedbackSensor(FeedbackDevice.Analog, 0, 0);
		
		//Sets the secondary controllers to follow the primary ones
		leftSide2.follow(leftSide1);
		rightSide2.follow(rightSide1);	
		
		//Identifies the Motor that each PID Output uses
		leftPIDOut = new PIDOutputClass(leftSide1);
		rightPIDOut = new PIDOutputClass(rightSide1);
		
		//Identifies the PID values as well as the magnetic encoder and the PID output that each PID Controller uses
		leftPIDCont = new PIDController(
				Constants.kTankP, Constants.kTankI, Constants.kTankD,
				Robot.leftAbsEnc, leftPIDOut);
		rightPIDCont = new PIDController(
				Constants.kTankP, Constants.kTankI, Constants.kTankD,
				Robot.rightAbsEnc, rightPIDOut);
		
		leftPIDCont.setInputRange(-360, 360);
		leftPIDCont.setContinuous();
		
		rightPIDCont.setInputRange(-360, 360);
		rightPIDCont.setContinuous();
		
	}

	//Basic tank drive method
	public void tankDrive(double lSpeed, double rSpeed){
		leftSide1.set(ControlMode.PercentOutput, lSpeed);
		rightSide1.set(ControlMode.PercentOutput, rSpeed);
		
	}
	
	//Initiates TankDrive as the default command of this subsystem
    public void initDefaultCommand() {
    	setDefaultCommand(new TankDrive());
    }
    
}

