package org.usfirst.frc2783.autonomous.actions;

import org.usfirst.frc2783.robot.Robot;
import org.usfirst.frc2783.subsystems.TankDriveBase;

/**
 * Waits for the robot to pass by a provided path marker (i.e. a waypoint on the field). This action routinely compares
 * to the crossed path markers provided by the drivetrain (in Path Control mode) and returns if the parameter path
 * marker is inside the drivetrain's Path Markers Crossed list
 * 
 * @param A
 *            Path Marker to determine if crossed
 */
public class WaitForPathMarkerAction extends Action {

    private TankDriveBase mDrive = Robot.tankDrive;
    private String mMarker;

    public WaitForPathMarkerAction(String marker) {
    	super("Wait For Path Marker");
        mMarker = marker;
    }

    @Override
    public void finish() {
    }

    @Override
    public void perform() {
    }

    @Override
    public boolean done() {
    	
    	return mDrive.hasPassedMarker(mMarker);
    	
    }

    @Override
    public void start() {
    }

}