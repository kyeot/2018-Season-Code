package org.usfirst.frc2783.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * 
 * The object interface, used to set all joysticks, buttons, and the such
 *
 */
public class OI {

	public static Joystick driver = new Joystick(Constants.driverID);
	public static Joystick manipulator = new Joystick(Constants.manipulatorID);
	
	public static Joystick leftJoy = new Joystick(3);
	public static Joystick rightJoy = new Joystick(4);

    public OI() {

    }

}