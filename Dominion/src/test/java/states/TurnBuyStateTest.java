package states;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.easymock.EasyMock;
import org.junit.Test;

import cards.Card;
import gameComponents.Player;
import gameComponents.Supply;

public class TurnBuyStateTest {
	@Test
	public void testTurnBuyStateBase() {
		Player player = EasyMock.mock(Player.class);
		Turn turn = EasyMock.mock(Turn.class);
		Card card = EasyMock.mock(Card.class);
		Supply supply = EasyMock.mock(Supply.class);

		turn.buys = 1;
		turn.coins = 1;
		turn.player = player;
		turn.supplyPiles = supply;

		EasyMock.expect(card.getCost()).andReturn(1).anyTimes();

		EasyMock.expect(player.buy(supply, "guiBuyPhase", turn.actions, turn.buys, turn.coins))
				.andReturn(Optional.of(card));
		player.gainCard(card);
		supply.decrementPile(card);

		turn.run();

		EasyMock.replay(player, turn, card, supply);

		TurnBuyState state = new TurnBuyState();

		state.run(turn);

		assertEquals(turn.coins, 0);
		assertEquals(turn.buys, 0);

		EasyMock.verify(player, turn, card, supply);
	}

	@Test
	public void testTurnBuyStateMultipleBuys() {
		Player player = EasyMock.mock(Player.class);
		Turn turn = EasyMock.mock(Turn.class);
		Card card = EasyMock.mock(Card.class);
		Supply supply = EasyMock.mock(Supply.class);

		turn.buys = 2;
		turn.coins = 2;

		EasyMock.expect(card.getCost()).andReturn(1).anyTimes();

		EasyMock.expect(player.buy(supply, "guiBuyPhase", turn.actions, turn.buys, turn.coins))
				.andReturn(Optional.of(card));
		player.gainCard(card);
		supply.decrementPile(card);

		EasyMock.expect(player.buy(supply, "guiBuyPhase", turn.actions, turn.buys - 1, turn.coins - 1))
				.andReturn(Optional.of(card));
		player.gainCard(card);
		supply.decrementPile(card);

		turn.run();

		EasyMock.replay(player, turn, card, supply);

		turn.player = player;
		turn.supplyPiles = supply;

		TurnBuyState state = new TurnBuyState();

		state.run(turn);

		assertEquals(turn.coins, 0);
		assertEquals(turn.buys, 0);

		EasyMock.verify(player, turn, card, supply);
	}

	@Test
	public void testTurnBuyStateExitBuyEarly() {
		Player player = EasyMock.mock(Player.class);
		Turn turn = EasyMock.mock(Turn.class);

		turn.buys = 2;
		turn.player = player;

		EasyMock.expect(player.buy(turn.supplyPiles, "guiBuyPhase", turn.actions, turn.buys, turn.coins))
				.andReturn(Optional.empty());

		turn.run();

		EasyMock.replay(player, turn);

		TurnBuyState state = new TurnBuyState();

		state.run(turn);

		EasyMock.verify(player, turn);
	}

	@Test
	public void testBuyNotEnoughCoins() {
		Player player = EasyMock.mock(Player.class);
		Turn turn = EasyMock.mock(Turn.class);
		Card card = EasyMock.mock(Card.class);

		turn.buys = 1;
		turn.coins = 1;
		turn.player = player;

		EasyMock.expect(player.buy(turn.supplyPiles, "guiBuyPhase", turn.actions, turn.buys, turn.coins))
				.andReturn(Optional.of(card));
		EasyMock.expect(card.getCost()).andReturn(10);

		EasyMock.expect(player.buy(turn.supplyPiles, "guiBuyPhase", turn.actions, turn.buys, turn.coins))
				.andReturn(Optional.empty());

		turn.run();

		EasyMock.replay(player, turn, card);

		TurnBuyState state = new TurnBuyState();

		state.run(turn);

		assertEquals(turn.coins, 1);
		assertEquals(turn.buys, 1);

		EasyMock.verify(player, turn, card);

	}
}
