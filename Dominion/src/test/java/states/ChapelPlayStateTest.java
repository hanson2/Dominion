package states;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cards.Card;
import cards.Copper;
import gameComponents.Player;
import util.GameConstants;

public class ChapelPlayStateTest {

	Player player;
	Turn turn;
	ChapelPlayState state;

	@Before
	public void setup() {
		player = EasyMock.mock(Player.class);
		turn = EasyMock.mock(Turn.class);
		state = new ChapelPlayState();
	}

	@After
	public void tearDown() {
		EasyMock.verify(player, turn);
	}

	@Test
	public void testTrashNoCards() {
		turn.player = player;
		turn.state = state;

		EasyMock.expect(player.sizeOfHand()).andReturn(5);
		EasyMock.expect(player.promptYesNo("chapelPrompt")).andReturn(false);

		EasyMock.replay(player, turn);

		state.run(turn);
	}

	@Test
	public void testTrashOneCard() {
		Card cardToTrash = new Copper();
		turn.player = player;
		turn.state = state;

		EasyMock.expect(player.sizeOfHand()).andReturn(5);
		EasyMock.expect(player.promptYesNo("chapelPrompt")).andReturn(true);
		EasyMock.expect(player.chooseCardFromHand(GameConstants.CHAPELPROMPTKEY, turn.actions, turn.buys, turn.coins))
				.andReturn(cardToTrash);
		EasyMock.expect(player.trashCardFromHand(cardToTrash.getClass())).andReturn(true);

		EasyMock.expect(player.sizeOfHand()).andReturn(4);
		EasyMock.expect(player.promptYesNo("chapelPrompt")).andReturn(false);

		EasyMock.replay(player, turn);

		state.run(turn);
	}

	@Test
	public void testTrashTwoCards() {
		Card cardToTrash = new Copper();
		turn.player = player;
		turn.state = state;

		EasyMock.expect(player.sizeOfHand()).andReturn(5);
		EasyMock.expect(player.promptYesNo("chapelPrompt")).andReturn(true);
		EasyMock.expect(player.chooseCardFromHand(GameConstants.CHAPELPROMPTKEY, turn.actions, turn.buys, turn.coins))
				.andReturn(cardToTrash);
		EasyMock.expect(player.trashCardFromHand(cardToTrash.getClass())).andReturn(true);

		EasyMock.expect(player.sizeOfHand()).andReturn(4);
		EasyMock.expect(player.promptYesNo("chapelPrompt")).andReturn(true);
		EasyMock.expect(player.chooseCardFromHand(GameConstants.CHAPELPROMPTKEY, turn.actions, turn.buys, turn.coins))
				.andReturn(cardToTrash);
		EasyMock.expect(player.trashCardFromHand(cardToTrash.getClass())).andReturn(true);

		EasyMock.expect(player.sizeOfHand()).andReturn(3);
		EasyMock.expect(player.promptYesNo("chapelPrompt")).andReturn(false);

		EasyMock.replay(player, turn);

		state.run(turn);
	}

	@Test
	public void testTrashThreeCards() {
		Card cardToTrash = new Copper();
		turn.player = player;
		turn.state = state;

		EasyMock.expect(player.sizeOfHand()).andReturn(5);
		EasyMock.expect(player.promptYesNo("chapelPrompt")).andReturn(true);
		EasyMock.expect(player.chooseCardFromHand(GameConstants.CHAPELPROMPTKEY, turn.actions, turn.buys, turn.coins))
				.andReturn(cardToTrash);
		EasyMock.expect(player.trashCardFromHand(cardToTrash.getClass())).andReturn(true);

		EasyMock.expect(player.sizeOfHand()).andReturn(4);
		EasyMock.expect(player.promptYesNo("chapelPrompt")).andReturn(true);
		EasyMock.expect(player.chooseCardFromHand(GameConstants.CHAPELPROMPTKEY, turn.actions, turn.buys, turn.coins))
				.andReturn(cardToTrash);
		EasyMock.expect(player.trashCardFromHand(cardToTrash.getClass())).andReturn(true);

		EasyMock.expect(player.sizeOfHand()).andReturn(3);
		EasyMock.expect(player.promptYesNo("chapelPrompt")).andReturn(true);
		EasyMock.expect(player.chooseCardFromHand(GameConstants.CHAPELPROMPTKEY, turn.actions, turn.buys, turn.coins))
				.andReturn(cardToTrash);
		EasyMock.expect(player.trashCardFromHand(cardToTrash.getClass())).andReturn(true);

		EasyMock.expect(player.sizeOfHand()).andReturn(2);
		EasyMock.expect(player.promptYesNo("chapelPrompt")).andReturn(false);

		EasyMock.replay(player, turn);

		state.run(turn);
	}

	@Test
	public void testTrashFourCards() {
		Card cardToTrash = new Copper();
		turn.player = player;
		turn.state = state;

		EasyMock.expect(player.sizeOfHand()).andReturn(5);
		EasyMock.expect(player.promptYesNo("chapelPrompt")).andReturn(true);
		EasyMock.expect(player.chooseCardFromHand(GameConstants.CHAPELPROMPTKEY, turn.actions, turn.buys, turn.coins))
				.andReturn(cardToTrash);
		EasyMock.expect(player.trashCardFromHand(cardToTrash.getClass())).andReturn(true);

		EasyMock.expect(player.sizeOfHand()).andReturn(4);
		EasyMock.expect(player.promptYesNo("chapelPrompt")).andReturn(true);
		EasyMock.expect(player.chooseCardFromHand(GameConstants.CHAPELPROMPTKEY, turn.actions, turn.buys, turn.coins))
				.andReturn(cardToTrash);
		EasyMock.expect(player.trashCardFromHand(cardToTrash.getClass())).andReturn(true);

		EasyMock.expect(player.sizeOfHand()).andReturn(3);
		EasyMock.expect(player.promptYesNo("chapelPrompt")).andReturn(true);
		EasyMock.expect(player.chooseCardFromHand(GameConstants.CHAPELPROMPTKEY, turn.actions, turn.buys, turn.coins))
				.andReturn(cardToTrash);
		EasyMock.expect(player.trashCardFromHand(cardToTrash.getClass())).andReturn(true);

		EasyMock.expect(player.sizeOfHand()).andReturn(2);
		EasyMock.expect(player.promptYesNo("chapelPrompt")).andReturn(true);
		EasyMock.expect(player.chooseCardFromHand(GameConstants.CHAPELPROMPTKEY, turn.actions, turn.buys, turn.coins))
				.andReturn(cardToTrash);
		EasyMock.expect(player.trashCardFromHand(cardToTrash.getClass())).andReturn(true);

		EasyMock.replay(player, turn);

		state.run(turn);
	}

	@Test
	public void testTrashRunOutOfCards() {
		Card cardToTrash = new Copper();
		turn.player = player;
		turn.state = state;

		EasyMock.expect(player.sizeOfHand()).andReturn(1);
		EasyMock.expect(player.promptYesNo("chapelPrompt")).andReturn(true);
		EasyMock.expect(player.chooseCardFromHand(GameConstants.CHAPELPROMPTKEY, turn.actions, turn.buys, turn.coins))
				.andReturn(cardToTrash);
		EasyMock.expect(player.trashCardFromHand(cardToTrash.getClass())).andReturn(true);

		EasyMock.expect(player.sizeOfHand()).andReturn(0);

		EasyMock.replay(player, turn);

		state.run(turn);
	}

}
