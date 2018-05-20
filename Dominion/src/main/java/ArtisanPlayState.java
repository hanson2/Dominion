import java.util.Optional;

public class ArtisanPlayState extends CardPlayState {
	public void run(Turn turn) {
		int coins = 5;
		Card card = null;
		while (true) {
			card = turn.player.forcedBuy(coins);

			if (card.getCost() <= coins) {
				turn.player.gainCardToHand(card);
				break;
			}

		}
		card = turn.player.chooseCardFromHand();
		turn.player.placeOnDrawPile(card);
		turn.player.trashCardFromHand(card.getClass());

	}
}
