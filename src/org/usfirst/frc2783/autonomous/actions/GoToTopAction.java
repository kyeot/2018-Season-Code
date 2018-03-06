package org.usfirst.frc2783.autonomous.actions;

import org.usfirst.frc2783.robot.Robot;

public class GoToTopAction extends Action{

	public GoToTopAction() {
		super("GoToTopAction");
		
	}
	
	@Override
	public void start(){
    	Robot.yesso = true;
    	Robot.elevatorBase.elevator(0.8);
	}
	
	@Override
	public boolean done(){
        return Robot.elEncCounter.getRotations() >= 12;
		
	}
	
	@Override
	public void finish(){
    	Robot.elevatorBase.elevator(0);
    	Robot.yesso = false;
		
	}
	
}
