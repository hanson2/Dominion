import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ChapelTest {
	
	Card card;
	
	@Before
	public void setup() {
		card = new Chapel();
	}

	@Test
	public void testGetType() {
		assertTrue(card.getType().contains(CardType.ACTION));		
	}

	@Test
	public void testGetCost() {
		assertEquals(card.getCost(), GameConstants.CHAPELCOST);
	}

	@Test
	public void testGetCoinsAdded() {
		assertEquals(card.getCoinsAdded(), GameConstants.DEFAULTCARDATTRIBUTE);
	}

	@Test
	public void testGetActionsAdded() {
		assertEquals(card.getActionsAdded(), GameConstants.DEFAULTCARDATTRIBUTE);
	}

	@Test
	public void testGetBuysAdded() {
		assertEquals(card.getBuysAdded(), GameConstants.DEFAULTCARDATTRIBUTE);
	}

	@Test
	public void testGetCardsAdded() {
		assertEquals(card.getCardsAdded(), GameConstants.DEFAULTCARDATTRIBUTE);
	}

	@Test
	public void testGetVictoryValue() {
		assertEquals(card.getVictoryValue(), GameConstants.DEFAULTCARDATTRIBUTE);
	}

	@Test
	public void testGetPlayState() {
		assertEquals(card.getPlayState().getClass(), ChapelPlayState.class);
	}

}
