
public class Turn {
	Player player;
	int buys;
	int actions;
	TurnState state;

	public Turn(Player player) {
		this.player = player;
		this.buys = 1;
		this.actions = 1;
		this.state = new TurnActionState(player, this);
	}

	public void run() {
		this.state.run();
	}

	public Class<? extends TurnState> getCurrentStateType() {
		return this.state.getClass();
	}

}
