package org.usfirst.frc2783.loops;

import org.usfirst.frc2783.util.Logger;

import edu.wpi.first.wpilibj.RobotController;

public class VoltageLogger implements Loop{

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onLoop() {
		// TODO Auto-generated method stub
		Logger.info("Your voltage is: " + RobotController.getInputVoltage());
		
	}

	@Override
	public void onStop() {
		// TODO Auto-generated method stub
		
	}

}
