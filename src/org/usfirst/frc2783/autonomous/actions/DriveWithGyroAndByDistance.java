package org.usfirst.frc2783.autonomous.actions;

import org.usfirst.frc2783.robot.Constants;
import org.usfirst.frc2783.robot.Robot;
import org.usfirst.frc2783.util.GyroSource;
import org.usfirst.frc2783.util.LeftEncoderCounter;
import org.usfirst.frc2783.util.NavSensor;
import org.usfirst.frc2783.util.RightEncoderCounter;

import com.ctre.phoenix.motorcontrol.NeutralMode;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveWithGyroAndByDistance extends Action {
	
	class GyroDriveOut implements PIDOutput {
		@Override
		public void pidWrite(double output) {
			rot = -output;
		}
	}
	
	NavSensor gyro = NavSensor.getInstance();
	
	GyroSource gyroSource;
	GyroDriveOut gyroDriveOut;
	
	PIDController gyroDrivePid;
	
	double rot;

	public static double leftDistanceInDegrees;
	public static double rightDistanceInDegrees;
	
	double leftRotationOnStart;
	double rightRotationOnStart;
	
	double speedScaler;
	double leftDistance;
	double rightDistance;
	
	double leftAngleOnStart;
	double rightAngleOnStart;
	
	double wantedLeftTotalDegrees;
	double wantedRightTotalDegrees;
	
	double wantedLeftRotations;
	double wantedRightRotations;
	
	double wantedLeftAdditionalDegrees;
	double wantedRightAdditionalDegrees;
    
	double leftSpeed;
	double rightSpeed;
	
	double leftSpeedOnStart;
	double rightSpeedOnStart;
	
	boolean isLeftRotationsDone = false;
	boolean isLeftDegreesDone = false;
	boolean isRightRotationsDone = false;
	boolean isRightDegreesDone = false;
	
	public DriveWithGyroAndByDistance(double speedScaler, double leftDistance, double rightDistance) {
		super("DriveByDistance");

		Robot.angle = gyro.getAngle(false);
		
		gyroDriveOut = new GyroDriveOut();
		gyroSource = new GyroSource();
		gyroDrivePid = new PIDController(Constants.kGyroDriveP, Constants.kGyroDriveI, Constants.kGyroDriveD, gyroSource, gyroDriveOut);
		
		gyroDrivePid.setInputRange(0, 360);
		gyroDrivePid.setContinuous();
		
    	this.speedScaler = speedScaler;
    	this.leftDistance = leftDistance;
    	this.rightDistance = rightDistance;
    	
    	leftAngleOnStart = Robot.leftAbsEnc.getValue();
    	rightAngleOnStart = Robot.rightAbsEnc.getValue();
    	
    	leftDistanceInDegrees = (leftDistance/Constants.inchPerDegree)-leftAngleOnStart;
    	rightDistanceInDegrees = (rightDistance/Constants.inchPerDegree)-rightAngleOnStart;
    	
    	wantedLeftTotalDegrees = leftAngleOnStart + leftDistanceInDegrees;
    	wantedRightTotalDegrees = rightAngleOnStart + rightDistanceInDegrees;
    	
    	leftRotationOnStart = LeftEncoderCounter.leftRotationCounter;
    	rightRotationOnStart = RightEncoderCounter.rightRotationCounter;
    	
    	if(leftDistanceInDegrees > rightDistanceInDegrees){
    		rightSpeed = rightDistanceInDegrees/leftDistanceInDegrees*speedScaler;
    		leftSpeed = speedScaler;
    	}
    	else if(rightDistanceInDegrees > leftDistanceInDegrees){
    		leftSpeed = leftDistanceInDegrees/rightDistanceInDegrees*speedScaler;
    		rightSpeed = speedScaler;
    	}
    	else{
    		rightSpeed = speedScaler;
    		leftSpeed = speedScaler;
    	}
    	
    	leftSpeedOnStart = leftSpeed;
    	rightSpeedOnStart = rightSpeed;
    	
    	wantedLeftRotations = Math.floor(wantedLeftTotalDegrees/4096);
    	wantedRightRotations = Math.floor(wantedRightTotalDegrees/4096);
    	
    	wantedLeftAdditionalDegrees = wantedLeftTotalDegrees%4096;
    	wantedRightAdditionalDegrees = wantedRightTotalDegrees%4096;
    	
	}
	
	@Override
	public void start(){
		SmartDashboard.putString("DB/String 5", "not done");
	}
	
	@Override
	public void perform(){                                                                                 
    	if(LeftEncoderCounter.leftRotationCounter >= (leftRotationOnStart + wantedLeftRotations)){
    		isLeftRotationsDone = true;
    	}
    	
    	if(RightEncoderCounter.rightRotationCounter >= (rightRotationOnStart + wantedRightRotations)){
    		isRightRotationsDone = true;
    	}
    	
    	if(isLeftRotationsDone){
    		leftSpeed = leftSpeedOnStart/2;
    		
    		Robot.tankDrive.setLeftPose(wantedLeftAdditionalDegrees);
    		
    		if(Robot.leftAbsEnc.getValue() < wantedLeftAdditionalDegrees + 25 && Robot.leftAbsEnc.getValue() > wantedLeftAdditionalDegrees - 25){
        		isLeftDegreesDone = true;
        	}
    	}
    	
    	if(isRightRotationsDone){
    		rightSpeed = rightSpeedOnStart/2;
    		
    		Robot.tankDrive.setRightPose(wantedRightAdditionalDegrees);
    		
    		if(Robot.rightAbsEnc.getValue() < wantedRightAdditionalDegrees + 25 && Robot.rightAbsEnc.getValue() > wantedRightAdditionalDegrees - 25){
        		isRightDegreesDone = true;
        	}
    	}
    	
    	if(isLeftDegreesDone){
    		leftSpeed = 0;
    	}
    	
    	if(isRightDegreesDone){
    		rightSpeed = 0;
    	}
    	
    	ddaso(leftSpeed);
		
	}
	
	public void ddaso(double speed){
		gyroDrivePid.setSetpoint(Robot.angle);
		gyroDrivePid.enable();

		Robot.tankDrive.tankDrive(-speed, -speed+rot);
	}
	
	@Override
	public boolean done(){
		return isLeftDegreesDone && isRightDegreesDone;
	}

	@Override
	public void finish() {
    	Robot.tankDrive.tankDrive(0, 0);
    	Robot.tankDrive.left1.setNeutralMode(NeutralMode.Brake);
    	Robot.tankDrive.right1.setNeutralMode(NeutralMode.Brake);
	}

}