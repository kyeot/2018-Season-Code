package org.usfirst.frc2783.loops;

import java.util.ArrayList;
import java.util.List;

import org.usfirst.frc2783.util.CrashTrackingRunnable;
import org.usfirst.frc2783.util.Logger;

import org.usfirst.frc2783.loops.Loop;

import edu.wpi.first.wpilibj.Notifier;

/**
 * Manages a List of loops, starting and stopping them under a
 * crash tracker.
 * 
 * @author 2783
 */
public class Looper {
	
	double period;
	private final Object taskRunningLock_ = new Object();
	
	CrashTrackingRunnable runnable = new CrashTrackingRunnable() {
		@Override
		public void runCrashTracked() {
			for(Loop l : loops) {
				//l.onLoop()
				l.onLoop(200);
			}
		}
		
		@Override
		public void logCrash() {
			Logger.error("Exception caught in Loops");
		}
	};
	
	List<Loop> loops;
	Notifier notifier;
	
	public Looper(double period) {
		this.period = 1/period;
		loops = new ArrayList<Loop>();
		notifier = new Notifier(runnable);
	}
	
	public void startLoops() {
		for(Loop l : loops) {
			//l.onStart();
			l.onStart(200);
		}
		notifier.startPeriodic(period);
		
	}
	
	public void addLoop(Loop l) {
		loops.add(l);
	}
	
	public void stopLoops() {
		notifier.stop();
		for(Loop l : loops) {
			//l.onStop();
			l.onStop(200);
		}
	}
	
	public synchronized void register(Loop loop) {
        synchronized (taskRunningLock_) {
            loops.add(loop);
        }
    }

}