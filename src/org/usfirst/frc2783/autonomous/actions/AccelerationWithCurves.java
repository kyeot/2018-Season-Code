package org.usfirst.frc2783.autonomous.actions;

import org.usfirst.frc2783.util.scenarios;
import org.usfirst.frc2783.robot.Constants;
import org.usfirst.frc2783.robot.Robot;
import org.usfirst.frc2783.util.Logger;

import com.ctre.phoenix.motorcontrol.NeutralMode;

import edu.wpi.first.wpilibj.RobotController;

public class AccelerationWithCurves extends Action {
	// Inputs given
	double initialSpeed;
	double initialRadius;
	double desiredFinalSpeed;
	double radius;
	double nextFinalSpeed;
	double nextRadius;
	double turnState;

	// Time measurements
	double runtime; // Total time of operation
	double startTime; // Initial time
	double curTime; // Time at any given moment
	double endTime; // Time at end of action
	double showtime; // Time since the initial time

	// The following variables refer to a velocity-time graph
	double maxIntersectInitial;
	double maxIntersectFinal;
	double behaviorChangeOne;
	double behaviorChangeTwo;
	boolean hasStagnantSegment;

	/*
	 * The robot will accelerate as fast as it needs to, unless the calculated
	 * acceleration value is greater than the maximum acceleration. For all
	 * practical purposes, we use .5 percent per second per second.
	 */
	double maxAcceleration = .5;

	// Outputs given throughout the code

	scenarios scenario;
	double robotSpeed;
	double angularVelocity;
	double leftSpeed;
	double rightSpeed;

	/*
	 * Use this action when acceleration is not 0. All speeds refer to the speed
	 * of the robot in general, and are on a scale from 0 to 1. To turn, pass
	 * through a non-zero radius. When referring to radius, use a positive
	 * number to represent a right turn, and a negative number to represent a
	 * left turn. As you may expect, when a radius is included, the motion
	 * followed by the robot will be in a circle with the specified radius.
	 * 
	 * In regards to how the action runs, given a starting speed, a max speed
	 * (desiredFinalSpeed), and an ending speed, the robot obeys the following
	 * conditions: 1. The robot must never accelerate or decelerate faster than
	 * maxAcceleration. 2. The robot must start with speed initialSpeed. 3. The
	 * robot must end with speed nextFinalSpeed. 4. The robot must never go
	 * faster than desiredFinalSpeed. 5. The robot must go as fast as possible.
	 */
	public AccelerationWithCurves(double initX, double initY, double initialSpeed, double initialRadius, double finalX,
			double finalY, double desiredFinalSpeed, double radius, double nextX, double nextY, double nextFinalSpeed,
			double nextRadius, double time) {

		super("AccelerationWithCurves");

		if (time < 0) {
			throw new Error("Time travelers not allowed. Please use a positive time.");
		}

		this.initialSpeed = initialSpeed;
		this.initialRadius = initialRadius;
		this.desiredFinalSpeed = desiredFinalSpeed;
		this.radius = radius;
		this.nextFinalSpeed = nextFinalSpeed;
		this.nextRadius = nextRadius;
		runtime = time;

		if (radius == 0) {
			turnState = 0;
		} else if (radius > 0) {
			turnState = 1;
		} else {
			turnState = 2;
		}

		if (initialSpeed >= desiredFinalSpeed) {
			scenario = nextFinalSpeed > desiredFinalSpeed ? scenarios.BOTH_GREATER : scenarios.GREATER_THEN_LESSER;
		} else {
			scenario = nextFinalSpeed > desiredFinalSpeed ? scenarios.LESSER_THEN_GREATER : scenarios.BOTH_LESSER;
		}
	}

	public void start() {
		startTime = RobotController.getFPGATime();
		endTime = startTime + runtime;
		maxIntersectInitial = Math.abs((desiredFinalSpeed - initialSpeed) / maxAcceleration);
		maxIntersectFinal = Math.abs((nextFinalSpeed - desiredFinalSpeed) / (maxAcceleration));

		switch (scenario) {
		case BOTH_LESSER:
			if (maxIntersectInitial + maxIntersectFinal >= runtime) {
				hasStagnantSegment = false;
				behaviorChangeOne = (.5 * runtime) + ((1 / maxAcceleration) * (nextFinalSpeed - initialSpeed));
			} else {
				hasStagnantSegment = true;
				behaviorChangeOne = maxIntersectInitial;
				behaviorChangeTwo = runtime - maxIntersectFinal;
			}
			break;
		case GREATER_THEN_LESSER:
			if (maxIntersectInitial + maxIntersectFinal > runtime) {
				throw new Error("Impossible deceleration. Please lower your input.");
			} else if (maxIntersectInitial + maxIntersectFinal == runtime) {
				hasStagnantSegment = false;
				behaviorChangeOne = runtime;
			} else {
				hasStagnantSegment = true;
				behaviorChangeOne = maxIntersectInitial;
				behaviorChangeTwo = runtime - maxIntersectFinal;
			}
			break;
		case LESSER_THEN_GREATER:
			if (maxIntersectInitial + maxIntersectFinal >= runtime) {
				hasStagnantSegment = false;
				behaviorChangeOne = runtime;
			} else {
				hasStagnantSegment = true;
				behaviorChangeOne = maxIntersectInitial;
				behaviorChangeTwo = runtime - maxIntersectFinal;
			}
			break;
		case BOTH_GREATER:
			if (maxIntersectInitial + maxIntersectFinal >= runtime) {
				hasStagnantSegment = false;
				behaviorChangeOne = (.5 * runtime) + ((-1 / maxAcceleration) * (nextFinalSpeed - initialSpeed));
			} else {
				hasStagnantSegment = true;
				behaviorChangeOne = maxIntersectInitial;
				behaviorChangeTwo = runtime - maxIntersectFinal;
			}
			break;
		}
	}

	public void perform() {
		curTime = RobotController.getFPGATime();
		showtime = Math.abs(curTime - startTime);

		switch (scenario) {
		case BOTH_GREATER:
			if (hasStagnantSegment) {
				if (showtime <= behaviorChangeOne) {
					robotSpeed = initialSpeed - (maxAcceleration * showtime);
				} else if (showtime <= behaviorChangeTwo) {
					robotSpeed = desiredFinalSpeed;
				} else {
					robotSpeed = desiredFinalSpeed + (maxAcceleration * (showtime - behaviorChangeTwo));
				}
			} else {
				if (showtime <= behaviorChangeOne) {
					robotSpeed = initialSpeed - (maxAcceleration * showtime);
				} else {
					robotSpeed = (initialSpeed - (maxAcceleration * behaviorChangeOne))
							+ (maxAcceleration * (showtime - behaviorChangeOne));
				}
			}
			break;
		case GREATER_THEN_LESSER:
			if (hasStagnantSegment) {
				if (showtime <= behaviorChangeOne) {
					robotSpeed = initialSpeed - (maxAcceleration * showtime);
				} else if (showtime <= behaviorChangeTwo) {
					robotSpeed = desiredFinalSpeed;
				} else {
					robotSpeed = desiredFinalSpeed - (maxAcceleration * (showtime - behaviorChangeTwo));
				}
			} else {
				robotSpeed = initialSpeed - (maxAcceleration * showtime);
			}
			break;
		case LESSER_THEN_GREATER:
			if (hasStagnantSegment) {
				if (showtime <= behaviorChangeOne) {
					robotSpeed = initialSpeed + (maxAcceleration * showtime);
				} else if (showtime <= behaviorChangeTwo) {
					robotSpeed = desiredFinalSpeed;
				} else {
					robotSpeed = desiredFinalSpeed + (maxAcceleration * (showtime - behaviorChangeTwo));
				}
			} else {
				if (showtime <= behaviorChangeOne) {
					robotSpeed = initialSpeed + (maxAcceleration * showtime);
				} else {
					throw new Error("Timeout. Please allot more time for operation to run.");
				}
			}
			break;
		case BOTH_LESSER:
			if (hasStagnantSegment) {
				if (showtime <= behaviorChangeOne) {
					robotSpeed = initialSpeed + (maxAcceleration * showtime);
				} else if (showtime <= behaviorChangeTwo) {
					robotSpeed = desiredFinalSpeed;
				} else {
					robotSpeed = desiredFinalSpeed - (maxAcceleration * (showtime - behaviorChangeTwo));
				}
			} else {
				if (showtime <= behaviorChangeOne) {
					robotSpeed = initialSpeed + (maxAcceleration * showtime);
				} else {
					robotSpeed = (initialSpeed + (maxAcceleration * behaviorChangeOne))
							- (maxAcceleration * (showtime - behaviorChangeOne));
				}
			}
			break;
		default:
			Logger.error("Velocity case not found. Running without acceleration or deceleration.");
			scenario = null;
			robotSpeed = desiredFinalSpeed;
		}

		if (turnState == 0) {
			leftSpeed = robotSpeed;
			rightSpeed = robotSpeed;
		} else if (turnState == 1) {
			angularVelocity = robotSpeed / Math.abs(radius);
			leftSpeed = angularVelocity * (Math.abs(radius) + Constants.kTrackWidthInches);
			rightSpeed = angularVelocity * (Math.abs(radius) - Constants.kTrackWidthInches);
		} else if (turnState == 2) {
			angularVelocity = robotSpeed / Math.abs(radius);
			rightSpeed = angularVelocity * (Math.abs(radius) + Constants.kTrackWidthInches);
			leftSpeed = angularVelocity * (Math.abs(radius) - Constants.kTrackWidthInches);
		}

		if (Math.abs(leftSpeed) > 1) {
			leftSpeed = 1;
			rightSpeed = (leftSpeed / (Math.abs(radius) + Constants.kTrackWidthInches))
					* (Math.abs(radius) - Constants.kTrackWidthInches);
		} else if (Math.abs(rightSpeed) > 1) {
			rightSpeed = 1;
			leftSpeed = (leftSpeed / (Math.abs(radius) + Constants.kTrackWidthInches))
					* (Math.abs(radius) - Constants.kTrackWidthInches);
		}

		Robot.tankDrive.tankDrive(leftSpeed, rightSpeed);
	}

	public boolean done() {
		return showtime >= runtime;
	}

	public void finish() {
		Robot.tankDrive.leftMaster.setNeutralMode(NeutralMode.Brake);
		Robot.tankDrive.rightMaster.setNeutralMode(NeutralMode.Brake);
	}
}
