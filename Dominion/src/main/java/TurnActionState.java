import java.util.Optional;

public class TurnActionState extends TurnState {

	private Turn turn;
	private Player player;

	@Override
	public void run(Turn turn) {
		this.turn = turn;
		this.player = turn.player;

		while (this.turn.actions > 0) {
			Optional<Card> potentialCard = this.player.chooseCardToPlay();
			if(potentialCard.isPresent()) {
				Card card = potentialCard.get();
				this.handleCard(card);
				if (card.getType().contains(CardType.ACTION)) {
					this.turn.actions--;
				}
			} else {
				break;
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
