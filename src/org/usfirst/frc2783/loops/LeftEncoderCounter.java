package org.usfirst.frc2783.loops;

import org.usfirst.frc2783.robot.Robot;
import org.usfirst.frc2783.util.Conversion;

public class LeftEncoderCounter implements Loop{
	
	//Sets the rotation counters to 0
	static double leftRotationCounter = 0;
	
	double loopCount;

	double leftEncoderLastVal;
	
	double leftEncVal;
	double leftEncValSub1;
	double leftEncValSub2;
	double leftEncValSub3;

	boolean wasForward;
	
	@Override
	public void onStart(double timestamp) {
		
		
		wasForward = true;
		
		leftEncVal = Robot.leftAbsEnc.getValue();  
		
		if(Robot.isLeftForward){
			leftEncoderLastVal = leftEncVal-50;
		}
		
		else{
			leftEncoderLastVal = leftEncVal+50;
		}
		
	}

	@Override
	public void onLoop(double timestamp) {
		
    	if(Robot.tankDrive.leftMaster.getMotorOutputPercent() > 0.1){
    		Robot.isLeftForward = false;
    	}
    	
    	else if(Robot.tankDrive.leftMaster.getMotorOutputPercent() < -0.1){
    		Robot.isLeftForward = true;
    	}
		
		leftEncVal = Robot.leftAbsEnc.getValue();  
		
		if(wasForward == Robot.isLeftForward){
			if(Robot.isLeftForward){
				if(leftEncVal < leftEncoderLastVal){
					leftRotationCounter--;
					leftRotationCounter -= ((leftEncVal / 4096.0) * 100);
				}
			}
		
			else{
				if(leftEncVal > leftEncoderLastVal){
					leftRotationCounter++;
					leftRotationCounter += ((leftEncVal / 4096.0) * 100);
				}
			}
		}
			
		if(Robot.isLeftForward){
			leftEncoderLastVal = leftEncVal-50;
		}
		
		else{
			leftEncoderLastVal = leftEncVal+50;
		}
		
		wasForward = Robot.isLeftForward;
		
	}

	@Override
	public void onStop(double timestamp) {
		
	}
	
	public double getRotations(){
		return leftRotationCounter;
	}
	
	public double getInchPerSec() {
		double outputPercent = Robot.tankDrive.leftMaster.getMotorOutputPercent();
		return Conversion.outputPercentToVelocity(outputPercent);
	}

}