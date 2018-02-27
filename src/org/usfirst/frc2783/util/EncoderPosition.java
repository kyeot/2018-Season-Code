package org.usfirst.frc2783.util;

public class EncoderPosition {

	double rotations;
	double degrees;
	
	public EncoderPosition(int rotations, double degrees){
		this.rotations = rotations;
		this.degrees = degrees;
		
	}
	
	public double getRotations(){
		return rotations;
	}
	
	public double getDegrees(){
		return degrees;
	}
	
}
