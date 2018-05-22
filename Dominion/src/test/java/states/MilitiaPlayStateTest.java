package states;

import java.util.ArrayList;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cards.Copper;
import cards.Moat;
import gameComponents.Player;
import util.GameConstants;

public class MilitiaPlayStateTest {
	Turn turn;
	Player player;
	ArrayList<Player> subsequentPlayers;
	Copper toDiscard;

	@Before
	public void setup() {
		subsequentPlayers = new ArrayList<Player>();
		subsequentPlayers.add(EasyMock.mock(Player.class));
		toDiscard = new Copper();

		turn = new Turn(null, null, subsequentPlayers);
		turn.state = new MilitiaPlayState();
	}

	@After
	public void tearDown() {
		for (Player player2 : subsequentPlayers) {
			EasyMock.verify(player2);
		}
	}

	@Test
	public void testMilitiaStateRespectsMoat() {
		for (Player player2 : subsequentPlayers) {
			EasyMock.expect(player2.hasCardInHand(Moat.class)).andReturn(true);
			EasyMock.expect(player2.promptYesNo(GameConstants.MOATPROMPT)).andReturn(true);
		}

		for (Player player : subsequentPlayers) {
			EasyMock.replay(player);
		}

		turn.run();
	}

	@Test
	public void testMilitiaState2Players() {
		for (Player player2 : subsequentPlayers) {
			EasyMock.expect(player2.hasCardInHand(Moat.class)).andReturn(false);
			EasyMock.expect(player2.sizeOfHand()).andReturn(5);
			EasyMock.expect(player2.chooseCardFromHand(GameConstants.DISCARDPROMPTKEY, 1, 1, 0)).andReturn(toDiscard);
			EasyMock.expect(player2.discardCardFromHand(toDiscard.getClass())).andReturn(true);

			EasyMock.expect(player2.sizeOfHand()).andReturn(4);
			EasyMock.expect(player2.chooseCardFromHand(GameConstants.DISCARDPROMPTKEY, 1, 1, 0)).andReturn(toDiscard);
			EasyMock.expect(player2.discardCardFromHand(toDiscard.getClass())).andReturn(true);

			EasyMock.expect(player2.sizeOfHand()).andReturn(3);
		}

		for (Player player : subsequentPlayers) {
			EasyMock.replay(player);
		}

		turn.run();

	}

	@Test
	public void testMilitiaState3Players() {
		subsequentPlayers.add(EasyMock.mock(Player.class));

		for (Player player2 : subsequentPlayers) {
			EasyMock.expect(player2.hasCardInHand(Moat.class)).andReturn(false);
			EasyMock.expect(player2.sizeOfHand()).andReturn(5);
			EasyMock.expect(player2.chooseCardFromHand(GameConstants.DISCARDPROMPTKEY, 1, 1, 0)).andReturn(toDiscard);
			EasyMock.expect(player2.discardCardFromHand(toDiscard.getClass())).andReturn(true);

			EasyMock.expect(player2.sizeOfHand()).andReturn(4);
			EasyMock.expect(player2.chooseCardFromHand(GameConstants.DISCARDPROMPTKEY, 1, 1, 0)).andReturn(toDiscard);
			EasyMock.expect(player2.discardCardFromHand(toDiscard.getClass())).andReturn(true);

			EasyMock.expect(player2.sizeOfHand()).andReturn(3);
		}

		for (Player player : subsequentPlayers) {
			EasyMock.replay(player);
		}

		turn.run();

	}

	@Test
	public void testMilitiaState4Players() {
		subsequentPlayers.add(EasyMock.mock(Player.class));
		subsequentPlayers.add(EasyMock.mock(Player.class));

		for (Player player2 : subsequentPlayers) {
			EasyMock.expect(player2.hasCardInHand(Moat.class)).andReturn(false);
			EasyMock.expect(player2.sizeOfHand()).andReturn(5);
			EasyMock.expect(player2.chooseCardFromHand(GameConstants.DISCARDPROMPTKEY, 1, 1, 0)).andReturn(toDiscard);
			EasyMock.expect(player2.discardCardFromHand(toDiscard.getClass())).andReturn(true);

			EasyMock.expect(player2.sizeOfHand()).andReturn(4);
			EasyMock.expect(player2.chooseCardFromHand(GameConstants.DISCARDPROMPTKEY, 1, 1, 0)).andReturn(toDiscard);
			EasyMock.expect(player2.discardCardFromHand(toDiscard.getClass())).andReturn(true);

			EasyMock.expect(player2.sizeOfHand()).andReturn(3);
		}

		for (Player player : subsequentPlayers) {
			EasyMock.replay(player);
		}

		turn.run();

	}

	@Test
	public void testMilitiaStateLessThan3Cards() {
		for (Player player2 : subsequentPlayers) {
			EasyMock.expect(player2.hasCardInHand(Moat.class)).andReturn(false);
			EasyMock.expect(player2.sizeOfHand()).andReturn(2);
		}

		for (Player player : subsequentPlayers) {
			EasyMock.replay(player);
		}

		turn.run();

	}

	@Test
	public void testMilitiaStateAExactly3Cards() {
		for (Player player2 : subsequentPlayers) {
			EasyMock.expect(player2.hasCardInHand(Moat.class)).andReturn(false);
			EasyMock.expect(player2.sizeOfHand()).andReturn(3);
		}

		for (Player player : subsequentPlayers) {
			EasyMock.replay(player);
		}

		turn.run();

	}
}
