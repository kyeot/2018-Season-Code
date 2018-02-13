package org.usfirst.frc2783.robot;

import java.util.Random;

import org.usfirst.frc2783.commands.autonomous.TestAuto;
import org.usfirst.frc2783.commands.autonomous.actions.ActionScheduler;
import org.usfirst.frc2783.loops.Looper;
import org.usfirst.frc2783.subystems.TankDriveBase;
import org.usfirst.frc2783.util.LeftEncoderCounter;
import org.usfirst.frc2783.util.RightEncoderCounter;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
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
	
	public static LeftEncoderCounter leftCounter = new LeftEncoderCounter();

	public static RightEncoderCounter rightCounter = new RightEncoderCounter();
    
	public void robotInit() {
        oi = new OI();
        looper.addLoop(leftCounter);
        looper.addLoop(rightCounter);
        looper.startLoops();
        
        tankDriveBase.leftSide1.setNeutralMode(NeutralMode.Brake);
        tankDriveBase.rightSide1.setNeutralMode(NeutralMode.Brake);
        tankDriveBase.leftSide2.setNeutralMode(NeutralMode.Brake);
        tankDriveBase.rightSide2.setNeutralMode(NeutralMode.Brake);

        //gameData = DriverStation.getInstance().getGameSpecific/Message();
        gameData = getPracticeData(true, null);
        autoSides = gameData.substring(0, 1);
        
        String[] autonomousList = {"Test"};
        
        //Puts the autonomous modes selector into the dashboard
        SmartDashboard.putStringArray("Auto List", autonomousList);
        
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
        SmartDashboard.putString("DB/String 0", "" + Robot.leftAbsEnc.getValue());
        SmartDashboard.putString("DB/String 1", "" + Robot.rightAbsEnc.getValue());
        
        SmartDashboard.putString("DB/String 3", "" + Robot.isLeftForward);
        SmartDashboard.putString("DB/String 4", "" + Robot.isRightForward);
        
		SmartDashboard.putString("DB/String 8", "left: " + Robot.leftCounter.leftRotationCounter);
		SmartDashboard.putString("DB/String 9", "right: " + Robot.rightCounter.rightRotationCounter);
    }

    public void teleopInit() {
    }

    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        SmartDashboard.putString("DB/String 0", "" + Robot.leftAbsEnc.getValue());
        SmartDashboard.putString("DB/String 1", "" + Robot.rightAbsEnc.getValue());
        
        SmartDashboard.putString("DB/String 3", "" + Robot.isLeftForward);
        SmartDashboard.putString("DB/String 4", "" + Robot.isRightForward);
        
		SmartDashboard.putString("DB/String 8", "left: " + Robot.leftCounter.leftRotationCounter);
		SmartDashboard.putString("DB/String 9", "right: " + Robot.rightCounter.rightRotationCounter);
		
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
