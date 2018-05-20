package states;

import java.util.Optional;

import cards.Card;
import gameComponents.Player;

public class TurnBuyState extends TurnState {

	private Turn turn;
	private Player player;

	@Override
	public void run(Turn turn) {
		this.turn = turn;
		this.player = turn.player;

		while (this.turn.buys > 0) {
			Optional<Card> possiblyBoughtCard = this.player.buy(this.turn.supplyPiles);
			if (!possiblyBoughtCard.isPresent()) {
				break;
			}
			Card card = possiblyBoughtCard.get();
			if (card.getCost() <= this.turn.coins) {
				this.turn.buys--;
				this.turn.coins -= card.getCost();
				this.player.gainCard(card);
			}
		}

		this.turn.state = new TurnCleanupState();
		this.turn.run();
	}

}
