import java.util.Optional;

public class ArtisanPlayState extends CardPlayState {
	public void run(Turn turn){
		int coins = 5;
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
		card = turn.player.chooseCardFromHand();
		turn.player.drawPile.push(card);
		turn.player.trashCardFromHand(card.getClass());

	}
}
