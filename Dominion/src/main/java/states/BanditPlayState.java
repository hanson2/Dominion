package states;

import java.util.ArrayList;

import cards.Card;
import cards.Copper;
import cards.Gold;
import gameComponents.Player;
import util.CardType;
import util.GameConstants;

public class BanditPlayState extends CardPlayState {
	public void run(Turn turn) {
		turn.player.gainCard(new Gold(), turn.supplyPiles);
		for (Player player2 : turn.subsequentPlayers) {
			Card card1 = player2.drawACardAndReturn();
			Card card2 = player2.drawACardAndReturn();
			if (this.isCurrencyNotCopper(card1) && this.isCurrencyNotCopper(card2)) {
				ArrayList<Card> list = new ArrayList<Card>();
				list.add(card2);
				list.add(card1);
				list.remove(player2.chooseCardFromSelection(list, GameConstants.BANDITPROMPT));
				player2.gainCardToHand(list.get(0));
				player2.discardCardFromHand(list.get(0).getClass());
			} else if (this.isCurrencyNotCopper(card1)) {
				player2.gainCardToHand(card2);
				player2.discardCardFromHand(card2.getClass());
			} else if (this.isCurrencyNotCopper(card2)) {
				player2.gainCardToHand(card1);
				player2.discardCardFromHand(card1.getClass());
			} else {
				player2.gainCardToHand(card1);
				player2.discardCardFromHand(card1.getClass());
				player2.gainCardToHand(card2);
				player2.discardCardFromHand(card2.getClass());
			}
		}
	}

	private boolean isCurrencyNotCopper(Card card) {
		return !card.getClass().equals(Copper.class) && card.getType().contains(CardType.TREASURE);
	}
}
