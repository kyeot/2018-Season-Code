package org.usfirst.frc2783.autonomous.actions;

import java.util.ArrayList;

public class ActionGroup {

	ArrayList<Action> actions = new ArrayList<Action>();
	
	public ActionGroup() {
		actions = new ArrayList<Action>();
	}
	
	protected void addAction(Action action) {
		actions.add(action);
		//SmartDashboard.putString("DB/String 1", "Hiki");
	}
	
	public ArrayList<Action> getActions() {
		return actions;
	}
	
}