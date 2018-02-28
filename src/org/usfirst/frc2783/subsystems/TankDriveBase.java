package org.usfirst.frc2783.subsystems;

import org.usfirst.frc2783.autonomous.paths.Lookahead;
import org.usfirst.frc2783.autonomous.paths.Path;
import org.usfirst.frc2783.autonomous.paths.PathFollower;
import org.usfirst.frc2783.calculation.RigidTransform2d;
import org.usfirst.frc2783.calculation.Rotation2d;
import org.usfirst.frc2783.calculation.Twist2d;
import org.usfirst.frc2783.commands.TankDrive;
import org.usfirst.frc2783.loops.Loop;
import org.usfirst.frc2783.loops.Looper;
import org.usfirst.frc2783.robot.Constants;
import org.usfirst.frc2783.robot.Kinematics;
import org.usfirst.frc2783.robot.Robot;
import org.usfirst.frc2783.robot.RobotState;
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

/**
 * Subsystem base for the TankDrive
 */
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
    
    private final Loop mLoop = new Loop() {
    
	    

		@Override
		public void onStart() {
			synchronized (TankDriveBase.this) {
                setBrakeMode(false);
                setVelocitySetpoint(0, 0);
            }
		}

		@Override
		public void onLoop(double timestamp) {
	        synchronized (TankDriveBase.this) {
	            switch (mDriveControlState) {
	            case OPEN_LOOP:
	                return;
	            case VELOCITY_SETPOINT:
	                return;
	            case PATH_FOLLOWING:
	                if (mPathFollower != null) {
	                    updatePathFollower(timestamp);
	                }
	                return;
	                // fallthrough intended
	            case TURN_TO_HEADING:
	                return;
	            default:
	                System.out.println("Unexpected drive control state: " + mDriveControlState);
	                break;
	            }
	        }
	    }

		@Override
		public void onStop() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onLoop() {
			// TODO Auto-generated method stub
			
		}
    };
    
    public void registerEnabledLoops(Looper in) {
        in.register(mLoop);
    }
    
    //PID Source Class for the right side of the Tank Drive
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

    //PID Source Class for the left side of the Tank Drive
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

    //PID Output Class for the left side of the Tank Drive
	class LeftTankSideOut implements PIDOutput {
		@Override
		public void pidWrite(double output){
			leftOut = -output;
		}
	}

    //PID Output Class for the right side of the Tank Drive
	class RightTankSideOut implements PIDOutput {
		@Override
		public void pidWrite(double output){
			rightOut = output;
		}
	}
	
	//PID Output Class for tank rotation
	class TankPoseOut implements PIDOutput {
		@Override
		public void pidWrite(double output) {
			rot = -output;
		}
	}
	
	private Rotation2d mTargetHeading = new Rotation2d();
    private Path mCurrentPath = null;
	
	//Instantiates the right tank motor controllers
	public VictorSPX rightMaster = new VictorSPX(Constants.kRightDrive1);
	VictorSPX rightSlave = new VictorSPX(Constants.kRightDrive2);

	//Instantiates the left tank motor controllers
	public VictorSPX leftMaster = new VictorSPX(Constants.kLeftDrive1);
	VictorSPX leftSlave = new VictorSPX(Constants.kLeftDrive2);
	
	//Instantiates gyro as an instance of NavSensor
	NavSensor gyro = NavSensor.getInstance();
	
	RobotState mRobotState;
	
	double rot;

	double leftOut;
	double rightOut;
	
	DriveControlState mDriveControlState;
	
	//Creates Output and Source for the rotation PID
	PIDController posePid;
	TankPoseOut posePidOut;
	GyroSource posePidSource;
	
	PathFollower mPathFollower;
	
	//Creates Outputs and Sources for the left and right side PIDs
	LeftTankSideSource leftPidSource;
	RightTankSideSource rightPidSource;
	LeftTankSideOut leftSideOut;
	RightTankSideOut rightSideOut;
	PIDController leftSideController;
	PIDController rightSideController;

	//Constructor to construct the TankDriveBase
	public TankDriveBase(){
		//Sets the slave motor controllers to follow the masters
		rightSlave.follow(rightMaster);
		leftSlave.follow(leftMaster);
		
		//Sets all drive motors to be in brake mode
		setBrakeMode(true);
		
		//Creates the tank rotation PID controller
		posePidOut = new TankPoseOut();
		posePidSource = new GyroSource();
		posePid = new PIDController(Constants.kTankPoseP, Constants.kTankPoseI, Constants.kTankPoseD, 
										posePidSource, 
										posePidOut);
		posePid.setInputRange(0, 360);
		posePid.setContinuous();
		
		//Creates the left side PID controller
		leftPidSource = new LeftTankSideSource();
		leftSideOut = new LeftTankSideOut();
		leftSideController = new PIDController(Constants.kTankSideP, Constants.kTankSideI, Constants.kTankSideD,
												leftPidSource, leftSideOut);
		leftSideController.setInputRange(0, 360);
		leftSideController.setContinuous(false);
		
		//Creates the right side PID controller
		rightPidSource = new RightTankSideSource();
		rightSideOut = new RightTankSideOut();
		rightSideController = new PIDController(Constants.kTankSideP, Constants.kTankSideI, Constants.kTankSideD,
												rightPidSource, rightSideOut);
		rightSideController.setInputRange(0, 360);
		rightSideController.setContinuous(false);
	}
	
    /**
     * Sets the tank rotation to the Bearing you pass in, 0 - 360
     */
	public void setRobotPose(Bearing bearing){
		posePid.setSetpoint(bearing.getTheta());
		posePid.enable();
		
		rotate(rot);
		
	}
	
	/**
     * Sets the left tank side rotation to the Angle you pass in, 0 - 360
     */
	public void setLeftPose(double angle){
		leftSideController.setSetpoint(angle);
		rightSideController.enable();
		
		setLeftSide(leftOut);
		
	}
	
	/**
     * Sets the right tank rotation to the Angle you pass in, 0 - 360
     */
	public void setRightPose(double angle){
		rightSideController.setSetpoint(angle);
		rightSideController.enable();
		
		setRightSide(rightOut);
		
	}
	
	/**
     * Sets the speed of the tank sides to rotate based on the rotation motion you pass in
     */
	private void rotate(double rotationMotion){
		setLeftSide(rotationMotion);
		setRightSide(rotationMotion);	
	}
	
	/**
     * Sets the left side speed by percent
     */
	public void setLeftSide(double speed){
		leftMaster.set(ControlMode.PercentOutput, speed);
	}

	/**
     * Sets the right side speed by percent
     */
	public void setRightSide(double speed){
		rightMaster.set(ControlMode.PercentOutput, speed);
		
	}
	/**
	 * Moves tank drive by left and right speeds
	 */
	public void tankDrive(double leftSpeed, double rightSpeed) {
		leftMaster.set(ControlMode.PercentOutput, -leftSpeed);
		rightMaster.set(ControlMode.PercentOutput, rightSpeed);
		
	}
	
	@Override
	protected void initDefaultCommand() {
		TankDrive mhm = new TankDrive();
		setDefaultCommand(mhm);
		
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
     * Configures the drivebase to drive a path. Used for autonomous driving
     * THIS is what converts arcs to movenemts
     * 
     * @see Path
     */
    public synchronized void setWantDrivePath(Path path, boolean reversed) {
        if (mCurrentPath != path || mDriveControlState != DriveControlState.PATH_FOLLOWING) {
            //RobotState.getInstance().resetDistanceDriven(); //Need to reset rotations
            mPathFollower = new PathFollower(path, reversed,
                    new PathFollower.Parameters(
                            new Lookahead(Constants.kMinLookAhead,
                            			  Constants.kMaxLookAhead,
                                    	  Constants.kMinLookAheadSpeed,
                                    	  Constants.kMaxLookAheadSpeed),
                            			  Constants.kInertiaSteeringGain,
                            			  Constants.kPathFollowingProfileKp,
                            			  Constants.kPathFollowingProfileKi,
                            			  Constants.kPathFollowingProfileKv,
                            			  Constants.kPathFollowingProfileKffv,
                            			  Constants.kPathFollowingProfileKffa,
                            			  Constants.kPathFollowingMaxVel,
                            			  Constants.kPathFollowingMaxAccel,
                            			  Constants.kPathFollowingGoalPosTolerance,
                            			  Constants.kPathFollowingGoalVelTolerance, 
                            			  Constants.kPathStopSteeringDistance));
            mDriveControlState = DriveControlState.PATH_FOLLOWING;
            mCurrentPath = path;
        } else {
            setVelocitySetpoint(0, 0); //This method takes the movements and sends them to encoders
        }
    }
    
    /**
     * Called periodically when the robot is in path following mode. Updates the path follower with the robots latest
     * pose, distance driven, and velocity, the updates the wheel velocity setpoints.
     */
    private void updatePathFollower(double timestamp) {
		RigidTransform2d robot_pose = mRobotState.getLatestFieldToVehicle().getValue();
        
        //This command is that command that takes a path
        Twist2d command = mPathFollower.update(timestamp, robot_pose,
                RobotState.getInstance().getDistanceDriven(), RobotState.getInstance().getPredictedVelocity().dx);
        if (!mPathFollower.isFinished()) {
            Kinematics.DriveVelocity setpoint = Kinematics.inverseKinematics(command);
            updateVelocitySetpoint(setpoint.left, setpoint.right);
        } else {
            updateVelocitySetpoint(0, 0);
        }
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
     * Takes inches in parameters and tells robot to
     * move that many inches by converting inchesToRotations
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
    
    /**
	 * Sets Brake Mode based on Boolean you pass in, true = brake
	 */
	public void setBrakeMode(boolean on) {
		if (on) {
			rightMaster.setNeutralMode(NeutralMode.Brake);
			rightSlave.setNeutralMode(NeutralMode.Brake);
			
			leftMaster.setNeutralMode(NeutralMode.Brake);
			leftSlave.setNeutralMode(NeutralMode.Brake);
		}
		else {
			rightMaster.setNeutralMode(NeutralMode.Coast);
			rightSlave.setNeutralMode(NeutralMode.Coast);
			
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
	
	public synchronized boolean isDoneWithPath() {
        if (mDriveControlState == DriveControlState.PATH_FOLLOWING && mPathFollower != null) {
            return mPathFollower.isFinished();
        } else {
            System.out.println("Robot is not in path following mode");
            return true;
        }
    }
	
}
