
public class TurnCleanupState extends TurnState {

	private Player player;

	public TurnCleanupState(Turn turn) {
		this.player = turn.player;
	}

	@Override
	public void run() {
		this.player.discardHand();
		this.player.drawNewHand();
	}

}
