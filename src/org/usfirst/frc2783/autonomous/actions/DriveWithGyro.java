package org.usfirst.frc2783.autonomous.actions;

import org.usfirst.frc2783.robot.Constants;
import org.usfirst.frc2783.robot.Robot;
import org.usfirst.frc2783.util.GyroSource;
import org.usfirst.frc2783.util.NavSensor;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;

public class DriveWithGyro extends Action {
	
	class GyroDriveOut implements PIDOutput {
		@Override
		public void pidWrite(double output) {
			rot = output;
		}
	}
	
	NavSensor gyro = NavSensor.getInstance();
	
	GyroSource gyroSource;
	GyroDriveOut gyroDriveOut;
	
	PIDController gyroDrivePid;
	
	double rot;
	
	double angle;
	double speed;

	public DriveWithGyro(double angle, double speed, double time) {
		super("DriveWithGyro", time);

		this.angle = angle;
		this.speed = speed;
		
		gyroDriveOut = new GyroDriveOut();
		gyroSource = new GyroSource();
		gyroDrivePid = new PIDController(Constants.kGyroDriveP, Constants.kGyroDriveI, Constants.kGyroDriveD, gyroSource, gyroDriveOut);
		
		gyroDrivePid.setInputRange(-0.15, 0.15);
		gyroDrivePid.setContinuous(false);
	}
	
	@Override
	public void perform(){
		gyroDrivePid.setSetpoint(angle);
		gyroDrivePid.enable();
		
		Robot.tankDrive.tankDrive((0.5*speed), (0.5*speed)+rot);
		
	}

}
