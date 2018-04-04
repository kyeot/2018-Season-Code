package org.usfirst.frc2783.autonomous.actions.groups;

import java.util.Arrays;

import org.usfirst.frc2783.autonomous.actions.Action;
import org.usfirst.frc2783.autonomous.actions.ActionGroup;
import org.usfirst.frc2783.autonomous.actions.AutoElevator;
import org.usfirst.frc2783.autonomous.actions.AutoIntake;
import org.usfirst.frc2783.autonomous.actions.DrivePathAction;
import org.usfirst.frc2783.autonomous.actions.ParallelAction;
import org.usfirst.frc2783.robot.Robot;
import org.usfirst.frc2783.segments.LeftScaleToLeftStage;
import org.usfirst.frc2783.segments.LeftStageToLeftScale;
import org.usfirst.frc2783.segments.LeftStageToLeftSwitch;
import org.usfirst.frc2783.segments.LeftStartToLeftScale;
import org.usfirst.frc2783.segments.LeftStartToRightScale;
import org.usfirst.frc2783.segments.LeftSwitchToLeftStage;
import org.usfirst.frc2783.segments.RightScaleToRightStage;
import org.usfirst.frc2783.segments.RightStageToRightScale;
import org.usfirst.frc2783.segments.RightStageToRightSwitch;
import org.usfirst.frc2783.segments.RightSwitchToRightStage;
import org.usfirst.frc2783.segments.StageLeft;
import org.usfirst.frc2783.util.Logger;

public class TwoScaleFromLeft extends ActionGroup {

	public TwoScaleFromLeft(){
		super();
		
		try{
			if(Robot.isScaleLeft()) {
				addAction(new DrivePathAction(new LeftStartToLeftScale()));
//				addAction(new ParallelAction(Arrays.asList(new Action[] {
//						new DrivePathAction(new LeftStartToLeftScale()),
//		                new AutoElevator(-1, 1)
//		        })));
				addAction(new AutoIntake(1,1));
				addAction(new ParallelAction(Arrays.asList(new Action[] {
						new DrivePathAction(new LeftScaleToLeftStage()),
		                new AutoElevator(1, 1)
		        })));
				addAction(new ParallelAction(Arrays.asList(new Action[] {
						new DrivePathAction(new LeftStageToLeftSwitch()),
						new AutoIntake(-1,1)
		        })));
				addAction(new ParallelAction(Arrays.asList(new Action[] {
						new DrivePathAction(new LeftSwitchToLeftStage()),
		                new AutoElevator(.5, 1),
		                new AutoIntake(1,1)
		        })));
				addAction(new ParallelAction(Arrays.asList(new Action[] {
						new DrivePathAction(new LeftStageToLeftScale()),
		                new AutoElevator(1, 1)
		        })));
				addAction(new AutoIntake(1,1));
			} else {
				addAction(new DrivePathAction(new LeftStartToRightScale()));
//				addAction(new ParallelAction(Arrays.asList(new Action[] {
//						new DrivePathAction(new LeftStartToRightScale()),
//		                new AutoElevator(-1, 1)
//		        })));
//				addAction(new AutoIntake(1,1));
//				addAction(new ParallelAction(Arrays.asList(new Action[] {
//						new DrivePathAction(new RightScaleToRightStage()),
//		                new AutoElevator(1, 1)
//		        })));
//				addAction(new ParallelAction(Arrays.asList(new Action[] {
//						new DrivePathAction(new RightStageToRightSwitch()),
//						new AutoIntake(-1,1)
//		        })));
//				addAction(new ParallelAction(Arrays.asList(new Action[] {
//						new DrivePathAction(new RightSwitchToRightStage()),
//		                new AutoElevator(.5, 1),
//		                new AutoIntake(1,1)
//		        })));
//				addAction(new ParallelAction(Arrays.asList(new Action[] {
//						new DrivePathAction(new RightStageToRightScale()),
//		                new AutoElevator(1, 1)
//		        })));
//				addAction(new AutoIntake(1,1));
			}
			
		}
		
		catch(NullPointerException n) {
			Logger.error("Game Data Not Recieved, Crossing Baseline");
        	
			addAction(new DrivePathAction(new StageLeft()));
			
		}
		
	}
	
}