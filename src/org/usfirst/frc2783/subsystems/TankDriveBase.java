package org.usfirst.frc2783.subsystems;

import org.usfirst.frc2783.commands.TankDrive;
import org.usfirst.frc2783.robot.Constants;
import org.usfirst.frc2783.util.Bearing;
import org.usfirst.frc2783.util.NavSensor;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Subsystem;

public class TankDriveBase extends Subsystem {
	
	class TankPoseOut implements PIDOutput {
		@Override
		public void pidWrite(double output) {
			rot = -output;
		}
	}
	
	class GyroSource implements PIDSource {
		PIDSourceType sourceType;
		
		public GyroSource() {
			setPIDSourceType(PIDSourceType.kDisplacement);
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
			return gyro.getAngle(false);
		}
		
	}
		
	VictorSPX right1 = new VictorSPX(Constants.kRightDrive1);
	VictorSPX right2 = new VictorSPX(Constants.kRightDrive2);
	
	VictorSPX left1 = new VictorSPX(Constants.kLeftDrive1);
	VictorSPX left2 = new VictorSPX(Constants.kLeftDrive2);
	
	NavSensor gyro = NavSensor.getInstance();
	
	double rot;

	PIDController posePid;
	TankPoseOut posePidOut;
	GyroSource posePidSource;
		
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
		
	}
	
	public void setRobotPose(Bearing b){
		posePid.setSetpoint(b.getTheta());
		posePid.enable();
		
		rotate(rot);
		
	}
	
	private void rotate(double rotMot){
		left1.set(ControlMode.PercentOutput, rotMot);
		right1.set(ControlMode.PercentOutput, rotMot);
		
	}
	
	// moves robot with left and right drive sticks
	public void tankDrive(double leftSpeed, double rightSpeed) {
		if(left1.getOutputCurrent() > 2){
			
		}
		left1.set(ControlMode.PercentOutput, -leftSpeed);
		right1.set(ControlMode.PercentOutput, rightSpeed);
		
	}
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new TankDrive());
		
	}

}
