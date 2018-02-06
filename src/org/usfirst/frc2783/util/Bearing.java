package org.usfirst.frc2783.util;

/**
 * 2D Rotation, used in tandem with Vector
 * 
 * @author 2783
 * @see Transform
 * @see Vector
 */
public class Bearing {
	double theta;
	
	public Bearing(double theta) {
		this.theta = theta;
	}
	
	public Bearing(Vector v) {
		theta = v.dir().getTheta();
	}
	
	/**
	 * rotates bearing by adding passed bearing to current bearing
	 * and then modding 360 if its over 2PI.
	 * @param Bearing b
	 * @return Bearing(Added bearings mod 360)
	 */
	public Bearing rotate(Bearing b) {
		return new Bearing((this.theta+b.getTheta())%360);
	}
	
	public double sin() {
		return Math.sin(Math.toRadians(theta));
	}
	
	public double cos() {
		return Math.cos(Math.toRadians(theta));
	}
	
	public double getTheta() {
		return ((theta%360)+360)%360;
	}
}
