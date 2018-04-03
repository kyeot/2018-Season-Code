package org.usfirst.frc2783.loops;

/**
 * 
 * Simple interface for defining a Loop
 *
 */

public interface Loop {
	
	public void onStart(double timestamp);
	
	public void onStop(double timestamp);

	public void onLoop(double timestamp);

}
