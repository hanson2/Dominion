import static org.junit.Assert.*;

import org.junit.Test;

public class ProvinceTest {

	@Test
	public void testProvinceValues() {
		Card card = new Province();

		assertTrue(card.getType().contains(CardType.VICTORY));
		assertEquals(card.getPlayState().getClass(), CardPlayState.class);
		assertEquals(card.getCoinsAdded(), GameConstants.DEFAULTCARDATTRIBUTE);
		assertEquals(card.getActionsAdded(), GameConstants.DEFAULTCARDATTRIBUTE);
		assertEquals(card.getBuysAdded(), GameConstants.DEFAULTCARDATTRIBUTE);
		assertEquals(card.getCardsAdded(), GameConstants.DEFAULTCARDATTRIBUTE);
		assertEquals(card.getVictoryValue(), GameConstants.PROVINCEVICTORYVALUE);
		assertEquals(card.getCost(), GameConstants.PROVINCECOST);
	}
}
