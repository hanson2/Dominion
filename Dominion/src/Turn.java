
public class Turn {
	Player player;
	int buys;
	int actions;
	TurnState[] states = new TurnState[3];
	int state;

	public Turn(Player player) {
		this.player = player;
		this.buys = 1;
		this.actions = 1;
		this.states[0] = new TurnActionState(player, this);
		this.states[1] = new TurnBuyState(player, this);
		this.states[2] = new TurnCleanupState(player, this);
		this.state = 0;
	}

	public void run() {
		for (int i = 0; i < states.length; i++) {
			this.state = i;
			this.states[i].run();
		}
	}

	public String getCurrentStateType() {
		return "ACTION";
	}

}
