package org.usfirst.frc2783.autonomous.actions.groups;

import org.usfirst.frc2783.autonomous.actions.ActionGroup;
import org.usfirst.frc2783.autonomous.actions.DriveWithGyroAndByDistance;


public class StageRightWaypoint extends ActionGroup{

	public StageRightWaypoint(){
		super();
		
		addAction(new DriveWithGyroAndByDistance(0.5, 20, 20, 0));
		
	}
	
}