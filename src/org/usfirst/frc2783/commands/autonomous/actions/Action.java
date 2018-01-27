package org.usfirst.frc2783.commands.autonomous.actions;

import java.util.UUID;

import org.usfirst.frc2783.util.Timer;

public abstract class Action {
	
	String id;
	
	Timer timer;
	boolean timed;
	
	public Action(String id, double time) {
		this.id = id + ":" + UUID.randomUUID().toString();
		
		timer = new Timer(time);
		timed = true;
	}
	
	public Action(String id) {
		this.id = id + ":" + UUID.randomUUID().toString();
		
		timed = false;
	}
	
	public void start() {
		if(timed) {
			timer.start();
		}
	}
	
	public void perform() {
		
	}
	
	public boolean done() {
		if(timed) {
			return timer.ring();
		}
		return false;
	}
	
	public void finish() {
		
	}
	
	public boolean fail() {
		return false;
	}

	public String getId() {
		return id;
	}
	
}
