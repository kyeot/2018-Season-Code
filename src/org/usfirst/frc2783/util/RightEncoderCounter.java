package org.usfirst.frc2783.util;

import org.usfirst.frc2783.loops.Loop;
import org.usfirst.frc2783.robot.Robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class RightEncoderCounter implements Loop{
	
	double rightEncValSub1;
	double rightEncValSub2;
	double rightEncValSub3;
	double rightEncVal;

	public static double rightRotationCounter = 0;
	double rightEncoderLastVal;

	@Override
	public void onStart() {

		Robot.isRightForward = true;

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
		
    	if(Robot.tankDrive.right1.getMotorOutputPercent() > 0.1){
    		Robot.isRightForward = true;
    	}
    	
    	else if(Robot.tankDrive.right1.getMotorOutputPercent() < -0.1){
    		Robot.isRightForward = false;
    	}

		rightEncVal = Robot.rightAbsEnc.getValue();
		
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

		if(Robot.isRightForward){
			rightEncoderLastVal = rightEncVal+50;
		}
		
		else{
			rightEncoderLastVal = rightEncVal-50;
		}
		
		
	}

	@Override
	public void onStop() {
	}

}