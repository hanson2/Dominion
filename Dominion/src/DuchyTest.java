import static org.junit.Assert.*;

import org.junit.Test;

public class DuchyTest {

	@Test
	public void testDuchyValues() {
		Card card = new Duchy();

		assertTrue(card.getType().equals("VICTORY"));
		assertTrue(card.getPlayState().getClass().equals(DuchyPlayState.class));
		assertTrue(card.getCoinsAdded() == 0);
		assertTrue(card.getActionsAdded() == 0);
		assertTrue(card.getBuysAdded() == 0);
		assertTrue(card.getCardsAdded() == 0);
		assertTrue(card.getVictoryValue() == 3);
		assertTrue(card.getCost() == 5);
	}
}
