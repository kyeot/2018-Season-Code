package org.usfirst.frc2783.loops;

import org.usfirst.frc2783.robot.Kinematics;
import org.usfirst.frc2783.robot.Robot;
import org.usfirst.frc2783.robot.RobotState;
import org.usfirst.frc2783.util.Conversion;
import org.usfirst.frc2783.util.NavSensor;
import org.usfirst.frc2783.calculation.Rotation2d;
import org.usfirst.frc2783.calculation.Twist2d;

/**
 * Periodically estimates the state of the robot using the robot's distance traveled (compares two waypoints), gyroscope
 * orientation, and velocity, among various other factors. Similar to a car's odometer.
 */
public class RobotStateEstimator implements Loop {
    static RobotStateEstimator instance_ = new RobotStateEstimator();

    public static RobotStateEstimator getInstance() {
        return instance_;
    }

    RobotStateEstimator() {
    }

    RobotState robot_state_ = RobotState.getInstance();
    LeftEncoderCounter leftSide = Robot.leftCounter;
    RightEncoderCounter rightSide = Robot.rightCounter;
    double left_encoder_prev_distance_ = 0;
    double right_encoder_prev_distance_ = 0;
    NavSensor gyro = NavSensor.getInstance();
    
    @Override
    public synchronized void onStart(double timestamp) {
        left_encoder_prev_distance_ = leftSide.getRotations();
        right_encoder_prev_distance_ = rightSide.getRotations();
    }

    @Override
    public synchronized void onLoop(double timestamp) { //Need to fix mixture of loops
        final double left_distance = Conversion.rotationsToInches(leftSide.getRotations()); //THESE NEED TO BE TRANSLATED TO INCHES DONT FORGET
        final double right_distance = Conversion.rotationsToInches(rightSide.getRotations());
        final Rotation2d gyro_angle = Rotation2d.fromDegrees(gyro.getAngle(false)); //Use gyro to get angle
        final Twist2d odometry_velocity = robot_state_.generateOdometryFromSensors(
                left_distance - left_encoder_prev_distance_, right_distance - right_encoder_prev_distance_, gyro_angle);
        final Twist2d predicted_velocity = Kinematics.forwardKinematics(leftSide.getInchPerSec(),
        		rightSide.getInchPerSec());
        robot_state_.addObservations(timestamp, odometry_velocity, predicted_velocity);
        left_encoder_prev_distance_ = left_distance;
        right_encoder_prev_distance_ = right_distance;
    }

	@Override
	public void onStop(double timestamp) {
		// TODO Auto-generated method stub
		
	}

}