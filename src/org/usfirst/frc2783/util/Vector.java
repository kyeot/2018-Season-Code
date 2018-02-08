package org.usfirst.frc2783.util;

/**
 * A 2D Vector with magnitude and direction
 * 
 * @author 2783
 * @see Transform
 * @see Bearing
 */
public class Vector {
	
	double width;
	double height;
	
	/**
	 * This constructor defines the vector by giving the x and y lengths of the vector.
	 * @param x
	 * @param y
	 */
	public Vector(double x, double y) {
		this.width = x;
		this.height = y;
	}
	
	/**
	 * This constructor defines the vector by giving the direction and .
	 * @param dir
	 * @param mag
	 * @param a
	 */
	public Vector(double dir, double mag, boolean a) { 
		this.width = Math.cos(Math.toRadians(dir)) * mag;
		this.height = Math.sin(Math.toRadians(dir)) * mag;
	}
	
	/**
	 * This method takes a vector and and adds it to the passed vector and returns a new vector.
	 * @param v
	 * @return Vector(c, d)
	 */
	public Vector addVector(Vector v) {
		double c = width + v.getX();
		double d = height + v.getY();
		return new Vector(c, d);
	}
	
	/**
	 * Rotates vector by Bearing r.
	 * @param r
	 * @return Vector(rotated coordinates)
	 */
	public Vector rotateBy(Bearing r) {
		return new Vector((width * r.cos()) - (height * r.sin()),
						  (width * r.sin()) + (height * r.cos()));
				
	}
	
	public double mag() {
		return Math.hypot(width, height);
	}
	
	public Bearing dir() {
		return new Bearing(Math.toDegrees(Math.atan2(height, width)));
	}
	
	public double getX() {
		return width;
	}
	
	public double getY() {
		return height;
	}
}
