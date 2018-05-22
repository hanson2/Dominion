package states;

import cards.Card;
import cards.Moat;
import gameComponents.Player;
import util.GameConstants;

public class MilitiaPlayState extends CardPlayState {

	public void run(Turn turn) {
		while (turn.player.getHandSize() > 3) {
			Card card = turn.player.chooseCardFromHand(GameConstants.DISCARDPROMPTKEY);
			turn.player.discardCardFromHand(card.getClass());
		}
		for (Player player : turn.subsequentPlayers) {
			boolean ignore = false;
			if (player.hasCardInHand(Moat.class)) {
				ignore = player.promptYesNo(GameConstants.MOATPROMPT);
			}
			while (player.getHandSize() > 3 && !ignore) {
				Card card = player.chooseCardFromHand(GameConstants.DISCARDPROMPTKEY);
				player.discardCardFromHand(card.getClass());
			}
		}

	}
}
