package org.usfirst.frc2783.util;

import org.usfirst.frc2783.subystems.TankDriveBase;

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
			return TankDriveBase.leftSide1.getSelectedSensorPosition(0)/11.37777777777778;
		}
		else{
			return TankDriveBase.rightSide1.getSelectedSensorPosition(0)/11.37777777777778;
		}
			
	}

}
