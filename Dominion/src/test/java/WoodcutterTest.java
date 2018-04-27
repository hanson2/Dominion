import static org.junit.Assert.*;

import org.junit.Test;

public class WoodcutterTest {

	@Test
	public void testWoodcutterType() {
		Card card = new Woodcutter();

		assertTrue(card.getType().contains(CardType.ACTION));
	}

	@Test
	public void testWoodcutterPlayState() {
		Card card = new Woodcutter();

		assertEquals(card.getPlayState().getClass(), CardPlayState.class);
	}

	@Test
	public void testWoodcutterActionsAdded() {
		Card card = new Woodcutter();

		assertEquals(card.getActionsAdded(), 0);
	}

	@Test
	public void testWoodcutterCoinsAdded() {
		Card card = new Woodcutter();

		assertEquals(card.getCoinsAdded(), 2);
	}

	@Test
	public void testWoodcutterBuysAdded() {
		Card card = new Woodcutter();

		assertEquals(card.getBuysAdded(), 1);
	}

	@Test
	public void testWoodcutterCardsAdded() {
		Card card = new Woodcutter();

		assertEquals(card.getCardsAdded(), 0);
	}

	@Test
	public void testWoodcutterVictoryValue() {
		Card card = new Woodcutter();

		assertEquals(card.getVictoryValue(), 0);
	}

	@Test
	public void testWoodcutterCost() {
		Card card = new Woodcutter();

		assertEquals(card.getCost(), 3);
	}
}
