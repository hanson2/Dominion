package states;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cards.Card;
import cards.Copper;
import cards.Curse;
import cards.Duchy;
import cards.Gold;
import gameComponents.Player;
import gameComponents.Supply;

public class ArtisanPlaysStateTest {

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
		EasyMock.expect(player.forcedBuy(supplyPiles, "guiActionPhase", 5)).andReturn(card);
		player.gainCardToHand(card);

		card = new Curse();
		EasyMock.expect(player.chooseCardFromHand("guiActionPhase", 0, 0, 0)).andReturn(card);
		player.placeOnDrawPile(card);
		EasyMock.expect(player.trashCardFromHand(Curse.class)).andReturn(true);

		EasyMock.replay(turn, player, supplyPiles);

		ArtisanPlayState state = new ArtisanPlayState();
		state.run(turn);
	}

	@Test
	public void testExactCostBuy() {
		Card card = new Duchy();
		EasyMock.expect(player.forcedBuy(supplyPiles, "guiActionPhase", 5)).andReturn(card);
		player.gainCardToHand(card);

		card = new Curse();
		EasyMock.expect(player.chooseCardFromHand("guiActionPhase", 0, 0, 0)).andReturn(card);
		player.placeOnDrawPile(card);
		EasyMock.expect(player.trashCardFromHand(Curse.class)).andReturn(true);

		EasyMock.replay(turn, player, supplyPiles);

		ArtisanPlayState state = new ArtisanPlayState();
		state.run(turn);
	}

	@Test
	public void testBadPurchase() {
		Card card = new Gold();
		EasyMock.expect(player.forcedBuy(supplyPiles, "guiActionPhase", 5)).andReturn(card);
		card = new Copper();
		EasyMock.expect(player.forcedBuy(supplyPiles, "guiActionPhase", 5)).andReturn(card);
		player.gainCardToHand(card);

		card = new Curse();
		EasyMock.expect(player.chooseCardFromHand("guiActionPhase", 0, 0, 0)).andReturn(card);
		player.placeOnDrawPile(card);
		EasyMock.expect(player.trashCardFromHand(Curse.class)).andReturn(true);

		EasyMock.replay(turn, player, supplyPiles);

		ArtisanPlayState state = new ArtisanPlayState();
		state.run(turn);
	}

}
