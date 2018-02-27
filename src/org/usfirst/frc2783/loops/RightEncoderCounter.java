package org.usfirst.frc2783.loops;

import org.usfirst.frc2783.robot.Robot;

public class RightEncoderCounter implements Loop{
	
	private static RightEncoderCounter _instance;
	
	public static RightEncoderCounter getInstance(){
		return _instance;
	}
	
	double rightEncValSub1;
	double rightEncValSub2;
	double rightEncValSub3;
	double rightEncVal;

	static double rightRotationCounter = 0;
	double rightEncoderLastVal;
	
	boolean wasForward;

	@Override
	public void onStart() {

		wasForward = true;
		
		rightEncVal = Robot.rightAbsEnc.getValue();
		
		if(Robot.isRightForward){
			rightEncoderLastVal = rightEncVal+50;
		}
		
		else{
			rightEncoderLastVal = rightEncVal-50;
		}
		
	}

	@Override
	public void onLoop() {
		
    	if(Robot.tankDrive.rightMaster.getMotorOutputPercent() > 0.1){
    		Robot.isRightForward = true;
    	}
    	
    	else if(Robot.tankDrive.rightMaster.getMotorOutputPercent() < -0.1){
    		Robot.isRightForward = false;
    	}

		rightEncVal = Robot.rightAbsEnc.getValue();
		
		if(wasForward == Robot.isRightForward){
			if(Robot.isRightForward){
				if(rightEncVal > rightEncoderLastVal){
					rightRotationCounter--;
				}
			}
		
			else{
				if(rightEncVal < rightEncoderLastVal){
					rightRotationCounter++;
				}
			}

		}
			
		if(Robot.isRightForward){
			rightEncoderLastVal = rightEncVal+50;
		}
		
		else{
			rightEncoderLastVal = rightEncVal-50;
		}
		
		wasForward = Robot.isRightForward;
		
	}

	@Override
	public void onStop() {
	}

	@Override
	public void onLoop(double timestamp) {
		// TODO Auto-generated method stub
		
	}
	
	public double getRotations(){
		return rightRotationCounter;
	}

}