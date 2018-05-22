package states;

import gameComponents.Player;
import gameComponents.Supply;

public class TurnCreator {

	public static Player getPlayer(Turn turn) {
		return turn.player;
	}

	public static Supply getSupply(Turn turn) {
		return turn.supplyPiles;
	}

}
