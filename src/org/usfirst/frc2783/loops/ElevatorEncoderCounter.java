package org.usfirst.frc2783.loops;

import org.usfirst.frc2783.robot.Robot;
import org.usfirst.frc2783.subsystems.ElevatorBase;

public class ElevatorEncoderCounter implements Loop{
	
	//Sets the rotation counters to 0
	static double elevatorRotationCounter = 0;
	
	static double elevatorEncoderValueOnStart;
	
	double loopCount;

	double elevatorEncoderLastVal;
	
	double elevatorEncVal;
	double elevatorEncValSub1;
	double elevatorEncValSub2;
	double elevatorEncValSub3;

	boolean wasForward;
	
	@Override
	public void onStart() {
		
		wasForward = true;
		
		elevatorEncoderValueOnStart = Robot.elevatorAbsEnc.getValue();
		elevatorEncVal = Robot.elevatorAbsEnc.getValue();  
		
		if(Robot.isElevatorForward){
			elevatorEncoderLastVal = elevatorEncVal-50;
		}
		
		else{
			elevatorEncoderLastVal = elevatorEncVal+50;
		}
		
	}

	@Override
	public void onLoop() {

    	if(ElevatorBase.elevator1Mot.getMotorOutputPercent() > 0){
    		Robot.isElevatorForward = true;
    	}
    	
    	if(ElevatorBase.elevator1Mot.getMotorOutputPercent() < -0){
    		Robot.isElevatorForward = false;
    	}
		
		elevatorEncVal = Robot.elevatorAbsEnc.getValue();  
		
		if(Robot.isElevatorForward){
			if(elevatorEncVal > elevatorEncoderLastVal){
				elevatorRotationCounter++;
			}
		}
		
		else{
			if(elevatorEncVal < elevatorEncoderLastVal){
				elevatorRotationCounter--;
			}
		}
			
		if(Robot.isElevatorForward){
			elevatorEncoderLastVal = elevatorEncVal+50;
		}
		
		else{
			elevatorEncoderLastVal = elevatorEncVal-50;
		}
		
	}

	@Override
	public void onStop() {
	}

	@Override
	public void onLoop(double timestamp) {
		// TODO Auto-generated method stub
		
	}
	
	public double getRotations(){
		return elevatorRotationCounter;
	}
	
	public double getEncoderStartPos(){
		return elevatorEncoderValueOnStart;
	}

}