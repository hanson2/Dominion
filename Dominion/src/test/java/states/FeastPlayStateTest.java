package states;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cards.Card;
import cards.Copper;
import cards.Duchy;
import cards.Gold;
import gameComponents.Player;
import gameComponents.Supply;

public class FeastPlayStateTest {

	Player player;
	Turn turn;
	Supply supplyPiles;

	@Before
	public void setup() {
		player = EasyMock.mock(Player.class);
		turn = EasyMock.mock(Turn.class);
		supplyPiles = EasyMock.mock(Supply.class);
		turn.player = player;
		turn.supplyPiles = supplyPiles;
	}

	@After
	public void tearDown() {
		EasyMock.verify(player, turn, supplyPiles);
	}

	@Test
	public void testBaseCase() {
		turn.trashMostRecentlyPlayedCard();

		Card card = new Copper();
		EasyMock.expect(player.forcedBuy(supplyPiles, "guiActionPhase", 5)).andReturn(card);
		player.gainCard(card);
		supplyPiles.decrementPile(card);

		EasyMock.replay(turn, player, supplyPiles);

		FeastPlayState state = new FeastPlayState();
		state.run(turn);
	}

	@Test
	public void testExactCostBuy() {
		turn.trashMostRecentlyPlayedCard();

		Card card = new Duchy();
		EasyMock.expect(player.forcedBuy(supplyPiles, "guiActionPhase", 5)).andReturn(card);
		player.gainCard(card);
		supplyPiles.decrementPile(card);

		EasyMock.replay(turn, player, supplyPiles);

		FeastPlayState state = new FeastPlayState();
		state.run(turn);
	}

	@Test
	public void testBadPurchase() {
		turn.trashMostRecentlyPlayedCard();

		Card card = new Gold();
		EasyMock.expect(player.forcedBuy(supplyPiles, "guiActionPhase", 5)).andReturn(card);
		card = new Copper();
		EasyMock.expect(player.forcedBuy(supplyPiles, "guiActionPhase", 5)).andReturn(card);
		player.gainCard(card);
		supplyPiles.decrementPile(card);

		EasyMock.replay(turn, player, supplyPiles);

		FeastPlayState state = new FeastPlayState();
		state.run(turn);
	}
}
