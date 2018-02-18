package org.usfirst.frc2783.loops;

import org.usfirst.frc2783.util.Logger;

import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class PowerLoop implements Loop{

	@Override
	public void onStart() {
		SmartDashboard.putString("DB/String 0", "going");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onLoop() {
		if(RobotController.getInputVoltage() < 9){
	        Logger.info("Your voltage is " + RobotController.getInputVoltage());	
		}
	}

	@Override
	public void onStop() {
		// TODO Auto-generated method stub
		
	}

}
