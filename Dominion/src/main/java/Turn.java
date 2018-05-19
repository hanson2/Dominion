
public class Turn {
	Player player;
	int buys;
	int actions;
	int coins;
	TurnState state;
	Supply supplyPiles;

	public Turn(Player player, Supply supplyPiles) {
		this.player = player;
		this.buys = 1;
		this.actions = 1;
		this.coins = 0;
		this.state = new TurnActionState();
		this.supplyPiles = supplyPiles;
	}

	public void run() {
		this.state.run(this);
	}

	public Class<? extends TurnState> getCurrentStateType() {
		return this.state.getClass();
	}

}
