import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CellarTest {
	
	Card card;
	
	@Before
	public void setup() {
		card = new Cellar();
	}

	@Test
	public void testGetType() {
		assertTrue(card.getType().contains(CardType.ACTION));
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
		assertEquals(card.getActionsAdded(), 1);
	}

	@Test
	public void testGetBuysAdded() {
		assertEquals(card.getBuysAdded(), 0);
	}

	@Test
	public void testGetCardsAdded() {
		assertEquals(card.getCardsAdded(), 0);
	}

	@Test
	public void testGetVictoryValue() {
		assertEquals(card.getVictoryValue(), 0);
	}

	@Test
	public void testGetPlayState() {
		assertEquals(card.getPlayState().getClass(), CellarPlayState.class);
	}

}
