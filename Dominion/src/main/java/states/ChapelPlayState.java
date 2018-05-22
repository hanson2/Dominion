package states;

import cards.Card;
import gameComponents.Player;
import util.GameConstants;

public class ChapelPlayState extends CardPlayState {

	@Override
	public void run(Turn turn) {
		Player player = turn.player;

		for (int i = 0; i < 4; i++) {
			if (player.promptYesNo("chapelPrompt")) {
				Card toTrash = player.chooseCardFromHand(GameConstants.CHAPELPROMPTKEY);
				player.trashCardFromHand(toTrash.getClass());
			} else {
				break;
			}
		}
	}

}
