import static org.junit.Assert.*;

import org.easymock.EasyMock;
import org.junit.Test;

public class MoneylenderPlayStateTest {

	@Test
	public void testPlayStateDoActionCopperInHandYes() {
		Player player = EasyMock.partialMockBuilder(Player.class).withConstructor("test").addMockedMethod("promptYesNo")
				.createMock();
		Turn turn = EasyMock.mock(Turn.class);
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
		Player player = EasyMock.partialMockBuilder(Player.class).withConstructor("test").addMockedMethod("promptYesNo")
				.createMock();
		Turn turn = EasyMock.mock(Turn.class);
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
		Player player = EasyMock.partialMockBuilder(Player.class).withConstructor("test").addMockedMethod("promptYesNo")
				.createMock();
		Turn turn = EasyMock.mock(Turn.class);
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
		Player player = EasyMock.partialMockBuilder(Player.class).withConstructor("test").addMockedMethod("promptYesNo")
				.createMock();
		Turn turn = EasyMock.mock(Turn.class);

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
