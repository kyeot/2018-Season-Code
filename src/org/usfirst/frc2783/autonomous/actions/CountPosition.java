package org.usfirst.frc2783.autonomous.actions;

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
	public void onStart() {
		
	}

	@Override
	public void onStop() {
	
	}

	@Override
	public void onLoop(double timestamp) {
//		position += 4096 * ((v / 200) / (6 * Math.PI));
	}

	@Override
	public void onLoop() {
		// TODO Auto-generated method stub
		
	}
}
