package org.usfirst.frc2783.util;

import org.usfirst.frc2783.loops.Loop;
import org.usfirst.frc2783.robot.Robot;

public class LeftEncoderCounter implements Loop{
	
	//Sets the rotation counters to 0
	public static double leftRotationCounter = 0;
	
	double loopCount;

	double leftEncoderLastVal;
	
	double leftEncVal;
	double leftEncValSub1;
	double leftEncValSub2;
	double leftEncValSub3;

	@Override
	public void onStart() {
		
		Robot.isLeftForward = true;
		
		leftEncVal = Robot.leftAbsEnc.getValue();  
		
		if(Robot.isLeftForward){
			leftEncoderLastVal = leftEncVal-50;
		}
		
		else{
			leftEncoderLastVal = leftEncVal+50;
		}
		
	}

	@Override
	public void onLoop() {

    	if(Robot.tankDriveBase.mLeftMaster.getMotorOutputPercent() > 0.1){
    		Robot.isLeftForward = false;
    	}
    	
    	else if(Robot.tankDriveBase.mLeftMaster.getMotorOutputPercent() < -0.1){
    		Robot.isLeftForward = true;
    	}
		
		leftEncVal = Robot.leftAbsEnc.getValue();  
		
		if(Robot.isLeftForward){
			if(leftEncVal < leftEncoderLastVal){
				leftRotationCounter--;
			}
		}
		
		else{
			if(leftEncVal > leftEncoderLastVal){
				leftRotationCounter++;
			}
		}
		
		if(Robot.isLeftForward){
			leftEncoderLastVal = leftEncVal-50;
		}
		
		else{
			leftEncoderLastVal = leftEncVal+50;
		}
		
		
	}

	@Override
	public void onStop() {
	}

}