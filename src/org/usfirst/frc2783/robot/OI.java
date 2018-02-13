package org.usfirst.frc2783.robot;

import org.usfirst.frc2783.commands.autonomous.TestAuto;
import org.usfirst.frc2783.commands.autonomous.actions.DriveByDistance;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * 
 * The object interface, used to set all joysticks, buttons, and the such
 *
 */
public class OI {

	public static Joystick driver = new Joystick(Constants.kDriverControllerId);
	public static Joystick manipulator = new Joystick(Constants.kManipulatorControllerId);
	
	public static JoystickButton test = new JoystickButton(driver, 1);
	
	public static Joystick leftJoy = new Joystick(3);
	public static Joystick rightJoy = new Joystick(4);
	
    public OI() {
    	
    }

}

