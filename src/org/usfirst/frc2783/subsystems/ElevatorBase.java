package org.usfirst.frc2783.subsystems;

import org.usfirst.frc2783.commands.Elevator;
import org.usfirst.frc2783.robot.Constants;
import org.usfirst.frc2783.robot.Robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * @purpose: Sets base system for raising the robot
 * @author Maddie Lanham
 * @version 1/20/2017
 */
public class ElevatorBase extends Subsystem {
	
	class ElevatorEncSource implements PIDSource {
		PIDSourceType sourceType;
		public ElevatorEncSource() {
			setPIDSourceType(PIDSourceType.kDisplacement);
		}
		@Override
		public void setPIDSourceType(PIDSourceType pidSource) {
			sourceType = pidSource;
		}
		@Override
		public PIDSourceType getPIDSourceType() {
			return sourceType;
		}
		@Override
		public double pidGet() {
			return Robot.elevatorAbsEnc.getValue()/11.3777777777777777778;
		}	
	}

    //PID Output Class for the elevator
	class ElevatorOut implements PIDOutput {
		@Override
		public void pidWrite(double output){
			out = -output;
		}
	}

	// adds Victor
	public static VictorSPX elevator1Mot;
	public static VictorSPX elevator2Mot;
	
	long timeOnStart;
	double time;
	
	double out;
	
	public Servo shifter;
	
	ElevatorEncSource elevatorEncSource;
	ElevatorOut elevatorOut;
	PIDController elevatorEncController;
	
	boolean isUp = true;
	
	public ElevatorBase(){
		elevator1Mot = new VictorSPX(Constants.kElevator1);
		elevator2Mot = new VictorSPX(Constants.kElevator2);
		
		shifter = new Servo(Constants.kElevatorShifterID);
		
		elevator1Mot.setNeutralMode(NeutralMode.Brake);
		elevator2Mot.setNeutralMode(NeutralMode.Brake);
		
		elevatorEncSource = new ElevatorEncSource();
		elevatorOut = new ElevatorOut();
		elevatorEncController = new PIDController(Constants.kElevatorP, Constants.kElevatorI, Constants.kElevatorD,
												  elevatorEncSource, elevatorOut);
		elevatorEncController.setInputRange(0, 360);
		elevatorEncController.setContinuous(false);
		
	}
	
	public void elevatorPid(double angle){
		elevatorEncController.setSetpoint(angle);
		elevatorEncController.enable();
		
		elevator(out);
		
	}
	
	public void elevator(double speed) {
		
		if(speed >= 0.1){
			isUp = true;
		}
		else if(speed <= -0.1){
			isUp = false;
		}
		
		if(Robot.isClimb){
			isUp = !isUp;
		}
		
		if(isUp){
			elevator1Mot.set(ControlMode.PercentOutput, speed);
			elevator2Mot.set(ControlMode.PercentOutput, speed);
		}
		else if(!isUp){
			elevator1Mot.set(ControlMode.PercentOutput, speed/3);
			elevator2Mot.set(ControlMode.PercentOutput, speed/3);
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

