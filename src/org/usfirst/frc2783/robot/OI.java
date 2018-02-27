package org.usfirst.frc2783.robot;

import org.usfirst.frc2783.commands.ElevatorLockShift;
import org.usfirst.frc2783.commands.ClimbServoShift;
import org.usfirst.frc2783.commands.GoToElevatorPosition;
import org.usfirst.frc2783.commands.ElevatorServoShift;

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
	
	public static JoystickButton elevatorShift = new JoystickButton(manipulator, Constants.kElevatorGearShiftID);
	public static JoystickButton elevatorLockShift = new JoystickButton(manipulator, Constants.kElevatorLockShiftID);
	
	public static JoystickButton elevatorToGround = new JoystickButton(manipulator, Constants.kElevatorToGroundID);
	public static JoystickButton elevatorToSwitch = new JoystickButton(manipulator, Constants.kElevatorToSwitchID);
	public static JoystickButton elevatorToScale = new JoystickButton(manipulator, Constants.kElevatorToScaleID);

    public OI() {
    	
    	elevatorShift.whenPressed(new ElevatorServoShift());
    	elevatorLockShift.whenPressed(new ElevatorLockShift());
    	
    	elevatorToGround.whenPressed(new GoToElevatorPosition(Robot.groundPos));
    	elevatorToSwitch.whenPressed(new GoToElevatorPosition(Robot.switchPos));
    	elevatorToScale.whenPressed(new GoToElevatorPosition(Robot.scalePos));
    	
    }

}