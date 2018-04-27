import static org.junit.Assert.*;

import org.junit.Test;

public class LaboratoryTest {

	@Test
	public void testGetType() {
		Card lab = new Laboratory();
		assertTrue(lab.getType().contains(CardType.ACTION));
	}

	@Test
	public void testGetCost() {
		Card lab = new Laboratory();
		assertEquals(lab.getCost(), 5);
	}

	@Test
	public void testGetCoinsAdded() {
		Card lab = new Laboratory();
		assertEquals(lab.getCoinsAdded(), 0);
	}

	@Test
	public void testGetActionsAdded() {
		Card lab = new Laboratory();
		assertEquals(lab.getActionsAdded(), 1);
	}

	@Test
	public void testGetBuysAdded() {
		Card lab = new Laboratory();
		assertEquals(lab.getBuysAdded(), 0);
	}

	@Test
	public void testGetCardsAdded() {
		Card lab = new Laboratory();
		assertEquals(lab.getCardsAdded(), 2);
	}

	@Test
	public void testGetVictoryValue() {
		Card lab = new Laboratory();
		assertEquals(lab.getVictoryValue(), 0);
	}

	@Test
	public void testGetPlayState() {
		Card lab = new Laboratory();
		assertEquals(lab.getPlayState().getClass(), CardPlayState.class);
	}

}
