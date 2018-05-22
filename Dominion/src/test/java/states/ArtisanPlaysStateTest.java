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

public class ArtisanPlaysStateTest {

	Player player;
	Turn turn;

	@Before
	public void setup() {
		player = EasyMock.mock(Player.class);
		turn = EasyMock.mock(Turn.class);
	}

	@After
	public void tearDown() {
		EasyMock.verify(player, turn);
	}

	@Test
	public void testBaseCase() {
		Card card = new Copper();
		EasyMock.expect(player.forcedBuy(5)).andReturn(card);
		player.gainCardToHand(card);

		card = new Curse();
		EasyMock.expect(player.chooseCardFromHand("guiActionPhase", 0, 0, 0)).andReturn(card);
		player.placeOnDrawPile(card);
		EasyMock.expect(player.trashCardFromHand(Curse.class)).andReturn(true);

		EasyMock.replay(turn, player);

		turn.player = player;
		ArtisanPlayState state = new ArtisanPlayState();
		state.run(turn);
	}

	@Test
	public void testExactCostBuy() {
		Card card = new Duchy();
		EasyMock.expect(player.forcedBuy(5)).andReturn(card);
		player.gainCardToHand(card);

		card = new Curse();
		EasyMock.expect(player.chooseCardFromHand("guiActionPhase", 0, 0, 0)).andReturn(card);
		player.placeOnDrawPile(card);
		EasyMock.expect(player.trashCardFromHand(Curse.class)).andReturn(true);

		EasyMock.replay(turn, player);

		turn.player = player;
		ArtisanPlayState state = new ArtisanPlayState();
		state.run(turn);
	}

	@Test
	public void testBadPurchase() {
		Card card = new Gold();
		EasyMock.expect(player.forcedBuy(5)).andReturn(card);
		card = new Copper();
		EasyMock.expect(player.forcedBuy(5)).andReturn(card);
		player.gainCardToHand(card);

		card = new Curse();
		EasyMock.expect(player.chooseCardFromHand("guiActionPhase", 0, 0, 0)).andReturn(card);
		player.placeOnDrawPile(card);
		EasyMock.expect(player.trashCardFromHand(Curse.class)).andReturn(true);

		EasyMock.replay(turn, player);

		turn.player = player;
		ArtisanPlayState state = new ArtisanPlayState();
		state.run(turn);
	}

}
