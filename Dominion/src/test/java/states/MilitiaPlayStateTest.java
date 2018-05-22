package states;

import java.util.ArrayList;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cards.Copper;
import gameComponents.Player;
import util.GameConstants;

public class MilitiaPlayStateTest {
	Turn turn;
	Player player;
	ArrayList<Player> subsequentPlayers;
	Copper toDiscard;

	@Before
	public void setup() {
		player = EasyMock.mock(Player.class);
		subsequentPlayers = new ArrayList<Player>();
		subsequentPlayers.add(EasyMock.mock(Player.class));
		toDiscard = new Copper();

		turn = new Turn(player, null, subsequentPlayers);
		turn.state = new MilitiaPlayState();
	}

	@After
	public void tearDown() {
		EasyMock.verify(player);
		for (Player player2 : subsequentPlayers) {
			EasyMock.verify(player2);
		}
	}

	@Test
	public void testMilitiaState2Players() {

		EasyMock.expect(player.getHandSize()).andReturn(5);
		EasyMock.expect(player.chooseCardFromHand(GameConstants.DISCARDPROMPTKEY)).andReturn(toDiscard);
		EasyMock.expect(player.discardCardFromHand(toDiscard.getClass())).andReturn(true);

		EasyMock.expect(player.getHandSize()).andReturn(4);
		EasyMock.expect(player.chooseCardFromHand(GameConstants.DISCARDPROMPTKEY)).andReturn(toDiscard);
		EasyMock.expect(player.discardCardFromHand(toDiscard.getClass())).andReturn(true);

		EasyMock.expect(player.getHandSize()).andReturn(3);

		for (Player player2 : subsequentPlayers) {
			EasyMock.expect(player2.getHandSize()).andReturn(5);
			EasyMock.expect(player2.chooseCardFromHand(GameConstants.DISCARDPROMPTKEY)).andReturn(toDiscard);
			EasyMock.expect(player2.discardCardFromHand(toDiscard.getClass())).andReturn(true);

			EasyMock.expect(player2.getHandSize()).andReturn(4);
			EasyMock.expect(player2.chooseCardFromHand(GameConstants.DISCARDPROMPTKEY)).andReturn(toDiscard);
			EasyMock.expect(player2.discardCardFromHand(toDiscard.getClass())).andReturn(true);

			EasyMock.expect(player2.getHandSize()).andReturn(3);
		}

		EasyMock.replay(player);
		for (Player player : subsequentPlayers) {
			EasyMock.replay(player);
		}

		turn.run();

	}

	@Test
	public void testMilitiaState3Players() {
		subsequentPlayers.add(EasyMock.mock(Player.class));

		EasyMock.expect(player.getHandSize()).andReturn(5);
		EasyMock.expect(player.chooseCardFromHand(GameConstants.DISCARDPROMPTKEY)).andReturn(toDiscard);
		EasyMock.expect(player.discardCardFromHand(toDiscard.getClass())).andReturn(true);

		EasyMock.expect(player.getHandSize()).andReturn(4);
		EasyMock.expect(player.chooseCardFromHand(GameConstants.DISCARDPROMPTKEY)).andReturn(toDiscard);
		EasyMock.expect(player.discardCardFromHand(toDiscard.getClass())).andReturn(true);

		EasyMock.expect(player.getHandSize()).andReturn(3);

		for (Player player2 : subsequentPlayers) {
			EasyMock.expect(player2.getHandSize()).andReturn(5);
			EasyMock.expect(player2.chooseCardFromHand(GameConstants.DISCARDPROMPTKEY)).andReturn(toDiscard);
			EasyMock.expect(player2.discardCardFromHand(toDiscard.getClass())).andReturn(true);

			EasyMock.expect(player2.getHandSize()).andReturn(4);
			EasyMock.expect(player2.chooseCardFromHand(GameConstants.DISCARDPROMPTKEY)).andReturn(toDiscard);
			EasyMock.expect(player2.discardCardFromHand(toDiscard.getClass())).andReturn(true);

			EasyMock.expect(player2.getHandSize()).andReturn(3);
		}

		EasyMock.replay(player);
		for (Player player : subsequentPlayers) {
			EasyMock.replay(player);
		}

		turn.run();

	}

	@Test
	public void testMilitiaState4Players() {
		subsequentPlayers.add(EasyMock.mock(Player.class));
		subsequentPlayers.add(EasyMock.mock(Player.class));

		EasyMock.expect(player.getHandSize()).andReturn(5);
		EasyMock.expect(player.chooseCardFromHand(GameConstants.DISCARDPROMPTKEY)).andReturn(toDiscard);
		EasyMock.expect(player.discardCardFromHand(toDiscard.getClass())).andReturn(true);

		EasyMock.expect(player.getHandSize()).andReturn(4);
		EasyMock.expect(player.chooseCardFromHand(GameConstants.DISCARDPROMPTKEY)).andReturn(toDiscard);
		EasyMock.expect(player.discardCardFromHand(toDiscard.getClass())).andReturn(true);

		EasyMock.expect(player.getHandSize()).andReturn(3);

		for (Player player2 : subsequentPlayers) {
			EasyMock.expect(player2.getHandSize()).andReturn(5);
			EasyMock.expect(player2.chooseCardFromHand(GameConstants.DISCARDPROMPTKEY)).andReturn(toDiscard);
			EasyMock.expect(player2.discardCardFromHand(toDiscard.getClass())).andReturn(true);

			EasyMock.expect(player2.getHandSize()).andReturn(4);
			EasyMock.expect(player2.chooseCardFromHand(GameConstants.DISCARDPROMPTKEY)).andReturn(toDiscard);
			EasyMock.expect(player2.discardCardFromHand(toDiscard.getClass())).andReturn(true);

			EasyMock.expect(player2.getHandSize()).andReturn(3);
		}

		EasyMock.replay(player);
		for (Player player : subsequentPlayers) {
			EasyMock.replay(player);
		}

		turn.run();

	}

	@Test
	public void testMilitiaStateLessThan3Cards() {
		EasyMock.expect(player.getHandSize()).andReturn(2);

		for (Player player2 : subsequentPlayers) {
			EasyMock.expect(player2.getHandSize()).andReturn(2);
		}

		EasyMock.replay(player);
		for (Player player : subsequentPlayers) {
			EasyMock.replay(player);
		}

		turn.run();

	}

	@Test
	public void testMilitiaStateAExactly3Cards() {
		EasyMock.expect(player.getHandSize()).andReturn(3);

		for (Player player2 : subsequentPlayers) {
			EasyMock.expect(player2.getHandSize()).andReturn(3);
		}

		EasyMock.replay(player);
		for (Player player : subsequentPlayers) {
			EasyMock.replay(player);
		}

		turn.run();

	}
}
