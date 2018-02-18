package org.usfirst.frc2783.robot;

import java.io.File;
import java.io.IOException;

import org.usfirst.frc2783.autonomous.ScaleFromLeft;
import org.usfirst.frc2783.autonomous.SwitchFromLeft;
import org.usfirst.frc2783.autonomous.TestAuto;
import org.usfirst.frc2783.autonomous.actions.ActionScheduler;
import org.usfirst.frc2783.loops.LogData;
import org.usfirst.frc2783.loops.Looper;
import org.usfirst.frc2783.loops.PowerLoop;
import org.usfirst.frc2783.loops.VisionProcessor;
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
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.RobotController;
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
    
    double counter = 0;
    
    public static AnalogInput leftAbsEnc = new AnalogInput(0);
    public static AnalogInput rightAbsEnc = new AnalogInput(1);
    
    public static AnalogInput elevatorAbsEnc = new AnalogInput(2);
    
<<<<<<< HEAD
    public static TankDriveBase tankDriveBase = new TankDriveBase();
=======
    public static TankDriveBase tankDrive = new TankDriveBase();
>>>>>>> eec6a3416388300c7828cdec2354e14acf17a54a
    public static IntakeBase intake = new IntakeBase();
    public static ElevatorBase elevatorBase = new ElevatorBase();
    
    public static FieldTransform fieldTransform = FieldTransform.getInstance();
    
    public static boolean isClimb;
    
    public static boolean isLeftForward = false;
    public static boolean isRightForward = false;
    public static boolean isElevatorForward = false;
    
    PowerDistributionPanel pdp = new PowerDistributionPanel();
    
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
        
        slowLoop.addLoop(new PowerLoop());
        slowLoop.startLoops();
        
        looper.addLoop(new LogData());
        looper.addLoop(VisionProcessor.getInstance());
        looper.addLoop(leftCounter);
        looper.addLoop(rightCounter);
        looper.addLoop(elEncCounter);
        Logger.info("Starting Loops");
        looper.startLoops();

        String[] autonomousList = {"Test", "SwitchFromLeft", "ScaleFromLeft"};
        
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
		case "SwitchFromLeft":
			autoScheduler.setGroup(new SwitchFromLeft());
			break;
		case "ScaleFromLeft":
			autoScheduler.setGroup(new ScaleFromLeft());
			break;
		default:
			
    	} 
    	
    	autoScheduler.start();
    }
    
	public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
    	Logger.info("Starting Teleop");
    }
    
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        
        double leftSideCurrent = pdp.getCurrent(12) + pdp.getCurrent(13);
        
        SmartDashboard.putString("DB/String 4", "Left side current: " + leftSideCurrent);
        
        SmartDashboard.putString("DB/String 5", "robot angle: " + Math.floor(NavSensor.getInstance().getAngle(false)));
       
        SmartDashboard.putString("DB/String 6", "" + leftAbsEnc.getValue());
        SmartDashboard.putString("DB/String 7", "" + rightAbsEnc.getValue());
        
        SmartDashboard.putString("DB/String 8", "" + elevatorAbsEnc.getValue());
        SmartDashboard.putString("DB/String 9", "" + Robot.elEncCounter.elevatorRotationCounter);
        
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
