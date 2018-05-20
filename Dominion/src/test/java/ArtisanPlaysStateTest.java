import static org.junit.Assert.*;

import java.util.Optional;
import java.util.Stack;

import org.easymock.EasyMock;
import org.junit.Test;

public class ArtisanPlaysStateTest {
	@Test
	public void testBaseCase() {
		Player player = EasyMock.strictMock(Player.class);
		Turn turn = EasyMock.strictMock(Turn.class);

		Card card = new Copper();
		EasyMock.expect(player.forcedBuy(5)).andReturn(card);
		player.gainCardToHand(card);

		card = new Curse();
		EasyMock.expect(player.chooseCardFromHand()).andReturn(card);
		player.placeOnDrawPile(card);
		EasyMock.expect(player.trashCardFromHand(Curse.class)).andReturn(true);

		EasyMock.replay(turn, player);

		turn.player = player;
		ArtisanPlayState state = new ArtisanPlayState();
		state.run(turn);

		EasyMock.verify(turn, player);
	}

	@Test
	public void testExactCostBuy() {
		Player player = EasyMock.strictMock(Player.class);
		Turn turn = EasyMock.strictMock(Turn.class);

		Card card = new Duchy();
		EasyMock.expect(player.forcedBuy(5)).andReturn(card);
		player.gainCardToHand(card);

		card = new Curse();
		EasyMock.expect(player.chooseCardFromHand()).andReturn(card);
		player.placeOnDrawPile(card);
		EasyMock.expect(player.trashCardFromHand(Curse.class)).andReturn(true);

		EasyMock.replay(turn, player);

		turn.player = player;
		ArtisanPlayState state = new ArtisanPlayState();
		state.run(turn);

		EasyMock.verify(turn, player);
	}

	@Test
	public void testBadPurchase() {
		Player player = EasyMock.strictMock(Player.class);
		Turn turn = EasyMock.strictMock(Turn.class);

		Card card = new Gold();
		EasyMock.expect(player.forcedBuy(5)).andReturn(card);
		card = new Copper();
		EasyMock.expect(player.forcedBuy(5)).andReturn(card);
		player.gainCardToHand(card);

		card = new Curse();
		EasyMock.expect(player.chooseCardFromHand()).andReturn(card);
		player.placeOnDrawPile(card);
		EasyMock.expect(player.trashCardFromHand(Curse.class)).andReturn(true);

		EasyMock.replay(turn, player);

		turn.player = player;
		ArtisanPlayState state = new ArtisanPlayState();
		state.run(turn);

		EasyMock.verify(turn, player);
	}

}
