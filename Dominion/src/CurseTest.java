import static org.junit.Assert.*;

import org.junit.Test;

public class CurseTest {

	@Test
	public void testCurseValues() {
		Card card = new Curse();

		assertTrue(card.getType().equals("CURSE"));
		assertTrue(card.getPlayState().getClass().equals(CursePlayState.class));
		assertTrue(card.getCoinsAdded() == 0);
		assertTrue(card.getActionsAdded() == 0);
		assertTrue(card.getBuysAdded() == 0);
		assertTrue(card.getCardsAdded() == 0);
		assertTrue(card.getVictoryValue() == -1);
		assertTrue(card.getCost() == 0);
	}
}
