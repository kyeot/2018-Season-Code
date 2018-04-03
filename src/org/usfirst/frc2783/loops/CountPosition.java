package org.usfirst.frc2783.loops;

import org.usfirst.frc2783.loops.Loop;


public class CountPosition implements Loop{
	public double position = 0;
	public double v = 0;
	
	public CountPosition() {
		
	}
	
	public void update(double v) {
		this.v = v;
	}

	@Override
	public void onStart(double timestamp) {
		
	}

	@Override
	public void onStop(double timestamp) {
	
	}
	@Override
	public void onLoop(double timestamp) {
		position += 4096 * ((v / 200) / (6 * Math.PI));
	}
}
