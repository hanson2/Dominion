import static org.junit.Assert.*;

import org.junit.Test;

public class GoldTest {

	@Test
	public void testGoldValues() {
		Card card = new Gold();

		assertTrue(card.getType().contains(CardType.TREASURE));
		assertEquals(card.getPlayState().getClass(), CardPlayState.class);
		assertEquals(card.getCoinsAdded(), 3);
		assertEquals(card.getActionsAdded(), 0);
		assertEquals(card.getBuysAdded(), 0);
		assertEquals(card.getCardsAdded(), 0);
		assertEquals(card.getVictoryValue(), 0);
		assertEquals(card.getCost(), 6);
	}
}
