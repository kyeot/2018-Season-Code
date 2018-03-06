package org.usfirst.frc2783.autonomous.actions.groups;

import org.usfirst.frc2783.autonomous.actions.ActionGroup;
import org.usfirst.frc2783.autonomous.actions.RotateTankAction;
import org.usfirst.frc2783.util.Bearing;

public class TestAuto extends ActionGroup {
	
	public TestAuto() {
		super();

		addAction(new RotateTankAction(new Bearing(0), 5));
		
	}

}