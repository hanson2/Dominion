
public class TurnCleanupState extends TurnState {

	private Player player;

	@Override
	public void run(Turn turn) {
		this.player = turn.player;
		this.player.discardHand();
		this.player.drawNewHand();
	}

}
