package org.usfirst.frc2783.commands.autonomous;

import org.usfirst.frc2783.robot.Constants;
import org.usfirst.frc2783.robot.Robot;
import org.usfirst.frc2783.subystems.TankDriveBase;
import org.usfirst.frc2783.util.EncoderCounter;

import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class autoTankDrive extends Command {

	double lSpeed;
	double rSpeed;
	
	public static double leftDistanceInAngles;
	public static double rightDistanceInAngles;
	
	double leftRotationOnStart;
	double rightRotationOnStart;
	
	double speedScaler;
	double leftDistance;
	double rightDistance;
	
	double wantedLeftRotations;
	double wantedRightRotations;
	
	double wantedLeftAdditionalDegrees;
	double wantedRightAdditionalDegrees;
    
	double leftSpeed;
	double rightSpeed;
	
	String direction;
	
	boolean isRotationsDone = false;
	
    public autoTankDrive(double speedScaler, double leftDistance, double rightDistance, String direction){
    	requires(Robot.tankDriveBase);
    	
    	this.speedScaler = speedScaler;
    	this.leftDistance = leftDistance;
    	this.rightDistance = rightDistance;
    	this.direction = direction;
    	
    	leftDistanceInAngles = leftDistance/Constants.inchPerDegree;
    	rightDistanceInAngles = rightDistance/Constants.inchPerDegree;
    	
    	leftRotationOnStart = EncoderCounter.leftRotationCounter;
    	rightRotationOnStart = EncoderCounter.rightRotationCounter;
    	
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
    	
    	wantedLeftRotations = leftDistanceInAngles/4096;
    	wantedRightRotations = rightDistanceInAngles/4096;
    	
    	wantedLeftAdditionalDegrees = leftDistanceInAngles - (wantedLeftRotations*4096);
    	wantedRightAdditionalDegrees = rightDistanceInAngles - (wantedRightRotations*4096);
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	SmartDashboard.putString("DB/String 0", "" + leftDistanceInAngles);
    	SmartDashboard.putString("DB/String 1", "" + wantedLeftAdditionalDegrees);
    	SmartDashboard.putString("DB/String 2", "" + wantedLeftRotations);
    	                                                                                                                             
    	if(EncoderCounter.leftRotationCounter >= (leftRotationOnStart + wantedLeftRotations)
    			&& EncoderCounter.rightRotationCounter >= (rightRotationOnStart + wantedRightRotations)){
    		isRotationsDone = true;
    	}
    	
    	if(!isRotationsDone){
    		Robot.tankDriveBase.tankDrive(leftSpeed, -rightSpeed);
    	}
    	
    	if(isRotationsDone){
    		Robot.tankDriveBase.tankDrive(0, 0);
    		
    		Robot.tankDriveBase.leftPIDCont.enable();
    		Robot.tankDriveBase.rightPIDCont.enable();
    		
    		Robot.tankDriveBase.leftPIDCont.setSetpoint(wantedLeftAdditionalDegrees);
    		Robot.tankDriveBase.rightPIDCont.setSetpoint(wantedRightAdditionalDegrees);
    		
    	}
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (Robot.leftAbsEnc.getValue() > leftDistanceInAngles-5 
        		&& Robot.leftAbsEnc.getValue() < leftDistanceInAngles+5) 
        		&& (Robot.rightAbsEnc.getValue() > rightDistanceInAngles-5 
        		&& Robot.rightAbsEnc.getValue() < rightDistanceInAngles+5);
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
