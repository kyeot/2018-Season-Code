package org.usfirst.frc2783.util;

public abstract class CrashTrackingRunnable implements Runnable {
	
	@Override
	public void run() {
		//logs a loop error and crashes
		try {
			runCrashTracked();
		} catch(Throwable t) {
			Logger.error("Exception caught in Loops");
			logCrash();
			throw(t);
		}
	}
	
	public abstract void runCrashTracked();
	
	public abstract void logCrash();

}
