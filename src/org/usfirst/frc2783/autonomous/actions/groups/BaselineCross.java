package org.usfirst.frc2783.autonomous.actions.groups;

import org.usfirst.frc2783.autonomous.actions.ActionGroup;
import org.usfirst.frc2783.autonomous.actions.DriveWithGyroAndByDistance;

public class BaselineCross extends ActionGroup{

	public BaselineCross(){
		super();
		
		addAction(new DriveWithGyroAndByDistance(0.5, 13*12, 13*12, 0));
		
	}
	
}
