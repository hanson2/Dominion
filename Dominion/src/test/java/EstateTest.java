import static org.junit.Assert.*;

import org.junit.Test;

public class EstateTest {

	@Test
	public void testEstateValues() {
		Card card = new Estate();

		assertTrue(card.getType().contains(CardType.VICTORY));
		assertEquals(card.getPlayState().getClass(), CardPlayState.class);
		assertEquals(card.getCoinsAdded(), 0);
		assertEquals(card.getActionsAdded(), 0);
		assertEquals(card.getBuysAdded(), 0);
		assertEquals(card.getCardsAdded(), 0);
		assertEquals(card.getVictoryValue(), 1);
		assertEquals(card.getCost(), 2);
	}
}
