package cards;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import states.CardPlayState;
import util.CardType;
import util.GameConstants;

public class GardensTest {

	Card card;

	@Before
	public void setup() {
		card = new Gardens();
	}

	@Test
	public void testGetType() {
		assertTrue(card.getType().contains(CardType.VICTORY));
	}

	@Test
	public void testGetCost() {
		assertEquals(card.getCost(), GameConstants.GARDENSCOST);
	}

	@Test
	public void testGetName() {
		assertEquals(card.getName(), GameConstants.GARDENSNAME);
	}

	@Test
	public void testGetCoinsAdded() {
		assertEquals(card.getCoinsAdded(), GameConstants.DEFAULTCARDATTRIBUTE);
	}

	@Test
	public void testGetActionsAdded() {
		assertEquals(card.getActionsAdded(), GameConstants.DEFAULTCARDATTRIBUTE);
	}

	@Test
	public void testGetBuysAdded() {
		assertEquals(card.getBuysAdded(), GameConstants.DEFAULTCARDATTRIBUTE);
	}

	@Test
	public void testGetCardsAdded() {
		assertEquals(card.getCardsAdded(), GameConstants.DEFAULTCARDATTRIBUTE);
	}

	@Test
	public void testGetVictoryValue() {
		assertEquals(card.getVictoryValue(), GameConstants.DEFAULTCARDATTRIBUTE);
	}

	@Test
	public void testGetText() {
		assertEquals(card.getText(), GameConstants.GARDENSTEXT);
	}

	@Test
	public void testGetPlayState() {
		assertEquals(card.getPlayState().getClass(), CardPlayState.class);
	}

	@Test
	public void testGetTypeTranslationKeys() {
		ArrayList<String> expectedTranslationKeys = new ArrayList<String>();
		expectedTranslationKeys.add("cardtypeVictory");

		assertEquals(card.getTypeTranslationKeys(), expectedTranslationKeys);
	}

}
