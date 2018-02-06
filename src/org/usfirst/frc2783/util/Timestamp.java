package org.usfirst.frc2783.util;

import edu.wpi.first.wpilibj.RobotController;

public class Timestamp implements Comparable<Timestamp>{
	//adds time
	Double t;
	 
	//makes time stamp = time
	public Timestamp(double t) {
		this.t = t;
	}
	
	//starts new timer
	public static Timestamp setNewTime() {
		return new Timestamp(RobotController.getFPGATime()*10E-7);
	}
	
	//gets current time
	public Double getTime() {
		return t;
	}
	
	//finds how long ago a time stamp was taken
	public Double getAge() {
		return RobotController.getFPGATime()*10E-7 - t;
	}
	
	//compares two time stamps to see which one is greater
	@Override
	public int compareTo(Timestamp o) {
		// TODO Auto-generated method stub
		return o.getAge().compareTo(this.t);
	}
	
}
