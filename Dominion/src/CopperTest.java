import static org.junit.Assert.*;

import org.junit.Test;

public class CopperTest {

	@Test
	public void testCopperValues() {
		Card card = new Copper();

		assertTrue(card.getType().equals("TREASURE"));
		assertTrue(card.getCoinsAdded() == 1);
		assertTrue(card.getActionsAdded() == 0);
		assertTrue(card.getBuysAdded() == 0);
		assertTrue(card.getCardsAdded() == 0);
		assertTrue(card.getVictoryValue() == 0);
		assertTrue(card.getCost() == 0);
	}
}
