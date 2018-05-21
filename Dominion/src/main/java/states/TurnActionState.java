package states;

import java.util.Optional;

import cards.Card;
import gameComponents.Player;
import util.CardType;

public class TurnActionState extends TurnState {

	private Turn turn;
	private Player player;

	@Override
	public void run(Turn turn) {
		this.turn = turn;
		this.player = turn.player;

		while (true) {
			Optional<Card> potentialCard = this.player.chooseCardToPlay();
			if (potentialCard.isPresent()) {
				Card card = potentialCard.get();
				if (card.getType().contains(CardType.ACTION)) {
					if (this.turn.actions > 0) {
						this.handleCard(card);
						this.turn.actions--;
					}

				} else {
					this.handleCard(card);
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
		for (int i = 0; i < card.getCardsAdded(); i++) {
			this.player.drawACard();
		}

		this.player.discardCardFromHand(card.getClass());
		this.turn.state = card.getPlayState();
		this.turn.run();

	}

}
