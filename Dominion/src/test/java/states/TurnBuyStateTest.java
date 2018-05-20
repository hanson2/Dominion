package states;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.easymock.EasyMock;
import org.junit.Test;

import cards.Card;
import gameComponents.Player;

public class TurnBuyStateTest {
	@Test
	public void testTurnBuyStateBase() {
		Player player = EasyMock.mock(Player.class);
		Turn turn = EasyMock.mock(Turn.class);
		Card card = EasyMock.mock(Card.class);

		EasyMock.expect(card.getCost()).andReturn(1).anyTimes();

		EasyMock.expect(player.buy()).andReturn(Optional.of(card));
		player.gainCard(card);

		turn.run();

		EasyMock.replay(player, turn, card);

		turn.buys = 1;
		turn.coins = 1;
		turn.player = player;

		TurnBuyState state = new TurnBuyState();

		state.run(turn);

		assertEquals(turn.coins, 0);
		assertEquals(turn.buys, 0);

		EasyMock.verify(player, turn, card);
	}

	@Test
	public void testTurnBuyStateMultipleBuys() {
		Player player = EasyMock.mock(Player.class);
		Turn turn = EasyMock.mock(Turn.class);
		Card card = EasyMock.mock(Card.class);

		EasyMock.expect(card.getCost()).andReturn(1).anyTimes();

		EasyMock.expect(player.buy()).andReturn(Optional.of(card));
		player.gainCard(card);

		EasyMock.expect(player.buy()).andReturn(Optional.of(card));
		player.gainCard(card);

		turn.run();

		EasyMock.replay(player, turn, card);

		turn.buys = 2;
		turn.coins = 2;
		turn.player = player;

		TurnBuyState state = new TurnBuyState();

		state.run(turn);

		assertEquals(turn.coins, 0);
		assertEquals(turn.buys, 0);

		EasyMock.verify(player, turn, card);
	}

	@Test
	public void testTurnBuyStateExitBuyEarly() {
		Player player = EasyMock.mock(Player.class);
		Turn turn = EasyMock.mock(Turn.class);

		EasyMock.expect(player.buy()).andReturn(Optional.empty());

		turn.run();

		EasyMock.replay(player, turn);

		turn.buys = 2;
		turn.player = player;

		TurnBuyState state = new TurnBuyState();

		state.run(turn);

		EasyMock.verify(player, turn);
	}

	@Test
	public void testBuyNotEnoughCoins() {
		Player player = EasyMock.mock(Player.class);
		Turn turn = EasyMock.mock(Turn.class);
		Card card = EasyMock.mock(Card.class);

		EasyMock.expect(player.buy()).andReturn(Optional.of(card));
		EasyMock.expect(card.getCost()).andReturn(10);

		EasyMock.expect(player.buy()).andReturn(Optional.empty());

		turn.run();

		EasyMock.replay(player, turn, card);

		turn.buys = 1;
		turn.coins = 1;
		turn.player = player;

		TurnBuyState state = new TurnBuyState();

		state.run(turn);

		assertEquals(turn.coins, 1);
		assertEquals(turn.buys, 1);

		EasyMock.verify(player, turn, card);

	}
}
