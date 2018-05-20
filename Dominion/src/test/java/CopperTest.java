import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class CopperTest {

	@Test
	public void testCopperValues() {
		Card card = new Copper();
		
		ArrayList<String> expectedTranslationKeys = new ArrayList<String>();
		expectedTranslationKeys.add("cardtypeTreasure");

		assertTrue(card.getType().contains(CardType.TREASURE));
		assertEquals(card.getPlayState().getClass(), CardPlayState.class);
		assertEquals(card.getCoinsAdded(), GameConstants.COPPERCOINSADDED);
		assertEquals(card.getActionsAdded(), GameConstants.DEFAULTCARDATTRIBUTE);
		assertEquals(card.getBuysAdded(), GameConstants.DEFAULTCARDATTRIBUTE);
		assertEquals(card.getCardsAdded(), GameConstants.DEFAULTCARDATTRIBUTE);
		assertEquals(card.getVictoryValue(), GameConstants.DEFAULTCARDATTRIBUTE);
		assertEquals(card.getCost(), GameConstants.COPPERCOST);
		assertEquals(card.getName(), GameConstants.COPPERNAME);
		assertEquals(card.getText(), GameConstants.DEFAULTCARDTEXT);
		assertEquals(card.getTypeTranslationKeys(), expectedTranslationKeys);
	}
}
