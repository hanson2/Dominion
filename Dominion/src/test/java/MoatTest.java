import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MoatTest {
	
	Card card;
	
	@Before
	public void setup() {
		card = new Moat();
	}

	@Test
	public void testGetType() {
		assertTrue(card.getType().contains(CardType.ACTION));
		assertTrue(card.getType().contains(CardType.REACTION));
	}
	
	@Test
	public void testGetCost() {
		assertEquals(card.getCost(), 2);
	}
	
	@Test
	public void testGetCoinsAdded() {
		assertEquals(card.getCoinsAdded(), 0);
	}
	
	@Test
	public void testGetActionsAdded() {
		assertEquals(card.getActionsAdded(), 0);
	}
	
	@Test
	public void testGetBuysAdded() {
		assertEquals(card.getBuysAdded(), 0);
	}

	@Test
	public void testGetCardsAdded() {
		assertEquals(card.getCardsAdded(), 2);
	}

	@Test
	public void testGetVictoryValue() {
		assertEquals(card.getVictoryValue(), 0);
	}
	
	@Test
	public void testGetPlayState() {
		assertEquals(card.getPlayState().getClass(), CardPlayState.class);
	}

}
