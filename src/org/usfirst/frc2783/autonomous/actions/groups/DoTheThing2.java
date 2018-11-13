package org.usfirst.frc2783.autonomous.actions.groups;

import org.usfirst.frc2783.autonomous.actions.ActionGroup;
import org.usfirst.frc2783.autonomous.actions.DoTheThing;

public class DoTheThing2 extends ActionGroup {
	
	public DoTheThing2() {
		super();
		
		addAction(new DoTheThing(-0.5, 2));
		
	}
}
