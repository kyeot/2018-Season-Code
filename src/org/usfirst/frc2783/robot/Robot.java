package org.usfirst.frc2783.robot;

import java.io.File;
import java.io.IOException;

import org.usfirst.frc2783.autonomous.TestAuto;
import org.usfirst.frc2783.autonomous.actions.ActionScheduler;
import org.usfirst.frc2783.loops.LogData;
import org.usfirst.frc2783.loops.Looper;
import org.usfirst.frc2783.loops.VisionProcessor;
import org.usfirst.frc2783.subsystems.ElevatorBase;
import org.usfirst.frc2783.subsystems.IntakeBase;
import org.usfirst.frc2783.subsystems.TankDriveBase;
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
public class Robot extends IterativeRobot {

    public static OI oi;
    public static Looper looper = new Looper();
    
    @SuppressWarnings("unused")
	private static AHRS navSensor;
    
    public static AnalogInput leftAbsEnc = new AnalogInput(0);
    public static AnalogInput rightAbsEnc = new AnalogInput(1);
    
    public static TankDriveBase tankDrive = new TankDriveBase();
    public static IntakeBase intake = new IntakeBase();
    public static ElevatorBase elevatorBase = new ElevatorBase();
    
    public static FieldTransform fieldTransform = FieldTransform.getInstance();
    
    public static boolean isClimb;
    
    public static boolean isLeftForward = false;
    public static boolean isRightForward = false;
    
    public static ActionScheduler autoScheduler = new ActionScheduler();
    
    public static LeftEncoderCounter leftCounter = new LeftEncoderCounter();
    public static RightEncoderCounter rightCounter = new RightEncoderCounter();
    
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

        String[] autonomousList = {"Test"};
        
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

    public void autonomousInit() {
    	Logger.info("Starting Autonomous");
    	
    	String autoSelected = SmartDashboard.getString("Auto Selector", "None");

    	switch(autoSelected) {
		case "Test":
			autoScheduler.setGroup(new TestAuto());
			break;
		default:
			
    	} 
    	
    	autoScheduler.start();
    }
    
    public void autonomousPeriodic() {

        SmartDashboard.putString("DB/String 1", "" + Robot.leftAbsEnc.getValue());
        SmartDashboard.putString("DB/String 2", "" + Robot.rightAbsEnc.getValue());
        SmartDashboard.putString("DB/String 3", "" + Robot.leftCounter.leftRotationCounter);
        SmartDashboard.putString("DB/String 4", "" + Robot.rightCounter.rightRotationCounter);
        
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
