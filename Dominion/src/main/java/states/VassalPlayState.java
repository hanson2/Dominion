package states;

import java.util.Optional;

import cards.Card;
import gameComponents.Player;
import util.CardType;

public class VassalPlayState extends CardPlayState {

	@Override
	public void run(Turn turn) {
		Player player = turn.player;
		Optional<Card> cardPossibility = player.discardTopCardOfDrawPile();

		if (!cardPossibility.isPresent()) {
			return;
		} else {
			Card card = cardPossibility.get();
			if (card.getType().contains(CardType.ACTION)) {
				if (player.promptYesNo("vassalPrompt")) {
					turn.state = card.getPlayState();
					turn.run();
				}
			}
		}
	}

}
