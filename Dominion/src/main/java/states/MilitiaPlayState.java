package states;

import cards.Card;
import cards.Moat;
import gameComponents.Player;
import util.GameConstants;

public class MilitiaPlayState extends CardPlayState {

	public void run(Turn turn) {
		for (Player player : turn.subsequentPlayers) {
			boolean ignore = false;
			if (player.hasCardInHand(Moat.class)) {
				ignore = player.promptYesNo(GameConstants.MOATPROMPT);
			}
			while (!ignore && player.getHandSize() > 3) {
				Card card = player.chooseCardFromHand(GameConstants.DISCARDPROMPTKEY, turn.actions, turn.buys,
						turn.coins);
				player.discardCardFromHand(card.getClass());
			}
		}

	}
}
