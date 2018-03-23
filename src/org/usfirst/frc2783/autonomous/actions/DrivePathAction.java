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
        Robot.tankDrive.setLeftMPPose(Robot.leftPos.position);
        Robot.tankDrive.setRightMPPose(Robot.rightPos.position);
    }

    @Override
    public void finish() {
        // TODO: Perhaps set wheel velocity to 0?
    }

    @Override
    public void start() {
    	Robot.tankDrive.leftMPController.enable();
    	Robot.tankDrive.rightMPController.enable();
        mDrive.setWantDrivePath(mPath, mPathContainer.isReversed());
        //SmartDashboard.putString("DB/String 1", "sawdfghj,k");
//        TankDriveBase.leftV = 0;
    }
    
}