import static org.junit.Assert.*;

import org.junit.Test;

public class GoldTest {

	@Test
	public void testGoldValues() {
		Card card = new Gold();

		assertTrue(card.getType().equals("TREASURE"));
		assertTrue(card.getPlayState().getClass().equals(GoldPlayState.class));
		assertTrue(card.getCoinsAdded() == 3);
		assertTrue(card.getActionsAdded() == 0);
		assertTrue(card.getBuysAdded() == 0);
		assertTrue(card.getCardsAdded() == 0);
		assertTrue(card.getVictoryValue() == 0);
		assertTrue(card.getCost() == 6);
	}
}
