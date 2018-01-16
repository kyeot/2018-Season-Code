package org.usfirst.frc2783.robot;

import java.util.Random;

import org.usfirst.frc2783.commands.autonomous.modes.LeftSideScalePref;
import org.usfirst.frc2783.commands.autonomous.modes.LeftSideSwitchPref;
import org.usfirst.frc2783.commands.autonomous.modes.MiddleDoublePower;
import org.usfirst.frc2783.commands.autonomous.modes.MiddleScaleOnly;
import org.usfirst.frc2783.commands.autonomous.modes.MiddleSwitchOnly;
import org.usfirst.frc2783.commands.autonomous.modes.RightSideScalePref;
import org.usfirst.frc2783.commands.autonomous.modes.RightSideSwitchPref;
import org.usfirst.frc2783.loops.Looper;
import org.usfirst.frc2783.subystems.TankDriveBase;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Robot extends IterativeRobot {

    public static OI oi;
    public static Looper looper = new Looper();
    
    public static Random rand = new Random();
    
    public static Command autoCommand;
    
	private static AHRS navSensor;
    
    public static TankDriveBase tankDriveBase = new TankDriveBase();
    
    public static String gameData;
    public static String autoSides;
    
	public static SendableChooser chooser;
    
	@SuppressWarnings("unchecked")
	public void robotInit() {
        oi = new OI();
        looper.startLoops();

//      gameData = DriverStation.getInstance().getGameSpecificMessage();
        gameData = getPracticeData(true, null);
        autoSides = gameData.substring(0, 1);
        
//      Instantiates the autonomous chooser and adds all of the autonomous Modes to it
        chooser = new SendableChooser();
        chooser.addObject("Left Side Scale Pref", new LeftSideScalePref());
        chooser.addObject("Left Side Switch Pref", new LeftSideSwitchPref());
        chooser.addObject("Right Side Scale Pref", new RightSideScalePref());
        chooser.addObject("Right Side Switch Pref", new RightSideSwitchPref());
        chooser.addObject("Scale From Middle", new MiddleScaleOnly());
        chooser.addObject("Switch From Middle", new MiddleSwitchOnly());
        chooser.addObject("Double Power Up", new MiddleDoublePower());
        
        //Puts the autonomous modes selector into the dashboard
        SmartDashboard.putData("Autonomous Mode Chooser", chooser);
        
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
    	//Gets the autonomous selector value from the dashboard
//    	String autoSelected = SmartDashboard.getString("Auto Selector", "None");
    	
    	//Sets the autonomous Command to the one selected from Driver Station
    	autoCommand = (Command) chooser.getSelected();
    	
    	//Switches the autonomous mode based on the value from the SmartDashboard
//		switch(autoSelected) {
//			case "Left Side Scale Pref":
//				autoCommand = new LeftSideScalePref();
//				break;
//			case "Left Side Switch Pref":
//				autoCommand = new LeftSideSwitchPref();
//				break;
//			case "Right Side Scale Pref":
//				autoCommand = new RightSideScalePref();
//				break;
//			case "Right Side Switch Pref":
//				autoCommand = new RightSideSwitchPref();
//				break;
//			case "Scale From Middle":
//				autoCommand = new MiddleScaleOnly();
//				break;
//			case "Switch From Middle":
//				autoCommand = new MiddleSwitchOnly();
//				break;
//			case "Double Power Up":
//				autoCommand = new MiddleDoublePower();
//				break;
//			case "None":
//			default:
//				autoCommand = null;
//				break;
//		} 
		
    	//Makes it so the autonomous command does not run if it does not exist
    	if(autoCommand != null) {
    		autoCommand.start();
    	}
    }
    
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
    }

    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        System.out.println(gameData);
    }

	public void testPeriodic() {
		LiveWindow.run();
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
