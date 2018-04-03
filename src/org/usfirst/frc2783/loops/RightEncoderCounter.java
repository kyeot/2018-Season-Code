package org.usfirst.frc2783.loops;

import org.usfirst.frc2783.robot.Robot;
import org.usfirst.frc2783.util.Conversion;

public class RightEncoderCounter implements Loop{
	
	double rightEncValSub1;
	double rightEncValSub2;
	double rightEncValSub3;
	double rightEncVal;

	static double rightRotationCounter = 0;
	double rightEncoderLastVal;
	
	boolean wasForward;

	@Override
	public void onStart(double timestamp) {

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
	public void onLoop(double timestamp) {
		
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
					rightRotationCounter -= ((rightEncVal / 4096.0) * 100);
				}
			}
		
			else{
				if(rightEncVal < rightEncoderLastVal){
					rightRotationCounter++;
					rightRotationCounter += ((rightEncVal / 4096.0) * 100);
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
	public void onStop(double timestamp) {
	}
	
	public double getRotations(){
		return rightRotationCounter;
	}
	
	public double getInchPerSec() {
		double outputPercent = Robot.tankDrive.leftMaster.getMotorOutputPercent();
		return Conversion.outputPercentToVelocity(outputPercent);
	}

}