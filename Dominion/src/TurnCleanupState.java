
public class TurnCleanupState extends TurnState {

	private Turn turn;
	private Player player;
	
	public TurnCleanupState(Player player, Turn turn) {
		this.turn = turn;
		this.player = player;
	}
	
	@Override
	public void run() {
		this.player.discardHand();
		for (int i = 0; i < 5; i++) {
			this.player.drawACard();
		}
	}

}
