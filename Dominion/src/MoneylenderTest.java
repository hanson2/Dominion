import static org.junit.Assert.*;

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

}
