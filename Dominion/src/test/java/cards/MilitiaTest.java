package cards;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import states.MilitiaPlayState;
import util.CardType;
import util.GameConstants;

public class MilitiaTest {
	Militia card;

	@Before
	public void setup() {
		card = new Militia();
	}

	@Test
	public void testGetType() {
		assertTrue(card.getType().contains(CardType.ACTION));
		assertTrue(card.getType().contains(CardType.ATTACK));
	}

	@Test
	public void testGetCost() {
		assertEquals(card.getCost(), GameConstants.MILITIACOST);
	}

	@Test
	public void testGetCoinsAdded() {
		assertEquals(card.getCoinsAdded(), GameConstants.MILITIACOINSADDED);
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
	public void testGetPlayState() {
		assertEquals(card.getPlayState().getClass(), MilitiaPlayState.class);
	}

	@Test
	public void testGetName() {
		assertEquals(card.getName(), GameConstants.MILITIANAME);
	}

	@Test
	public void testGetText() {
		assertEquals(card.getText(), GameConstants.MILITIATEXT);
	}

	@Test
	public void testGetTypeTranslationKeys() {
		ArrayList<String> expectedTranslationKeys = new ArrayList<String>();
		expectedTranslationKeys.add("cardtypeAction");
		expectedTranslationKeys.add("cardtypeAttack");

		assertEquals(card.getTypeTranslationKeys(), expectedTranslationKeys);
	}
}
