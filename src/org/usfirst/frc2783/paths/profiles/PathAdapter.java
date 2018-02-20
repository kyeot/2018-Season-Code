package org.usfirst.frc2783.paths.profiles;

import org.usfirst.frc2783.robot.Constants;
import org.usfirst.frc2783.autonomous.paths.PathBuilder;
import org.usfirst.frc2783.autonomous.paths.PathBuilder.Waypoint;
import org.usfirst.frc2783.autonomous.paths.Path;
import org.usfirst.frc2783.calculation.RigidTransform2d;
import org.usfirst.frc2783.calculation.Rotation2d;
import org.usfirst.frc2783.calculation.Translation2d;

import java.util.ArrayList;

/**
 * Uses a field and robot profile to calculate Waypoints for the paths used by the GearThenHopperShoot auto modes.
 * 
 * @see RobotProfile
 * @see FieldProfile
 */
@SuppressWarnings("unused")
public class PathAdapter {

    static final RobotProfile kRobotProfile = new CompBot();
    static final FieldProfile kFieldProfile = new PracticeField();

    // Path Variables
    static final double kLargeRadius = 45;
    static final double kModerateRadius = 30;
    static final double kNominalRadius = 20;
    static final double kSmallRadius = 10;
    static final double kSpeed = 80;

    // Don't mess with these
    static final double kPegOffsetX = 17.77; // center of airship to boiler peg
    static final double kPegOffsetY = 30.66; // front of airship to boiler
                                             // pegkRobotProfile.getBlueBoilerGearXCorrection()
    
    static final Rotation2d kRedPegHeading = Rotation2d.fromDegrees(240);
    static final Rotation2d kBluePegHeading = Rotation2d.fromDegrees(125);
    static final Rotation2d kRedHopperHeading = Rotation2d.fromDegrees(45); // angle to hit the red hopper at
    static final Rotation2d kBlueHopperHeading = Rotation2d.fromDegrees(315); // angle to hit the blue hopper at
    static final Rotation2d kStartHeading = Rotation2d.fromDegrees(180); // start angle (backwards)
    
    static final double kFieldHeight = 324; // total height of the field in inches (doesn't really have to be accurate,
                                            // everything is relative)

    public static void main(String[] args) {
    	
    }

}
