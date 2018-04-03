package org.usfirst.frc2783.robot;

import java.util.Map;
import org.usfirst.frc2783.calculation.RigidTransform2d;
import org.usfirst.frc2783.calculation.Rotation2d;
import org.usfirst.frc2783.calculation.Translation2d;
import org.usfirst.frc2783.calculation.Twist2d;
import org.usfirst.frc2783.util.InterpolatingDouble;
import org.usfirst.frc2783.util.InterpolatingTreeMap;
import org.usfirst.frc2783.robot.Kinematics;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * RobotState keeps track of the poses of various coordinate frames throughout the match. A coordinate frame is simply a
 * point and direction in space that defines an (x,y) coordinate system. Transforms (or poses) keep track of the spatial
 * relationship between different frames.
 *
 * Robot frames of interest (from parent to child):
 *
 * 1. Field frame: origin is where the robot is turned on
 *
 * 2. Vehicle frame: origin is the center of the robot wheelbase, facing forwards
 *
 * 3. Camera frame: origin is the center of the camera imager relative to the robot base.
 *
 * 4. Goal frame: origin is the center of the boiler (note that orientation in this frame is arbitrary). Also note that
 * there can be multiple goal frames.
 *
 * As a kinematic chain with 4 frames, there are 3 transforms of interest:
 *
 * 1. Field-to-vehicle: This is tracked over time by integrating encoder and gyro measurements. It will inevitably
 * drift, but is usually accurate over short time periods.
 *
 * 2. Vehicle-to-camera: This is a constant.
 *
 * 3. Camera-to-goal: This is a pure translation, and is measured by the vision system.
 */

public class RobotState {
    private static RobotState instance_ = new RobotState();

    public static RobotState getInstance() {
        return instance_;
    }

    private static final int kObservationBufferSize = 100;

    private static final RigidTransform2d kVehicleToCamera = new RigidTransform2d(
            new Translation2d(Constants.kCameraXOffset, Constants.kCameraYOffset), new Rotation2d());

    // FPGATimestamp -> RigidTransform2d or Rotation2d
    /*
     * This is the variable that stores a time (InterpolatingDouble) with a location (RigidTransform2d).
     * This allows to store data of the robot movement. This is possibly used for feedback, for the robot
     * knows its location and where it wants to go. This InterpolatingTreeMap here is then compared to
     * the wanted state of the robot and thus the robot adjusts itself accordingly.
     */
    private InterpolatingTreeMap<InterpolatingDouble, RigidTransform2d> field_to_vehicle_;
    private Twist2d vehicle_velocity_predicted_;
    private Twist2d vehicle_velocity_measured_;
    private double distance_driven_;

    private RobotState() {
        reset(0, new RigidTransform2d());
    }

    /**
     * Resets the field to robot transform (robot's position on the field)
     */
    public synchronized void reset(double start_time, RigidTransform2d initial_field_to_vehicle) {
        field_to_vehicle_ = new InterpolatingTreeMap<>(kObservationBufferSize);
        field_to_vehicle_.put(new InterpolatingDouble(start_time), initial_field_to_vehicle);
        vehicle_velocity_predicted_ = Twist2d.identity();
        vehicle_velocity_measured_ = Twist2d.identity();
        distance_driven_ = 0.0;
    }

    public synchronized void resetDistanceDriven() {
        distance_driven_ = 0.0;
    }

    /**
     * Returns the robot's position on the field at a certain time. Linearly interpolates between stored robot positions
     * to fill in the gaps.
     */
    public synchronized RigidTransform2d getFieldToVehicle(double timestamp) {
        return field_to_vehicle_.getInterpolated(new InterpolatingDouble(timestamp));
    }

    public synchronized Map.Entry<InterpolatingDouble, RigidTransform2d> getLatestFieldToVehicle() {
    	//Robot.tankDrive.isExisting();
    	SmartDashboard.putString("DB/String 9", field_to_vehicle_.lastEntry().toString());
    	if (field_to_vehicle_.lastEntry().getKey().toString() == null) {
    		SmartDashboard.putString("DB/String 9", "Nothing is here");
    	}
    	return field_to_vehicle_.lastEntry();
        
    }

    public synchronized RigidTransform2d getPredictedFieldToVehicle(double lookahead_time) {
        return getLatestFieldToVehicle().getValue()
                .transformBy(RigidTransform2d.exp(vehicle_velocity_predicted_.scaled(lookahead_time)));
    }

    public synchronized RigidTransform2d getFieldToCamera(double timestamp) {
        return getFieldToVehicle(timestamp).transformBy(kVehicleToCamera);
    }

    public synchronized void addFieldToVehicleObservation(double timestamp, RigidTransform2d observation) {
        field_to_vehicle_.put(new InterpolatingDouble(timestamp), observation);
    }

    public synchronized void addObservations(double timestamp, Twist2d measured_velocity, Twist2d predicted_velocity) {
    	addFieldToVehicleObservation(timestamp, Kinematics.integrateForwardKinematics(getLatestFieldToVehicle().getValue(), measured_velocity));
        vehicle_velocity_measured_ = measured_velocity;
        vehicle_velocity_predicted_ = predicted_velocity;
    }
    
    public synchronized Twist2d generateOdometryFromSensors(double left_encoder_delta_distance,
    														double right_encoder_delta_distance,
    														Rotation2d current_gyro_angle) {
        final RigidTransform2d last_measurement = getLatestFieldToVehicle().getValue();
        final Twist2d delta = Kinematics.forwardKinematics(last_measurement.getRotation(),
                										   left_encoder_delta_distance,
                										   right_encoder_delta_distance,
                										   current_gyro_angle);
        distance_driven_ += delta.dx;
        return delta;
    }

    public synchronized double getDistanceDriven() {
        return distance_driven_;
    }

    public synchronized Twist2d getPredictedVelocity() {
        return vehicle_velocity_predicted_;
    }

    public synchronized Twist2d getMeasuredVelocity() {
        return vehicle_velocity_measured_;
    }

}
