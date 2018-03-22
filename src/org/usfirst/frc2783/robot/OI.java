package org.usfirst.frc2783.robot;

import org.usfirst.frc2783.commands.ElevatorLockShift;
import org.usfirst.frc2783.commands.ElevatorServoShift;
import org.usfirst.frc2783.commands.FaceDownField;
import org.usfirst.frc2783.commands.FaceDriverStation;
import org.usfirst.frc2783.commands.FaceEast;
import org.usfirst.frc2783.commands.FaceLeft;
import org.usfirst.frc2783.commands.FaceNorth;
import org.usfirst.frc2783.commands.FaceNorthEast;
import org.usfirst.frc2783.commands.FaceNorthWest;
import org.usfirst.frc2783.commands.FaceRight;
import org.usfirst.frc2783.commands.FaceSouth;
import org.usfirst.frc2783.commands.FaceSouthEast;
import org.usfirst.frc2783.commands.FaceSouthWest;
import org.usfirst.frc2783.commands.FaceWest;
import org.usfirst.frc2783.commands.GoToTopSimple;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
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
	
	public static JoystickButton faceDriverStation = new JoystickButton(driver, Constants.kFaceDriverStation);
	public static JoystickButton faceDownField = new JoystickButton(driver, Constants.kFaceDownField);
	public static JoystickButton faceLeft = new JoystickButton(driver, Constants.kFaceLeft);
	public static JoystickButton faceRight = new JoystickButton(driver, Constants.kFaceRight);
	
/*	public static Joystick dpad = new Joystick(3);
	public static Button button1 = new JoystickButton(dpad, 1),
						button2 = new JoystickButton(dpad, 2),
						button3 = new JoystickButton(dpad, 3),
						button4 = new JoystickButton(dpad, 4),
						button5 = new JoystickButton(dpad, 5),
						button6 = new JoystickButton(dpad, 6),
						button7 = new JoystickButton(dpad, 7),
						button8 = new JoystickButton(dpad, 8);
	
*/	


//	public static JoystickButton elevatorToGround = new JoystickButton(manipulator, Constants.kElevatorToGroundID);
//	public static JoystickButton elevatorToSwitch = new JoystickButton(manipulator, Constants.kElevatorToSwitchID);
//	public static JoystickButton elevatorToScale = new JoystickButton(manipulator, Constants.kElevatorToScaleID);

    public OI() {
    	
    	elevatorShift.whileHeld(new ElevatorServoShift());
    	elevatorLockShift.whenPressed(new ElevatorLockShift());
    	
    	elevatorUpSimple.whenPressed(new GoToTopSimple());
    	
    	faceDownField.whileHeld(new FaceDownField());
    	faceDriverStation.whileHeld(new FaceDriverStation());
    	faceLeft.whileHeld(new FaceLeft());
    	faceRight.whileHeld(new FaceRight());
   
/*    	button1.whileHeld(new FaceNorth());
		button2.whileHeld(new FaceNorthEast());
		button3.whileHeld(new FaceEast());
		button4.whileHeld(new FaceSouthEast());
		button5.whileHeld(new FaceSouth());
		button6.whileHeld(new FaceSouthWest());
		button7.whileHeld(new FaceWest());
		button8.whileHeld(new FaceNorthWest());
*/	
    	
//    	elevatorToGround.whenPressed(new GoToElevatorPosition(Robot.groundPos.getRotations(), Robot.groundPos.getDegrees()));
//    	elevatorToSwitch.whenPressed(new GoToElevatorPosition(Robot.switchPos.getRotations(), Robot.switchPos.getDegrees()));
//    	elevatorToScale.whenPressed(new GoToElevatorPosition(Robot.scalePos.getRotations(), Robot.scalePos.getDegrees()));

    	
    }

}