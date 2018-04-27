import static org.junit.Assert.*;

import org.junit.Test;

public class CopperTest {

	@Test
	public void testCopperValues() {
		Card card = new Copper();

		assertTrue(card.getType().contains(CardType.TREASURE));
		assertEquals(card.getPlayState().getClass(), CardPlayState.class);
		assertEquals(card.getCoinsAdded(), 1);
		assertEquals(card.getActionsAdded(), 0);
		assertEquals(card.getBuysAdded(), 0);
		assertEquals(card.getCardsAdded(), 0);
		assertEquals(card.getVictoryValue(), 0);
		assertEquals(card.getCost(), 0);
	}
}
