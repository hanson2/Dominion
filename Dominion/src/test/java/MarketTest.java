import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class MarketTest {

	@Test
	public void testGetType() {
		Card card = new Market();

		assertTrue(card.getType().contains(CardType.ACTION));
	}

	@Test
	public void testGetCost() {
		Card card = new Market();

		assertEquals(card.getCost(), GameConstants.MARKETCOST);
	}

	@Test
	public void testGetCoinsAdded() {
		Card card = new Market();

		assertEquals(card.getCoinsAdded(), GameConstants.MARKETCOINSADDED);
	}

	@Test
	public void testGetActionsAdded() {
		Card card = new Market();

		assertEquals(card.getActionsAdded(), GameConstants.MARKETACTIONSADDED);
	}

	@Test
	public void testGetBuysAdded() {
		Card card = new Market();

		assertEquals(card.getBuysAdded(), GameConstants.MARKETBUYSADDED);
	}

	@Test
	public void testGetCardsAdded() {
		Card card = new Market();

		assertEquals(card.getCardsAdded(), GameConstants.MARKETCARDSADDED);
	}

	@Test
	public void testGetVictoryValue() {
		Card card = new Market();

		assertEquals(card.getVictoryValue(), GameConstants.DEFAULTCARDATTRIBUTE);
	}

	@Test
	public void testGetPlayState() {
		Card card = new Market();

		assertEquals(card.getPlayState().getClass(), CardPlayState.class);
	}
	
	@Test
	public void testGetName() {
		Card card = new Market();
		
		assertEquals(card.getName(), GameConstants.MARKETNAME);
	}
	
	@Test
	public void testGetText() {
		Card card = new Market();
		
		assertEquals(card.getText(), GameConstants.DEFAULTCARDTEXT);
	}
	
	@Test
	public void testGetTypeTranslationKeys() {
		Card card = new Market();
		
		ArrayList<String> expectedTranslationKeys = new ArrayList<String>();
		expectedTranslationKeys.add("cardtypeAction");
		
		assertEquals(card.getTypeTranslationKeys(), expectedTranslationKeys);
	}

}
