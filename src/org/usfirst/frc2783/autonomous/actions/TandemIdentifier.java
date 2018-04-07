package org.usfirst.frc2783.autonomous.actions;

import org.usfirst.frc2783.robot.Robot;

public class TandemIdentifier extends Action{

	public TandemIdentifier() {
		super("TandemIdentifier");
	}

	public void perform() {
		Robot.tandemAction.runTandem();
	}
}
