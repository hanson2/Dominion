import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
		
		assertEquals(card.getCost(), GameConstants.CHANCELLORCOST);
	}

	@Test
	public void testGetCoinsAdded() {
		Card card = new Chancellor();
		
		assertEquals(card.getCoinsAdded(), GameConstants.CHANCELLORCOINSADDED);
	}

	@Test
	public void testGetActionsAdded() {
		Card card = new Chancellor();
		
		assertEquals(card.getActionsAdded(), GameConstants.DEFAULTCARDATTRIBUTE);
	}

	@Test
	public void testGetBuysAdded() {
		Card card = new Chancellor();
		
		assertEquals(card.getBuysAdded(), GameConstants.DEFAULTCARDATTRIBUTE);
	}

	@Test
	public void testGetCardsAdded() {
		Card card = new Chancellor();
		
		assertEquals(card.getCardsAdded(), GameConstants.DEFAULTCARDATTRIBUTE);
	}

	@Test
	public void testGetVictoryValue() {
		Card card = new Chancellor();
		
		assertEquals(card.getVictoryValue(), GameConstants.DEFAULTCARDATTRIBUTE);
	}

	@Test
	public void testGetPlayState() {
		Card card = new Chancellor();
		
		assertEquals(card.getPlayState().getClass(), ChancellorPlayState.class);
	}
	
	@Test
	public void testPlayStateDoAction() {
		Player player = EasyMock.mock(Player.class);
		Turn turn = EasyMock.mock(Turn.class);
		
		EasyMock.expect(player.promptYesNo("chancellorPrompt")).andReturn(true);
		
		player.discardDrawPile();
		EasyMock.expectLastCall();
		
		EasyMock.replay(player, turn);
		
		turn.player = player;
		
		ChancellorPlayState state = new ChancellorPlayState();
		
		state.run(turn);
		
		EasyMock.verify(turn, player);
	}
	
	@Test
	public void testPlayStateDoNotDoAction() {
		Player player = EasyMock.mock(Player.class);
		Turn turn = EasyMock.mock(Turn.class);
		
		EasyMock.expect(player.promptYesNo("chancellorPrompt")).andReturn(false);
		
		EasyMock.replay(player, turn);
		
		turn.player = player;
		
		ChancellorPlayState state = new ChancellorPlayState();
		
		state.run(turn);
		
		EasyMock.verify(turn, player);
	}

}
