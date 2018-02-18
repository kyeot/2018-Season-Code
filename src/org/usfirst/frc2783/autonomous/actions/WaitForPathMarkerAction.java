package org.usfirst.frc2783.autonomous.actions;

import org.usfirst.frc2783.subsystems.TankDriveBase;
import org.usfirst.frc2783.autonomous.actions.Action;
import org.usfirst.frc2783.robot.Robot;

/**
 * Waits for the robot to pass by a provided path marker (i.e. a waypoint on the field). This action routinely compares
 * to the crossed path markers provided by the drivetrain (in Path Control mode) and returns if the parameter path
 * marker is inside the drivetrain's Path Markers Crossed list
 * 
 * @param A
 *            Path Marker to determine if crossed
 */
public class WaitForPathMarkerAction extends Action {

    private String mMarker;

    public WaitForPathMarkerAction(String marker) {
    	super("Wait for path marker action");
        mMarker = marker;
    }

    @Override
    public void start() {
    }

    @Override
    public boolean done() {
        return Robot.tankDriveBase.hasPassedMarker(mMarker);
    }

    @Override
    public void perform() {
    }

    @Override
    public void finish() {
    }

}