package states;

import static org.junit.Assert.assertEquals;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cards.Copper;
import cards.Silver;
import gameComponents.GUI;
import gameComponents.Player;

public class MoneylenderPlayStateTest {
	
	Player player;
	Turn turn;
	GUI gui;
	
	@Before
	public void setup() {
		gui = EasyMock.mock(GUI.class);
		player = EasyMock.partialMockBuilder(Player.class).withConstructor("test", gui).addMockedMethod("promptYesNo")
				.createMock();
		turn = EasyMock.mock(Turn.class);
	}
	
	@After
	public void tearDown() {
		EasyMock.replay(gui);
		EasyMock.verify(gui);
	}

	@Test
	public void testPlayStateDoActionCopperInHandYes() {
		player.drawNewHand();

		EasyMock.expect(player.promptYesNo("moneylenderPrompt")).andReturn(true);

		EasyMock.replay(player, turn);

		turn.player = player;

		MoneylenderPlayState state = new MoneylenderPlayState();

		state.run(turn);

		assertEquals(player.sizeOfHand(), 4);
		assertEquals(turn.coins, 3);

		EasyMock.verify(player, turn);
	}

	@Test
	public void testPlayStateDoActionCopperNotInHandYes() {
		player.gainCard(new Silver());
		player.drawACard();

		EasyMock.expect(player.promptYesNo("moneylenderPrompt")).andReturn(true);

		player.trashCardFromHand(Copper.class);

		EasyMock.replay(player, turn);

		turn.player = player;

		MoneylenderPlayState state = new MoneylenderPlayState();

		state.run(turn);

		assertEquals(player.sizeOfHand(), 1);
		assertEquals(turn.coins, 0);

		EasyMock.verify(player, turn);
	}

	@Test
	public void testPlayStateDoActionCopperInHandNo() {
		player.drawNewHand();

		EasyMock.expect(player.promptYesNo("moneylenderPrompt")).andReturn(false);

		EasyMock.replay(player, turn);

		turn.player = player;

		MoneylenderPlayState state = new MoneylenderPlayState();

		state.run(turn);

		assertEquals(player.sizeOfHand(), 5);
		assertEquals(turn.coins, 0);

		EasyMock.verify(player, turn);
	}

	@Test
	public void testPlayStateDoActionCopperNotInHandNo() {
		EasyMock.expect(player.promptYesNo("moneylenderPrompt")).andReturn(false);

		EasyMock.replay(player, turn);

		turn.player = player;

		MoneylenderPlayState state = new MoneylenderPlayState();

		state.run(turn);

		assertEquals(player.sizeOfHand(), 0);
		assertEquals(turn.coins, 0);

		EasyMock.verify(player, turn);
	}

}
