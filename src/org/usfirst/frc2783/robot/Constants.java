package org.usfirst.frc2783.robot;

import edu.wpi.first.wpilibj.Solenoid;

/**
 * 
 * Class used to set every constant variable
 *
 */
public class Constants {
	
	//IDs for manipulator motor controllers, corresponds to their matching points on the PDP(Power Distribution Panel)
	public static final int kElevator1 = 2;
	public static final int kElevator2 = 0;
	public static final int kIntakeRight = 15;
	public static final int kIntakeLeft = 12;

	//IDs for drive motor controllers, corresponds to their matching points on the PDP(Power Distribution Panel)
	public static final int kLeftDrive1 = 4;
	public static final int kLeftDrive2 = 7;
	public static final int kRightDrive1 = 11;
	public static final int kRightDrive2 = 8;
	
	//Servo IDs (plugged into PWM ports)
	public static final int kElevatorShifterID = 0;

	//Joystick IDs
	public static final int kDriverControllerId = 0;
	public static final int kManipulatorControllerId = 1;
	
	public static final int kJoyTankLeftID = 3;
	public static final int kJoyTankRightID = 4;
	
	//Button IDs for manipulator
	public static final int kIntakeTestThing = 7;
	
	public static final int kElevatorToGroundID = 1;
	public static final int kElevatorToSwitchID = 2;
	public static final int kElevatorToScaleID = 4;
	
	public static final int kIntakeSpinnerID = 3;
	
	public static final int kElevatorLockShiftID = 9;
	public static final int kElevatorGearShiftID = 10;
	
	//Button IDs for driver
	public static final int kSlowModeID = 5;
	public static final int kFastModeID = 6;
	
	public static final int kVisionTestID = 1;
	
	public static final int kGyroResetID = 4;
	
	//PID values for tank rotation to angle
	public static final double kTankPoseP = 0.007;
	public static final double kTankPoseI = 0.0;
	public static final double kTankPoseD = 0.008;
	
	//PID values for gyro adjusted drive
	public static final double kGyroDriveP = 0.01;
	public static final double kGyroDriveI = 0.001;
	public static final double kGyroDriveD = 0.09;
	
	//PID values for tank wheel angle adjusters
	public static final double kTankSideP = 0.0075;
	public static final double kTankSideI = 0.0003;
	public static final double kTankSideD = 0.005;
	
	//PID values for elevator angle adjuster
	public static final double kElevatorP = 0.0075;
	public static final double kElevatorI = 0.0003;
	public static final double kElevatorD = 0.005;
	
	// Offsets for vision in inches
	public static final double kCameraXOffset = 6;     // distance forward of camera from center of robot
	public static final double kCameraYOffset = 0;   	// distance left or right of camera from center of robot	
	public static final double kCameraZOffset = 14;		// distance of camera from ground
	public static final double kCameraPitchOffset = 0.0;
	public static final double kCameraRollOffset = 0.0;
	public static final double kCameraYawOffset = 0.0;
	
	public static final double kGoalHeight = 6;	    // height to center of target in inches
	
	
	//Time between each loop in a loop in hertz
	public static final double kPeriod = 200; 
	public static final double kSlowLooperPeriod = 1;
	
	//Time between each loop in autonomous actions in hertz
	public static final double kAutoPeriod = 200;
	
	//Need to adjust these for our purposes
	public static double kTrackWidthInches = 26.655;
    public static double kTrackScrubFactor = 0.924;
	
	public static final double kTurretStowedAngle = 0;
	public static final double kTurretAngleTolerance = 0;
	
	public static final double kEventDelay = 4;
	
	public static final int kAndroidAppTcpPort = 8254;

	public static final double kWheelDiameterByInches = 6;
	public static final double kWheelCircumferenceByInches = kWheelDiameterByInches * Math.PI;
	public static final double kInchPerDegree = kWheelCircumferenceByInches/4096;
	
	// Path following constants
    public static double kMinLookAhead = 12.0; // inches
    public static double kMinLookAheadSpeed = 9.0; // inches per second
    public static double kMaxLookAhead = 24.0; // inches
    public static double kMaxLookAheadSpeed = 120.0; // inches per second
    public static double kDeltaLookAhead = kMaxLookAhead - kMinLookAhead;
    public static double kDeltaLookAheadSpeed = kMaxLookAheadSpeed - kMinLookAheadSpeed;

    public static double kInertiaSteeringGain = 0.0; // angular velocity command is multiplied by this gain *
                                                     // our speed
                                                     // in inches per sec
    public static double kSegmentCompletionTolerance = 0.1; // inches
    public static double kPathFollowingMaxAccel = 120.0; // inches per second^2
    public static double kPathFollowingMaxVel = 120.0; // inches per second
    public static double kPathFollowingProfileKp = 5.00;
    public static double kPathFollowingProfileKi = 0.03;
    public static double kPathFollowingProfileKv = 0.02;
    public static double kPathFollowingProfileKffv = 1.0;
    public static double kPathFollowingProfileKffa = 0.05;
    public static double kPathFollowingGoalPosTolerance = 0.75;
    public static double kPathFollowingGoalVelTolerance = 12.0;
    public static double kPathStopSteeringDistance = 9.0;
	
	public static final double kCameraFrameRate = 30;
	public static final double kTargetMaxAge = 0.3; 
	
	public static final double kGyroMaxAge = 0.4;
	
	public static final int kArmPdpPortId = 0;
	public static final double kArmCurrentLoweredThreshold = 0.1;
	
	public static final double kDriveHighGearMaxSetpoint = 17 * 12; //17 feet per second
	
	/**
     * Make an {@link Solenoid} instance for the single-number ID of the solenoid
     * 
     * @param solenoidId
     *            One of the kXyzSolenoidId constants
     */
    public static Solenoid makeSolenoidForId(int solenoidId) {
        return new Solenoid(solenoidId / 8, solenoidId % 8);
    }
	
}
