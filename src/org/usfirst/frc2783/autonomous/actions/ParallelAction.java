package org.usfirst.frc2783.autonomous.actions;

@SuppressWarnings("unused")
public class ParallelAction extends Action {
	
	private Action act1;
	private Action act2;
	
	public ParallelAction(Action act1, Action act2) {
		
		//Returns name as both action ids
		super("Parallel " + act1.id + " and " + act2.id);
		//sets given action to actions on object
		this.act1 = act1;
		this.act2 = act2;
		
	}
	
	

}
