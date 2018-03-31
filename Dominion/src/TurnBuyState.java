
public class TurnBuyState extends TurnState {

	private Turn turn;
	private Player player;

	public TurnBuyState(Turn turn) {
		this.turn = turn;
		this.player = turn.player;
	}

	@Override
	public void run() {
		while (this.turn.buys > 0) {
			if (!this.player.buy()) {
				this.turn.buys = 0;
			}
			this.turn.buys--;
		}

		this.turn.state = new TurnCleanupState(this.turn);
		this.turn.run();
	}

}
