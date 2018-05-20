import java.util.Optional;

public class WorkshopPlayState extends CardPlayState {

	public void run(Turn turn) {

		int coins = 4;
		Card card = null;
		while (true) {
			card = turn.player.forcedBuy(coins);

			if (card.getCost() <= coins) {
				turn.player.gainCard(card);
				break;
			}
		}

	}
}
