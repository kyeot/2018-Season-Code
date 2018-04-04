package org.usfirst.frc2783.subsystems;

import org.usfirst.frc2783.robot.OI;

import edu.wpi.first.wpilibj.buttons.Trigger;

public class Dpad extends Trigger {

	int angle;
	
	public Dpad (int angle){  
		this.angle = angle;
	}
	
	@Override
	public boolean get() {
		// TODO Auto-generated method stub
		return OI.driver.getPOV() == angle;
		
		
	}

}
