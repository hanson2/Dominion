package cards;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import states.MoneylenderPlayState;
import util.CardType;
import util.GameConstants;

public class MoneylenderTest {

	@Test
	public void testGetType() {
		Card card = new Moneylender();

		assertTrue(card.getType().contains(CardType.ACTION));
	}

	@Test
	public void testGetCost() {
		Card card = new Moneylender();

		assertEquals(card.getCost(), GameConstants.MONEYLENDERCOST);
	}

	@Test
	public void testGetCoinsAdded() {
		Card card = new Moneylender();

		assertEquals(card.getCoinsAdded(), GameConstants.DEFAULTCARDATTRIBUTE);
	}

	@Test
	public void testGetActionsAdded() {
		Card card = new Moneylender();

		assertEquals(card.getActionsAdded(), GameConstants.DEFAULTCARDATTRIBUTE);
	}

	@Test
	public void testGetBuysAdded() {
		Card card = new Moneylender();

		assertEquals(card.getBuysAdded(), GameConstants.DEFAULTCARDATTRIBUTE);
	}

	@Test
	public void testGetCardsAdded() {
		Card card = new Moneylender();

		assertEquals(card.getCardsAdded(), GameConstants.DEFAULTCARDATTRIBUTE);
	}

	@Test
	public void testGetVictoryValue() {
		Card card = new Moneylender();

		assertEquals(card.getVictoryValue(), GameConstants.DEFAULTCARDATTRIBUTE);
	}

	@Test
	public void testGetPlayState() {
		Card card = new Moneylender();

		assertEquals(card.getPlayState().getClass(), MoneylenderPlayState.class);
	}
	
	@Test
	public void testGetName() {
		Card card = new Moneylender();
		
		assertEquals(card.getName(), GameConstants.MONEYLENDERNAME);
	}
	
	@Test
	public void testGetText() {
		Card card = new Moneylender();
		
		assertEquals(card.getText(), GameConstants.MONEYLENDERTEXT);
	}
	
	@Test
	public void testGetTypeTranslationKeys() {
		Card card = new Moneylender();
		
		ArrayList<String> expectedTranslationKeys = new ArrayList<String>();
		expectedTranslationKeys.add("cardtypeAction");
		
		assertEquals(card.getTypeTranslationKeys(), expectedTranslationKeys);
	}

}
