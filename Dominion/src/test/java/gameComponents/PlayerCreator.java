package gameComponents;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

import org.easymock.EasyMock;

import cards.Card;

public class PlayerCreator {

	public static Player makeMockedPlayer() {
		Player player = EasyMock.mock(Player.class);
		player.discardPile = new Stack<>();
		player.hand = new ArrayList<>();
		return player;
	}

	public static void addToHand(Player player, Card... cards) {
		player.hand.addAll(Arrays.asList(cards));
	}

}
