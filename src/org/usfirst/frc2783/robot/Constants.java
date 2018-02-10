package org.usfirst.frc2783.robot;

/**
 * 
 * Class used to set every constant variable
 *
 */
public class Constants {
	
	// IDs for motor controllers correspond to their matching points on the PDP(Power Distribution Panel)
	public static final int kElevator1 = 2;
	public static final int kElevator2 = 12;
	public static final int kIntakeRight = 15;
	public static final int kIntakeLeft = 1;

	public static final int kLeftDrive1 = 4;
	public static final int kLeftDrive2 = 7;
	public static final int kRightDrive1 = 11;
	public static final int kRightDrive2 = 8;
	
	public static final double kPeriod = 0.01; 

	public static final double kAutoPeriod = 0.01;
	
	public static final double kTurretStowedAngle = 0;
	public static final double kTurretAngleTolerance = 0;
	
	public static final double kEventDelay = 4;
	
	public static final int kAndroidAppTcpPort = 8254;
	
	public static final double kCameraFrameRate = 30;
	public static final double kTargetMaxAge = 0.3; 
	
	public static final double kGyroMaxAge = 0.4;
	
	public static final double kCameraXOffset = 13;
	public static final double kCameraYOffset = 0.25;
	public static final double kCameraZOffset = 3;
	public static final double kCameraPitchOffset = 0.0;
	public static final double kCameraRollOffset = 0.0;
	public static final double kCameraYawOffset = 0.0;
	
	public static final double kGoalHeight = 8;
	
	public static final int kArmPdpPortId = 0;
	public static final double kArmCurrentLoweredThreshold = 0.1;
	
	public static final int kDriverControllerId = 0;
	public static final int kManipulatorControllerId = 1;
	
	public static final int kJoyTankLeftID = 3;
	public static final int kJoyTankRightID = 4;
	
	public static final int kLowGearID = 2;
	public static final int kHighGearID = 3;
	
}
