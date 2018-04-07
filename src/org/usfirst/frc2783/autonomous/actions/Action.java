package org.usfirst.frc2783.autonomous.actions;

import java.util.UUID;

import org.usfirst.frc2783.util.Timer;
/**
 * 
 * Class to make an action, if you pass a time into the constructor it will time itself, if you do not then
 * you will need to override the "done" method and manually have it return true.
 *
 */
public class Action {
	
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
	
	//Where you put code that runs at the start of the action, if it's timed it automatically starts the timer here
	public void start() {
		if(timed) {
			timer.start();
		}
	}
	
	//The main loop, runs on repeat based on period value in Constants
	public void perform() {
		
	}
	
	//Make this return true when you want the action to end, if it's time this will automatically return true when the timer rings
	public boolean done() {
		if(timed) {
			return timer.ring();
		}
		return false;
	}
	
	//Runs once after the Action ends
	public void finish() {
		
	}
	
	public boolean fail() {
		return false;
	}

	//Returns the Action ID set in constructor
	public String getId() {
		return id;
	}
	
}