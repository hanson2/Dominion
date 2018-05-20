import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class EstateTest {

	@Test
	public void testEstateValues() {
		Card card = new Estate();
		
		ArrayList<String> expectedTranslationKeys = new ArrayList<String>();
		expectedTranslationKeys.add("cardtypeVictory");

		assertTrue(card.getType().contains(CardType.VICTORY));
		assertEquals(card.getPlayState().getClass(), CardPlayState.class);
		assertEquals(card.getCoinsAdded(), GameConstants.DEFAULTCARDATTRIBUTE);
		assertEquals(card.getActionsAdded(), GameConstants.DEFAULTCARDATTRIBUTE);
		assertEquals(card.getBuysAdded(), GameConstants.DEFAULTCARDATTRIBUTE);
		assertEquals(card.getCardsAdded(), GameConstants.DEFAULTCARDATTRIBUTE);
		assertEquals(card.getVictoryValue(), GameConstants.ESTATEVICTORYVALUE);
		assertEquals(card.getCost(), GameConstants.ESTATECOST);
		assertEquals(card.getName(), GameConstants.ESTATENAME);
		assertEquals(card.getText(), GameConstants.DEFAULTCARDTEXT);
		assertEquals(card.getTypeTranslationKeys(), expectedTranslationKeys);
	}
}
