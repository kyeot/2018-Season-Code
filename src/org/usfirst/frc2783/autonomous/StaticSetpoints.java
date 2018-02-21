package org.usfirst.frc2783.autonomous;

import org.usfirst.frc2783.autonomous.paths.PathBuilder.Setpoint;

// A place to store x,y values for set positions on the field without storing information of radii or speed.

public class StaticSetpoints {
	
	public static Setpoint leftCornerStart = new Setpoint(17, 282);
	public static Setpoint rightCornerStart = new Setpoint(17, 43);
	public static Setpoint centerStart = new Setpoint(17, 155);
	public static Setpoint exchangeStart = new Setpoint(17, 193);
	public static Setpoint rightOfSwitch = new Setpoint(150, 43);
	public static Setpoint leftOfSwitch = new Setpoint(150, 282);
	public static Setpoint platformFarRight = new Setpoint(240, 75);
	public static Setpoint platformFarLeft = new Setpoint(240, 250);
	public static Setpoint preScaleRight = new Setpoint(280, 75);
	public static Setpoint preScaleLeft = new Setpoint(280, 250);
	public static Setpoint scaleRight = new Setpoint(300, 75);
	public static Setpoint scaleLeft = new Setpoint(300, 250);
	public static Setpoint switchCubeRight = new Setpoint(240, 90);
	public static Setpoint switchCubeLeft = new Setpoint(240, 235);
	public static Setpoint switchRight = new Setpoint(213, 90);
	public static Setpoint switchLeft = new Setpoint(213, 235);
	
}
