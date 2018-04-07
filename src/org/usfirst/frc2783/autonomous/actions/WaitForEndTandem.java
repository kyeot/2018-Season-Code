package org.usfirst.frc2783.autonomous.actions;

import org.usfirst.frc2783.robot.Robot;

public class WaitForEndTandem extends Action{

	double initCount;
	boolean waitForAll;
	
	/* 
	 * An action exclusively for ActionScheduler that waits for the completion of one or multiple TandemAction(s)
	 * 
	 * @param waitForAll 
	 * 		Set to true if you are waiting for all queued tandem actions, false if only the completion of the current one.
	 */
	public WaitForEndTandem(boolean waitForAll) {
		super("WaitForEndTandem");
	}

	@Override
	public void start() {
		initCount = Robot.tandemAction.getCurCount();
	}
	
	@Override
	public boolean done() {
		if(Robot.tandemAction.getCurCount() == Robot.tandemAction.getSetCount()) {
			return true;
		}
		
		if(!waitForAll) {
			return (Robot.tandemAction.getCurCount() != initCount);
		}
		
		return false;
	}
}
