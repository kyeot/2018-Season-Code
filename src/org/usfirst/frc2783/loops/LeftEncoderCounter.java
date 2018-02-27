package org.usfirst.frc2783.loops;

import org.usfirst.frc2783.robot.Robot;

public class LeftEncoderCounter implements Loop{
	
	private static LeftEncoderCounter _instance;
	
	public static LeftEncoderCounter getInstance(){
		return _instance;
	}
	
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
	public void onStart() {
		
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
	public void onLoop() {

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
				}
			}
		
			else{
				if(leftEncVal > leftEncoderLastVal){
					leftRotationCounter++;
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
	public void onStop() {
	}

	@Override
	public void onLoop(double timestamp) {
		// TODO Auto-generated method stub
		
	}
	
	public double getRotations(){
		return leftRotationCounter;
	}

}