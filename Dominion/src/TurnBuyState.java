
public class TurnBuyState extends TurnState {
	
	private Turn turn;
	private Player player;
	
	public TurnBuyState(Player player, Turn turn) {
		this.turn = turn;
		this.player = player;
	}

	@Override
	public void run() {
		while (this.turn.buys > 0) {
			if (!this.player.buy()) {
				this.turn.buys = 0;
			}
			this.turn.buys--;
		}
	}

}
