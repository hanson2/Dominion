import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class DuchyTest {

	@Test
	public void testDuchyValues() {
		Card card = new Duchy();
		
		ArrayList<String> expectedTranslationKeys = new ArrayList<String>();
		expectedTranslationKeys.add("cardtypeVictory");

		assertTrue(card.getType().contains(CardType.VICTORY));
		assertEquals(card.getPlayState().getClass(), CardPlayState.class);
		assertEquals(card.getCoinsAdded(), GameConstants.DEFAULTCARDATTRIBUTE);
		assertEquals(card.getActionsAdded(), GameConstants.DEFAULTCARDATTRIBUTE);
		assertEquals(card.getBuysAdded(), GameConstants.DEFAULTCARDATTRIBUTE);
		assertEquals(card.getCardsAdded(), GameConstants.DEFAULTCARDATTRIBUTE);
		assertEquals(card.getVictoryValue(), GameConstants.DUCHYVICTORYVALUE);
		assertEquals(card.getCost(), GameConstants.DUCHYCOST);
		assertEquals(card.getName(), GameConstants.DUCHYNAME);
		assertEquals(card.getText(), GameConstants.DEFAULTCARDTEXT);
		assertEquals(card.getTypeTranslationKeys(), expectedTranslationKeys);
	}
}
