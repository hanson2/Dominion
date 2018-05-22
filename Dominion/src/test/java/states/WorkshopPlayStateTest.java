package states;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cards.Card;
import cards.Copper;
import cards.Market;
import cards.Moneylender;
import gameComponents.Player;
import gameComponents.Supply;

public class WorkshopPlayStateTest {

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
		Card card = new Copper();
		EasyMock.expect(player.forcedBuy(supplyPiles, "guiActionPhase", 4)).andReturn(card);
		player.gainCard(card);
		supplyPiles.decrementPile(card);

		EasyMock.replay(turn, player, supplyPiles);

		turn.player = player;
		WorkshopPlayState state = new WorkshopPlayState();
		state.run(turn);
	}

	@Test
	public void testExactCostBuy() {
		Card card = new Moneylender();
		EasyMock.expect(player.forcedBuy(supplyPiles, "guiActionPhase", 4)).andReturn(card);
		player.gainCard(card);
		supplyPiles.decrementPile(card);

		EasyMock.replay(turn, player, supplyPiles);

		turn.player = player;
		WorkshopPlayState state = new WorkshopPlayState();
		state.run(turn);
	}

	@Test
	public void testBadPurchase() {
		Card card = new Market();
		EasyMock.expect(player.forcedBuy(supplyPiles, "guiActionPhase", 4)).andReturn(card);
		card = new Copper();
		EasyMock.expect(player.forcedBuy(supplyPiles, "guiActionPhase", 4)).andReturn(card);
		player.gainCard(card);
		supplyPiles.decrementPile(card);

		EasyMock.replay(turn, player, supplyPiles);

		turn.player = player;
		WorkshopPlayState state = new WorkshopPlayState();
		state.run(turn);
	}

}
