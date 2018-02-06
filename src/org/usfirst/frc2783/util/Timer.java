package org.usfirst.frc2783.util;

import edu.wpi.first.wpilibj.RobotController;

public class Timer {
//Instantiates variables
	double startTime;
	double endTime;
	double time;
	
	public Timer(double time) {
		this.time = time;
		startTime = 0;
		endTime = 0;
	}
	
	//activates a timer
	public void start() {
		startTime = RobotController.getFPGATime();
		endTime = startTime + (1000000 * time);
	}
	//prints timer
	public boolean ring() {
		return RobotController.getFPGATime() >= endTime;
	}
	
}
