package org.usfirst.frc2783.autonomous.actions.groups;

import org.usfirst.frc2783.autonomous.actions.ActionGroup;
import org.usfirst.frc2783.autonomous.actions.AutoDrive;

public class BaselineCross extends ActionGroup{

	public BaselineCross(){
		super();
		
		addAction(new AutoDrive(.5, 0.6, 5));
		
	}
	
}
