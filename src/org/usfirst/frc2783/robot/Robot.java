package org.usfirst.frc2783.robot;

import java.io.File;
import java.io.IOException;

import org.usfirst.frc2783.autonomous.DriveGyroTest;
import org.usfirst.frc2783.autonomous.ScaleFromLeft;
import org.usfirst.frc2783.autonomous.ScaleFromRight;
import org.usfirst.frc2783.autonomous.SwitchFromLeft;
import org.usfirst.frc2783.autonomous.SwitchFromRight;
import org.usfirst.frc2783.autonomous.TestAuto;
import org.usfirst.frc2783.autonomous.actions.ActionScheduler;
import org.usfirst.frc2783.loops.LogData;
import org.usfirst.frc2783.loops.Looper;
import org.usfirst.frc2783.loops.VisionProcessor;
import org.usfirst.frc2783.loops.VoltageLogger;
import org.usfirst.frc2783.subsystems.ElevatorBase;
import org.usfirst.frc2783.subsystems.IntakeBase;
import org.usfirst.frc2783.subsystems.TankDriveBase;
import org.usfirst.frc2783.util.ElevatorEncoderCounter;
import org.usfirst.frc2783.util.LeftEncoderCounter;
import org.usfirst.frc2783.util.Logger;
import org.usfirst.frc2783.util.NavSensor;
import org.usfirst.frc2783.util.RightEncoderCounter;
import org.usfirst.frc2783.vision.VisionServer;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

//adds classes to the code

@SuppressWarnings("static-access")
public class Robot extends IterativeRobot {

    public static OI oi;
    public static Looper looper = new Looper(Constants.kPeriod);
    public static Looper slowLoop = new Looper(0.1);
    
    @SuppressWarnings("unused")
	private static AHRS navSensor;
    
    public static double angle = 0;
    
    public static AnalogInput leftAbsEnc = new AnalogInput(0);
    public static AnalogInput rightAbsEnc = new AnalogInput(1);
    public static AnalogInput elevatorAbsEnc = new AnalogInput(2);
    
    public static TankDriveBase tankDrive = new TankDriveBase();
    public static IntakeBase intake = new IntakeBase();
    public static ElevatorBase elevatorBase = new ElevatorBase();
    
    public static FieldTransform fieldTransform = FieldTransform.getInstance();
    
    public static boolean isClimb;
    
    public static boolean isLeftForward = false;
    public static boolean isRightForward = false;
    public static boolean isElevatorForward = false;
    
    public static ActionScheduler autoScheduler = new ActionScheduler();
    
    public static LeftEncoderCounter leftCounter = new LeftEncoderCounter();
    public static RightEncoderCounter rightCounter = new RightEncoderCounter();
    public static ElevatorEncoderCounter elEncCounter = new ElevatorEncoderCounter();
    
    boolean isBrownOut = false;
    boolean wasBrownOut = false;
    
    VisionServer mVisionServer = VisionServer.getInstance();
    
        public void robotInit() {
        oi = new OI();
        
        mVisionServer.addVisionUpdateReceiver(VisionProcessor.getInstance());
        
        NavSensor.getInstance().resetGyroNorth(180, 0);
        
        looper.addLoop(new LogData());
        looper.addLoop(VisionProcessor.getInstance());
        looper.addLoop(leftCounter);
        looper.addLoop(rightCounter);
        Logger.info("Starting Loops");
        looper.startLoops();
        
        slowLoop.addLoop(new VoltageLogger());
        slowLoop.startLoops();

        String[] autonomousList = {"Test", "DriveGyroTest", "ScaleFromLeft", "SwitchFromLeft", "ScaleFromRight", "ScaleFromLeft"};
        
        //Puts the autonomous modes selector into the dashboard
        SmartDashboard.putStringArray("Auto List", autonomousList);
        
        NavSensor.getInstance().updateHistory();
        
        File logFile = new File("/home/lvuser/log.txt");
        try {
			logFile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        try {
	         navSensor = new AHRS(SPI.Port.kMXP);
	     } catch (RuntimeException ex) {
	         DriverStation.reportError("Error instantiating navX MXP:  " + ex.getMessage(), true);
	     }
    }

    public void disabledInit(){
    }

    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }
    
    public static String gameData;
	public static String autoSides;
	public static String switchVal;
	public static String scaleVal;
   
	public void autonomousInit() {
    	
    	
    	Logger.info("Starting Autonomous");
    	
    	String autoSelected = SmartDashboard.getString("Auto Selector", "None");

    	gameData = DriverStation.getInstance().getGameSpecificMessage();
    	autoSides = gameData.substring(0,1);
    	switchVal = gameData.substring(0);
    	scaleVal = gameData.substring(1);
    	
    	//Switch Statement to Run the Right Auto Code Depending on the selected position and switch/scale sides
    	switch(autoSelected) {
		case "Test":
			autoScheduler.setGroup(new TestAuto());
			break;
		case "DriveGyroTest":
			autoScheduler.setGroup(new DriveGyroTest());
			break;
		case "ScaleFromleft":
			ScaleFromLeft scaleFromLeft = new ScaleFromLeft();
			autoScheduler.setGroup(scaleFromLeft);
			if (scaleVal == "L" || scaleVal == "l") {
				scaleFromLeft.bothLeft();
			} else if (scaleVal == "R" || scaleVal == "r") {
				scaleFromLeft.bothRight();
			} else {
				Logger.error("Cannot parse input. Running default case.");
				scaleFromLeft.driveForward();
			}
			break;
		case "ScaleFromright":
			ScaleFromRight scaleFromRight = new ScaleFromRight();
			autoScheduler.setGroup(scaleFromRight);
			if (scaleVal == "L" || scaleVal == "l") {
				scaleFromRight.bothLeft();
			} else if (scaleVal == "R" || scaleVal == "r") {
				scaleFromRight.bothRight();
			} else {
				Logger.error("Cannot parse input. Running default case.");
				scaleFromRight.driveForward();
			}
			break;
		case "SwitchFromLeft":
			SwitchFromLeft switchFromLeft = new SwitchFromLeft();
			autoScheduler.setGroup(switchFromLeft);
			if (switchVal == "L" || switchVal == "l") {
				switchFromLeft.bothLeft();
			} else if (switchVal == "R" || switchVal == "r") {
				switchFromLeft.bothRight();
			} else {
				Logger.error("Cannot parse input. Running default case.");
				switchFromLeft.driveForward();
			}
			break;
		case "SwitchFromRight":
			SwitchFromRight switchFromRight = new SwitchFromRight();
			autoScheduler.setGroup(switchFromRight);
			if (switchVal == "L" || switchVal == "l") {
				switchFromRight.bothLeft();
			} else if (switchVal == "R" || switchVal == "r") {
				switchFromRight.bothRight();
			} else {
				Logger.error("Cannot parse input. Running default case.");
				switchFromRight.driveForward();
			}
			break;
		default:
			
    	} 
    	
    	autoScheduler.start();
    }
    
	public void autonomousPeriodic() {

        SmartDashboard.putString("DB/String 7", "robot angle: " + Math.floor(NavSensor.getInstance().getAngle(false)));
        
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
    	Logger.info("Starting Teleop");
    }
    
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        
        SmartDashboard.putString("DB/String 1", "" + Robot.leftAbsEnc.getValue());
        SmartDashboard.putString("DB/String 2", "" + Robot.rightAbsEnc.getValue());
        SmartDashboard.putString("DB/String 3", "" + Robot.leftCounter.leftRotationCounter);
        SmartDashboard.putString("DB/String 4", "" + Robot.rightCounter.rightRotationCounter);
        
        SmartDashboard.putString("DB/String 7", "robot angle: " + Math.floor(NavSensor.getInstance().getAngle(false)));
     
    }

    public void testPeriodic() {
    	
    }
    
    public static String parseMatchTime() {
    	double s = DriverStation.getInstance().getMatchTime();
    	
    	if(s != -1.0) {
	    	if(DriverStation.getInstance().isAutonomous()) {
	    		
	    		int t = (int) (15 - Math.ceil(s));
	    		return ":" + Integer.toString((int) t) + " (Auton)";
	    		
	    	}
	    	else if(DriverStation.getInstance().isOperatorControl()) {
	    		
	    		int t = (int) (135 - Math.ceil(s));
	    		return Integer.toString((int) Math.floor(t / 60)) + ":" + Integer.toString((int) t % 60) + " (TeleOp)";
	    		
	    	}
	    	else {
	    		
	    		return "Disabled";
	    		
	    	}
	    	
    	}
    	else {
    		
    		return "Not Practice";
    		
    	}
    	
    }
    
}
