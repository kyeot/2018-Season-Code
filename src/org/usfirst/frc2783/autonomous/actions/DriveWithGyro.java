package org.usfirst.frc2783.autonomous.actions;

import org.usfirst.frc2783.robot.Constants;
import org.usfirst.frc2783.robot.Robot;
import org.usfirst.frc2783.util.Bearing;
import org.usfirst.frc2783.util.GyroSource;
import org.usfirst.frc2783.util.NavSensor;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveWithGyro extends Action {
	
	class GyroDriveOut implements PIDOutput {
		@Override
		public void pidWrite(double output) {
			rot = -output;
		}
	}
	
	NavSensor gyro = NavSensor.getInstance();
	
	double d = 0;
	
	GyroSource gyroSource;
	GyroDriveOut gyroDriveOut;
	
	PIDController gyroDrivePid;
	
	double rot;
	
	double speed;

	public DriveWithGyro(double speed, double time) {
		super("DriveWithGyro", time);
		
		this.speed = speed;
		
		Robot.angle = gyro.getAngle(false);
		
		gyroDriveOut = new GyroDriveOut();
		gyroSource = new GyroSource();
		gyroDrivePid = new PIDController(Constants.kGyroDriveP, Constants.kGyroDriveI, Constants.kGyroDriveD, gyroSource, gyroDriveOut);
		
		gyroDrivePid.setInputRange(0, 360);
		gyroDrivePid.setContinuous();
	}
	
	@Override
	public void perform(){
		
		SmartDashboard.putString("DB/String 0", "" + Math.floor(Robot.angle));
		
		gyroDrivePid.setSetpoint(Robot.angle);
		gyroDrivePid.enable();

		Robot.tankDrive.tankDrive(-speed, -speed+rot);

	}

}
