package states;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cards.Card;
import cards.Copper;
import cards.Curse;
import cards.Estate;
import cards.Gold;
import gameComponents.Player;
import gameComponents.Supply;

public class RemodelPlayStateTest {

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
		EasyMock.expect(player.chooseCardFromHand("guiActionPhase", 0, 0, 0))
				.andReturn(new Curse());
		EasyMock.expect(player.trashCardFromHand(Curse.class)).andReturn(true);
		Card card = new Copper();
		EasyMock.expect(player.forcedBuy(turn.supplyPiles, "guiActionPhase", 2)).andReturn(card);

		player.gainCard(card);

		supplyPiles.decrementPile(card);

		EasyMock.replay(turn, player, supplyPiles);

		turn.player = player;
		turn.supplyPiles = supplyPiles;
		RemodelPlayState state = new RemodelPlayState();
		state.run(turn);
	}

	@Test
	public void testExactCostBuy() {
		EasyMock.expect(player.chooseCardFromHand("guiActionPhase", 0, 0, 0))
				.andReturn(new Curse());
		EasyMock.expect(player.trashCardFromHand(Curse.class)).andReturn(true);
		Card card = new Estate();
		EasyMock.expect(player.forcedBuy(turn.supplyPiles, "guiActionPhase", 2)).andReturn(card);

		player.gainCard(card);

		supplyPiles.decrementPile(card);

		EasyMock.replay(turn, player, supplyPiles);

		turn.player = player;
		turn.supplyPiles = supplyPiles;
		RemodelPlayState state = new RemodelPlayState();
		state.run(turn);
	}

	@Test
	public void testBadPurchase() {
		EasyMock.expect(player.chooseCardFromHand("guiActionPhase", 0, 0, 0))
				.andReturn(new Curse());
		EasyMock.expect(player.trashCardFromHand(Curse.class)).andReturn(true);
		EasyMock.expect(player.forcedBuy(turn.supplyPiles, "guiActionPhase", 2))
				.andReturn(new Gold());
		Card card = new Copper();
		EasyMock.expect(player.forcedBuy(turn.supplyPiles, "guiActionPhase", 2)).andReturn(card);

		player.gainCard(card);

		supplyPiles.decrementPile(card);

		EasyMock.replay(turn, player, supplyPiles);

		RemodelPlayState state = new RemodelPlayState();
		state.run(turn);
	}
}
