package org.usfirst.frc2783.robot;

import edu.wpi.first.wpilibj.Joystick;

/**
 * 
 * The object interface, used to set all joysticks, buttons, and the such
 *
 */
public class OI {
	
	public static Joystick driver = new Joystick(0);
	public static Joystick manipulator = new Joystick(1);

    public OI() {
   

}

}