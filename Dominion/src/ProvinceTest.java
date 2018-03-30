import static org.junit.Assert.*;

import org.junit.Test;

public class ProvinceTest {

	@Test
	public void testProvinceValues() {
		Card card = new Province();

		assertTrue(card.getType().equals("VICTORY"));
		assertTrue(card.getPlayState().getClass().equals(ProvincePlayState.class));
		assertTrue(card.getCoinsAdded() == 0);
		assertTrue(card.getActionsAdded() == 0);
		assertTrue(card.getBuysAdded() == 0);
		assertTrue(card.getCardsAdded() == 0);
		assertTrue(card.getVictoryValue() == 6);
		assertTrue(card.getCost() == 8);
	}
}
