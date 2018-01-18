package org.usfirst.frc2783.subystems;

import org.usfirst.frc2783.commands.TankDrive;
import org.usfirst.frc2783.robot.Constants;
import org.usfirst.frc2783.robot.OI;
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
	
	//Creates the PID controllers for each side
	PIDController leftPIDCont;
	PIDController rightPIDCont;
	
	//Creates the PID Outut classes for each side
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
	
	//Creates the Magnetic Encoder PID sources
	MagEncoderSource leftMagEncSource;
	MagEncoderSource rightMagEncSource;
	
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
		
		leftMagEncSource = new MagEncoderSource("left");
		rightMagEncSource = new MagEncoderSource("right");
		
		//Configures the magnetic encoders from the Talons
//		leftSide1.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, 0, 0);
//		rightSide1.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, 0, 0);
		
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
		
		//Identifies the Motor that each PID Output uses
		leftPIDOut = new PIDOutputClass(leftSide1);
		rightPIDOut = new PIDOutputClass(rightSide1);
		
		//Identifies the PID values as well as the magnetic encoder and the PID output that each PID Controller uses
		leftPIDCont = new PIDController(
				Constants.kLeftTankP, Constants.kLeftTankI, Constants.kLeftTankD,
				leftMagEncSource, leftPIDOut);
		leftPIDCont = new PIDController(
				Constants.kRightTankP, Constants.kRightTankI, Constants.kRightTankD,
				rightMagEncSource, rightPIDOut);
		
	}
	
	//Method to run the PIDs to adjust the tank sides to the wanted angle
	public void setTankSidesAngles(double leftAngle, double rightAngle){
		leftPIDCont.enable();
		leftPIDCont.setSetpoint(leftAngle);
			
		rightPIDCont.enable();
		rightPIDCont.setSetpoint(rightAngle);
		
	}
	
	//Method to move tank drive by distance given
	public void moveSideByDistance(double leftDistance, double rightDistance){
		
		//Sets the angles of each sides encoders before moving as variables
		currentLeftAng = leftSide1.getSelectedSensorPosition(0)/11.377777777778;
		currentRightAng = rightSide1.getSelectedSensorPosition(0)/11.377777777778;
		
		//Puts the amount of degrees to move to go the wanted distance in variables
		leftDegrees = ((leftDistance/(Constants.wheelDiameterByInches*(Math.PI))/4096)/11.377777777778);
		rightDegrees = ((rightDistance/(Constants.wheelDiameterByInches*(Math.PI))/4096)/11.377777777778);
		
		//Sets the PID setpoints and runs them
		setTankSidesAngles(currentLeftAng + leftDegrees, currentRightAng + rightDegrees);
		
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

