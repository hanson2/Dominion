package states;

import cards.Card;
import gameComponents.Player;

public class CellarPlayState extends CardPlayState {

	@Override
	public void run(Turn turn) {
		int numCardsToAdd = 0;
		Player player = turn.player;

		int handSize = player.sizeOfHand();

		while (handSize > 0) {
			if (player.promptYesNo("cellarPrompt")) {
				Card card = player.chooseCardFromHand("guiActionPhase", turn.actions, turn.buys, turn.coins);
				player.discardCardFromHand(card.getClass());
				numCardsToAdd++;
			} else {
				break;
			}
			handSize = player.sizeOfHand();
		}

		for (int i = 0; i < numCardsToAdd; i++) {
			player.drawACard();
		}
	}

}
