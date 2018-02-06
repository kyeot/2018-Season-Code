package org.usfirst.frc2783.commands.autonomous;

import org.usfirst.frc2783.robot.Constants;
import org.usfirst.frc2783.robot.Robot;

import com.ctre.phoenix.motorcontrol.NeutralMode;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoTankDrive extends Command {

	double lSpeed;
	double rSpeed;
	
	public static double leftDistanceInAngles;
	public static double rightDistanceInAngles;
	
	double leftRotationOnStart;
	double rightRotationOnStart;
	
	double speedScaler;
	double leftDistance;
	double rightDistance;
	
	double leftAngleOnStart;
	double rightAngleOnStart;
	
	double wantedLeftRotations;
	double wantedRightRotations;
	
	double wantedLeftAdditionalDegrees;
	double wantedRightAdditionalDegrees;
    
	double leftSpeed;
	double rightSpeed;
	
	String direction;
	
	boolean isLeftRotationsDone = false;
	boolean isLeftDegreesDone = false;
	boolean isRightRotationsDone = false;
	boolean isRightDegreesDone = false;
	
    public AutoTankDrive(double speedScaler, double leftDistance, double rightDistance, String direction){
    	requires(Robot.tankDriveBase);
    	
    	this.speedScaler = speedScaler;
    	this.leftDistance = leftDistance;
    	this.rightDistance = rightDistance;
    	this.direction = direction;
    	
    	leftAngleOnStart = Robot.leftAbsEnc.getValue();
    	rightAngleOnStart = Robot.rightAbsEnc.getValue();
    	
    	leftDistanceInAngles = leftDistance/Constants.inchPerDegree-leftAngleOnStart;
    	rightDistanceInAngles = rightDistance/Constants.inchPerDegree-rightAngleOnStart;
    	
    	leftRotationOnStart = Robot.leftCounter.leftRotationCounter;
    	rightRotationOnStart = Robot.rightCounter.rightRotationCounter;
    	
    	if(leftDistanceInAngles > rightDistanceInAngles){
    		rightSpeed = rightDistanceInAngles/leftDistanceInAngles*speedScaler;
    		leftSpeed = speedScaler;
    	}
    	else if(rightDistanceInAngles > leftDistanceInAngles){
    		leftSpeed = leftDistanceInAngles/rightDistanceInAngles*speedScaler;
    		rightSpeed = speedScaler;
    	}
    	else{
    		rightSpeed = speedScaler;
    		leftSpeed = speedScaler;
    	}
    	
    	if(direction == "Backward"){
    		leftSpeed = -leftSpeed;
    		rightSpeed = -rightSpeed;
    	}
    	
    }

    // Called just before this Command runs the first time
	protected void initialize() {
    	
    	wantedLeftRotations = Math.floor(leftDistanceInAngles/4096);
    	wantedRightRotations = Math.floor(rightDistanceInAngles/4096);
    	
    	wantedLeftAdditionalDegrees = leftDistanceInAngles - (wantedLeftRotations * 4096);
    	wantedRightAdditionalDegrees = rightDistanceInAngles - (wantedRightRotations * 4096);
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	                                                                                                                             
    	if(Robot.leftCounter.leftRotationCounter >= (leftRotationOnStart + wantedLeftRotations)){
    		isLeftRotationsDone = true;
    	}
    	
    	if(Robot.rightCounter.rightRotationCounter >= (rightRotationOnStart + wantedRightRotations)){
    		isRightRotationsDone = true;
    	}
    	
    	if(isLeftRotationsDone){
    		if(Robot.leftAbsEnc.getValue() < wantedLeftAdditionalDegrees + 50 && Robot.leftAbsEnc.getValue() > wantedLeftAdditionalDegrees - 50){
        		isLeftDegreesDone = true;
        	}
    	}
    	
    	if(isRightRotationsDone){
    		if(Robot.rightAbsEnc.getValue() < wantedRightAdditionalDegrees + 50 && Robot.rightAbsEnc.getValue() > wantedRightAdditionalDegrees - 50){
        		isRightDegreesDone = true;
        	}
    	}
    	
    	if(isLeftDegreesDone){
    		leftSpeed = 0;
    	}
    	
    	if(isRightDegreesDone){
    		rightSpeed = 0;
    	}
    	
    	Robot.tankDriveBase.tankDrive(-leftSpeed, rightSpeed);
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isLeftDegreesDone && isRightDegreesDone;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.tankDriveBase.tankDrive(0, 0);
    	Robot.tankDriveBase.leftSide1.setNeutralMode(NeutralMode.Brake);
    	Robot.tankDriveBase.rightSide1.setNeutralMode(NeutralMode.Brake);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
