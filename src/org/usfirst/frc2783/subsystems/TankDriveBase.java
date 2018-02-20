package org.usfirst.frc2783.subsystems;

import org.usfirst.frc2783.autonomous.paths.PathFollower;
import org.usfirst.frc2783.commands.TankDrive;
import org.usfirst.frc2783.robot.Constants;
import org.usfirst.frc2783.robot.Robot;
import org.usfirst.frc2783.util.Bearing;
import org.usfirst.frc2783.util.GyroSource;
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
	
	// The robot drivetrain's various states.
    public enum DriveControlState {
        OPEN_LOOP, // open loop voltage control
        VELOCITY_SETPOINT, // velocity PID control
        PATH_FOLLOWING, // used for autonomous driving
        TURN_TO_HEADING, // turn in place
    }
	
	class RightTankSideSource implements PIDSource {
		PIDSourceType sourceType;
		public RightTankSideSource() {
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
			return Robot.rightAbsEnc.getValue()/11.377777777777777778;
		}	
	}
	
	class LeftTankSideSource implements PIDSource {
		PIDSourceType sourceType;
		public LeftTankSideSource() {
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
			return Robot.leftAbsEnc.getValue()/11.377777777777777778;
		}	
	}
	
	class LeftTankSideOut implements PIDOutput {
		@Override
		public void pidWrite(double output){
			leftOut = -output;
		}
	}
	
	class RightTankSideOut implements PIDOutput {
		@Override
		public void pidWrite(double output){
			rightOut = output;
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
	
	DriveControlState mDriveControlState;
	
	PIDController posePid;
	TankPoseOut posePidOut;
	GyroSource posePidSource;
	
	PathFollower mPathFollower;
	
	LeftTankSideSource leftPidSource;
	RightTankSideSource rightPidSource;
	LeftTankSideOut leftSideOut;
	RightTankSideOut rightSideOut;
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
		
		leftPidSource = new LeftTankSideSource();
		rightPidSource = new RightTankSideSource();
		
		leftSideOut = new LeftTankSideOut();
		rightSideOut = new RightTankSideOut();
		
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
	
	public void setLeftPose(double angle){
		leftSideController.setSetpoint(angle);
		rightSideController.enable();
		
		setLeftSide(leftOut);
		
	}
	
	public void setRightPose(double angle){
		rightSideController.setSetpoint(angle);
		rightSideController.enable();
		
		setRightSide(rightOut);
		
	}
	
	private void rotate(double rotMot){
		left1.set(ControlMode.PercentOutput, rotMot);
		right1.set(ControlMode.PercentOutput, rotMot);
		
	}
	
	public void setLeftSide(double speed){
		left1.set(ControlMode.PercentOutput, speed);
	}

	public void setRightSide(double speed){
		right1.set(ControlMode.PercentOutput, speed);
		
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

	public synchronized boolean hasPassedMarker(String marker) {
        if (mDriveControlState == DriveControlState.PATH_FOLLOWING && mPathFollower != null) {
            return mPathFollower.hasPassedMarker(marker);
        } else {
            System.out.println("Robot is not in path following mode");
            return false;
        }
    }

}
