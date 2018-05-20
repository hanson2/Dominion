package states;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.easymock.EasyMock;
import org.junit.Test;

import cards.Card;
import gameComponents.GUI;
import gameComponents.Player;
import gameComponents.PlayerCreator;

public class TurnCleanupStateTest {

	@Test
	public void testPlayNoCards() {
		GUI gui = EasyMock.mock(GUI.class);
		Player player = PlayerCreator.makeMockedPlayer();
		Turn turn = EasyMock.mock(Turn.class);

		turn.playArea = new ArrayList<>();

		player.cleanup(turn.playArea);

		Card[] cardList = new Card[5];
		for (int i = 0; i < 5; ++i) {
			cardList[i] = EasyMock.mock(Card.class);
		}
		PlayerCreator.addToHand(player, cardList);

		EasyMock.replay(player, turn, gui);
		EasyMock.replay((Object[]) cardList);

		turn.player = player;

		TurnCleanupState state = new TurnCleanupState();

		state.run(turn);

		assertTrue(turn.playArea.isEmpty());

		EasyMock.verify(player, turn, gui);
		EasyMock.verify((Object[]) cardList);
	}

}
