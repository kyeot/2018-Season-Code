package org.usfirst.frc2783.robot;

import org.usfirst.frc2783.commands.ElevatorLockShift;
import org.usfirst.frc2783.commands.ElevatorServoShift;
import org.usfirst.frc2783.commands.FaceDownField;
import org.usfirst.frc2783.commands.FaceDriverStation;
import org.usfirst.frc2783.commands.FaceEast;
import org.usfirst.frc2783.commands.FaceNorthEast;
import org.usfirst.frc2783.commands.FaceNorthWest;
import org.usfirst.frc2783.commands.FaceSouthEast;
import org.usfirst.frc2783.commands.FaceSouthWest;
import org.usfirst.frc2783.commands.FaceWest;
import org.usfirst.frc2783.commands.GoToTopSimple;
import org.usfirst.frc2783.subsystems.Dpad;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;
import edu.wpi.first.wpilibj.command.Command;

/**
 * 
 * The object interface, used to set all joysticks, buttons, and the such
 *
 */
public class OI {
	
	public static Joystick driver = new Joystick(Constants.kDriverControllerId);

	 //Joystick Controls 
//	public static Joystick driver1 = new Joystick(Constants.kDriverControllerId);
//	public static Joystick driver2 = new Joystick(Constants.kDriverControllerId);
	
	public static Joystick manipulator = new Joystick(Constants.kManipulatorControllerId);
	
	public static JoystickButton elevatorShift = new JoystickButton(manipulator, Constants.kElevatorGearShiftID);
	public static JoystickButton elevatorLockShift = new JoystickButton(manipulator, Constants.kElevatorLockShiftID);
	
	public static JoystickButton elevatorUpSimple = new JoystickButton(manipulator, 4);
	
	public static Trigger dPadNorth = new Dpad(0);
	public static Trigger dPadSouth = new Dpad(180);
	public static Trigger dPadEast = new Dpad(90);
	public static Trigger dPadWest = new Dpad(270); 
	public static Trigger dpadNorthWest = new Dpad(315);
	public static Trigger dPadNorthEast = new Dpad(45);
	public static Trigger dPadSouthWest = new Dpad(135);
	public static Trigger dPadSouthEast = new Dpad(225);
	
	 //Driver Rotation Controls
//	public static JoystickButton faceDriverStation = new JoystickButton(driver, Constants.kFaceDriverStation);
//	public static JoystickButton faceDownField = new JoystickButton(driver, Constants.kFaceDownField);
//	public static JoystickButton faceLeft = new JoystickButton(driver, Constants.kFaceLeft);
//	public static JoystickButton faceRight = new JoystickButton(driver, Constants.kFaceRight);
	
	 //Dpad Rotation Controls
//	public static JoystickButton faceNorth = new JoystickButton(driver, Constants.);
//	public static JoystickButton faceSouth = new JoystickButton(driver, Constants.POVdown);
//	public static JoystickButton faceWest = new JoystickButton(driver, Constants.POVleft);
//	public static JoystickButton faceEast = new JoystickButton(driver, Constants.POVright);

//	public static JoystickButton elevatorToGround = new JoystickButton(manipulator, Constants.kElevatorToGroundID);
//	public static JoystickButton elevatorToSwitch = new JoystickButton(manipulator, Constants.kElevatorToSwitchID);
//	public static JoystickButton elevatorToScale = new JoystickButton(manipulator, Constants.kElevatorToScaleID);
	
    public OI() {
    	
    	elevatorShift.whileHeld(new ElevatorServoShift());
    	elevatorLockShift.whenPressed(new ElevatorLockShift());
    	
    	elevatorUpSimple.whenPressed(new GoToTopSimple());
    	
    	dPadNorth.whileActive(new FaceDownField());
    	dPadSouth.whileActive(new FaceDriverStation());
    	dPadEast.whileActive(new FaceEast());
   	    dPadWest.whileActive(new FaceWest());
   	    dPadNorthEast.whileActive(new FaceNorthEast());
    	dpadNorthWest.whileActive(new FaceNorthWest());
    	dPadSouthEast.whileActive(new FaceSouthEast());
   	    dPadSouthWest.whileActive(new FaceSouthWest());
   	    
   	    //Rotation Commands
//   	faceDownField.whileHeld(new FaceDownField());
//    	faceDriverStation.whileHeld(new FaceDriverStation());
//    	faceLeft.whileHeld(new FaceLeft());
//   	faceRight.whileHeld(new FaceRight());
	
//    	elevatorToGround.whenPressed(new GoToElevatorPosition(Robot.groundPos.getRotations(), Robot.groundPos.getDegrees()));
//    	elevatorToSwitch.whenPressed(new GoToElevatorPosition(Robot.switchPos.getRotations(), Robot.switchPos.getDegrees()));
//    	elevatorToScale.whenPressed(new GoToElevatorPosition(Robot.scalePos.getRotations(), Robot.scalePos.getDegrees()));
    	
    }

	public static Command FaceNorth() {
		return null;
	}

}