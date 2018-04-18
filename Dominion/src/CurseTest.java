import static org.junit.Assert.*;

import org.junit.Test;

public class CurseTest {

	@Test
	public void testCurseValues() {
		Card card = new Curse();

		assertTrue(card.getType().contains(CardType.CURSE));
		assertEquals(card.getPlayState().getClass(), CardPlayState.class);
		assertEquals(card.getCoinsAdded(), 0);
		assertEquals(card.getActionsAdded(), 0);
		assertEquals(card.getBuysAdded(), 0);
		assertEquals(card.getCardsAdded(), 0);
		assertEquals(card.getVictoryValue(), -1);
		assertEquals(card.getCost(), 0);
	}
}
