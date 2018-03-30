import static org.junit.Assert.*;

import org.junit.Test;

public class EstateTest {

	@Test
	public void testEstateValues() {
		Card card = new Estate();

		assertTrue(card.getType().equals("VICTORY"));
		assertTrue(card.getPlayState().getClass().equals(EstatePlayState.class));
		assertTrue(card.getCoinsAdded() == 0);
		assertTrue(card.getActionsAdded() == 0);
		assertTrue(card.getBuysAdded() == 0);
		assertTrue(card.getCardsAdded() == 0);
		assertTrue(card.getVictoryValue() == 1);
		assertTrue(card.getCost() == 2);
	}
}
