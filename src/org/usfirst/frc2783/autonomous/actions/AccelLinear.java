package org.usfirst.frc2783.autonomous.actions;
import org.usfirst.frc2783.robot.Robot;
import org.usfirst.frc2783.util.Logger;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import edu.wpi.first.wpilibj.RobotController;

public class AccelLinear extends Action{
	double initX;
	double initY;
	double initialSpeed;
	double desiredFinalSpeed;
	double finX;
	double finY;
	double nextFinalSpeed;
	
	double runtime; //Total time of operation
	double startTime; //Initial time
	double curTime; //Time at any given moment
	double endTime; //Time at end of action
	double showtime; //Time since the initial time
	
	double maxIntersectInitial;
	double maxIntersectFinal;
	double behaviorChangeOne;
	double behaviorChangeTwo;
	boolean hasStagnantSegment;
	
	double robotSpeed;
	double rightSpeed;
	double leftSpeed;
	
	double maxAcceleration = .5;
	
	String scenario;
	
	public AccelLinear(double initX, double initY, double initS, double finX, double finY, double finS) {
		super("AccelLinear");
		this.initX = initX;
		this.initY = initY;
		initialSpeed = initS;
		this.finX = finX;
		this.finY = finY;
		nextFinalSpeed = finS;
		desiredFinalSpeed = 1;
		
		if(initS >= desiredFinalSpeed) {
			scenario = finS > desiredFinalSpeed ? "Both Bigger" : "Bigger then Smaller";
		} else {
			scenario = finS > desiredFinalSpeed ? "Smaller then Bigger" : "Both Smaller";
		}
	}
	
	public AccelLinear(double initX, double initY, double initS, double midS, double finX, double finY, double finS) {
		super("AccelLinear");
		this.initX = initX;
		this.initY = initY;
		initialSpeed = initS;
		desiredFinalSpeed = midS;
		this.finX = finX;
		this.finY = finY;
		nextFinalSpeed = finS;
		
		if(midS == 0) {
			throw new Error("Please enter nonzero value for middle speed");
		}
		
		if(initS >= midS) {
			scenario = finS > midS ? "Both Bigger" : "Bigger then Smaller";
		} else {
			scenario = finS > midS ? "Smaller then Bigger" : "Both Smaller";
		}
	}
	
	public void start() {
		startTime = RobotController.getFPGATime();
		endTime = startTime + runtime;
		maxIntersectInitial = Math.abs((desiredFinalSpeed - initialSpeed)/maxAcceleration);
		maxIntersectFinal = Math.abs((nextFinalSpeed - desiredFinalSpeed)/(maxAcceleration));
		
		switch(scenario) {
		case "Both Smaller":
			if(maxIntersectInitial+maxIntersectFinal >= runtime) {
				hasStagnantSegment = false;
				behaviorChangeOne = (.5*runtime)+((1/maxAcceleration)*(nextFinalSpeed-initialSpeed));
			} else {
				hasStagnantSegment = true;
				behaviorChangeOne = maxIntersectInitial;
				behaviorChangeTwo = runtime-maxIntersectFinal;
			}
			break;
		case "Bigger then Smaller":
			if(maxIntersectInitial+maxIntersectFinal > runtime) {
				throw new Error("Impossible deceleration. Please lower your input.");
			} else if(maxIntersectInitial+maxIntersectFinal == runtime) {
				hasStagnantSegment = false;
				behaviorChangeOne = runtime;
			} else {
				hasStagnantSegment = true;
				behaviorChangeOne = maxIntersectInitial;
				behaviorChangeTwo = runtime-maxIntersectFinal;
			}
			break;
		case "Smaller then Bigger":
			if(maxIntersectInitial+maxIntersectFinal >= runtime) {
				hasStagnantSegment = false;
				behaviorChangeOne = runtime;
			} else {
				hasStagnantSegment = true;
				behaviorChangeOne = maxIntersectInitial;
				behaviorChangeTwo = runtime-maxIntersectFinal;
			}
			break;
		case "Both Bigger":
			if(maxIntersectInitial+maxIntersectFinal >= runtime) {
				hasStagnantSegment = false;
				behaviorChangeOne = (.5*runtime)+((- 1/maxAcceleration)*(nextFinalSpeed-initialSpeed));
			} else {
				hasStagnantSegment = true;
				behaviorChangeOne = maxIntersectInitial;
				behaviorChangeTwo = runtime-maxIntersectFinal;
			}
			break;
		}	
	}
	
	public void perform() {
		curTime = RobotController.getFPGATime();
		showtime = Math.abs(curTime - startTime);
		
		switch(scenario) {
		case "Both Bigger":
			if(hasStagnantSegment) {
				if(showtime <= behaviorChangeOne) {
					robotSpeed = initialSpeed - (maxAcceleration*showtime);
				} else if (showtime <= behaviorChangeTwo) {
					robotSpeed = desiredFinalSpeed;
				} else {
					robotSpeed = desiredFinalSpeed+(maxAcceleration*(showtime-behaviorChangeTwo));
				}
			} else {
				if(showtime <= behaviorChangeOne) {
					robotSpeed = initialSpeed - (maxAcceleration*showtime);
				} else {
					robotSpeed = (initialSpeed-(maxAcceleration*behaviorChangeOne))+(maxAcceleration*(showtime-behaviorChangeOne));
				}
			}
			break;
		case "Bigger then Smaller":
			if(hasStagnantSegment) {
				if(showtime <= behaviorChangeOne) {
					robotSpeed = initialSpeed - (maxAcceleration*showtime);
				} else if (showtime <= behaviorChangeTwo) {
					robotSpeed = desiredFinalSpeed;
				} else {
					robotSpeed = desiredFinalSpeed - (maxAcceleration*(showtime-behaviorChangeTwo));
				}
			} else {
				robotSpeed = initialSpeed - (maxAcceleration*showtime);
			}
			break;
		case "Smaller then Bigger":
			if(hasStagnantSegment) {
				if(showtime <= behaviorChangeOne) {
					robotSpeed = initialSpeed + (maxAcceleration*showtime);
				} else if(showtime <= behaviorChangeTwo) {
					robotSpeed = desiredFinalSpeed;
				} else {
					robotSpeed = desiredFinalSpeed + (maxAcceleration*(showtime-behaviorChangeTwo));
				}
			} else {
				if(showtime <= behaviorChangeOne) {
					robotSpeed = initialSpeed + (maxAcceleration*showtime);
				} else {
					throw new Error("Timeout. Please allot more time for operation to run.");
				}
			}
			break;
		case "Both Smaller":
			if(hasStagnantSegment) {
				if(showtime <= behaviorChangeOne) {
					robotSpeed = initialSpeed + (maxAcceleration*showtime);
				} else if(showtime <= behaviorChangeTwo) {
					robotSpeed = desiredFinalSpeed;
				} else {
					robotSpeed = desiredFinalSpeed - (maxAcceleration*(showtime-behaviorChangeTwo));
				}
			} else {
				if(showtime <= behaviorChangeOne) {
					robotSpeed = initialSpeed + (maxAcceleration*showtime);
				} else {
					robotSpeed = (initialSpeed+(maxAcceleration*behaviorChangeOne))-(maxAcceleration*(showtime-behaviorChangeOne));
				}
			}
			break;
		default:
			Logger.error("Velocity case not found. Running without acceleration or deceleration.");
			scenario="";
			robotSpeed = desiredFinalSpeed;
		}
		
		leftSpeed = robotSpeed;
		rightSpeed = robotSpeed;
		
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
