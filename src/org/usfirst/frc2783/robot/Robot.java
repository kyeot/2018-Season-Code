package org.usfirst.frc2783.robot;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.usfirst.frc2783.autonomous.actions.ActionGroup;
import org.usfirst.frc2783.autonomous.actions.ActionScheduler;
import org.usfirst.frc2783.autonomous.actions.TandemAction;
import org.usfirst.frc2783.autonomous.actions.groups.BaselineCross;
import org.usfirst.frc2783.autonomous.actions.groups.DoTheThing2;
import org.usfirst.frc2783.autonomous.actions.groups.DoubleScaleFromLeft;
import org.usfirst.frc2783.autonomous.actions.groups.DoubleScaleFromRight;
import org.usfirst.frc2783.autonomous.actions.groups.ScaleFromLeft;
import org.usfirst.frc2783.autonomous.actions.groups.ScaleFromLeftFarOut;
import org.usfirst.frc2783.autonomous.actions.groups.ScaleFromRight;
import org.usfirst.frc2783.autonomous.actions.groups.ScaleFromRightFarOut;
import org.usfirst.frc2783.autonomous.actions.groups.ScaleSwitchFromLeft;
import org.usfirst.frc2783.autonomous.actions.groups.ScaleSwitchFromRight;
import org.usfirst.frc2783.autonomous.actions.groups.SwitchFromCenter;
import org.usfirst.frc2783.autonomous.actions.groups.SwitchFromLeft;
import org.usfirst.frc2783.autonomous.actions.groups.SwitchFromRight;
import org.usfirst.frc2783.autonomous.actions.groups.TestAuto;
import org.usfirst.frc2783.loops.ElevatorEncoderCounter;
import org.usfirst.frc2783.loops.LeftEncoderCounter;
import org.usfirst.frc2783.loops.LogData;
import org.usfirst.frc2783.loops.Loop;
import org.usfirst.frc2783.loops.Looper;
import org.usfirst.frc2783.loops.RightEncoderCounter;
import org.usfirst.frc2783.loops.VisionProcessor;
import org.usfirst.frc2783.subsystems.ElevatorBase;
import org.usfirst.frc2783.subsystems.IntakeBase;
import org.usfirst.frc2783.subsystems.TankDriveBase;
import org.usfirst.frc2783.util.EncoderPosition;
import org.usfirst.frc2783.util.Logger;
import org.usfirst.frc2783.util.NavSensor;
import org.usfirst.frc2783.vision.VisionServer;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {

	// Instantiates the Object Interface
	public static OI oi;

	// Creates NavSensor for detecting the angle of the robot
	@SuppressWarnings("unused")
	private static AHRS navSensor;

	// Creates Subsystems for each main robot function
	public static TankDriveBase tankDrive = new TankDriveBase();
	public static IntakeBase intake = new IntakeBase();
	public static ElevatorBase elevatorBase = new ElevatorBase();

	// Creates Scheduler for running the correct actions at the correct times
	// during auto
	public static ActionScheduler autoScheduler = new ActionScheduler();
	public static TandemAction tandemAction = new TandemAction();
	
	public void setGroup(ActionGroup group) {
		autoScheduler.setGroup(group);
		tandemAction.setGroup(group);
	}

	// Creates externally used and called variables
	public static boolean isLeftForward = true;
	public static boolean isRightForward = true;
	public static boolean isElevatorForward = true;

	public static boolean yesso = false;

	public static boolean isHigh;
	public static boolean isClimb;
	public static boolean isUp;

	public static boolean isLimit = false;

	public static boolean switchAutoIsFront = true;
	public static boolean scaleAutoWillFar = true;
	
	public static double angle = 0;
	
	public double leftTotalAngle = 0;
	public double rightTotalAngle = 0;
	
//	DigitalInput intakeLimit = new DigitalInput(0);
	
	// Creates Randomizer for use in test autonomous
	public static Random rand = new Random();

	// Creates Loopers
	public static Looper looper = new Looper(Constants.kPeriod);
	public static Looper slowLoop = new Looper(Constants.kSlowLooperPeriod);

	public UsbCamera camera = CameraServer.getInstance().startAutomaticCapture(0);

	// Creates the simple loop used to log at a slow rate
	private Loop slowLoopLogger = new Loop() {
		@Override
		public void onStart() {
		}

		@Override
		public void onLoop() {
			Logger.info("Your voltage is: " + RobotController.getInputVoltage());
		}

		@Override
		public void onStop() {
		}

		@Override
		public void onLoop(double timestamp) {
		}
	};

	// Creates Encoders with Respective IDs
	public static AnalogInput leftAbsEnc = new AnalogInput(0);
	public static AnalogInput rightAbsEnc = new AnalogInput(1);	public static AnalogInput elevatorAbsEnc = new AnalogInput(2);

	// Creates Encoder Counters for measuring Loops on each Encoder
	public static LeftEncoderCounter leftCounter = new LeftEncoderCounter();
	public static RightEncoderCounter rightCounter = new RightEncoderCounter();
	public static ElevatorEncoderCounter elEncCounter = new ElevatorEncoderCounter();

	// Creates Elevator Encoder set Position Variables
	public static EncoderPosition groundPos = new EncoderPosition(1, elEncCounter.getEncoderStartPos());
	public static EncoderPosition switchPos = new EncoderPosition(6, elEncCounter.getEncoderStartPos());
	public static EncoderPosition scalePos = new EncoderPosition(13, elEncCounter.getEncoderStartPos());

	// Creates Variables for storing which sides of the field elements are which
	public static String gameData;
	public static String switchesVal;
	public static String scaleVal;

	// Creates Instances of Vision Classes for Communicating with the phone
	public static FieldTransform fieldTransform = FieldTransform.getInstance();
	VisionServer mVisionServer = VisionServer.getInstance();

	public void robotInit() {
		oi = new OI();

		// Clears SmartDashboard
		SmartDashboard.putString("DB/String 0", "");
		SmartDashboard.putString("DB/String 1", "");
		SmartDashboard.putString("DB/String 2", "");
		SmartDashboard.putString("DB/String 3", "");
		SmartDashboard.putString("DB/String 4", "");
		SmartDashboard.putString("DB/String 5", "");
		SmartDashboard.putString("DB/String 6", "");
		SmartDashboard.putString("DB/String 7", "");
		SmartDashboard.putString("DB/String 8", "");
		SmartDashboard.putString("DB/String 9", "");

		// Adds VisionProcessor Loop to the server
		mVisionServer.addVisionUpdateReceiver(VisionProcessor.getInstance());

		// Resets NavSensor to make 0 forward
		NavSensor.getInstance().resetGyroNorth(180, 0);

		// Adds loops to the main looper
		looper.addLoop(new LogData());
//		looper.addLoop(VisionProcessor.getInstance());
		looper.addLoop(leftCounter);
		looper.addLoop(rightCounter);
		looper.addLoop(elEncCounter);
		looper.addLoop(tankDrive.registerEnabledLoops());
		Logger.info("Starting Loops");
		// Starts the main looper
		looper.startLoops();

		// Adds slow loops to the slow looper
		slowLoop.addLoop(slowLoopLogger);
		// Starts the slow looper
		slowLoop.startLoops();

		// Creates a List of selectable autonomous groups
		String[] autonomousList = {"DoTheThing",
								   "BaselineCross",
								   "Test",
								   "SwitchFromCenter",
								   "SwitchFromLeftFar",
								   "SwitchFromRightFar",
								   "ScaleFromLeft",
								   "ScaleFromRight",
								   "2ScaleFromLeft",
								   "2ScaleFromRight",
								   "ScaleFromLeftNoFarSide",
								   "ScaleFromRightNoFarSide",
								   "2ScaleFromLeftNoFarSide",
								   "2ScaleFromRightNoFarSide",
								   "ScaleFromLeftNullZone",
								   "ScaleFromRightNullZone"};

		// Puts the autonomous groups list into the dashboard
		SmartDashboard.putStringArray("Auto List", autonomousList);

		// Updates the history of NavSensor angles
		NavSensor.getInstance().updateHistory();

		// Creates the log file in a directory on the roborio
		File logFile = new File("/home/lvuser/log.txt");
		try {
			logFile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Creates the NavSensor
		try {
			navSensor = new AHRS(SPI.Port.kMXP);
		} catch (RuntimeException ex) {
			DriverStation.reportError("Error instantiating navX MXP:  " + ex.getMessage(), true);
		}
	}

	public void disabledInit() {
	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		
		leftTotalAngle = ((Robot.leftCounter.getRotations())*(4096)) + Robot.leftAbsEnc.getValue();
		rightTotalAngle = ((Robot.rightCounter.getRotations())*(4096)) + Robot.rightAbsEnc.getValue();
		
	}

	public void autonomousInit() {
		
		Logger.info("Starting Autonomous");

		// Creates the String based on which autonomous group was selected on
		// the dashboard
		String autoSelected = SmartDashboard.getString("Auto Selector", "None");

		// Makes the field element sides corrospond to actual sides which
		// information from the driver station (or a randomizer in test mode)
		gameData = getPracticeData(false);
		switchesVal = gameData.substring(0, 1);
		scaleVal = gameData.substring(1, 2);

		// Switch Statement to Run the Right Autonomous group Depending on the
		// selected position and switch/scale sides
		switch (autoSelected) {
		case "DoTheThing":
			setGroup(new DoTheThing2());
			break;
		case "Test":
			setGroup(new TestAuto());
			break;
		case "ScaleFromLeft":
			Robot.scaleAutoWillFar = true;
			setGroup(new ScaleFromLeft());
			break;
		case "ScaleFromRight":
			Robot.scaleAutoWillFar = true;
			setGroup(new ScaleFromRight());
			break;
		case "SwitchFromLeftClose":
			Robot.switchAutoIsFront = true;
			setGroup(new SwitchFromLeft());
			break;
		case "SwitchFromRightClose":
			Robot.switchAutoIsFront = true;
			setGroup(new SwitchFromRight());
			break;
		case "SwitchFromLeftFar":
			Robot.switchAutoIsFront = false;
			setGroup(new SwitchFromLeft());
			break;
		case "SwitchFromRightFar":
			Robot.switchAutoIsFront = false;
			setGroup(new SwitchFromRight());
			break;
		case "SwitchFromCenter":
			setGroup(new SwitchFromCenter());
			break;
		case "BaselineCross":
			setGroup(new BaselineCross());
			break;
		case "2ScaleFromLeft":
			Robot.scaleAutoWillFar = true;
			setGroup(new DoubleScaleFromLeft());
			break;
		case "ScaleSwitchFromLeft":
			Robot.scaleAutoWillFar = true;
			setGroup(new ScaleSwitchFromLeft());
			break;
		case "2ScaleFromRight":
			Robot.scaleAutoWillFar = true;
			setGroup(new DoubleScaleFromRight());
			break;
		case "ScaleSwitchFromRight":
			Robot.scaleAutoWillFar = true;
			setGroup(new ScaleSwitchFromRight());
			break;
		case "ScaleFromLeftNoFarSide":
			Robot.scaleAutoWillFar = false;
			setGroup(new ScaleFromLeft());
			break;
		case "ScaleFromRightNoFarSide":
			Robot.scaleAutoWillFar = false;
			setGroup(new ScaleFromRight());
			break;
		case "2ScaleFromLeftNoFarSide":
			Robot.scaleAutoWillFar = false;
			setGroup(new DoubleScaleFromLeft());
			break;
		case "2ScaleFromRightNoFarSide":
			Robot.scaleAutoWillFar = false;
			setGroup(new DoubleScaleFromRight());
			break;
		case "ScaleFromLeftNullZone":
			setGroup(new ScaleFromLeftFarOut());
			break;
		case "ScaleFromRightNullZone":
			setGroup(new ScaleFromRightFarOut());
			break;
		default:
			setGroup(new BaselineCross());
		}

		// Starts the selected autonomous group with the scheduler
		autoScheduler.start();
		tandemAction.start();
	}

	public void autonomousPeriodic() {
		
//		NavSensor.getInstance().resetGyroNorth(Math.floor((SmartDashboard.getNumber("DB/Slider 0", 0))*(72)), 0);

		SmartDashboard.putString("DB/String 3", "ELEVATOR ROT: " + Robot.elEncCounter.getRotations());
		SmartDashboard.putString("DB/String 4", "ELEVATOR VALUE: " + Robot.elevatorAbsEnc.getValue());
		SmartDashboard.putString("DB/String 5", "LEFT ROT: " + Robot.leftCounter.getRotations());
		SmartDashboard.putString("DB/String 6", "LEFT VALUE: " + Robot.leftAbsEnc.getValue());
		SmartDashboard.putString("DB/String 7", "RIGHT ROT: " + Robot.rightCounter.getRotations());
		SmartDashboard.putString("DB/String 8", "RIGHT VALUE: " + Robot.rightAbsEnc.getValue());
		SmartDashboard.putString("DB/String 9", "GYRO ANGLE: " + Math.floor(NavSensor.getInstance().getAngle(false)));
		
		leftTotalAngle = ((Robot.leftCounter.getRotations())*(4096)) + Robot.leftAbsEnc.getValue();
		rightTotalAngle = ((Robot.rightCounter.getRotations())*(4096)) + Robot.rightAbsEnc.getValue();
		
		Scheduler.getInstance().run();
	}

	public void teleopInit() {
		Logger.info("Starting Teleop");
		
		autoScheduler.stop();
		tandemAction.stop();
		
	}

	public void teleopPeriodic() {
		Scheduler.getInstance().run();

//		NavSensor.getInstance().resetGyroNorth(Math.floor((SmartDashboard.getNumber("DB/Slider 0", 0))*(72)), 0);
		
		leftTotalAngle = ((Robot.leftCounter.getRotations())*(4096)) + Robot.leftAbsEnc.getValue();
		rightTotalAngle = ((Robot.rightCounter.getRotations())*(4096)) + Robot.rightAbsEnc.getValue();
		
		try {
			if (isSwitchesLeft()) {
				SmartDashboard.putString("DB/String 0", "SWITCHES: LEFT");
			} else {
				SmartDashboard.putString("DB/String 1", "SWITCHES: RIGHT");
			}

			if (isScaleLeft()) {
				SmartDashboard.putString("DB/String 1", "SCALE: LEFT");
			} else {
				SmartDashboard.putString("DB/String 1", "SCALE: RIGHT");
			}
		} catch (NullPointerException n) {
		}

		SmartDashboard.putString("DB/String 3", "ELEVATOR ROT: " + Robot.elEncCounter.getRotations());
		SmartDashboard.putString("DB/String 4", "ELEVATOR VALUE: " + Robot.elevatorAbsEnc.getValue());
		SmartDashboard.putString("DB/String 5", "LEFT ROTAT: " + Robot.leftCounter.getRotations());
		SmartDashboard.putString("DB/String 6", "LEFT VALUE: " + (4096 - Robot.leftAbsEnc.getValue()));
		SmartDashboard.putString("DB/String 7", "RIGHT ROT: " + Robot.rightCounter.getRotations());
		SmartDashboard.putString("DB/String 8", "RIGHT VALUE: " + Robot.rightAbsEnc.getValue());
		SmartDashboard.putString("DB/String 9", "GYRO ANGLE: " + Math.floor(NavSensor.getInstance().getAngle(false)));

	}

	public void testPeriodic() {

	}

	/**
	 * Used to get the game specific data on which sides of the field elements
	 * belong to which alliance
	 * 
	 * @param isTest
	 * @return
	 */
	public static String getPracticeData(boolean isTest) {
		if (isTest) {
			String switchesString;
			String scaleString;

			int switchesInt = rand.nextInt(2) + 1;
			int scaleInt = rand.nextInt(2) + 1;

			if (switchesInt == 1) {
				switchesString = "L";
			} else {
				switchesString = "R";
			}

			if (scaleInt == 1) {
				scaleString = "L";
			} else {
				scaleString = "R";
			}

			return switchesString + scaleString + switchesString;

		}

		else {
			try {
				return DriverStation.getInstance().getGameSpecificMessage();
			} catch (Throwable t) {
				Logger.error("No Game Message Recieved");
				return "IDK";
			}
		}

	}

	/**
	 * @return Whether or not your side of the switch is the left side
	 */
	public static boolean isSwitchesLeft() {
		return switchesVal.equals("L");
	}

	/**
	 * @return Whether or not your side of the scale is the left side
	 */
	public static boolean isScaleLeft() {
		return scaleVal.equals("L");
	}

	public static String parseMatchTime() {
		double s = DriverStation.getInstance().getMatchTime();

		if (s != -1.0) {
			if (DriverStation.getInstance().isAutonomous()) {

				int t = (int) (15 - Math.ceil(s));
				return ":" + Integer.toString((int) t) + " (Auton)";

			} else if (DriverStation.getInstance().isOperatorControl()) {

				int t = (int) (135 - Math.ceil(s));
				return Integer.toString((int) Math.floor(t / 60)) + ":" + Integer.toString((int) t % 60) + " (TeleOp)";

			} else {

				return "Disabled";

			}

		} else {

			return "Not Practice";

		}

	}

}
