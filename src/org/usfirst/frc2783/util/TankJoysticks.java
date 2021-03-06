package org.usfirst.frc2783.util;

import org.usfirst.frc2783.robot.Constants;

import edu.wpi.first.wpilibj.Joystick;

public class TankJoysticks {
	
	private static TankJoysticks instance = new TankJoysticks();

	Joystick left = new Joystick(Constants.kJoyTankLeftID);
	Joystick right = new Joystick(Constants.kJoyTankRightID);
	
	public static TankJoysticks getInstance(){
		return instance;
	}

	
/**
 * 0 -> 2 = 0 -> 2 on left Joystick, 10 -> 12 = 0 -> 2 on right Joystick
 */
	public double getRawAxis(int id){
		
		double ret;
		
		switch(id){
			case 0:
				ret = left.getRawAxis(0);
				break;
			case 1:
				ret = left.getRawAxis(1);
				break;
			case 2:
				ret = left.getRawAxis(2);
				break;
			case 3:
				ret = right.getRawAxis(10);
				break;
			case 4:
				ret = right.getRawAxis(11);
				break;
			case 5:
				ret = right.getRawAxis(12);
				break;
			default:
				ret = 0;
				break;
		}
		
		return ret;
		
	}
	
/**
 * 0 -> 9 = 0 -> 9 on the left Joystick, 10 -> 19 = 0 -> 9 on the right Joystick
 */
	public boolean getRawButton(int id){
		
		boolean ret;
		
		switch(id){
			case 0:
				ret = left.getRawButton(0);
				break;
			case 1:
				ret = left.getRawButton(1);
				break;
			case 2:
				ret = left.getRawButton(2);
				break;
			case 3:
				ret = left.getRawButton(3);
				break;
			case 4:
				ret = left.getRawButton(4);
				break;
			case 5:
				ret = left.getRawButton(5);
				break;
			case 6:
				ret = left.getRawButton(6);
				break;
			case 7:
				ret = left.getRawButton(7);
				break;
			case 8:
				ret = left.getRawButton(8);
				break;
			case 9:
				ret = left.getRawButton(9);
				break;
			case 10:
				ret = right.getRawButton(0);
				break;
			case 11:
				ret = right.getRawButton(1);
				break;
			case 12:
				ret = right.getRawButton(2);
				break;
			case 13:
				ret = right.getRawButton(3);
				break;
			case 14:
				ret = right.getRawButton(4);
				break;
			case 15:
				ret = right.getRawButton(5);
				break;
			case 16:
				ret = right.getRawButton(6);
				break;
			case 17:
				ret = right.getRawButton(7);
				break;
			case 18:
				ret = right.getRawButton(8);
				break;
			case 19:
				ret = right.getRawButton(9);
				break;
			default:
				ret = false;
				break;
		}
		
		return ret;
		
	}
	
	
}
