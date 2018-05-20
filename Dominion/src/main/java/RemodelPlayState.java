import java.util.Optional;

public class RemodelPlayState extends CardPlayState {

	@Override
	public void run(Turn turn) {
		Card card = turn.player.chooseCardFromHand();
		turn.player.trashCardFromHand(card.getClass());
		int coins = card.getCost() + 2;

		while (true) {
			card = turn.player.forcedBuy(coins);
			if (card.getCost() <= coins) {
				turn.player.gainCard(card);
				break;
			}

		}
	}

}