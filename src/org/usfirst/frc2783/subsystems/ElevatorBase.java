package org.usfirst.frc2783.subsystems;

import org.usfirst.frc2783.commands.Elevator;
import org.usfirst.frc2783.robot.Constants;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * @purpose: Sets base system for raising the robot
 * @author Maddie Lanham
 * @version 1/20/2017
 */
public class ElevatorBase extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	// adds Victor
	public static VictorSPX elevator1Mot;
	public static VictorSPX elevator2Mot;
	
	Servo shifter;
	
	public ElevatorBase(){
		elevator1Mot = new VictorSPX(Constants.kElevator1);
		elevator2Mot = new VictorSPX(Constants.kElevator2);
		
		shifter = new Servo(0);
		
		elevator1Mot.setNeutralMode(NeutralMode.Brake);
		elevator2Mot.setNeutralMode(NeutralMode.Brake);
		
	}
	
	// moves elevator using left stick
	//forward up, backwards down
	public void elevator(double speed) {
		elevator1Mot.set(ControlMode.PercentOutput, speed);
		elevator2Mot.set(ControlMode.PercentOutput, speed);
			
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

