package org.usfirst.frc2783.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * 
 * The object interface, used to set all joysticks, buttons, and the such
 *
 */
public class OI {
	
	public static Joystick controller = new Joystick(0);

//	public static JoystickButton dad = new JoystickButton(controller, 1);
	
    public OI() {
//    	dad.whenActive(new TankDrive());
    	
    }

}

