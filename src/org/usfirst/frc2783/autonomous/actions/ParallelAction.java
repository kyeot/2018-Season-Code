package org.usfirst.frc2783.autonomous.actions;

@SuppressWarnings("unused")
public class ParallelAction extends Action {
	
	private Action act1;
	private Action act2;
	
	public ParallelAction(Action act1, Action act2) {
		
		super("Parallel " + act1.id + " and " + act2.id);
		
		this.act1 = act1;
		this.act2 = act2;
		
	}

}
