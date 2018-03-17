package org.usfirst.frc2783.autonomous.paths;

import org.usfirst.frc2783.autonomous.paths.PathBuilder.Setpoint;
import org.usfirst.frc2783.util.Logger;
import org.usfirst.frc2783.util.Scenarios;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.RobotController;

public class PathVelocity {
	double distance;
	double vi;
	double vp;
	double vf;
	
	double vivpint;
	double vpvfint;
	
	double spareDist;
	double potentialvp;
	
	double changeOne;
	double changeTwo;
	
	boolean hasStagnantSegment;
	public Scenarios scenario;
	
	public double startTime;
	public double runtime;
	
	double maxAccel = .5;
	
	public PathVelocity(double distance, double vi, double vp, double vf) {
		this.distance = distance;
		this.vi = percentToVelocity(vi);
		this.vp = percentToVelocity(vp);
		this.vf = percentToVelocity(vf);
		
		startTime = RobotController.getFPGATime();
		
		init();
//		PIDController test = new PIDController(5, 6, 7, 8);
	}
	
	public PathVelocity(double xone, double yone, double xtwo, double ytwo, double vi, double vp, double vf) {
		//Only for linear functions
		distance = dist(xone, yone, xtwo, ytwo);
		this.vi = percentToVelocity(vi);
		this.vp = percentToVelocity(vp);
		this.vf = percentToVelocity(vf);
		
		startTime = RobotController.getFPGATime();
		
		init();
	}
	
	public PathVelocity(Setpoint sOne, Setpoint sTwo, double vi, double vp, double vf) {
		double xone = sOne.getPosition().x();
		double yone = sOne.getPosition().y();
		double xtwo = sTwo.getPosition().x();
		double ytwo = sTwo.getPosition().y();
		
		distance = dist(xone, yone, xtwo, ytwo);
		this.vi = percentToVelocity(vi);
		this.vp = percentToVelocity(vp);
		this.vf = percentToVelocity(vf);
		
		startTime = RobotController.getFPGATime();
		
		init();
	}
	
	public void init() {
		compareSpeeds();
		calculateRuntime();
		calculateBehaviorChanges();
	}
	
	public double percentToVelocity(double value) {
		return value * 132;
	}
	

	public double velocityToPercent(double value) {
		return value / 132;
	}
	
	public void compareSpeeds() {
		if (vi >= vp) {
			scenario = vf > vp ? Scenarios.BOTH_GREATER : Scenarios.GREATER_THEN_LESSER;
		} else {
			scenario = vf > vp ? Scenarios.LESSER_THEN_GREATER : Scenarios.BOTH_LESSER;
		}
	}
	
	public void calculateRuntime() {
		switch(scenario) {
		case BOTH_GREATER:
			if(Math.abs((square(vf) - square(vi)) / (2 * maxAccel)) < distance) {
				spareDist = distance - Math.abs((square(vf) - square(vi)) / (2 * maxAccel));
				if(vi < vf) {
					potentialvp = Math.sqrt(square(vi) - (maxAccel * spareDist));
				} else {
					potentialvp = Math.sqrt(square(vf) - (maxAccel * spareDist));
				}
				runtime = ((vi - potentialvp) / maxAccel) + ((vf - potentialvp) / maxAccel);
				vp = potentialvp > vp ? potentialvp : vp;
			} else if(Math.abs((square(vf) - square(vi)) / (2 * maxAccel)) == distance) {
				runtime = Math.abs((vf - vi) / maxAccel);
			} else {
				Logger.error("Cannot achieve desired velocity. Accelerating as much as possible.");
				if (vf > vi) {
					vf = Math.sqrt(square(vi) + (2 * maxAccel * distance));
				} else {
					vf = Math.sqrt(square(vi) - (2 * maxAccel * distance));
				}
				runtime = Math.abs((vf - vi)) / maxAccel;
			}
		case LESSER_THEN_GREATER:
			if(Math.abs((square(vf) - square(vi)) / (2 * maxAccel)) < distance) {
				spareDist = distance - Math.abs((square(vf) - square(vi)) / (2 * maxAccel));
				runtime = ((vf - vi) / maxAccel) + (spareDist / vp);
			} else if(Math.abs((square(vf) - square(vi)) / (2 * maxAccel)) == distance) {
				runtime = (vf - vi) / maxAccel;
			} else {
				Logger.error("Cannot achieve desired velocity. Accelerating as much as possible.");
				vf = Math.sqrt(square(vi) + (2 * maxAccel * distance));
				runtime = (vf - vi) / maxAccel;
			}
		case GREATER_THEN_LESSER:
			if(Math.abs((square(vf) - square(vi)) / (2 * maxAccel)) < distance) {
				spareDist = distance - Math.abs((square(vf) - square(vi)) / (2 * maxAccel));
				runtime = ((vi - vf) / maxAccel) + (spareDist / vp);
			} else if(Math.abs((square(vf) - square(vi)) / (2 * maxAccel)) == distance) {
				runtime = (vi - vf) / maxAccel;
			} else {
				Logger.error("Cannot achieve desired velocity. Accelerating as much as possible.");
				vf = Math.sqrt(square(vi) - (2 * maxAccel * distance));
				runtime = (vi - vf) / maxAccel;
			}
		case BOTH_LESSER:
			if(Math.abs((square(vf) - square(vi)) / (2 * maxAccel)) < distance) {
				spareDist = distance - Math.abs((square(vf) - square(vi)) / (2 * maxAccel));
				if(vi < vf) {
					potentialvp = Math.sqrt(square(vi) + (maxAccel * spareDist));
				} else {
					potentialvp = Math.sqrt(square(vf) + (maxAccel * spareDist));
				}
				runtime = ((potentialvp - vi) / maxAccel) + ((potentialvp - vf) / maxAccel);
				vp = potentialvp < vp ? potentialvp : vp;
			} else if(Math.abs((square(vf) - square(vi)) / (2 * maxAccel)) == distance) {
				runtime = Math.abs((vf - vi) / maxAccel);
			} else {
				Logger.error("Cannot achieve desired velocity. Accelerating as much as possible.");
				if (vf > vi) {
					vf = Math.sqrt(square(vi) + (2 * maxAccel * distance));
				} else {
					vf = Math.sqrt(square(vi) - (2 * maxAccel * distance));
				}
				runtime = Math.abs((vf - vi)) / maxAccel;
			}
		}
	}
	
	
	//General Functions
	public double dist(double xone, double yone, double xtwo, double ytwo) {
		return Math.sqrt(square(ytwo - yone) + square(xtwo - xone));
	}
	
	public double square(double value) {
		return value*value;
	}
	
	
	public void calculateBehaviorChanges() {
		vivpint = Math.abs((vp - vi) / maxAccel);
		vpvfint = Math.abs((vf - vp) / (maxAccel));

		switch (scenario) {
		case BOTH_LESSER:
			if (vivpint + vpvfint >= runtime) {
				hasStagnantSegment = false;
				changeOne = (.5 * runtime) + ((1 / maxAccel) * (vf - vi));
			} else {
				hasStagnantSegment = true;
				changeOne = vivpint;
				changeTwo = runtime - vpvfint;
			}
			break;
		case GREATER_THEN_LESSER:
			if (vivpint + vpvfint > runtime) {
				throw new Error("Impossible deceleration. Please lower your input.");
			} else if (vivpint + vpvfint == runtime) {
				hasStagnantSegment = false;
				changeOne = runtime;
			} else {
				hasStagnantSegment = true;
				changeOne = vivpint;
				changeTwo = runtime - vpvfint;
			}
			break;
		case LESSER_THEN_GREATER:
			if (vivpint + vpvfint >= runtime) {
				hasStagnantSegment = false;
				changeOne = runtime;
			} else {
				hasStagnantSegment = true;
				changeOne = vivpint;
				changeTwo = runtime - vpvfint;
			}
			break;
		case BOTH_GREATER:
			if (vivpint + vpvfint >= runtime) {
				hasStagnantSegment = false;
				changeOne = (.5 * runtime) + ((-1 / maxAccel) * (vf - vi));
			} else {
				hasStagnantSegment = true;
				changeOne = vivpint;
				changeTwo = runtime - vpvfint;
			}
			break;
		}
	}
	
	public static double seconds(double ms) {
		return ms / 1000000;
	}
	
	public double getOutput(double curTime) {
		double showtime = seconds(curTime - startTime);
		switch (scenario) {
		case BOTH_GREATER:
			if (hasStagnantSegment) {
				if (showtime <= changeOne) {
					return velocityToPercent(vi - (maxAccel * showtime));
				} else if (showtime <= changeTwo) {
					return velocityToPercent(vp);
				} else {
					return velocityToPercent(vp + (maxAccel * (showtime - changeTwo)));
				}
			} else {
				if (showtime <= changeOne) {
					return velocityToPercent(vi - (maxAccel * showtime));
				} else {
					return velocityToPercent((vi - (maxAccel * changeOne))
							+ (maxAccel * (showtime - changeOne)));
				}
			}
		case GREATER_THEN_LESSER:
			if (hasStagnantSegment) {
				if (showtime <= changeOne) {
					return velocityToPercent(vi - (maxAccel * showtime));
				} else if (showtime <= changeTwo) {
					return velocityToPercent(vp);
				} else {
					return velocityToPercent(vp - (maxAccel * (showtime - changeTwo)));
				}
			} else {
				return velocityToPercent(vi - (maxAccel * showtime));
			}
		case LESSER_THEN_GREATER:
			if (hasStagnantSegment) {
				if (showtime <= changeOne) {
					return velocityToPercent(vi + (maxAccel * showtime));
				} else if (showtime <= changeTwo) {
					return velocityToPercent(vp);
				} else {
					return velocityToPercent(vp + (maxAccel * (showtime - changeTwo)));
				}
			} else {
				if (showtime <= changeOne) {
					return velocityToPercent(vi + (maxAccel * showtime));
				} else {
					throw new Error("Timeout. Please allot more time for operation to run.");
				}
			}
		case BOTH_LESSER:
			if (hasStagnantSegment) {
				if (showtime <= changeOne) {
					return velocityToPercent(vi + (maxAccel * showtime));
				} else if (showtime <= changeTwo) {
					return velocityToPercent(vp);
				} else {
					return velocityToPercent(vp - (maxAccel * (showtime - changeTwo)));
				}
			} else {
				if (showtime <= changeOne) {
					return velocityToPercent(vi + (maxAccel * showtime));
				} else {
					return velocityToPercent((vi + (maxAccel * changeOne))
							- (maxAccel * (showtime - changeOne)));
				}
			}
		default:
			Logger.error("Velocity case not found. Running without acceleration or deceleration.");
			scenario = null;
			return velocityToPercent(vp);
		}
	}
}
