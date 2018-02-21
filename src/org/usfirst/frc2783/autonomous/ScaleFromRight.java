package org.usfirst.frc2783.autonomous;

import org.usfirst.frc2783.autonomous.actions.ActionGroup;
import org.usfirst.frc2783.autonomous.actions.AutoElevator;
import org.usfirst.frc2783.autonomous.actions.AutoIntake;
import org.usfirst.frc2783.autonomous.actions.DriveWithGyroAndByDistance;
import org.usfirst.frc2783.autonomous.actions.RotateTankAction;
import org.usfirst.frc2783.util.Bearing;

public class ScaleFromRight extends ActionGroup implements autoAutonomousInterface{

	public ScaleFromRight(){
		super();
		
	}

	@Override
	public void bothLeft() {
		addAction(new AutoElevator(-0.5, 0.5));
		addAction(new DriveWithGyroAndByDistance(0.5, 24*12, 24*12));
		addAction(new RotateTankAction(new Bearing(90), 4));
		addAction(new DriveWithGyroAndByDistance(0.5, 36, 36));
		addAction(new AutoElevator(-1, 2.5));
		addAction(new AutoIntake(1, 1));

		
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
		addAction(new RotateTankAction(new Bearing(90), 3));
		addAction(new DriveWithGyroAndByDistance(0.5, 17*12, 17*12));
		addAction(new RotateTankAction(new Bearing(0), 3));
		addAction(new DriveWithGyroAndByDistance(0.5, 24, 24));
		addAction(new AutoElevator(-1, 1));
		addAction(new AutoIntake(0.75, 1));
		
	}

	@Override
	public void driveForward() {
		addAction(new DriveWithGyroAndByDistance(0.5, 12*12, 12*12));
		
	}
	
}