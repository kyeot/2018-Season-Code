package org.usfirst.frc2783.subsystems;

import org.usfirst.frc2783.commands.TankDrive;
import org.usfirst.frc2783.robot.Constants;
import org.usfirst.frc2783.robot.Robot;
import org.usfirst.frc2783.util.Bearing;
import org.usfirst.frc2783.util.GyroSource;
import org.usfirst.frc2783.util.NavSensor;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Subsystem;

public class TankDriveBase extends Subsystem {
	
	class TankSideSource implements PIDSource {
		AnalogInput encoder;
		PIDSourceType sourceType;
		public TankSideSource(AnalogInput encoder) {
			setPIDSourceType(PIDSourceType.kDisplacement);
			this.encoder = encoder;
		}
		@Override
		public void setPIDSourceType(PIDSourceType pidSource) {
			sourceType = pidSource;
		}
		@Override
		public PIDSourceType getPIDSourceType() {
			return sourceType;
		}
		@Override
		public double pidGet() {
			return encoder.getValue()/11.377777777777777778;
		}	
	}
	
	class TankSideOut implements PIDOutput {
		double outputVar;
		public TankSideOut(double outputVar){
			this.outputVar = outputVar;
		}
		@Override
		public void pidWrite(double output){
			outputVar = output;
		}
	}
	
	class TankPoseOut implements PIDOutput {
		@Override
		public void pidWrite(double output) {
			rot = -output;
		}
	}
		
	public VictorSPX right1 = new VictorSPX(Constants.kRightDrive1);
	VictorSPX right2 = new VictorSPX(Constants.kRightDrive2);
	
	public VictorSPX left1 = new VictorSPX(Constants.kLeftDrive1);
	VictorSPX left2 = new VictorSPX(Constants.kLeftDrive2);
	
	NavSensor gyro = NavSensor.getInstance();
	
	double rot;

	double leftOut;
	double rightOut;
	
	PIDController posePid;
	TankPoseOut posePidOut;
	GyroSource posePidSource;
	
	TankSideSource leftPidSource;
	TankSideSource rightPidSource;
	TankSideOut leftSideOut;
	TankSideOut rightSideOut;
	PIDController leftSideController;
	PIDController rightSideController;
		
	public TankDriveBase(){
		right2.follow(right1);
		left2.follow(left1);
		
		right1.setNeutralMode(NeutralMode.Brake);
		right2.setNeutralMode(NeutralMode.Brake);
		
		left1.setNeutralMode(NeutralMode.Brake);
		left2.setNeutralMode(NeutralMode.Brake);
		
		posePidOut = new TankPoseOut();
		posePidSource = new GyroSource();
		posePid = new PIDController(Constants.kTankPoseP, Constants.kTankPoseI, Constants.kTankPoseD, 
										posePidSource, 
										posePidOut);
		posePid.setInputRange(0, 360);
		posePid.setContinuous();
		
		leftPidSource = new TankSideSource(Robot.leftAbsEnc);
		rightPidSource = new TankSideSource(Robot.rightAbsEnc);
		
		leftSideOut = new TankSideOut(leftOut);
		rightSideOut = new TankSideOut(rightOut);
		
		leftSideController = new PIDController(Constants.kTankSideP, Constants.kTankSideI, Constants.kTankSideD,
												leftPidSource, leftSideOut);
		leftSideController.setInputRange(0, 360);
		leftSideController.setContinuous();
		
		rightSideController = new PIDController(Constants.kTankSideP, Constants.kTankSideI, Constants.kTankSideD,
												rightPidSource, rightSideOut);
		leftSideController.setInputRange(0, 360);
		leftSideController.setContinuous();
	}
	
	public void setRobotPose(Bearing b){
		posePid.setSetpoint(b.getTheta());
		posePid.enable();
		
		rotate(rot);
		
	}
	
	public void setLeftSidePose(double angle){
		leftSideController.setSetpoint(angle);
		leftSideController.enable();
		
		left1.set(ControlMode.PercentOutput, leftOut);
		
	}
	
	public void setRightSidePose(double angle){
		rightSideController.setSetpoint(angle);
		rightSideController.enable();
		
		right1.set(ControlMode.PercentOutput, rightOut);
		
	}
	
	private void rotate(double rotMot){
		left1.set(ControlMode.PercentOutput, rotMot);
		right1.set(ControlMode.PercentOutput, rotMot);
		
	}
	
	//Moves tank drive by left and right speeds
	public void tankDrive(double leftSpeed, double rightSpeed) {
		left1.set(ControlMode.PercentOutput, -leftSpeed);
		right1.set(ControlMode.PercentOutput, rightSpeed);
		
	}
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new TankDrive());
		
	}

}
