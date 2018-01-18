package org.usfirst.frc2783.commands.autonomous.modes;

import org.usfirst.frc2783.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RightSideScalePref extends CommandGroup {

    public RightSideScalePref() {
    	
    	switch (Robot.autoSides) {
        case "RR":  
        	//Code to place right switch, pick up crate, place right scale
             break;
        case "LR":  
        	//Code to place right scale, pick up crate, place left switch
             break;
        case "RL":  
        	//Code to place right switch, pick up crate, place left scale
             break;
        case "LL": 
        	//Code to place on scale from right side
        	 break;
        	 
    }
    	
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}