package org.usfirst.frc2783.commands.autonomous;

import org.usfirst.frc2783.commands.autonomous.actions.ActionGroup;
import org.usfirst.frc2783.commands.autonomous.actions.AutoDrive;

public class TestAuto extends ActionGroup {
	
	public TestAuto() {
		super();
		
		addAction(new AutoDrive(0.5, 0.5 ,1));
	}

}
