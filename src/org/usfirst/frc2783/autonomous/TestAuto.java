package org.usfirst.frc2783.autonomous;

import org.usfirst.frc2783.autonomous.actions.ActionGroup;
import org.usfirst.frc2783.autonomous.actions.RotateTankAction;
import org.usfirst.frc2783.util.Bearing;

public class TestAuto extends ActionGroup {
	
	public TestAuto() {
		super();

		addAction(new RotateTankAction(new Bearing(0), 5));
		
//		addAction(new DriveByDistance(-0.5, (21*12)+6, (21*12)+6));
//		addAction(new DriveByDistance(-0.5, 17, -17));
//		addAction(new DriveByDistance(-0.5, (14*12)+6, (14*12)+6));
	}

}