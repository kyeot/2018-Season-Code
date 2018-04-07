package org.usfirst.frc2783.loops;

import org.usfirst.frc2783.util.EventLogger;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Simple loop that runs the events of EventLogger
 * 
 * @author 2783
 */
public class LogData implements Loop{
	
	
	EventLogger gyroHandler = new EventLogger("Reset GYRO", "WARN") {
		@Override
		public boolean event() {
			return RobotController.isBrownedOut();
		}
	};
	
	EventLogger batteryHandler = new EventLogger("Battery Browned Out!", "WARN") {
		@Override
		public boolean event() {
			return RobotController.isBrownedOut();
		}
	};
	
	EventLogger dcHandler = new EventLogger("The Driver Station is Disconnected!", "WARN") {
		boolean lastState;
		boolean state;
		
		@Override
		public boolean event() {
			state = (lastState != DriverStation.getInstance().isDSAttached()) && (lastState);
			lastState = DriverStation.getInstance().isDSAttached();
		
			return state;
		}
	};
	
	EventLogger recHandler = new EventLogger("The Driver Station is Reconnected!", "INFO") {
		boolean lastState;
		boolean state;
		
		@Override
		public boolean event() {
			state = (lastState != DriverStation.getInstance().isDSAttached()) && (!lastState);
			lastState = DriverStation.getInstance().isDSAttached();
			
			return state;
		}
	};

	@Override
	public void onStart() {
		
	}

	@Override
	public void onLoop() {
		batteryHandler.handleEvent();
		dcHandler.handleEvent();
		recHandler.handleEvent();
		
	}

	@Override
	public void onStop() {
		
	}

	@Override
	public void onLoop(double timestamp) {
		// TODO Auto-generated method stub
		
	}

}
