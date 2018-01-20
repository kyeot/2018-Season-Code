package org.usfirst.frc2783.util;

import org.usfirst.frc2783.robot.Robot;

import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;

public class AbsoluteEncoderSource implements PIDSource {
	
	String side;
	
	public AbsoluteEncoderSource(String side){
		this.side = side;
		
	}

	@Override
	public void setPIDSourceType(PIDSourceType pidSource) {
		
	}

	@Override
	public PIDSourceType getPIDSourceType() {
		return null;
		
	}

	@Override
	public double pidGet() {
		if(side == "left"){
			return Robot.leftAbsEnc.getValue();
		}
		else{
			return Robot.rightAbsEnc.getValue();
		}
			
	}

}
