package org.usfirst.frc2783.util;

import org.usfirst.frc2783.loops.Loop;
import org.usfirst.frc2783.robot.Robot;
import org.usfirst.frc2783.subsystems.ElevatorBase;

public class ElevatorEncoderCounter implements Loop{
	
	//Sets the rotation counters to 0
	public static double elevatorRotationCounter = 0;
	
	double loopCount;

	double elevatorEncoderLastVal;
	
	double elevatorEncVal;
	double elevatorEncValSub1;
	double elevatorEncValSub2;
	double elevatorEncValSub3;

	@Override
	public void onStart() {
		
		Robot.isElevatorForward = true;
		
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

    	if(ElevatorBase.elevator1Mot.getMotorOutputPercent() > 0.1){
    		Robot.isElevatorForward = false;
    	}
    	
    	else if(ElevatorBase.elevator1Mot.getMotorOutputPercent() < -0.1){
    		Robot.isElevatorForward = true;
    	}
		
		elevatorEncVal = Robot.elevatorAbsEnc.getValue();  
		
		if(Robot.isElevatorForward){
			if(elevatorEncVal < elevatorEncoderLastVal){
				elevatorRotationCounter--;
			}
		}
		
		else{
			if(elevatorEncVal > elevatorEncoderLastVal){
				elevatorRotationCounter++;
			}
		}
		
		if(Robot.isElevatorForward){
			elevatorEncoderLastVal = elevatorEncVal-50;
		}
		
		else{
			elevatorEncoderLastVal = elevatorEncVal+50;
		}
		
		
	}

	@Override
	public void onStop() {
	}

}