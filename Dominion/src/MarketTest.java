import static org.junit.Assert.*;

import org.junit.Test;

public class MarketTest {

	@Test
	public void testGetType() {
		Card card = new Market();

		assertTrue(card.getType().contains(CardType.ACTION));
	}

	@Test
	public void testGetCost() {
		Card card = new Market();

		assertEquals(card.getCost(), 5);
	}

	@Test
	public void testGetCoinsAdded() {
		Card card = new Market();

		assertEquals(card.getCoinsAdded(), 1);
	}

	@Test
	public void testGetActionsAdded() {
		Card card = new Market();

		assertEquals(card.getActionsAdded(), 1);
	}

	@Test
	public void testGetBuysAdded() {
		Card card = new Market();

		assertEquals(card.getBuysAdded(), 1);
	}

	@Test
	public void testGetCardsAdded() {
		Card card = new Market();

		assertEquals(card.getCardsAdded(), 1);
	}

	@Test
	public void testGetVictoryValue() {
		Card card = new Market();

		assertEquals(card.getVictoryValue(), 0);
	}

	@Test
	public void testGetPlayState() {
		Card card = new Market();

		assertEquals(card.getPlayState().getClass(), CardPlayState.class);
	}

}
