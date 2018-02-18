package org.usfirst.frc2783.autonomous.actions;

import org.usfirst.frc2783.robot.Constants;
import org.usfirst.frc2783.robot.Robot;
import org.usfirst.frc2783.util.LeftEncoderCounter;
import org.usfirst.frc2783.util.RightEncoderCounter;

import com.ctre.phoenix.motorcontrol.NeutralMode;

public class DriveForwardByDistance extends Action {

	public static double distanceInDegrees;
	
	double rotationOnStart;
	
	double speedScaler;
	double distance;
	
	double angleOnStart;
	
	double wantedTotalDegrees;
	
	double wantedRotations;
	
	double wantedAdditionalDegrees;
	
	double speed;
	
	double speedOnStart;
	
	boolean isRotationsDone = false;
	boolean isDegreesDone = false;
	
	public DriveForwardByDistance(double speedScaler, double distance) {
		super("DriveForwardByDistance");

    	this.speedScaler = speedScaler;
    	this.distance = distance;
    	
    	angleOnStart = Robot.rightAbsEnc.getValue();
    	
    	distanceInDegrees = distance/Constants.inchPerDegree-angleOnStart;
    	
    	wantedTotalDegrees = angleOnStart + distanceInDegrees;
    	
    	rotationOnStart = LeftEncoderCounter.leftRotationCounter;
    	
    	speed = speedScaler;
    	
    	speedOnStart = speed;
    	speedOnStart = speed;
    	
    	wantedRotations = Math.floor(wantedTotalDegrees/4096);
    	wantedRotations = Math.floor(wantedTotalDegrees/4096);
    	
    	wantedAdditionalDegrees = wantedTotalDegrees%4096;
    	wantedAdditionalDegrees = wantedTotalDegrees%4096;
    	
	}
	
	@Override
	public void start(){
		
	}
	
	@Override
	public void perform(){                                                                                 
    	if(RightEncoderCounter.rightRotationCounter >= (rotationOnStart + wantedRotations)){
    		isRotationsDone = true;
    	}
    	
    	if(isRotationsDone){
    		speed = speedOnStart/2;
    		if(Robot.rightAbsEnc.getValue() < wantedAdditionalDegrees + 50 && Robot.leftAbsEnc.getValue() > wantedAdditionalDegrees - 50){
        		isDegreesDone = true;
        	}
    	}
    	    	
    	if(isDegreesDone){
    		speed = 0;
    	}
    	
    	Robot.tankDriveBase.tankDrive(-speed, speed);
		
	}
	
	@Override
	public boolean done(){
		return isDegreesDone;
	}

	public void finish() {
    	Robot.tankDriveBase.tankDrive(0, 0);
    	Robot.tankDriveBase.mLeftMaster.setNeutralMode(NeutralMode.Brake);
    	Robot.tankDriveBase.mRightMaster.setNeutralMode(NeutralMode.Brake);
	}

}