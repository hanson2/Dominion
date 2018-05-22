package states;

import cards.Gold;

public class BanditPlayState extends CardPlayState {
	public void run(Turn turn) {
		turn.supplyPiles.decrementPile(new Gold());
		turn.player.gainCard(new Gold());
		// TODO rebase to when we get turn.subsequentPlayers
	}
}
