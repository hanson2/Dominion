
public class TurnBuyState extends TurnState {

	private Turn turn;
	private Player player;

	@Override
	public void run(Turn turn) {
		this.turn = turn;
		this.player = turn.player;
		
		while (this.turn.buys > 0) {
			if (!this.player.buy()) {
				this.turn.buys = 0;
			}
			this.turn.buys--;
		}

		this.turn.state = new TurnCleanupState();
		this.turn.run();
	}

}
