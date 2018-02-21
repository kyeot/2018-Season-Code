package org.usfirst.frc2783.autonomous;

import org.usfirst.frc2783.autonomous.actions.ActionGroup;
import org.usfirst.frc2783.autonomous.actions.AutoElevator;
import org.usfirst.frc2783.autonomous.actions.AutoIntake;
import org.usfirst.frc2783.autonomous.actions.DriveWithGyroAndByDistance;
import org.usfirst.frc2783.autonomous.actions.RotateTankAction;
import org.usfirst.frc2783.util.Bearing;

public class SwitchFromRight extends ActionGroup implements autoAutonomousInterface{
	
	public SwitchFromRight() {
		super();
				
	}

	@Override
	public void bothLeft() {
		addAction(new DriveWithGyroAndByDistance(0.5, 120, 120));
		addAction(new RotateTankAction(new Bearing(90), 3));
		addAction(new AutoElevator(-1, 1));
		addAction(new DriveWithGyroAndByDistance(0.5, 5*12, 5*12));
		addAction(new AutoIntake(0.75, 1));
		
	}

	@Override
	public void scaleLeftSwitchRight() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void scaleRightSwitchLeft() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void bothRight() {

		addAction(new DriveWithGyroAndByDistance(0.5, 17*12, 17*12));
		addAction(new RotateTankAction(new Bearing(270), 3));
		addAction(new DriveWithGyroAndByDistance(0.5, 15*12, 15*12));
		addAction(new RotateTankAction(new Bearing(180), 3));
		addAction(new AutoElevator(-1, 1));
		addAction(new AutoIntake(0.75, 1));
		
	}

	@Override
	public void driveForward() {
		addAction(new DriveWithGyroAndByDistance(0.5, 12*12, 12*12));
		
	}
	
}