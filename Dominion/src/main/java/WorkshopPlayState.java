import java.util.Optional;

public class WorkshopPlayState extends CardPlayState {

	public void run(Turn turn) {

		int coins = 4;
		Card card = null;
		while (true) {
			Optional<Card> possiblyBoughtCard = turn.player.buy();
			if (possiblyBoughtCard.isPresent()) {
				card = possiblyBoughtCard.get();
				if (card.getCost() <= coins) {
					turn.player.gainCard(card);
					break;
				}
			}
		}

	}
}
