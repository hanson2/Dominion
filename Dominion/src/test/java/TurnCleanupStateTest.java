import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

import org.easymock.EasyMock;
import org.junit.Test;

public class TurnCleanupStateTest {

	@Test
	public void testPlayAllCards() {
		Player player = EasyMock.partialMockBuilder(Player.class).withConstructor("John").addMockedMethod("drawNewHand")
				.createMock();
		Turn turn = EasyMock.mock(Turn.class);

		player.drawNewHand();
		turn.playArea = new ArrayList<>();
		player.discardPile = new Stack<>();

		Card[] cardList = new Card[5];
		for (int i = 0; i < 5; ++i) {
			cardList[i] = EasyMock.mock(Card.class);
		}
		turn.playArea.addAll(Arrays.asList(cardList));

		EasyMock.replay(player, turn);
		EasyMock.replay((Object[]) cardList);

		turn.player = player;

		TurnCleanupState state = new TurnCleanupState();

		state.run(turn);

		assertTrue(turn.playArea.isEmpty());
		assertTrue(player.discardPile.containsAll(Arrays.asList(cardList)));

		EasyMock.verify(player, turn);
		EasyMock.verify((Object[]) cardList);
	}

	@Test
	public void testPlaySomeCards() {
		Player player = EasyMock.partialMockBuilder(Player.class).withConstructor("John").addMockedMethod("drawNewHand")
				.createMock();
		Turn turn = EasyMock.mock(Turn.class);

		player.drawNewHand();
		turn.playArea = new ArrayList<>();

		Card[] cardList = new Card[5];
		for (int i = 0; i < 5; ++i) {
			cardList[i] = EasyMock.mock(Card.class);
		}
		turn.playArea.add(cardList[0]);
		turn.playArea.add(cardList[1]);
		for (int i = 2; i < 5; ++i) {
			player.hand.add(cardList[i]);
		}

		EasyMock.replay(player, turn);
		EasyMock.replay((Object[]) cardList);

		turn.player = player;

		TurnCleanupState state = new TurnCleanupState();

		state.run(turn);

		assertTrue(turn.playArea.isEmpty());
		assertTrue(player.discardPile.containsAll(Arrays.asList(cardList)));

		EasyMock.verify(player, turn);
		EasyMock.verify((Object[]) cardList);
	}

	@Test
	public void testPlayNoCards() {
		Player player = EasyMock.partialMockBuilder(Player.class).withConstructor("John").addMockedMethod("drawNewHand")
				.createMock();
		Turn turn = EasyMock.mock(Turn.class);

		player.drawNewHand();

		turn.playArea = new ArrayList<>();

		Card[] cardList = new Card[5];
		for (int i = 0; i < 5; ++i) {
			cardList[i] = EasyMock.mock(Card.class);
		}
		player.hand.addAll(Arrays.asList(cardList));

		EasyMock.replay(player, turn);
		EasyMock.replay((Object[]) cardList);

		turn.player = player;

		TurnCleanupState state = new TurnCleanupState();

		state.run(turn);

		assertTrue(turn.playArea.isEmpty());
		assertTrue(player.discardPile.containsAll(Arrays.asList(cardList)));

		EasyMock.verify(player, turn);
		EasyMock.verify((Object[]) cardList);
	}

}
