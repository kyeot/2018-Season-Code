package org.usfirst.frc2783.util;

import org.usfirst.frc2783.robot.Constants;

import edu.wpi.first.wpilibj.RobotController;

/**
 * Abstract class which executes code when the abstract method event() returns true.
 * 
 * @author 2783
 */
public abstract class EventLogger {
	String msg;
	String lvl;
	double timeLast = 0;
	
	/**
	 * 
	 * @param msg
	 * @param loggerLevel
	 */
	public EventLogger(String msg, String loggerLevel) {
		// Defining variables in lines 13+14
		this.msg = msg;
		this.lvl = loggerLevel;
	}

	public abstract boolean event();
	
	public void handleEvent() {
		// getFPGATTime stands for the time in microseconds  from the FMS 
	    // A microsecond is equal to 10^(-6)
		if(event() && ((RobotController.getFPGATime() - timeLast) > Constants.kEventDelay * 1000000)) {
			Logger.log(lvl, msg);
		// Defining variable in line 15
			timeLast = RobotController.getFPGATime();
		}
	}
	
}
