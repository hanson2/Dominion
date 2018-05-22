package cards;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import states.FeastPlayState;
import util.CardType;
import util.GameConstants;

public class FeastTest {

	Card card;

	@Before
	public void setup() {
		card = new Feast();
	}

	@Test
	public void testGetType() {
		assertTrue(card.getType().contains(CardType.ACTION));
	}

	@Test
	public void testGetCost() {
		assertEquals(card.getCost(), GameConstants.FEASTCOST);
	}

	@Test
	public void testGetName() {
		assertEquals(card.getName(), GameConstants.FEASTNAME);
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
		assertEquals(card.getText(), GameConstants.FEASTTEXT);
	}

	@Test
	public void testGetPlayState() {
		assertEquals(card.getPlayState().getClass(), FeastPlayState.class);
	}

	@Test
	public void testGetTypeTranslationKeys() {
		ArrayList<String> expectedTranslationKeys = new ArrayList<String>();
		expectedTranslationKeys.add("cardtypeAction");

		assertEquals(card.getTypeTranslationKeys(), expectedTranslationKeys);
	}

}
