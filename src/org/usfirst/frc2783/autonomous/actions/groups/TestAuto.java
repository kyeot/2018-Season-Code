package org.usfirst.frc2783.autonomous.actions.groups;

import org.usfirst.frc2783.autonomous.actions.ActionGroup;
import org.usfirst.frc2783.autonomous.actions.AutoDrive;

public class TestAuto extends ActionGroup {
	
	public TestAuto() {
		super();

		addAction(new AutoDrive(1, 1, 5));
		
	}

}