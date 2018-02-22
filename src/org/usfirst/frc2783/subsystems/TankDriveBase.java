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
	
    /**
     * Check if the drive talons are configured for velocity control
     */
    protected static boolean usesTalonVelocityControl(DriveControlState state) {
        if (state == DriveControlState.VELOCITY_SETPOINT || state == DriveControlState.PATH_FOLLOWING) {
            return true;
        }
        return false;
    }

    /**
     * Check if the drive talons are configured for position control
     */
    protected static boolean usesTalonPositionControl(DriveControlState state) {
        if (state == DriveControlState.TURN_TO_HEADING) {
            return true;
        }
        return false;
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
		
	public VictorSPX rightMaster = new VictorSPX(Constants.kRightDrive1);
	VictorSPX right2 = new VictorSPX(Constants.kRightDrive2);
	
	public VictorSPX leftMaster = new VictorSPX(Constants.kLeftDrive1);
	VictorSPX leftSlave = new VictorSPX(Constants.kLeftDrive2);
	
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
		right2.follow(rightMaster);
		leftSlave.follow(leftMaster);
		
		setBrakeMode(true);
		
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
		leftMaster.set(ControlMode.PercentOutput, rotMot);
		rightMaster.set(ControlMode.PercentOutput, rotMot);
		
	}
	
	public void setLeftSide(double speed){
		leftMaster.set(ControlMode.PercentOutput, speed);
	}

	public void setRightSide(double speed){
		rightMaster.set(ControlMode.PercentOutput, speed);
		
	}
	
	//Moves tank drive by left and right speeds
	public void tankDrive(double leftSpeed, double rightSpeed) {
		leftMaster.set(ControlMode.PercentOutput, -leftSpeed);
		rightMaster.set(ControlMode.PercentOutput, rightSpeed);
		
	}
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new TankDrive());
		
	}
	
    /**
     * Adjust Velocity setpoint (if already in velocity mode)
     * 
     * @param left_inches_per_sec
     * @param right_inches_per_sec
     */
    @SuppressWarnings("unused")
	private synchronized void updateVelocitySetpoint(double left_inches_per_sec, double right_inches_per_sec) {
        if (usesTalonVelocityControl(mDriveControlState)) {
            final double max_desired = Math.max(Math.abs(left_inches_per_sec), Math.abs(right_inches_per_sec));
            final double scale = max_desired > Constants.kDriveHighGearMaxSetpoint
                    ? Constants.kDriveHighGearMaxSetpoint / max_desired : 1.0;
            leftMaster.set(ControlMode.Velocity, inchesPerSecondToRpm(left_inches_per_sec * scale));
            rightMaster.set(ControlMode.Velocity, inchesPerSecondToRpm(right_inches_per_sec * scale));
        } else {
            System.out.println("Hit a bad velocity control state");
            leftMaster.set(ControlMode.Velocity, 0);
            rightMaster.set(ControlMode.Velocity, 0);
        }
    }

    /**
     * Adjust position setpoint (if already in position mode)
     * 
     * @param left_inches_per_sec
     * @param right_inches_per_sec
     */
    @SuppressWarnings("unused")
	private synchronized void updatePositionSetpoint(double left_position_inches, double right_position_inches) {
        if (usesTalonPositionControl(mDriveControlState)) {
            leftMaster.set(ControlMode.Position, inchesToRotations(left_position_inches));
            rightMaster.set(ControlMode.Position, inchesToRotations(right_position_inches));
        } else {
            System.out.println("Hit a bad position control state");
            leftMaster.set(ControlMode.Position, 0);
            rightMaster.set(ControlMode.Position, 0);
        }
    }
	
    private static double inchesPerSecondToRpm(double inches_per_second) {
        return inchesToRotations(inches_per_second) * 60;
    }
    
    private static double inchesToRotations(double inches) {
        return inches / (Constants.kWheelDiameterByInches * Math.PI);
    }
    
	public void setBrakeMode(boolean on) {
		if (on) {
			rightMaster.setNeutralMode(NeutralMode.Brake);
			right2.setNeutralMode(NeutralMode.Brake);
			
			leftMaster.setNeutralMode(NeutralMode.Brake);
			leftSlave.setNeutralMode(NeutralMode.Brake);
		}
		else {
			rightMaster.setNeutralMode(NeutralMode.Coast);
			right2.setNeutralMode(NeutralMode.Coast);
			
			leftMaster.setNeutralMode(NeutralMode.Coast);
			leftSlave.setNeutralMode(NeutralMode.Coast);
		}
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
