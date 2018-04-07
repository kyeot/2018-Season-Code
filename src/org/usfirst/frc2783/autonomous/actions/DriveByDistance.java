package org.usfirst.frc2783.autonomous.actions;

import org.usfirst.frc2783.loops.LeftEncoderCounter;
import org.usfirst.frc2783.loops.RightEncoderCounter;
import org.usfirst.frc2783.robot.Constants;
import org.usfirst.frc2783.robot.Robot;

import com.ctre.phoenix.motorcontrol.NeutralMode;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
	
	double wantedLeftTotalDegrees;
	double wantedRightTotalDegrees;
	
	double wantedLeftRotations;
	double wantedRightRotations;
	
	double wantedLeftAdditionalDegrees;
	double wantedRightAdditionalDegrees;
    
	double leftSpeed;
	double rightSpeed;
	
	double leftSpeedOnStart;
	double rightSpeedOnStart;
	
	boolean isRight = true;
	
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
    	
    	leftDistanceInDegrees = (leftDistance/Constants.kInchPerDegree)-leftAngleOnStart;
    	rightDistanceInDegrees = (rightDistance/Constants.kInchPerDegree)-rightAngleOnStart;
    	
    	wantedLeftTotalDegrees = leftAngleOnStart + leftDistanceInDegrees;
    	wantedRightTotalDegrees = rightAngleOnStart + rightDistanceInDegrees;
    	
    	leftRotationOnStart = Robot.leftCounter.getRotations();
    	rightRotationOnStart = Robot.rightCounter.getRotations();
    	
    	if(leftDistanceInDegrees > rightDistanceInDegrees){
    		rightSpeed = rightDistanceInDegrees/leftDistanceInDegrees*speedScaler;
    		leftSpeed = speedScaler;
    		isRight = true;
    	}
    	else if(rightDistanceInDegrees > leftDistanceInDegrees){
    		leftSpeed = leftDistanceInDegrees/rightDistanceInDegrees*speedScaler;
    		rightSpeed = speedScaler;
    		isRight = false;
    	}
    	else{
    		rightSpeed = speedScaler;
    		leftSpeed = speedScaler;
    	}
    	
    	leftSpeedOnStart = leftSpeed;
    	rightSpeedOnStart = rightSpeed;
    	
    	wantedLeftRotations = Math.floor(wantedLeftTotalDegrees/4096);
    	wantedRightRotations = Math.floor(wantedRightTotalDegrees/4096);
    	
    	wantedLeftAdditionalDegrees = wantedLeftTotalDegrees%4096;
    	wantedRightAdditionalDegrees = wantedRightTotalDegrees%4096;
    	
	}
	
	@Override
	public void start(){
		
	}
	
	@Override
	public void perform(){                
    	if(Robot.leftCounter.getRotations() >= (leftRotationOnStart + wantedLeftRotations)){
    		isLeftRotationsDone = true;
    	}
    	
    	if(Robot.rightCounter.getRotations() >= (rightRotationOnStart + wantedRightRotations)){
    		isRightRotationsDone = true;
    	}
    	
    	if(isLeftRotationsDone){
    		leftSpeed = leftSpeedOnStart/2;
    		if(Robot.leftAbsEnc.getValue() < wantedLeftAdditionalDegrees + 50 && Robot.leftAbsEnc.getValue() > wantedLeftAdditionalDegrees - 50){
        		isLeftDegreesDone = true;
        	}
    	}
    	
    	if(isRightRotationsDone){
    		rightSpeed = rightSpeedOnStart/2;
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
    	
    	Robot.tankDrive.tankDrive(-leftSpeed, -rightSpeed);
		
	}
	
	@Override
	public boolean done(){
		if(isRight){
			return isRightDegreesDone;
		}
		else{
			return isLeftDegreesDone;
		}
	}

	public void finish() {
    	Robot.tankDrive.tankDrive(0, 0);
    	Robot.tankDrive.leftMaster.setNeutralMode(NeutralMode.Brake);
    	Robot.tankDrive.rightMaster.setNeutralMode(NeutralMode.Brake);
	}

}

