import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Stack;

import org.easymock.EasyMock;
import org.junit.Test;

public class TurnCleanupStateTest {

	@Test
	public void testTurnPlayedCard() {
		Player player = EasyMock.mock(Player.class);
		Turn turn = EasyMock.mock(Turn.class);

		player.discardHand();
		player.drawNewHand();
		turn.playArea = new ArrayList<Card>();
		player.discardPile = new Stack<>();

		Card playedCard = EasyMock.mock(Card.class);
		turn.playArea.add(playedCard);

		EasyMock.replay(player, turn, playedCard);

		turn.player = player;// base value

		TurnCleanupState state = new TurnCleanupState();

		state.run(turn);

		assertTrue(turn.playArea.isEmpty());
		assertTrue(player.discardPile.contains(playedCard));

		EasyMock.verify(player, turn, playedCard);
	}

}
