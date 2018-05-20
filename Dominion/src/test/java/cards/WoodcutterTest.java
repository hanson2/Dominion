package cards;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import states.CardPlayState;
import util.CardType;
import util.GameConstants;

public class WoodcutterTest {

	@Test
	public void testWoodcutterType() {
		Card card = new Woodcutter();

		assertTrue(card.getType().contains(CardType.ACTION));
	}

	@Test
	public void testWoodcutterPlayState() {
		Card card = new Woodcutter();

		assertEquals(card.getPlayState().getClass(), CardPlayState.class);
	}

	@Test
	public void testWoodcutterActionsAdded() {
		Card card = new Woodcutter();

		assertEquals(card.getActionsAdded(), GameConstants.DEFAULTCARDATTRIBUTE);
	}

	@Test
	public void testWoodcutterCoinsAdded() {
		Card card = new Woodcutter();

		assertEquals(card.getCoinsAdded(), GameConstants.WOODCUTTERCOINSADDED);
	}

	@Test
	public void testWoodcutterBuysAdded() {
		Card card = new Woodcutter();

		assertEquals(card.getBuysAdded(), GameConstants.WOODCUTTERBUYSADDED);
	}

	@Test
	public void testWoodcutterCardsAdded() {
		Card card = new Woodcutter();

		assertEquals(card.getCardsAdded(), GameConstants.DEFAULTCARDATTRIBUTE);
	}

	@Test
	public void testWoodcutterVictoryValue() {
		Card card = new Woodcutter();

		assertEquals(card.getVictoryValue(), GameConstants.DEFAULTCARDATTRIBUTE);
	}

	@Test
	public void testWoodcutterCost() {
		Card card = new Woodcutter();

		assertEquals(card.getCost(), GameConstants.WOODCUTTERCOST);
	}

	@Test
	public void testWoodcutterName() {
		Card card = new Woodcutter();

		assertEquals(card.getName(), GameConstants.WOODCUTTERNAME);
	}

	@Test
	public void testWoodcutterText() {
		Card card = new Woodcutter();

		assertEquals(card.getText(), GameConstants.DEFAULTCARDTEXT);
	}

	@Test
	public void testWoodcutterGetTypeTranslationKeys() {
		Card card = new Woodcutter();

		ArrayList<String> expectedTranslationKeys = new ArrayList<String>();
		expectedTranslationKeys.add("cardtypeAction");

		assertEquals(card.getTypeTranslationKeys(), expectedTranslationKeys);
	}
}
