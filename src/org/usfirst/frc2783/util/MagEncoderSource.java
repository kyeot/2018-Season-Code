package org.usfirst.frc2783.util;

import org.usfirst.frc2783.robot.Robot;

import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;

public class MagEncoderSource implements PIDSource {
	
	String side;
	
	public MagEncoderSource(String side){
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
			return Robot.tankDriveBase.leftSide1.getSelectedSensorPosition(0)/11.37777777777778;
		}
		else{
			return Robot.tankDriveBase.rightSide1.getSelectedSensorPosition(0)/11.37777777777778;
		}
			
	}

}
