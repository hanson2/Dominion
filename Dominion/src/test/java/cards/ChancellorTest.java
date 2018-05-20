package cards;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import states.ChancellorPlayState;
import util.CardType;
import util.GameConstants;

public class ChancellorTest {

	@Test
	public void testGetType() {
		Card card = new Chancellor();
		
		assertTrue(card.getType().contains(CardType.ACTION));
	}

	@Test
	public void testGetCost() {
		Card card = new Chancellor();
		
		assertEquals(card.getCost(), GameConstants.CHANCELLORCOST);
	}

	@Test
	public void testGetCoinsAdded() {
		Card card = new Chancellor();
		
		assertEquals(card.getCoinsAdded(), GameConstants.CHANCELLORCOINSADDED);
	}

	@Test
	public void testGetActionsAdded() {
		Card card = new Chancellor();
		
		assertEquals(card.getActionsAdded(), GameConstants.DEFAULTCARDATTRIBUTE);
	}

	@Test
	public void testGetBuysAdded() {
		Card card = new Chancellor();
		
		assertEquals(card.getBuysAdded(), GameConstants.DEFAULTCARDATTRIBUTE);
	}

	@Test
	public void testGetCardsAdded() {
		Card card = new Chancellor();
		
		assertEquals(card.getCardsAdded(), GameConstants.DEFAULTCARDATTRIBUTE);
	}

	@Test
	public void testGetVictoryValue() {
		Card card = new Chancellor();
		
		assertEquals(card.getVictoryValue(), GameConstants.DEFAULTCARDATTRIBUTE);
	}

	@Test
	public void testGetPlayState() {
		Card card = new Chancellor();
		
		assertEquals(card.getPlayState().getClass(), ChancellorPlayState.class);
	}
	
	@Test
	public void testGetName() {
		Card card = new Chancellor();
		
		assertEquals(card.getName(), GameConstants.CHANCELLORNAME);
	}
	
	@Test
	public void testGetText() {
		Card card = new Chancellor();
		
		assertEquals(card.getText(), GameConstants.CHANCELLORTEXT);
	}
	
	@Test
	public void testGetTypeTranslationKeys() {
		Card card = new Chancellor();
		
		ArrayList<String> expectedTranslationKeys = new ArrayList<String>();
		expectedTranslationKeys.add("cardtypeAction");
		
		assertEquals(card.getTypeTranslationKeys(), expectedTranslationKeys);
	}

}
