
public class Turn {
	Player player;
	int buys;
	int actions;
	int coins;
	TurnState state;

	public Turn(Player player) {
		this.player = player;
		this.buys = 1;
		this.actions = 1;
		this.coins = 0;
		this.state = new TurnActionState(this);
	}

	public void run() {
		this.state.run();
	}

	public Class<? extends TurnState> getCurrentStateType() {
		return this.state.getClass();
	}

}
