
public class TurnActionState extends TurnState {

	private Turn turn;
	private Player player;

	@Override
	public void run(Turn turn) {
		this.turn = turn;
		this.player = turn.player;

		while (this.turn.actions > 0) {
			Card card = this.player.chooseCardToPlay().get();
			this.handleCard(card);
			if (card.getType().contains(CardType.ACTION)) {
				this.turn.actions--;
			}

		}

		this.turn.state = new TurnBuyState();
		this.turn.run();
	}

	private void handleCard(Card card) {

		this.turn.actions += card.getActionsAdded();
		this.turn.buys += card.getBuysAdded();
		this.turn.coins += card.getCoinsAdded();
		this.turn.playArea.add(card);
		
		this.turn.state = card.getPlayState();
		this.turn.run();

	}

}
