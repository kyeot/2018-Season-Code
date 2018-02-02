package org.usfirst.frc2783.robot;

import java.util.Random;

import org.usfirst.frc2783.commands.autonomous.TestAuto;
import org.usfirst.frc2783.commands.autonomous.actions.ActionScheduler;
import org.usfirst.frc2783.commands.autonomous.modes.LeftSideScalePref;
import org.usfirst.frc2783.commands.autonomous.modes.LeftSideSwitchPref;
import org.usfirst.frc2783.commands.autonomous.modes.MiddleDoublePower;
import org.usfirst.frc2783.commands.autonomous.modes.MiddleScaleOnly;
import org.usfirst.frc2783.commands.autonomous.modes.MiddleSwitchOnly;
import org.usfirst.frc2783.commands.autonomous.modes.RightSideScalePref;
import org.usfirst.frc2783.commands.autonomous.modes.RightSideSwitchPref;
import org.usfirst.frc2783.loops.Looper;
import org.usfirst.frc2783.subystems.TankDriveBase;
import org.usfirst.frc2783.util.EncoderCounter;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Robot extends IterativeRobot {

    public static OI oi;
    public static Looper looper = new Looper();
    
    public static AnalogInput leftAbsEnc = new AnalogInput(0);
    public static AnalogInput rightAbsEnc = new AnalogInput(1);
    
    public static boolean isLeftForward;
    public static boolean isRightForward;
    
    public static Random rand = new Random();
    
    public static Command autoCommand;
    
	private static AHRS navSensor;
    
    public static TankDriveBase tankDriveBase = new TankDriveBase();
    
    public static String gameData;
    public static String autoSides;
    
	public static ActionScheduler autoScheduler = new ActionScheduler();
	
	EncoderCounter counter = new EncoderCounter();
    
	@SuppressWarnings("unchecked")
	public void robotInit() {
        oi = new OI();
        looper.addLoop(counter);
        looper.startLoops();

//      gameData = DriverStation.getInstance().getGameSpecificMessage();
        gameData = getPracticeData(true, null);
        autoSides = gameData.substring(0, 1);
        
        String[] autonomousList = {"Test"};
        
        //Puts the autonomous modes selector into the dashboard
        SmartDashboard.putStringArray("Autonomous Mode Chooser", autonomousList);
        
        //Gets the Switch/Scale sides from the Driver Station and stores it as a variable
        
        try {
	         navSensor = new AHRS(SPI.Port.kMXP);
	     } catch (RuntimeException ex ) {
	         DriverStation.reportError("Error instantiating navX MXP:  " + ex.getMessage(), true);
	     }
    }

    public void disabledInit(){
    }

    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    public void autonomousInit() {
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
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
    }

    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        SmartDashboard.putString("DB/String 0", "" + Robot.leftAbsEnc.getValue());
        SmartDashboard.putString("DB/String 1", "" + Robot.rightAbsEnc.getValue());
        System.out.println(Robot.leftAbsEnc.getValue());
    }

	public void testPeriodic() {
    }
	
	public static String getPracticeData(boolean random, String testValue) {
		
		if(random){
			String closeString;
			String scaleString;
			String farString;
		
			int close = rand.nextInt(2) + 1;
			int scale = rand.nextInt(2) + 1;
			int far = rand.nextInt(2) + 1;
		
			if(close == 1){
				closeString = "L";
			}
			else{
				closeString = "R";
			}
		
			if(scale == 1){
				scaleString = "L";
			}
			else{
				scaleString = "R";
			}
		
			if(far == 1){
				farString = "L";
			}
			else{
				farString = "R";
			}
		
			return closeString + scaleString + farString;
		}
		
		else{
			return testValue;
		}
		
	}
	
    public static String parseMatchTime() {
    	double s = DriverStation.getInstance().getMatchTime();
    	
    	if(s != -1.0) {
	    	if(DriverStation.getInstance().isAutonomous()) {
	    		int t = (int) (15-Math.ceil(s));
	    		return ":" + Integer.toString((int) t) + " (Auton)";
	    	} else if(DriverStation.getInstance().isOperatorControl()) {
	    		int t = (int) (135-Math.ceil(s));
	    		return Integer.toString((int) Math.floor(t/60)) + ":" + Integer.toString((int) t%60) + " (TeleOp)";
	    	} else {
	    		return "Disabled";
	    	}
    	} else {
    		return "Not Practice";
    	}
    	
    }
    
}
