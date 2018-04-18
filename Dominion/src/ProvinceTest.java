import static org.junit.Assert.*;

import org.junit.Test;

public class ProvinceTest {

	@Test
	public void testProvinceValues() {
		Card card = new Province();

		assertTrue(card.getType().contains(CardType.VICTORY));
		assertEquals(card.getPlayState().getClass(), CardPlayState.class);
		assertEquals(card.getCoinsAdded(), 0);
		assertEquals(card.getActionsAdded(), 0);
		assertEquals(card.getBuysAdded(), 0);
		assertEquals(card.getCardsAdded(), 0);
		assertEquals(card.getVictoryValue(), 6);
		assertEquals(card.getCost(), 8);
	}
}
