package org.usfirst.frc2783.util;

import org.usfirst.frc2783.robot.Constants;
import org.usfirst.frc2783.robot.Robot;

public class Conversion {
	
	@SuppressWarnings("unused")
	private static double inchesPerSecondToRpm(double inches_per_second) {
		return inchesToRotations(inches_per_second) * 60;
	}

	public static double inchesToRotations(double inches) {
		return inches / (Constants.kWheelDiameterByInches * Math.PI);
	}

	public static double rotationsToInches(double rotations) {
        return rotations * (Constants.kWheelDiameterByInches * Math.PI);
    }

    public static double rpmToInchesPerSecond(double rpm) {
        return rotationsToInches(rpm) / 60;
    }

    public static double outputPercentToVelocity(double outputPercent) {
    	return outputPercent * Constants.kMaxSpeed;
    }
}
