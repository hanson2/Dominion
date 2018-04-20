import static org.junit.Assert.*;

import org.junit.Test;

public class VillageTest {

	@Test
	public void testGetType() {
		Card village = new Village();
		assertTrue(village.getType().contains(CardType.ACTION));
	}

	@Test
	public void testGetCost() {
		Card village = new Village();
		assertEquals(village.getCost(), 3);
	}

	@Test
	public void testGetCoinsAdded() {
		Card village = new Village();
		assertEquals(village.getCoinsAdded(), 0);
	}

	@Test
	public void testGetActionsAdded() {
		Card village = new Village();
		assertEquals(village.getActionsAdded(), 2);
	}

	@Test
	public void testGetBuysAdded() {
		Card village = new Village();
		assertEquals(village.getBuysAdded(), 0);
	}

	@Test
	public void testGetCardsAdded() {
		Card village = new Village();
		assertEquals(village.getCardsAdded(), 1);
	}

	@Test
	public void testGetVictoryValue() {
		Card village = new Village();
		assertEquals(village.getVictoryValue(), 0);
	}

	@Test
	public void testGetPlayState() {
		Card village = new Village();
		assertEquals(village.getPlayState().getClass(), CardPlayState.class);
	}

}
