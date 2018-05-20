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
		Stack<Card> pile = new Stack<Card>();
		Card card = new Copper();
		EasyMock.expect(player.buy()).andReturn(Optional.of(card));
		player.gainCard(card);
		EasyMock.expect(player.chooseCardFromHand()).andReturn(new Curse());
		
		EasyMock.expect(player.trashCardFromHand(Curse.class)).andReturn(true);

		EasyMock.replay(turn, player);
		
		turn.player = player;
		player.drawPile = pile;
		ArtisanPlayState state = new ArtisanPlayState();
		state.run(turn);

		EasyMock.verify(turn, player);
		assertEquals(pile.pop().getClass(), Curse.class);
	}
	@Test
	public void testExactCostBuy(){
		Player player = EasyMock.strictMock(Player.class);
		Turn turn = EasyMock.strictMock(Turn.class);
		Stack<Card> pile = new Stack<Card>();
		Card card = new Duchy();
		EasyMock.expect(player.buy()).andReturn(Optional.of(card));
		player.gainCard(card);
		
		EasyMock.expect(player.chooseCardFromHand()).andReturn(new Curse());
		
		EasyMock.expect(player.trashCardFromHand(Curse.class)).andReturn(true);
		

		EasyMock.replay(turn, player);
		
		turn.player = player;
		player.drawPile = pile;
		ArtisanPlayState state = new ArtisanPlayState();
		state.run(turn);

		EasyMock.verify(turn, player);
		assertEquals(pile.pop().getClass(), Curse.class);
	}
	@Test
	public void testBadPurchase(){
		Player player = EasyMock.strictMock(Player.class);
		Turn turn = EasyMock.strictMock(Turn.class);
		Stack<Card> pile = new Stack<Card>();
		Card card = new Gold();
		EasyMock.expect(player.buy()).andReturn(Optional.of(card));
		card = new Copper();
		EasyMock.expect(player.buy()).andReturn(Optional.of(card));
		player.gainCard(card);
		
		EasyMock.expect(player.chooseCardFromHand()).andReturn(new Curse());
		EasyMock.expect(player.trashCardFromHand(Curse.class)).andReturn(true);
		

		EasyMock.replay(turn, player);
		
		turn.player = player;
		player.drawPile = pile;
		ArtisanPlayState state = new ArtisanPlayState();
		state.run(turn);

		EasyMock.verify(turn, player);
		assertEquals(pile.pop().getClass(), Curse.class);
	}

}
