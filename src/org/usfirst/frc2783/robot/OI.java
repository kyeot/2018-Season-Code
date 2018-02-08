package org.usfirst.frc2783.robot;

import org.usfirst.frc2783.commands.ServoShift;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * 
 * The object interface, used to set all joysticks, buttons, and the such
 *
 */
public class OI {
	
	//adds controllers
	public static Joystick driver = new Joystick(Constants.kDriverControllerId);
	public static Joystick manipulator = new Joystick(Constants.kManipulatorControllerId);
	
	public static JoystickButton lowGear = new JoystickButton(manipulator, Constants.kLowGearID);
	public static JoystickButton highGear = new JoystickButton(manipulator, Constants.kHighGearID);

    public OI() {
    	
    	lowGear.whileHeld(new ServoShift());
    	highGear.whileHeld(new ServoShift());

    }

}