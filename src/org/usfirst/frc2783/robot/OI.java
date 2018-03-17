package org.usfirst.frc2783.robot;

import org.usfirst.frc2783.commands.ElevatorLockShift;
import org.usfirst.frc2783.commands.ElevatorServoShift;
import org.usfirst.frc2783.commands.FaceDownField;
import org.usfirst.frc2783.commands.FaceDriverStation;
import org.usfirst.frc2783.commands.GoToTopSimple;

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
	
	public static JoystickButton elevatorUpSimple = new JoystickButton(manipulator, 4);
	
//	public static JoystickButton skrtLeft = new JoystickButton(driver, 3);
//	public static JoystickButton skrtRight = new JoystickButton(driver, 2);

	public static JoystickButton faceDriverStation = new JoystickButton(driver, Constants.kFaceDriverStation);
	public static JoystickButton faceDownField = new JoystickButton(driver, Constants.kFaceDownField);

	//	public static JoystickButton elevatorToGround = new JoystickButton(manipulator, Constants.kElevatorToGroundID);
//	public static JoystickButton elevatorToSwitch = new JoystickButton(manipulator, Constants.kElevatorToSwitchID);
//	public static JoystickButton elevatorToScale = new JoystickButton(manipulator, Constants.kElevatorToScaleID);

    public OI() {
    	
    	elevatorShift.whileHeld(new ElevatorServoShift());
    	elevatorLockShift.whenPressed(new ElevatorLockShift());
    	
    	elevatorUpSimple.whenPressed(new GoToTopSimple());
    	
    	faceDriverStation.whileHeld(new FaceDownField());
    	faceDownField.whileHeld(new FaceDriverStation());
    	
//    	elevatorToGround.whenPressed(new GoToElevatorPosition(Robot.groundPos.getRotations(), Robot.groundPos.getDegrees()));
//    	elevatorToSwitch.whenPressed(new GoToElevatorPosition(Robot.switchPos.getRotations(), Robot.switchPos.getDegrees()));
//    	elevatorToScale.whenPressed(new GoToElevatorPosition(Robot.scalePos.getRotations(), Robot.scalePos.getDegrees()));
    	
    }

}