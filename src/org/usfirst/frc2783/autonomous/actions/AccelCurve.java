 package org.usfirst.frc2783.autonomous.actions;

import org.usfirst.frc2783.autonomous.paths.PathVelocity;
import org.usfirst.frc2783.autonomous.paths.PathBuilder.Setpoint;
import org.usfirst.frc2783.robot.Robot;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import edu.wpi.first.wpilibj.RobotController;

public class AccelCurve extends Action {
	PathVelocity robotSpeed;
	double rightSpeed;
	double leftSpeed;

	double maxAcceleration = .5;
	
	
	public AccelCurve(double initX,
					   double initY,
					   double initS,
					   double finX,
					   double finY,
					   double finS,
					   double lambda) {
		super("AccelCurve");
		robotSpeed = new PathVelocity(initX, initY, finX, finY, initS, 1, finS);
	}
	
	public AccelCurve(Setpoint sOne, Setpoint sTwo, Setpoint sThree, double vi, double vp, double vf, double lambda) {
		super("AccelCurve");
		
		robotSpeed = new PathVelocity(sOne, sTwo, vi, vp, vf);
	}
	
	/**
	 * This constructor also creates a linear path with two x, y
	 * points and two s speeds, but also includes a mid speed
	 * to help calculate acceleration
	 * 
	 * @param initX
	 * @param initY
	 * @param initS
	 * @param midS
	 * @param finX
	 * @param finY
	 * @param finS
	 */
	public AccelCurve(double initX,
					   double initY,
					   double initS,
					   double midS,
					   double finX,
					   double finY,
					   double finS,
					   double lambda) {
		super("AccelCurve");
		
		if (midS == 0) {
			throw new Error("Please enter nonzero value for middle speed");
		}
		
		robotSpeed = new PathVelocity(initX, initY, finX, finY, initS, midS, finS);
	}
	
	public double arcLength(Setpoint sOne, Setpoint sTwo, Setpoint sThree, double limda) {
		
	}

	public double linDistance(double xOne, double yOne, double xTwo, double yTwo) {
		return Math.sqrt(square(xTwo - xOne) + square(yTwo - yOne));
	}
	
	public double linDistance(Setpoint sOne, Setpoint sTwo) {
		return Math.sqrt(square(sTwo.getPosition().x() - sOne.getPosition().x()) + square(sTwo.getPosition().y() - sOne.getPosition().y()));
	}
	
	public double square(double value) {
		return value * value;
	}
	
	@Override
	public void start() {
	}

	@Override
	public void perform() {
		leftSpeed = robotSpeed.getOutput(RobotController.getFPGATime());;
		rightSpeed = robotSpeed.getOutput(RobotController.getFPGATime());;

		Robot.tankDrive.tankDrive(leftSpeed, rightSpeed);
	}

	@Override
	public boolean done() {
		return PathVelocity.seconds(RobotController.getFPGATime() - robotSpeed.startTime) > robotSpeed.runtime;
	}

	@Override
	public void finish() {
		// All you're doing here is setting the brake mode, it won't stop the
		// robot if thats your goal
		Robot.tankDrive.leftMaster.setNeutralMode(NeutralMode.Brake);
		Robot.tankDrive.rightMaster.setNeutralMode(NeutralMode.Brake);
	}
}
