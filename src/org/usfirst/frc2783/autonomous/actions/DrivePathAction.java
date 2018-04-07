package org.usfirst.frc2783.autonomous.actions;

import org.usfirst.frc2783.autonomous.paths.Path;
import org.usfirst.frc2783.autonomous.paths.PathContainer;
import org.usfirst.frc2783.robot.Robot;
import org.usfirst.frc2783.subsystems.TankDriveBase;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DrivePathAction extends Action {
	
	private PathContainer mPathContainer;
    private Path mPath;
    private TankDriveBase mDrive = Robot.tankDrive;

    public DrivePathAction(PathContainer p, String name) {
        super(name);
    	
    	mPathContainer = p;
        mPath = mPathContainer.buildPath();
    }

    @Override
    public boolean done() {
        return mDrive.isDoneWithPath();
    }

    @Override
    public void perform() {
        // Nothing done here, controller updates in mEnabedLooper in robot
    }

    @Override
    public void finish() {
        // TODO: Perhaps set wheel velocity to 0?
    }

    @Override
    public void start() {
        mDrive.setWantDrivePath(mPath, mPathContainer.isReversed());
        //SmartDashboard.putString("DB/String 1", "sawdfghj,k");
    }
    
}