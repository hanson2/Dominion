import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class CurseTest {

	@Test
	public void testCurseValues() {
		Card card = new Curse();
		
		ArrayList<String> expectedTranslationKeys = new ArrayList<String>();
		expectedTranslationKeys.add("cardtypeCurse");

		assertTrue(card.getType().contains(CardType.CURSE));
		assertEquals(card.getPlayState().getClass(), CardPlayState.class);
		assertEquals(card.getCoinsAdded(), GameConstants.DEFAULTCARDATTRIBUTE);
		assertEquals(card.getActionsAdded(), GameConstants.DEFAULTCARDATTRIBUTE);
		assertEquals(card.getBuysAdded(), GameConstants.DEFAULTCARDATTRIBUTE);
		assertEquals(card.getCardsAdded(), GameConstants.DEFAULTCARDATTRIBUTE);
		assertEquals(card.getVictoryValue(), GameConstants.CURSEVICTORYVALUE);
		assertEquals(card.getCost(), GameConstants.CURSECOST);
		assertEquals(card.getName(), GameConstants.CURSENAME);
		assertEquals(card.getText(), GameConstants.DEFAULTCARDTEXT);
		assertEquals(card.getTypeTranslationKeys(), expectedTranslationKeys);
	}
}
