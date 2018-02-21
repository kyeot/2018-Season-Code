package org.usfirst.frc2783.autonomous.actions;

import java.util.ArrayList;

import org.usfirst.frc2783.robot.Constants;
import org.usfirst.frc2783.util.CrashTrackingRunnable;
import org.usfirst.frc2783.util.Logger;

import edu.wpi.first.wpilibj.Notifier;

public class ActionScheduler {
	
	Notifier thread;
	Action action;
	
	boolean active = false;
	
	ArrayList<Action> queue;
	
	public ActionScheduler() {
		//The list of actions in a queue
		queue = new ArrayList<Action>();
		
		thread = new Notifier(new CrashTrackingRunnable() {
			
			@Override
			public void runCrashTracked() {
				
				if(isActive()) {
					
					//perform action of boolean says so
					action.perform();
					
					if(action.done()) {
						
						//When boolean says so, finish action and say action has finished
						action.finish();
						Logger.info("Action " + action.getId() + " has finished and quit");
						
						if(!queue.isEmpty()) {
							setAuto(queue.get(0));
							queue.get(0).start();
							queue.remove(0);
						} else {
							stop();
						}
						
					}
					if(action.fail()) {
						Logger.error("Action " + action.getId() + " has failed and quit");
						
						if(!queue.isEmpty()) {
							setAuto(queue.get(0));
							queue.get(0).start();
							queue.remove(0);
						} else {
							stop();
						}
					}
				}
				
			} 
			
			@Override
			public void logCrash() {
				Logger.error("Exception caught in Actions: " + action.getId());
				stop();
			}
		});
	}
	
	public void setAuto(Action action) {
		this.action = action;
	}
	
	public void setGroup(ActionGroup group) {
		for(Action a : group.getActions()) {
			queue(a);
		}
	}
	
	public void queue(Action action) {
		queue.add(action);
	}
	
	public void start() {
		if(!queue.isEmpty()) {
			setAuto(queue.get(0));
			queue.remove(0);
		}
		if(action != null) {
			action.start();
			thread.startPeriodic(Constants.kAutoPeriod);
			active = true;
		} else {
			Logger.warn("No Action to Start the Scheduler");
		}
		
	}
	
	public void stop() {
		if(isActive()) {
			thread.stop();
			active = false;
		}
		
	}
	
	public boolean isActive() {
		return active;
	}
}