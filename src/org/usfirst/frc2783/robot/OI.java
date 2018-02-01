package org.usfirst.frc2783.robot;

import org.usfirst.frc2783.commands.autonomous.autoTankDrive;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * 
 * The object interface, used to set all joysticks, buttons, and the such
 *
 */
public class OI {

	public static Joystick driver = new Joystick(Constants.driverID);
	public static JoystickButton d = new JoystickButton(driver, 1);
	
    public OI() {
    	d.whenActive(new autoTankDrive(0.1, 50, 50, "Forward"));
    	
    }

}

