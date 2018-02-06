package org.usfirst.frc2783.util;

/**
 * A 2D Vector with magnitude and direction
 * 
 * @author 2783
 * @see Transform
 * @see Bearing
 */
public class Vector {
	
	double x;
	double y;
	
	/**
	 * This constructor defines the vector by giving the x and y lengths of the vector.
	 * @param x
	 * @param y
	 */
	public Vector(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * This constructor defines the vector by giving the direction and .
	 * @param dir
	 * @param mag
	 * @param a
	 */
	public Vector(double dir, double mag, boolean a) { 
		this.x = Math.cos(Math.toRadians(dir)) * mag;
		this.y = Math.sin(Math.toRadians(dir)) * mag;
	}
	
	/**
	 * This method takes a vector and and adds it to the passed vector and returns a new vector.
	 * @param v
	 * @return Vector(c, d)
	 */
	public Vector addVector(Vector v) {
		double c = x + v.getX();
		double d = y + v.getY();
		return new Vector(c, d);
	}
	
	/**
	 * Rotates vector by Bearing r.
	 * @param r
	 * @return Vector(rotated coordinates)
	 */
	public Vector rotateBy(Bearing r) {
		return new Vector((x * r.cos()) - (y * r.sin()),
						  (x * r.sin()) + (y * r.cos()));
	}
	
	public double mag() {
		return Math.hypot(x, y);
	}
	
	public Bearing dir() {
		return new Bearing(Math.toDegrees(Math.atan2(y, x)));
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
}
