package org.usfirst.frc2783.autonomous.actions;

import org.usfirst.frc2783.util.scenarios;
import org.usfirst.frc2783.robot.Robot;
import org.usfirst.frc2783.util.Logger;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import edu.wpi.first.wpilibj.RobotController;

public class AccelLinear extends Action {
	double initX;
	double initY;
	double initialSpeed;
	double desiredFinalSpeed;
	double finX;
	double finY;
	double nextFinalSpeed;

	double runtime; // Total time of operation
	double startTime; // Initial time
	double curTime; // Time at any given moment
	double endTime; // Time at end of action
	double showtime; // Time since the initial time

	double maxIntersectInitial;
	double maxIntersectFinal;
	double behaviorChangeOne;
	double behaviorChangeTwo;
	boolean hasStagnantSegment;

	double robotSpeed;
	double rightSpeed;
	double leftSpeed;

	double maxAcceleration = .5;

	scenarios scenario;
	
	/**
	 * Constructs a line of an x, y positions and an s speed
	 * and calculates the acceleration on the line of travel
	 * 
	 * @param initX
	 * @param initY
	 * @param initS
	 * @param finX
	 * @param finY
	 * @param finS
	 */
	public AccelLinear(double initX,
					   double initY,
					   double initS,
					   double finX,
					   double finY,
					   double finS) {
		super("AccelLinear");
		this.initX = initX;
		this.initY = initY;
		initialSpeed = initS;
		this.finX = finX;
		this.finY = finY;
		nextFinalSpeed = finS;
		desiredFinalSpeed = 1;

		if (initS >= desiredFinalSpeed) {
			scenario = finS > desiredFinalSpeed ? scenarios.BOTH_GREATER : scenarios.GREATER_THEN_LESSER;
		} else {
			scenario = finS > desiredFinalSpeed ? scenarios.LESSER_THEN_GREATER : scenarios.BOTH_LESSER;
		}
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
	public AccelLinear(double initX,
					   double initY,
					   double initS,
					   double midS,
					   double finX,
					   double finY,
					   double finS) {
		super("AccelLinear");
		this.initX = initX;
		this.initY = initY;
		initialSpeed = initS;
		desiredFinalSpeed = midS;
		this.finX = finX;
		this.finY = finY;
		nextFinalSpeed = finS;

		if (midS == 0) {
			throw new Error("Please enter nonzero value for middle speed");
		}

		if (initS >= midS) {
			scenario = finS > midS ? scenarios.BOTH_GREATER : scenarios.GREATER_THEN_LESSER;
		} else {
			scenario = finS > midS ? scenarios.LESSER_THEN_GREATER : scenarios.BOTH_LESSER;
		}
	}

	@Override
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

	@Override
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

		leftSpeed = robotSpeed;
		rightSpeed = robotSpeed;

		Robot.tankDrive.tankDrive(leftSpeed, rightSpeed);
	}

	@Override
	public boolean done() {
		return showtime >= runtime;
	}

	@Override
	public void finish() {
		// All you're doing here is setting the brake mode, it won't stop the
		// robot if thats your goal
		Robot.tankDrive.leftMaster.setNeutralMode(NeutralMode.Brake);
		Robot.tankDrive.rightMaster.setNeutralMode(NeutralMode.Brake);
	}
}
