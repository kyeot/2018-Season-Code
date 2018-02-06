package org.usfirst.frc2783.commands.autonomous.actions;

import org.usfirst.frc2783.robot.Constants;
import org.usfirst.frc2783.robot.Robot;

import com.ctre.phoenix.motorcontrol.NeutralMode;

public class DriveByDistance extends Action {

	public static double leftDistanceInDegrees;
	public static double rightDistanceInDegrees;
	
	double leftRotationOnStart;
	double rightRotationOnStart;
	
	double speedScaler;
	double leftDistance;
	double rightDistance;
	
	double leftAngleOnStart;
	double rightAngleOnStart;
	
	double wantedLeftRotations;
	double wantedRightRotations;
	
	double wantedLeftAdditionalDegrees;
	double wantedRightAdditionalDegrees;
    
	double leftSpeed;
	double rightSpeed;
	
	boolean isLeftRotationsDone = false;
	boolean isLeftDegreesDone = false;
	boolean isRightRotationsDone = false;
	boolean isRightDegreesDone = false;
	
	public DriveByDistance(double speedScaler, double leftDistance, double rightDistance) {
		super("DriveByDistance");

    	this.speedScaler = speedScaler;
    	this.leftDistance = leftDistance;
    	this.rightDistance = rightDistance;
    	
    	leftAngleOnStart = Robot.leftAbsEnc.getValue();
    	rightAngleOnStart = Robot.rightAbsEnc.getValue();
    	
    	leftDistanceInDegrees = leftDistance/Constants.inchPerDegree-leftAngleOnStart;
    	rightDistanceInDegrees = rightDistance/Constants.inchPerDegree-rightAngleOnStart;
    	
    	leftRotationOnStart = Robot.leftCounter.leftRotationCounter;
    	rightRotationOnStart = Robot.rightCounter.rightRotationCounter;
    	
    	if(leftDistanceInDegrees > rightDistanceInDegrees){
    		rightSpeed = rightDistanceInDegrees/leftDistanceInDegrees*speedScaler;
    		leftSpeed = speedScaler;
    	}
    	else if(rightDistanceInDegrees > leftDistanceInDegrees){
    		leftSpeed = leftDistanceInDegrees/rightDistanceInDegrees*speedScaler;
    		rightSpeed = speedScaler;
    	}
    	else{
    		rightSpeed = speedScaler;
    		leftSpeed = speedScaler;
    	}
    	
	}
	
	@Override
	public void start(){

    	wantedLeftRotations = Math.floor(leftDistanceInDegrees/4096);
    	wantedRightRotations = Math.floor(rightDistanceInDegrees/4096);
    	
    	wantedLeftAdditionalDegrees = leftDistanceInDegrees - (wantedLeftRotations * 4096);
    	wantedRightAdditionalDegrees = rightDistanceInDegrees - (wantedRightRotations * 4096);
		
	}
	
	@Override
	public void perform(){                                                                                 
    	if(Robot.leftCounter.leftRotationCounter >= (leftRotationOnStart + wantedLeftRotations)){
    		isLeftRotationsDone = true;
    	}
    	
    	if(Robot.rightCounter.rightRotationCounter >= (rightRotationOnStart + wantedRightRotations)){
    		isRightRotationsDone = true;
    	}
    	
    	if(isLeftRotationsDone){
    		if(Robot.leftAbsEnc.getValue() < wantedLeftAdditionalDegrees + 50 && Robot.leftAbsEnc.getValue() > wantedLeftAdditionalDegrees - 50){
        		isLeftDegreesDone = true;
        	}
    	}
    	
    	if(isRightRotationsDone){
    		if(Robot.rightAbsEnc.getValue() < wantedRightAdditionalDegrees + 50 && Robot.rightAbsEnc.getValue() > wantedRightAdditionalDegrees - 50){
        		isRightDegreesDone = true;
        	}
    	}
    	
    	if(isLeftDegreesDone){
    		leftSpeed = 0;
    	}
    	
    	if(isRightDegreesDone){
    		rightSpeed = 0;
    	}
    	
    	Robot.tankDriveBase.tankDrive(-leftSpeed, rightSpeed);
		
	}
	
	@Override
	public boolean done(){
		return isLeftDegreesDone && isRightDegreesDone;
	}

	public void finish() {
    	Robot.tankDriveBase.tankDrive(0, 0);
    	Robot.tankDriveBase.leftSide1.setNeutralMode(NeutralMode.Brake);
    	Robot.tankDriveBase.rightSide1.setNeutralMode(NeutralMode.Brake);
	}

}
