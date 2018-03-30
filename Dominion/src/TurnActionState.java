
public class TurnActionState extends TurnState {

	private Turn turn;
	private Player player;

	public TurnActionState(Turn turn) {
		this.turn = turn;
		this.player = turn.player;
	}

	@Override
	public void run() {

		while (this.turn.actions > 0) {
			Card card = this.player.playCard();
			this.handleCard(card);
			this.turn.actions--;

		}

		this.turn.state = new TurnBuyState(this.turn);
		this.turn.run();
	}

	private void handleCard(Card card) {

		this.turn.actions += card.getActionsAdded();
		this.turn.buys += card.getBuysAdded();

	}

}
