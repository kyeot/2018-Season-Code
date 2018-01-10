package org.usfirst.frc2783.commands.autonomous;

import org.usfirst.frc2783.robot.Robot;

import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class autoTankDrive extends Command {

	private long commandStartedAt;
	
	private double runTime;
	double lSpeed;
	double rSpeed;

    public autoTankDrive(double lSpeed, double rSpeed, double runTime) {
		requires(Robot.tankDriveBase);
		
		this.runTime = runTime;
		this.lSpeed = lSpeed;
		this.lSpeed = lSpeed;
		
    }

    // Called just before this Command runs the first time
	protected void initialize() {
    	commandStartedAt = RobotController.getFPGATime();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.tankDriveBase.tankDrive(lSpeed, rSpeed);
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return RobotController.getFPGATime() > (runTime * 1000000 + commandStartedAt);
    }

    // Called once after isFinished returns true
    protected void end() {
    	commandStartedAt = 0;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
