package org.usfirst.frc2783.util;

import java.lang.reflect.Array;
import java.util.ArrayList;

import org.usfirst.frc2783.loops.Loop;
import org.usfirst.frc2783.robot.Constants;
import org.usfirst.frc2783.robot.Robot;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class EncoderCounter implements Loop{
	
	//Sets the rotation counters to 0
	public static double leftRotationCounter = 0;
	public static double rightRotationCounter = 0;
	
	double loopCount;

	double leftEncoderLastVal;
	double rightEncoderLastVal;
	
	double leftEncVal;
	double rightEncVal;
	double leftEncValSub1;
	double leftEncValSub2;
	double leftEncValSub3;
	double rightEncValSub1;
	double rightEncValSub2;
	double rightEncValSub3;
	
	double yesso = 0;
	
//	ArrayList<Double> leftValues = new ArrayList();
//	ArrayList<Double> rightValues = new ArrayList();
	
	public EncoderCounter(){
		
	}

	@Override
	public void onStart() {
		Robot.isLeftForward = true;
		Robot.isRightForward = true;
		
		leftEncVal = Robot.leftAbsEnc.getValue();  
		rightEncVal = Robot.rightAbsEnc.getValue();
		
		if(Robot.isLeftForward){
			leftEncoderLastVal = leftEncVal+50;
		}
		else{
			leftEncoderLastVal = leftEncVal-50;
		}
		
		if(Robot.isRightForward){
			rightEncoderLastVal = rightEncVal-50;
		}
		else{
			rightEncoderLastVal = rightEncVal+50;
		}
		
	}

	@Override
	public void onLoop() {
		
		yesso++;
		
//		SmartDashboard.putString("DB/String 7", "mh " + yesso);
		
		leftEncVal = Robot.leftAbsEnc.getValue();  
		rightEncVal = Robot.rightAbsEnc.getValue();
		
		if(Robot.isLeftForward){
			if(leftEncVal > leftEncoderLastVal){
				leftRotationCounter++;
			}
		}
		
		else{
			if(leftEncVal < leftEncoderLastVal){
				leftRotationCounter--;
			}
		}
		
		if(Robot.isRightForward){
			if(rightEncVal < rightEncoderLastVal){
				rightRotationCounter++;
			}
		}
		
		else{
			if(rightEncVal > rightEncoderLastVal){
				rightRotationCounter--;
			}
		}
		
		if(Robot.isLeftForward = true){
			leftEncoderLastVal = leftEncVal+50;
		}
		else{
			leftEncoderLastVal = leftEncVal-50;
		}
		
		if(Robot.isRightForward){
			rightEncoderLastVal = rightEncVal-50;
		}
		else{
			rightEncoderLastVal = rightEncVal+50;
		}
		
		SmartDashboard.putString("DB/String 8", "mhm " + leftRotationCounter);
		SmartDashboard.putString("DB/String 9", "mhm " + rightRotationCounter);
//		
//		SmartDashboard.putString("DB/String 3", "" + Robot.leftAbsEnc.getValue());
		
	}

	@Override
	public void onStop() {
		
	}

}
