package org.usfirst.frc2783.robot;

import org.usfirst.frc2783.commands.autonomous.TestAuto;
import org.usfirst.frc2783.commands.autonomous.actions.ActionScheduler;
import org.usfirst.frc2783.loops.Looper;
import org.usfirst.frc2783.subsystems.ElevatorBase;
import org.usfirst.frc2783.subsystems.IntakeBase;
import org.usfirst.frc2783.subsystems.TankDriveBase;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Robot extends IterativeRobot {

    public static OI oi;
    public static Looper looper = new Looper();
    
    public static ActionScheduler autoScheduler = new ActionScheduler();
    
    private static AHRS navSensor;
    
    public static TankDriveBase tankDrive = new TankDriveBase();
    public static IntakeBase intake = new IntakeBase();
    public static ElevatorBase elevatorBase = new ElevatorBase();
   
    public static NetworkTable smartDashTable;
    
    public void robotInit() {
        oi = new OI();
        looper.startLoops();
        
    	this.smartDashTable = NetworkTable.getTable("SmartDashboard");
    	
		String[] autonomousList = {"Test"};
    	this.smartDashTable.putStringArray("Auto List", autonomousList);

        
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
    	autoScheduler.stop();
    }

    public void teleopPeriodic() {
        Scheduler.getInstance().run();
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
