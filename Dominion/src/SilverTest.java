import static org.junit.Assert.*;

import org.junit.Test;

public class SilverTest {

	@Test
	public void testSilverValues() {
		Card card = new Silver();

		assertTrue(card.getType().contains(CardType.TREASURE));
		assertTrue(card.getPlayState().getClass().equals(SilverPlayState.class));
		assertTrue(card.getCoinsAdded() == 2);
		assertTrue(card.getActionsAdded() == 0);
		assertTrue(card.getBuysAdded() == 0);
		assertTrue(card.getCardsAdded() == 0);
		assertTrue(card.getVictoryValue() == 0);
		assertTrue(card.getCost() == 3);
	}
}
