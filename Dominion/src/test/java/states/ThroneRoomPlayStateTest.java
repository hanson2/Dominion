package states;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.easymock.EasyMock;
import org.junit.Test;

import cards.Card;
import gameComponents.Player;
import util.CardType;

public class ThroneRoomPlayStateTest {

	@Test
	public void testDoNotUse() {
		ThroneRoomPlayState state = new ThroneRoomPlayState();
		Player player = EasyMock.mock(Player.class);
		Turn turn = EasyMock.mock(Turn.class);
		turn.player = player;
		turn.state = state;

		EasyMock.expect(player.promptYesNo("throneroomPrompt")).andReturn(false);

		EasyMock.replay(player, turn);

		state.run(turn);

		assertEquals(turn.state.getClass(), state.getClass());

		EasyMock.verify(player, turn);
	}

	@Test
	public void testUseNonAction() {
		ThroneRoomPlayState state = new ThroneRoomPlayState();
		Set<CardType> cardType = new HashSet<CardType>();
		cardType.add(CardType.TREASURE);
		Player player = EasyMock.mock(Player.class);
		Turn turn = EasyMock.mock(Turn.class);
		Card card = EasyMock.mock(Card.class);
		turn.player = player;
		turn.state = state;

		EasyMock.expect(player.promptYesNo("throneroomPrompt")).andReturn(true);
		EasyMock.expect(player.chooseCardFromHand("guiActionPhase", turn.actions, turn.buys, turn.coins))
				.andReturn(card);
		EasyMock.expect(card.getType()).andReturn(cardType);

		EasyMock.replay(player, turn, card);

		state.run(turn);

		assertEquals(turn.state.getClass(), state.getClass());

		EasyMock.verify(player, turn, card);
	}

	@Test
	public void testUseAction() {
		ThroneRoomPlayState state = new ThroneRoomPlayState();
		Set<CardType> cardType = new HashSet<CardType>();
		cardType.add(CardType.ACTION);
		Player player = EasyMock.mock(Player.class);
		Turn turn = EasyMock.mock(Turn.class);
		Card card = EasyMock.mock(Card.class);
		turn.player = player;
		turn.state = state;

		EasyMock.expect(player.promptYesNo("throneroomPrompt")).andReturn(true);
		EasyMock.expect(player.chooseCardFromHand("guiActionPhase", turn.actions, turn.buys, turn.coins))
				.andReturn(card);
		EasyMock.expect(card.getType()).andReturn(cardType);
		EasyMock.expect(card.getPlayState()).andReturn(new CardPlayState());
		turn.run();
		EasyMock.expectLastCall();
		turn.run();
		EasyMock.expectLastCall();

		EasyMock.expect(card.getPlayState()).andReturn(new CardPlayState());
		EasyMock.replay(player, turn, card);

		state.run(turn);

		assertEquals(turn.state.getClass(), card.getPlayState().getClass());

		EasyMock.verify(player, turn, card);
	}

}
