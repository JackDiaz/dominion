package model;



public class GameStateMachine {
	private State state;
	
	public enum State {
		TURN_START,
		ACTION_PHASE,
		EXECUTING_ACTION_CARD,
		WAIT_FOR_CARD_INPUT,
		WAIT_FOR_CHOICE_INPUT,
		BUY_PHASE,
		WAIT_FOR_OPPONENT_TURNS
	}
	
	private enum Transition {
		START_TURN,
		NEXT_ACTION_CARD,
		WAIT_FOR_CARD,
		ACTION_CARD_EXECUTED,
		ACTION_PHASE_COMPLETE,
		BUY_PHASE_COMPLETE,
		IS_PLAYER_TURN
	}
	
	public State getState() {
		return this.state;
	}
	
	public State startTurn() throws InvalidOperationException {
		return this.transitionState(State.TURN_START, State.ACTION_PHASE, Transition.START_TURN);
	}
	
	public State nextActionCard() throws InvalidOperationException {
		return this.transitionState(State.ACTION_PHASE, State.EXECUTING_ACTION_CARD, Transition.NEXT_ACTION_CARD);
	}
	
	public State waitForCard() throws InvalidOperationException {
		return this.transitionState(State.ACTION_PHASE, State.EXECUTING_ACTION_CARD, Transition.NEXT_ACTION_CARD);
	}
	
	public State actionCardExecuted() throws InvalidOperationException {
		return this.transitionState(State.EXECUTING_ACTION_CARD, State.ACTION_PHASE, Transition.ACTION_CARD_EXECUTED);
	}
	
	public State actionPhaseComplete() throws InvalidOperationException {
		return this.transitionState(State.ACTION_PHASE, State.BUY_PHASE, Transition.ACTION_PHASE_COMPLETE);
	}
	
	public State buyPhaseComplete() throws InvalidOperationException {
		return this.transitionState(State.BUY_PHASE, State.WAIT_FOR_OPPONENT_TURNS, Transition.BUY_PHASE_COMPLETE);
	}
	
	public State isPlayerTurn() throws InvalidOperationException {
		return this.transitionState(State.WAIT_FOR_OPPONENT_TURNS, State.TURN_START, Transition.IS_PLAYER_TURN);
	}
	
	private void setState(State state) {
		this.state = state;
	}
	
	private State transitionState(State fromState, State toState, Transition transition) throws InvalidOperationException {
		if (this.state != fromState) {
			throw new InvalidOperationException(transition + " transition is invalid from state" + this.getState());
		}
		
		this.setState(toState);
		return this.getState();
	}
}