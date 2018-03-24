package org.usfirst.frc2783.autonomous.actions;

import java.util.ArrayList;

import org.usfirst.frc2783.autonomous.paths.Path;
import org.usfirst.frc2783.autonomous.paths.PathContainer;
import org.usfirst.frc2783.autonomous.paths.PathSegment;
import org.usfirst.frc2783.robot.Robot;

public class DrivePathAction extends Action {
	
	private PathContainer mPathContainer; //It is important to remember that a path container is a set of waypoints
    private Path mPath;
    private PathSegment currentSeg;
    private ActionScheduler driveScheduler; //Use actionAcheduler to run each drive action at segmented times
    private ArrayList<Action> driveActions = new ArrayList<Action>();

    public DrivePathAction(PathContainer p) {
        super("Following Path " + p.toString());
    	
    	mPathContainer = p;
        mPath = mPathContainer.buildPath();
        
        //converts path to an array of drive actions to be performed in perform 
        for (int i = 0; i < mPath.countSegments(); i++) {
        	currentSeg = mPath.getSegments().get(i);
        	Action segAction;
        	//If the current segment of the path is a line...
        	if (currentSeg.isLine()) {
        		//Drive that line using the accelLinear class
        		segAction = new AccelLinear(currentSeg);
        		driveActions.add(segAction);
        	} else {
        		//AccelCurve
        	}
        }
    }

    @Override
    public boolean done() {
    	return true;
    }

    @Override
    public void perform() {

    	driveScheduler.setGroup(driveActions); //Schedules all the drive actions. Performs the action in AccelLinear and AccelCurve

        Robot.tankDrive.setLeftMPPose(Robot.leftPos.position);
        Robot.tankDrive.setRightMPPose(Robot.rightPos.position);
        
    }

    @Override
    public void finish() {
        // TODO: Perhaps set wheel velocity to 0?
    }

    @Override
    public void start() {
        //mDrive.setWantDrivePath(mPath, mPathContainer.isReversed());

    	Robot.tankDrive.leftMPController.enable();
    	Robot.tankDrive.rightMPController.enable();
        //mDrive.setWantDrivePath(mPath, mPathContainer.isReversed());

        //SmartDashboard.putString("DB/String 1", "sawdfghj,k");
//        TankDriveBase.leftV = 0;
    }
    
}