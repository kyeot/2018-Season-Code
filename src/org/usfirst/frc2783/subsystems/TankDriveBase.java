package org.usfirst.frc2783.subsystems;

import org.usfirst.frc2783.commands.TankDrive;
import org.usfirst.frc2783.paths.PathFollower;
import org.usfirst.frc2783.robot.Constants;
import org.usfirst.frc2783.robot.Robot;
import org.usfirst.frc2783.util.Bearing;
import org.usfirst.frc2783.util.GyroSource;
import org.usfirst.frc2783.util.LeftEncoderCounter;
import org.usfirst.frc2783.util.NavSensor;
import org.usfirst.frc2783.util.RightEncoderCounter;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
<<<<<<< HEAD
import edu.wpi.first.wpilibj.Solenoid;
=======
>>>>>>> eec6a3416388300c7828cdec2354e14acf17a54a
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TankDriveBase extends Subsystem {
	
<<<<<<< HEAD
	public enum DriveControlState {
        OPEN_LOOP, // open loop voltage control
        VELOCITY_SETPOINT, // velocity PID control
        PATH_FOLLOWING, // used for autonomous driving
        TURN_TO_HEADING, // turn in place
    }

	class LeftTankSideSource implements PIDSource {
		PIDSourceType sourceType;

		public LeftTankSideSource() {
			setPIDSourceType(PIDSourceType.kDisplacement);
		}

=======
	class LeftTankSideSource implements PIDSource {
		PIDSourceType sourceType;
		public LeftTankSideSource() {
			setPIDSourceType(PIDSourceType.kDisplacement);
		}
>>>>>>> eec6a3416388300c7828cdec2354e14acf17a54a
		@Override
		public void setPIDSourceType(PIDSourceType pidSource) {
			sourceType = pidSource;
		}
<<<<<<< HEAD

=======
>>>>>>> eec6a3416388300c7828cdec2354e14acf17a54a
		@Override
		public PIDSourceType getPIDSourceType() {
			return sourceType;
		}
<<<<<<< HEAD

		@Override
		public double pidGet() {
			return Robot.leftAbsEnc.getValue() / 11.377777777777777778;
		}
	}

	class RightTankSideSource implements PIDSource {
		PIDSourceType sourceType;

		public RightTankSideSource() {
			setPIDSourceType(PIDSourceType.kDisplacement);
		}

=======
		@Override
		public double pidGet() {
			return Robot.leftAbsEnc.getValue()/11.377777777777777778;
		}	
	}
	
	class RightTankSideSource implements PIDSource {
		PIDSourceType sourceType;
		public RightTankSideSource() {
			setPIDSourceType(PIDSourceType.kDisplacement);
		}
>>>>>>> eec6a3416388300c7828cdec2354e14acf17a54a
		@Override
		public void setPIDSourceType(PIDSourceType pidSource) {
			sourceType = pidSource;
		}
<<<<<<< HEAD

=======
>>>>>>> eec6a3416388300c7828cdec2354e14acf17a54a
		@Override
		public PIDSourceType getPIDSourceType() {
			return sourceType;
		}
<<<<<<< HEAD

		@Override
		public double pidGet() {
			return Robot.rightAbsEnc.getValue() / 11.377777777777777778;
		}
	}

	class LeftTankSideOut implements PIDOutput {
		@Override
		public void pidWrite(double output) {
			leftOut = -output;
		}
	}

	class RightTankSideOut implements PIDOutput {
		@Override
		public void pidWrite(double output) {
			leftOut = output;
		}
	}

=======
		@Override
		public double pidGet() {
			return Robot.rightAbsEnc.getValue()/11.377777777777777778;
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
			leftOut = output;
		}
	}
	
>>>>>>> eec6a3416388300c7828cdec2354e14acf17a54a
	class TankPoseOut implements PIDOutput {
		@Override
		public void pidWrite(double output) {
			rot = -output;
		}
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

	public VictorSPX mRightMaster = new VictorSPX(Constants.kRightDrive1);
	VictorSPX right2 = new VictorSPX(Constants.kRightDrive2);

	public VictorSPX mLeftMaster = new VictorSPX(Constants.kLeftDrive1);
	VictorSPX left2 = new VictorSPX(Constants.kLeftDrive2);

	NavSensor gyro = NavSensor.getInstance();

	double rot;

	double leftOut;
	double rightOut;
	
<<<<<<< HEAD
	DriveControlState mDriveControlState;
	
	PIDController posePid;
	TankPoseOut posePidOut;
	GyroSource posePidSource;

=======
	PIDController posePid;
	TankPoseOut posePidOut;
	GyroSource posePidSource;
	
>>>>>>> eec6a3416388300c7828cdec2354e14acf17a54a
	LeftTankSideSource leftPidSource;
	RightTankSideSource rightPidSource;
	LeftTankSideOut leftSideOut;
	RightTankSideOut rightSideOut;
	PIDController leftSideController;
	PIDController rightSideController;
<<<<<<< HEAD
	
	private final Solenoid mShifter;
	private PathFollower mPathFollower;

	public TankDriveBase() {
		right2.follow(mRightMaster);
		left2.follow(mLeftMaster);

		setBrakeMode(true);

=======
		
	public TankDriveBase(){
		right2.follow(right1);
		left2.follow(left1);
		
		right1.setNeutralMode(NeutralMode.Brake);
		right2.setNeutralMode(NeutralMode.Brake);
		
		left1.setNeutralMode(NeutralMode.Brake);
		left2.setNeutralMode(NeutralMode.Brake);
		
>>>>>>> eec6a3416388300c7828cdec2354e14acf17a54a
		posePidOut = new TankPoseOut();
		posePidSource = new GyroSource();
		posePid = new PIDController(Constants.kTankPoseP, Constants.kTankPoseI, Constants.kTankPoseD, posePidSource,
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
		
<<<<<<< HEAD
		mShifter = new Solenoid(0 / 8, 0 % 8);
=======
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
>>>>>>> eec6a3416388300c7828cdec2354e14acf17a54a
	}
	
	public synchronized void setBrakeMode(boolean on) {
		if (on) {
			mRightMaster.setNeutralMode(NeutralMode.Brake);
			right2.setNeutralMode(NeutralMode.Brake);

			mLeftMaster.setNeutralMode(NeutralMode.Brake);
			left2.setNeutralMode(NeutralMode.Brake);
		} else {
			mRightMaster.setNeutralMode(NeutralMode.Coast);
			right2.setNeutralMode(NeutralMode.Coast);

			mLeftMaster.setNeutralMode(NeutralMode.Coast);
			left2.setNeutralMode(NeutralMode.Coast);
		}
	}
	
	/**
     * Start up velocity mode. This sets the drive train in high gear as well.
     * 
     * @param left_inches_per_sec
     * @param right_inches_per_sec
     */
    public synchronized void setVelocitySetpoint(double left_inches_per_sec, double right_inches_per_sec) {
        mDriveControlState = DriveControlState.VELOCITY_SETPOINT;
        updateVelocitySetpoint(left_inches_per_sec, right_inches_per_sec);
    }

  

    /**
     * Adjust Velocity setpoint (if already in velocity mode)
     * 
     * @param left_inches_per_sec
     * @param right_inches_per_sec
     */
    private synchronized void updateVelocitySetpoint(double left_inches_per_sec, double right_inches_per_sec) {
        if (usesTalonVelocityControl(mDriveControlState)) {
            final double max_desired = Math.max(Math.abs(left_inches_per_sec), Math.abs(right_inches_per_sec));
            final double scale = max_desired > Constants.kDriveHighGearMaxSetpoint
                    ? Constants.kDriveHighGearMaxSetpoint / max_desired : 1.0;
            mLeftMaster.set(ControlMode.Velocity, inchesPerSecondToRpm(left_inches_per_sec * scale));
            mRightMaster.set(ControlMode.Velocity, inchesPerSecondToRpm(right_inches_per_sec * scale));
        } else {
            System.out.println("Hit a bad velocity control state");
            mLeftMaster.set(ControlMode.Velocity, 0);
            mRightMaster.set(ControlMode.Velocity, 0);
        }
    }

    /**
     * Adjust position setpoint (if already in position mode)
     * 
     * @param left_inches_per_sec
     * @param right_inches_per_sec
     */
    private synchronized void updatePositionSetpoint(double left_position_inches, double right_position_inches) {
        if (usesTalonPositionControl(mDriveControlState)) {
            mLeftMaster.set(ControlMode.Position, inchesToRotations(left_position_inches));
            mRightMaster.set(ControlMode.Position, inchesToRotations(right_position_inches));
        } else {
            System.out.println("Hit a bad position control state");
            mLeftMaster.set(ControlMode.Velocity, 0);
            mRightMaster.set(ControlMode.Velocity, 0);
        }
    }

    private static double rotationsToInches(double rotations) {
        return rotations * (Constants.kDriveWheelDiameterInches * Math.PI);
    }

    private static double rpmToInchesPerSecond(double rpm) {
        return rotationsToInches(rpm) / 60;
    }

    private static double inchesToRotations(double inches) {
        return inches / (Constants.kDriveWheelDiameterInches * Math.PI);
    }

    private static double inchesPerSecondToRpm(double inches_per_second) {
        return inchesToRotations(inches_per_second) * 60;
    }

    public double getLeftDistanceInches() {
        return rotationsToInches(LeftEncoderCounter.leftRotationCounter);
    }

    public double getRightDistanceInches() {
        return rotationsToInches(RightEncoderCounter.rightRotationCounter);
    }

    public double getLeftVelocityInchesPerSec() {
        return rpmToInchesPerSecond(LeftEncoderCounter.leftRotationCounter);
    }

    public double getRightVelocityInchesPerSec() {
        return rpmToInchesPerSecond(RightEncoderCounter.rightRotationCounter);
    }
    
    public boolean hasPassedMarker(String marker) {
        if (mDriveControlState == DriveControlState.PATH_FOLLOWING && mPathFollower != null) {
            return mPathFollower.hasPassedMarker(marker);
        } else {
            System.out.println("Robot is not in path following mode");
            return false;
        }
    }
	
	public void setRobotPose(Bearing b) {
		posePid.setSetpoint(b.getTheta());
		posePid.enable();

		rotate(rot);

	}
<<<<<<< HEAD

	public void setLeftSidePose(double angle) {
		leftSideController.setSetpoint(angle);
		leftSideController.enable();

		setLeft(leftOut);

=======
	
	public void setLeftSidePose(double angle){
		leftSideController.setSetpoint(angle);
		leftSideController.enable();
		
		setLeft(leftOut);
		
	}
	
	public void setRightSidePose(double angle){
		rightSideController.setSetpoint(angle);
		rightSideController.enable();
		
		setRight(rightOut);
		
	}
	
	private void setLeft(double speed){
		left1.set(ControlMode.PercentOutput, speed);
	}
	
	private void setRight(double speed){
		right1.set(ControlMode.PercentOutput, speed);
	}
	
	private void rotate(double rotMot){
		left1.set(ControlMode.PercentOutput, rotMot);
		right1.set(ControlMode.PercentOutput, rotMot);
		
>>>>>>> eec6a3416388300c7828cdec2354e14acf17a54a
	}

	public void setRightSidePose(double angle) {
		rightSideController.setSetpoint(angle);
		rightSideController.enable();

		setRight(rightOut);

	}

	private void setLeft(double speed) {
		mLeftMaster.set(ControlMode.PercentOutput, speed);
	}

	private void setRight(double speed) {
		mRightMaster.set(ControlMode.PercentOutput, speed);
	}

	private void rotate(double rotMot) {
		mLeftMaster.set(ControlMode.PercentOutput, rotMot);
		mRightMaster.set(ControlMode.PercentOutput, rotMot);

	}

	// Moves tank drive by left and right speeds
	public void tankDrive(double leftSpeed, double rightSpeed) {
		mLeftMaster.set(ControlMode.PercentOutput, -leftSpeed);
		mRightMaster.set(ControlMode.PercentOutput, rightSpeed);

	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new TankDrive());

	}

}
