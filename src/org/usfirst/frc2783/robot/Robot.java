package org.usfirst.frc2783.robot;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.usfirst.frc2783.autonomous.actions.ActionScheduler;
import org.usfirst.frc2783.autonomous.actions.groups.BaselineCross;
import org.usfirst.frc2783.autonomous.actions.groups.DriveGyroTest;
import org.usfirst.frc2783.autonomous.actions.groups.ScaleFromLeft;
import org.usfirst.frc2783.autonomous.actions.groups.ScaleFromRight;
import org.usfirst.frc2783.autonomous.actions.groups.SwitchFromLeft;
import org.usfirst.frc2783.autonomous.actions.groups.SwitchFromRight;
import org.usfirst.frc2783.autonomous.actions.groups.TestAuto;
import org.usfirst.frc2783.loops.ElevatorEncoderCounter;
import org.usfirst.frc2783.loops.LeftEncoderCounter;
import org.usfirst.frc2783.loops.LogData;
import org.usfirst.frc2783.loops.Looper;
import org.usfirst.frc2783.loops.RightEncoderCounter;
import org.usfirst.frc2783.loops.VisionProcessor;
import org.usfirst.frc2783.loops.VoltageLogger;
import org.usfirst.frc2783.subsystems.ElevatorBase;
import org.usfirst.frc2783.subsystems.IntakeBase;
import org.usfirst.frc2783.subsystems.TankDriveBase;
import org.usfirst.frc2783.util.EncoderPosition;
import org.usfirst.frc2783.util.Logger;
import org.usfirst.frc2783.util.NavSensor;
import org.usfirst.frc2783.vision.VisionServer;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

//adds classes to the code

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
    
    public static Random rand = new Random();
    
    public static boolean isLeftForward = true;
    public static boolean isRightForward = true;
    public static boolean isElevatorForward = true;
    
    public static boolean isHigh;
    
    public static ActionScheduler autoScheduler = new ActionScheduler();
    
    public static LeftEncoderCounter leftCounter = LeftEncoderCounter.getInstance();
    public static RightEncoderCounter rightCounter = RightEncoderCounter.getInstance();
    public static ElevatorEncoderCounter elEncCounter = ElevatorEncoderCounter.getInstance();
    
    public static EncoderPosition groundPos;
    public static EncoderPosition switchPos;
    public static EncoderPosition scalePos;
    
    public static String gameData;
	public static String switchesVal;
	public static String scaleVal;
    
    VisionServer mVisionServer = VisionServer.getInstance();
    
    public void robotInit() {
        oi = new OI();
        
        mVisionServer.addVisionUpdateReceiver(VisionProcessor.getInstance());
        
        NavSensor.getInstance().resetGyroNorth(180, 0);
        
        looper.addLoop(new LogData());
        looper.addLoop(VisionProcessor.getInstance());
        looper.addLoop(leftCounter);
        looper.addLoop(rightCounter);
        looper.addLoop(elEncCounter);
        Logger.info("Starting Loops");
        looper.startLoops();
        
        slowLoop.addLoop(new VoltageLogger());
        slowLoop.startLoops();

        groundPos = new EncoderPosition(0, elEncCounter.getEncoderStartPos());
        switchPos = new EncoderPosition(2, elEncCounter.getEncoderStartPos());
        scalePos = new EncoderPosition(6, elEncCounter.getEncoderStartPos());
        
        String[] autonomousList = {"Test", "DriveGyroTest", "BaselineCross", "ScaleFromLeft", "SwitchFromLeft", "ScaleFromRight", "SwitchFromRight"};
        
        //Puts the autonomous modes selector into the dashboard
        SmartDashboard.putStringArray("Auto List", autonomousList);
        
        NavSensor.getInstance().updateHistory();
        
        File logFile = new File("/home/lvuser/log.txt");
        try {
			logFile.createNewFile();
		} 
        catch (IOException e) {
			e.printStackTrace();
		}
        
        try {
	         navSensor = new AHRS(SPI.Port.kMXP);
	    }
        catch (RuntimeException ex) {
	         DriverStation.reportError("Error instantiating navX MXP:  " + ex.getMessage(), true);
	    }
    }

    public void disabledInit(){
    }

    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }
   
	public void autonomousInit() {
    	
    	Logger.info("Starting Autonomous");
    	
    	String autoSelected = SmartDashboard.getString("Auto Selector", "None");

    	gameData = getPracticeData(true);
    	
    	switchesVal = gameData.substring(0, 1);
    	scaleVal = gameData.substring(1, 2);
    	
    	//Switch Statement to Run the Right Auto Code Depending on the selected position and switch/scale sides
    	switch(autoSelected) {
		case "Test":
			autoScheduler.setGroup(new TestAuto());
			break;
		case "DriveGyroTest":
			autoScheduler.setGroup(new DriveGyroTest());
			break;
		case "ScaleFromleft":
			autoScheduler.setGroup(new ScaleFromLeft());
			break;
		case "ScaleFromright":
			autoScheduler.setGroup(new ScaleFromRight());
			break;
		case "SwitchFromLeft":
			autoScheduler.setGroup(new SwitchFromLeft());
			break;
		case "SwitchFromRight":
			autoScheduler.setGroup(new SwitchFromRight());
			break;
		case "BaselineCross":
			autoScheduler.setGroup(new BaselineCross());
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
        SmartDashboard.putString("DB/String 8", "" + leftCounter.getRotations());
        SmartDashboard.putString("DB/String 9", "" + rightCounter.getRotations());
        
        SmartDashboard.putString("DB/String 7", "robot angle: " + Math.floor(NavSensor.getInstance().getAngle(false)));
     
    }

    public void testPeriodic() {
    	
    }
    
    public static String getPracticeData(boolean isTest) {
		if(isTest){
			String switchesString;
			String scaleString;
		
			int switchesInt = rand.nextInt(2) + 1;
			int scaleInt = rand.nextInt(2) + 1;
		
			if(switchesInt == 1){
				switchesString = "L";
			}
			else{
				switchesString = "R";
			}
		
			if(scaleInt == 1){
				scaleString = "L";
			}
			else{
				scaleString = "R";
			}
			
			return switchesString + scaleString + switchesString;
			
		}
		
		else{
			try{
				return DriverStation.getInstance().getGameSpecificMessage();
			} 
			catch(Throwable t) {
				Logger.error("No Game Message Recieved");
				return "IDK";
			}
		}
		
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
