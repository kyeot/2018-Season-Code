package org.usfirst.frc2783.robot;

import org.usfirst.frc2783.commands.ClimbHold;
import org.usfirst.frc2783.commands.ClimbServoShift;
import org.usfirst.frc2783.commands.ServoShift;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * 
 * The object interface, used to set all joysticks, buttons, and the such
 *
 */
public class OI {
	
	public static Joystick driver = new Joystick(Constants.kDriverControllerId);
//	public static Joystick driver1 = new Joystick(Constants.kDriverControllerId);
//	public static Joystick driver2 = new Joystick(Constants.kDriverControllerId);
	public static Joystick manipulator = new Joystick(Constants.kManipulatorControllerId);
	
	public static JoystickButton elevatorShifter = new JoystickButton(manipulator, Constants.kGearShiftID);
	public static JoystickButton climberShifter = new JoystickButton(manipulator, Constants.kDeployClimbID);
	
	public static JoystickButton switchBrake = new JoystickButton(manipulator, 1);

    public OI() {
    	
    	elevatorShifter.whileHeld(new ServoShift());
    	climberShifter.whileHeld(new ClimbServoShift());
    	
    	switchBrake.whenPressed(new ClimbHold());

    }

}