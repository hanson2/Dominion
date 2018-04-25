import static org.junit.Assert.*;

import org.easymock.EasyMock;
import org.junit.Test;

public class ChancellorTest {

	@Test
	public void testGetType() {
		Card card = new Chancellor();
		
		assertTrue(card.getType().contains(CardType.ACTION));
	}

	@Test
	public void testGetCost() {
		Card card = new Chancellor();
		
		assertEquals(card.getCost(), 3);
	}

	@Test
	public void testGetCoinsAdded() {
		Card card = new Chancellor();
		
		assertEquals(card.getCoinsAdded(), 2);
	}

	@Test
	public void testGetActionsAdded() {
		Card card = new Chancellor();
		
		assertEquals(card.getActionsAdded(), 0);
	}

	@Test
	public void testGetBuysAdded() {
		Card card = new Chancellor();
		
		assertEquals(card.getBuysAdded(), 0);
	}

	@Test
	public void testGetCardsAdded() {
		Card card = new Chancellor();
		
		assertEquals(card.getCardsAdded(), 0);
	}

	@Test
	public void testGetVictoryValue() {
		Card card = new Chancellor();
		
		assertEquals(card.getVictoryValue(), 0);
	}

	@Test
	public void testGetPlayState() {
		Card card = new Chancellor();
		
		assertEquals(card.getPlayState().getClass(), ChancellorPlayState.class);
	}
	
	@Test
	public void testPlayStateDoAction() {
		Player player = EasyMock.partialMockBuilder(Player.class)
				.withConstructor("test")
				.addMockedMethod("promptYesNo")
				.createMock();
		Turn turn = EasyMock.mock(Turn.class);
		
		EasyMock.expect(player.promptYesNo("Would you like to discard you draw pile?")).andReturn(true);
		
		player.discardDrawPile();
		
		EasyMock.replay(player, turn);
		
		turn.player = player;
		
		ChancellorPlayState state = new ChancellorPlayState();
		
		state.run(turn);
		
		assertEquals(player.sizeOfDrawPile(), 0);
		
		EasyMock.verify(turn, player);
	}

}
