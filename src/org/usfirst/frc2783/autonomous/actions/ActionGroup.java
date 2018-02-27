package org.usfirst.frc2783.autonomous.actions;

import java.util.ArrayList;

public class ActionGroup {

	ArrayList<Action> actions = new ArrayList<Action>();
	ArrayList<Action> actions2 = new ArrayList<Action>();
	
	public ActionGroup() {
		actions = new ArrayList<Action>();
		actions2 = new ArrayList<Action>();
	}
	
	protected void addAction(Action action) {
		actions.add(action);
	}
	
	protected void addSecondaryAction(Action action) {
		actions2.add(action);
	}
	
	public ArrayList<Action> getActions() {
		return actions;
	}
	
}