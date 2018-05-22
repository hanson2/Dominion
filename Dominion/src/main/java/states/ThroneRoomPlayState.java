package states;

import cards.Card;
import gameComponents.Player;
import util.CardType;
import util.GameConstants;

public class ThroneRoomPlayState extends CardPlayState {

	@Override
	public void run(Turn turn) {
		Player player = turn.player;

		if (player.promptYesNo("throneroomPrompt")) {
			Card card = player.chooseCardFromHand(GameConstants.THRONEROOMPROMPTKEY);
			if (card.getType().contains(CardType.ACTION)) {
				CardPlayState state = card.getPlayState();
				turn.state = state;
				turn.run();
				turn.run();
			}
		}
	}

}
