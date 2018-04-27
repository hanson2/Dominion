import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.Test;

public class MoneylenderTest {

	@Test
	public void testGetType() {
		Card card = new Moneylender();
		
		assertTrue(card.getType().contains(CardType.ACTION));
	}

	@Test
	public void testGetCost() {
		Card card = new Moneylender();
		
		assertEquals(card.getCost(), 4);
	}

	@Test
	public void testGetCoinsAdded() {
		Card card = new Moneylender();
		
		assertEquals(card.getCoinsAdded(), 0);
	}

	@Test
	public void testGetActionsAdded() {
		Card card = new Moneylender();
		
		assertEquals(card.getActionsAdded(), 0);
	}

	@Test
	public void testGetBuysAdded() {
		Card card = new Moneylender();
		
		assertEquals(card.getBuysAdded(), 0);
	}

	@Test
	public void testGetCardsAdded() {
		Card card = new Moneylender();
		
		assertEquals(card.getCardsAdded(), 0);
	}

	@Test
	public void testGetVictoryValue() {
		Card card = new Moneylender();
		
		assertEquals(card.getVictoryValue(), 0);
	}

	@Test
	public void testGetPlayState() {
		Card card = new Moneylender();
		
		assertEquals(card.getPlayState().getClass(), MoneylenderPlayState.class);
	}
//TODO
	@Test
	public void testPlayStateDoActionCopperInHandYes() {
		List<Card> hand = new ArrayList<Card>();
		hand.add(new Copper());
		Player player = EasyMock.partialMockBuilder(Player.class)
				.withConstructor("test")
				.addMockedMethod("promptYesNo")
				.addMockedMethod("getHand")
				.createMock();
		Turn turn = EasyMock.mock(Turn.class);
		
		EasyMock.expect(player.promptYesNo("Would you like to trash a Copper for 3 Coins?")).andReturn(true);
		EasyMock.expect(player.getHand()).andReturn(hand);
		
		player.trashCardFromHand(Copper.class);
		
		EasyMock.replay(player, turn);
		
		turn.player = player;
		
		MoneylenderPlayState state = new MoneylenderPlayState();
		
		state.run(turn);
		
		assertEquals(player.getHand().size(), 0);
		
		EasyMock.verify(turn, player);
	}

}
