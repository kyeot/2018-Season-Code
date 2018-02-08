package org.usfirst.frc2783.subsystems;

import org.usfirst.frc2783.commands.Elevator;
import org.usfirst.frc2783.robot.Constants;
import org.usfirst.frc2783.robot.OI;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * @purpose: Sets base system for raising the robot
 * @author Maddie Lanham
 * @version 1/20/2017
 */
public class ElevatorBase extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	// adds Victor
	VictorSPX elevatorMot;
	
	Servo shifter;
	
	public ElevatorBase(){
		elevatorMot = new VictorSPX(Constants.kElevator1);
		
		shifter = new Servo(0);
		
		elevatorMot.setNeutralMode(NeutralMode.Brake);
		
	}
	
	// moves elevator using left stick
	//forward up, backwards down
	public void elevator(double speed) {
		if (Math.abs(OI.manipulator.getRawAxis(1)) > 0.15) {
			elevatorMot.set(ControlMode.PercentOutput, speed);
		}
		else {
			elevatorMot.set(ControlMode.PercentOutput, 0);
		}
	}
	
	public void lowGear(){
		shifter.set(0);
		
	}

	public void highGear(){
		shifter.set(1);
		
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new Elevator());
    	
    }
}
