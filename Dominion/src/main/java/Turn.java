import java.util.ArrayList;
import java.util.List;

public class Turn {
	Player player;
	int buys;
	int actions;
	int coins;
	TurnState state;
	Supply supplyPiles;
	public List<Card> playArea;

	public Turn(Player player, Supply supplyPiles) {
		this.player = player;
		this.buys = 1;
		this.actions = 1;
		this.coins = 0;
		this.state = new TurnActionState();
		this.supplyPiles = supplyPiles;
		this.playArea = new ArrayList<>();
	}

	public void run() {
		this.state.run(this);
	}

	public Class<? extends TurnState> getCurrentStateType() {
		return this.state.getClass();
	}

}
