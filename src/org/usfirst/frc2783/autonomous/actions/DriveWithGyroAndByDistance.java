package org.usfirst.frc2783.autonomous.actions;

import org.usfirst.frc2783.robot.Constants;
import org.usfirst.frc2783.robot.Robot;
import org.usfirst.frc2783.util.GyroSource;
import org.usfirst.frc2783.util.LeftEncoderCounter;
import org.usfirst.frc2783.util.NavSensor;
import org.usfirst.frc2783.util.RightEncoderCounter;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;

public class DriveWithGyroAndByDistance extends Action {
	
	//PID Output Class for the gyro corrected drive
	class GyroDriveOut implements PIDOutput {
		@Override
		public void pidWrite(double output) {
			rot = -output;
		}
	}
	
	//Instantiates gyro as an instance of the NavSensor class
	NavSensor gyro = NavSensor.getInstance();
	
	//Creates the gyro correction PID Controller objects
	GyroSource gyroSource;
	GyroDriveOut gyroDriveOut;
	PIDController gyroDrivePid;
	
	double rot;

	//Creates left and right variables for total distance needed to go in degrees
	public static double leftDistanceInDegrees;
	public static double rightDistanceInDegrees;
	
	//Creates left and right variables for what each side's rotation counter is on startup
	double leftRotationOnStart;
	double rightRotationOnStart;
	
	//Creates left and right variables for what the encoder angles are on startup
	double leftAngleOnStart;
	double rightAngleOnStart;
	
	//Creates the variables for speed and each sides distance given when the action is ran
	double speedScaler;
	double leftDistance;
	double rightDistance;
	
	//Creates left and right variables for the total degrees needed to travel for each side
	double wantedLeftTotalDegrees;
	double wantedRightTotalDegrees;
	
	//Creates left and right variables for the total entire rotations needed to travel for each side
	double wantedLeftRotations;
	double wantedRightRotations;
	
	//Creates left and right variables for the amount of extra degrees needed to go after wanted rotations are complete
	double wantedLeftAdditionalDegrees;
	double wantedRightAdditionalDegrees;
    
	//Creates left and right variables for speed
	double leftSpeed;
	double rightSpeed;
	
	//Creates left and right variables for the speeds on startup
	double leftSpeedOnStart;
	double rightSpeedOnStart;
	
	//Creates left and right booleans for whether each stage is done
	boolean isLeftRotationsDone = false;
	boolean isLeftDegreesDone = false;
	boolean isRightRotationsDone = false;
	boolean isRightDegreesDone = false;
	
	double angle;
	
	static LeftEncoderCounter leftCounter = LeftEncoderCounter.getInstance();
	static RightEncoderCounter rightCounter = RightEncoderCounter.getInstance();
	
	/**
	 * 
	 * Drives the tank drive forward with automatic gyroscope adjustment based on the left and right distances you give it
	 * and the speed scaler to adjust speed.
	 * 
	 * @param SpeedScaler
	 * @param LeftDistance
	 * @param RightDistance
	 */
	public DriveWithGyroAndByDistance(double speedScaler, double leftDistance, double rightDistance, double angle) {
		super("DriveByDistance");

		//Creates the PID controller for gyro adjustment
		gyroDriveOut = new GyroDriveOut();
		gyroSource = new GyroSource();
		gyroDrivePid = new PIDController(Constants.kGyroDriveP, Constants.kGyroDriveI, Constants.kGyroDriveD, gyroSource, gyroDriveOut);
		
		gyroDrivePid.setInputRange(0, 360);
		gyroDrivePid.setContinuous();
		
		//Sets the local speed and distance variables to what you pass in
    	this.speedScaler = speedScaler;
    	this.leftDistance = leftDistance;
    	this.rightDistance = rightDistance;
    	
    	this.angle = angle;
    	
    	//Makes the angle on start equal the angle, on start
    	leftAngleOnStart = Robot.leftAbsEnc.getValue();
    	rightAngleOnStart = Robot.rightAbsEnc.getValue();
    	
    	//Makes the distances in degrees equal the distances given scaled from inches to degrees
    	leftDistanceInDegrees = (leftDistance/Constants.kInchPerDegree)-leftAngleOnStart;
    	rightDistanceInDegrees = (rightDistance/Constants.kInchPerDegree)-rightAngleOnStart;
    	
    	//Makes the wanted total angle equal the wanted additional degrees plus the starting angles
    	wantedLeftTotalDegrees = leftAngleOnStart + leftDistanceInDegrees;
    	wantedRightTotalDegrees = rightAngleOnStart + rightDistanceInDegrees;
    	
    	//Makes the rotations on start equal the rotations, on start
    	leftRotationOnStart = leftCounter.getRotations();
    	rightRotationOnStart = rightCounter.getRotations();
    	
    	//Scales the left and right speeds scale based on which needs to go more distance
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
    	
    	//Makes the speeds on start equal the speeds for later use
    	leftSpeedOnStart = leftSpeed;
    	rightSpeedOnStart = rightSpeed;
    	
    	//Makes wanted rotations equal the wanted total degrees divided by the degrees per rotation, 4096
    	wantedLeftRotations = Math.floor(wantedLeftTotalDegrees/4096);
    	wantedRightRotations = Math.floor(wantedRightTotalDegrees/4096);
    	
    	//Makes wanted additional degrees equal equal the total angle to go to modulo 4096 to get the remainder after rotations
    	wantedLeftAdditionalDegrees = wantedLeftTotalDegrees%4096;
    	wantedRightAdditionalDegrees = wantedRightTotalDegrees%4096;
    	
	}
	
	@Override
	public void start(){
	}
	
	@Override
	public void perform(){                         
		//Detects when the rotations are done and sets the booleans correspondingly
    	if(leftCounter.getRotations() >= (leftRotationOnStart + wantedLeftRotations)){
    		isLeftRotationsDone = true;
    	}
    	if(rightCounter.getRotations() >= (rightRotationOnStart + wantedRightRotations)){
    		isRightRotationsDone = true;
    	}
    	
    	//When the rotations are done halves the speeds and uses the side PID's to adjust to the additional degrees angle
    	if(isLeftRotationsDone){
    		leftSpeed = leftSpeedOnStart/2;
    		
    		if(Robot.leftAbsEnc.getValue() < wantedLeftAdditionalDegrees + 25 && Robot.leftAbsEnc.getValue() > wantedLeftAdditionalDegrees - 25){
        		isLeftDegreesDone = true;
        	}
    	}
    	if(isRightRotationsDone){
    		rightSpeed = rightSpeedOnStart/2;
    		
    		if(Robot.rightAbsEnc.getValue() < wantedRightAdditionalDegrees + 25 && Robot.rightAbsEnc.getValue() > wantedRightAdditionalDegrees - 25){
        		isRightDegreesDone = true;
        	}
    	}
    	
    	//Sets the speeds to 0 when the degrees are done
    	if(isLeftDegreesDone){
    		leftSpeed = 0;
    	}
    	if(isRightDegreesDone){
    		rightSpeed = 0;
    	}
    	
    	//Drives with the speed and gyro adjustment
    	gyroDrive(leftSpeed);
		
	}
	
	/**
	 * Drives with gyro adjustment by given speed
	 * 
	 * @param speed
	 */
	public void gyroDrive(double speed){
		gyroDrivePid.setSetpoint(angle);
		gyroDrivePid.enable();

		Robot.tankDrive.tankDrive(-speed, -speed+rot);
	}
	
	@Override
	public boolean done(){
		return isLeftDegreesDone || isRightDegreesDone;
	}

	@Override
	public void finish() {
		//Cuts the speed to motors and puts them in brake mode when the angle is reached
    	Robot.tankDrive.tankDrive(0, 0);
    	Robot.tankDrive.setBrakeMode(true);
	}

}