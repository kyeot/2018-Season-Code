package org.usfirst.frc2783.loops;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.usfirst.frc2783.robot.RobotState;

public class RobotTrackerBridge implements Loop {
	
	RobotState robotPosition = RobotState.getInstance();
	JSONObject timeTable = new JSONObject();
	
	@SuppressWarnings("unchecked")
	@Override
	public void onStart(double timestamp) {
		try {
			timeTable.put(robotPosition.getLatestFieldToVehicle().getKey(), robotPosition.getLatestFieldToVehicle().getValue());
		} catch (NullPointerException e) {
			timeTable.put(0, 0);
		}
	}

	@Override
	public void onStop(double timestamp) {
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public void onLoop(double timestamp) {
		timeTable.put(robotPosition.getLatestFieldToVehicle().getKey(), robotPosition.getLatestFieldToVehicle().getValue());
		try (FileWriter file = new FileWriter("robotCoords.json")) {
			file.write(timeTable.toString());
			file.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
