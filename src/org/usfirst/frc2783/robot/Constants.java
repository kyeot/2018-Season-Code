package org.usfirst.frc2783.robot;

/**
 * 
 * Class used to set every constant variable
 *
 */
public class Constants {
	
	public static final double kTankP = 0.001;
	public static final double kTankI = 0.0;
	public static final double kTankD = 0.0;
	
	public static final double encoderScaler = 11.3777777777777777777777777777778;
	
	public static final double wheelDiameterByInches = 6;
	public static final double wheelCircumferenceByInches = wheelDiameterByInches * Math.PI;
	public static final double inchPerDegree = wheelDiameterByInches/4096;
	
	public static final int kLeftSide1ID = 4;
	public static final int kLeftSide2ID = 7;
	public static final int kRightSide1ID = 8;
	public static final int kRightSide2ID = 11;
	
	public static final double kPeriod = 0.0005; 

	public static final double kAutoPeriod = 0.0005;
	
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
	
}
