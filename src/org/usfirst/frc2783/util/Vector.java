package org.usfirst.frc2783.util;

/**
 * A 2D Vector with magnitude and direction
 * 
 * @author 2783
 * @see Transform
 * @see Bearing
 */
public class Vector {
	double a;
	double b;
	
	public Vector(double a, double b) {
		this.a = a;
		this.b = b;
	}
	
	public Vector(double dir, double mag, boolean a) { 
		this.a = Math.cos(Math.toRadians(dir)) * mag;
		this.b = Math.sin(Math.toRadians(dir)) * mag;
	}
	
	public Vector translate(Vector v) {
		double c = a + v.getA();
		double d = b + v.getB();
		return new Vector(c,d);
	}
	
	public Vector rotateBy(Bearing r) {
		return new Vector((a*r.cos())-(b*r.sin()), (a*r.sin())+(b*r.cos()));
				
	}
	
	public double mag() {
		return Math.hypot(a, b);
	}
	
	public Bearing dir() {
		return new Bearing(Math.toDegrees(Math.atan2(b,a)));
	}
	
	public double getA() {
		return a;
	}
	
	public double getB() {
		return b;
	}
}