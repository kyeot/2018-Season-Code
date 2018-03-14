package org.usfirst.frc2783.autonomous.actions.groups;

import org.usfirst.frc2783.autonomous.actions.ActionGroup;
import org.usfirst.frc2783.autonomous.actions.AutoDrive;

public class SkrtLeftGroup extends ActionGroup {

	public SkrtLeftGroup(){
		super();
		
		addAction(new AutoDrive(0.5, 0, 1));
		addAction(new AutoDrive(0, 0.5, 1));
		
	}
	
}
