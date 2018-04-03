package org.usfirst.frc2783.autonomous.actions;

import java.util.ArrayList;

import org.usfirst.frc2783.autonomous.paths.Path;
import org.usfirst.frc2783.autonomous.paths.PathContainer;
import org.usfirst.frc2783.autonomous.paths.PathSegment;
import org.usfirst.frc2783.robot.Robot;
import org.usfirst.frc2783.subsystems.TankDriveBase;

public class DrivePathAction extends Action {
	
	private PathContainer mPathContainer; //It is important to remember that a path container is a set of waypoints
    private Path mPath;
    private TankDriveBase mDrive = Robot.tankDrive;

    public DrivePathAction(PathContainer p) {
        super("Following Path " + p.toString());
    	
    	mPathContainer = p;
        mPath = mPathContainer.buildPath();
        
    }

    @Override
    public boolean done() {
    	return mDrive.isDoneWithPath();
    }

    @Override
    public void perform() {
    	
    }

    @Override
    public void finish() {
        // TODO: Perhaps set wheel velocity to 0?
    }

    @Override
    public void start() {
    	mDrive.setWantDrivePath(mPath, mPathContainer.isReversed());
    }
    
}