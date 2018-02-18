package org.usfirst.frc2783.autonomous.actions;

import org.usfirst.frc2783.robot.Constants;
import org.usfirst.frc2783.robot.Robot;
import org.usfirst.frc2783.subsystems.ElevatorBase;
import org.usfirst.frc2783.util.LeftEncoderCounter;

import com.ctre.phoenix.motorcontrol.NeutralMode;

public class DriveElevatorByDistance extends Action {

	public static double distanceInDegrees;
	double rotationOnStart;
	double distance;
	double angleOnStart;
	double wantedTotalDegrees;
	double wantedRotations;
	double wantedAdditionalDegrees;
	double speed;
	double speedOnStart;
	
	boolean isRotationsDone = false;
	boolean isDegreesDone = false;
	
	public DriveElevatorByDistance(double speed, double distance) {
		super("DriveByDistance");

    	this.speed = speed;
    	this.distance = distance;
    	
    	angleOnStart = Robot.leftAbsEnc.getValue();
    	
    	distanceInDegrees = (distance/Constants.inchPerDegree)-angleOnStart;
    	
    	wantedTotalDegrees = angleOnStart + distanceInDegrees;
    	
    	rotationOnStart = LeftEncoderCounter.leftRotationCounter;
    	
    	speedOnStart = speed;
    	
    	wantedRotations = Math.floor(wantedTotalDegrees/4096);
    	
    	wantedAdditionalDegrees = wantedTotalDegrees%4096;
    	
	}
	
	@Override
	public void start(){
		
	}
	
	@Override
	public void perform(){                                                                                 
    	if(LeftEncoderCounter.leftRotationCounter >= (rotationOnStart + wantedRotations)){
    		isRotationsDone = true;
    	}
    	
    	if(isRotationsDone){
    		speed = speedOnStart/2;
    		if(Robot.leftAbsEnc.getValue() < wantedAdditionalDegrees + 50 && Robot.leftAbsEnc.getValue() > wantedAdditionalDegrees - 50){
        		isDegreesDone = true;
        	}
    	}
    	
    	if(isDegreesDone){
    		speed = 0;
    	}
    	
    	Robot.elevatorBase.elevator(speed);
		
	}
	
	@Override
	public boolean done(){
		return isDegreesDone;
	}

	public void finish() {
    	Robot.elevatorBase.elevator(0);
    	ElevatorBase.elevator1Mot.setNeutralMode(NeutralMode.Brake);
	}

}

