import static org.junit.Assert.*;

import org.junit.Test;

public class SilverTest {

	@Test
	public void testSilverValues() {
		Card card = new Silver();

		assertTrue(card.getType().contains(CardType.TREASURE));
		assertEquals(card.getPlayState().getClass(), CardPlayState.class);
		assertEquals(card.getCoinsAdded(), 2);
		assertEquals(card.getActionsAdded(), 0);
		assertEquals(card.getBuysAdded(), 0);
		assertEquals(card.getCardsAdded(), 0);
		assertEquals(card.getVictoryValue(), 0);
		assertEquals(card.getCost(), 3);
	}
}
