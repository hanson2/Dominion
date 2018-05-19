import static org.junit.Assert.*;

import org.junit.Test;

public class EstateTest {

	@Test
	public void testEstateValues() {
		Card card = new Estate();

		assertTrue(card.getType().contains(CardType.VICTORY));
		assertEquals(card.getPlayState().getClass(), CardPlayState.class);
		assertEquals(card.getCoinsAdded(), GameConstants.DEFAULTCARDATTRIBUTE);
		assertEquals(card.getActionsAdded(), GameConstants.DEFAULTCARDATTRIBUTE);
		assertEquals(card.getBuysAdded(), GameConstants.DEFAULTCARDATTRIBUTE);
		assertEquals(card.getCardsAdded(), GameConstants.DEFAULTCARDATTRIBUTE);
		assertEquals(card.getVictoryValue(), GameConstants.ESTATEVICTORYVALUE);
		assertEquals(card.getCost(), GameConstants.ESTATECOST);
	}
}
