public class TurnCleanupState extends TurnState {

	@Override
	public void run(Turn turn) {
		turn.player.discardPile.addAll(turn.playArea);
		turn.playArea.clear();
		turn.player.discardHand();
		turn.player.drawNewHand();
	}

}
