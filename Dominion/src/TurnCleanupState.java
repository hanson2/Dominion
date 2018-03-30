
public class TurnCleanupState extends TurnState {

	private Player player;

	public TurnCleanupState(Player player) {
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
