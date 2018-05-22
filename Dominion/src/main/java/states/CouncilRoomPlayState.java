package states;

import gameComponents.Player;

public class CouncilRoomPlayState extends CardPlayState {

	public void run(Turn turn) {
		for (Player player2 : turn.subsequentPlayers) {
			player2.drawACard();
		}
	}

}
