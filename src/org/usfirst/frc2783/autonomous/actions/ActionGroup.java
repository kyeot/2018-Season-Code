package org.usfirst.frc2783.autonomous.actions;

import java.util.ArrayList;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ActionGroup {

	ArrayList<Action> actions = new ArrayList<Action>();
	ArrayList<Action> actions2 = new ArrayList<Action>();
	
	public ActionGroup() {
		actions = new ArrayList<Action>();
		actions2 = new ArrayList<Action>();
	}
	
	protected void addAction(Action action) {
		actions.add(action);
		//SmartDashboard.putString("DB/String 1", "Hiki");
	}
	
	protected void addSecondaryAction(Action action) {
		actions2.add(action);
	}
	
	public ArrayList<Action> getActions() {
		return actions;
	}
	
}