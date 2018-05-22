package states;

import cards.Card;
import gameComponents.Player;
import util.GameConstants;

public class MilitiaPlayState extends CardPlayState {

	public void run(Turn turn) {
		while (turn.player.getHandSize() > 3) {
			Card card = turn.player.chooseCardFromHand(GameConstants.MILITIAPROMPTKEY);
			turn.player.discardCardFromHand(card.getClass());
		}
		for (Player player : turn.subsequentPlayers) {
			while (player.getHandSize() > 3) {
				Card card = player.chooseCardFromHand(GameConstants.MILITIAPROMPTKEY);
				player.discardCardFromHand(card.getClass());
			}
		}

	}
}
