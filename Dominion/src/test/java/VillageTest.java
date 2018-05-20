import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class VillageTest {

	@Test
	public void testGetType() {
		Card village = new Village();
		assertTrue(village.getType().contains(CardType.ACTION));
	}

	@Test
	public void testGetCost() {
		Card village = new Village();
		assertEquals(village.getCost(), GameConstants.VILLAGECOST);
	}

	@Test
	public void testGetCoinsAdded() {
		Card village = new Village();
		assertEquals(village.getCoinsAdded(), GameConstants.DEFAULTCARDATTRIBUTE);
	}

	@Test
	public void testGetActionsAdded() {
		Card village = new Village();
		assertEquals(village.getActionsAdded(), GameConstants.VILLAGEACTIONSADDED);
	}

	@Test
	public void testGetBuysAdded() {
		Card village = new Village();
		assertEquals(village.getBuysAdded(), GameConstants.DEFAULTCARDATTRIBUTE);
	}

	@Test
	public void testGetCardsAdded() {
		Card village = new Village();
		assertEquals(village.getCardsAdded(), GameConstants.VILLAGECARDSADDED);
	}

	@Test
	public void testGetVictoryValue() {
		Card village = new Village();
		assertEquals(village.getVictoryValue(), GameConstants.DEFAULTCARDATTRIBUTE);
	}

	@Test
	public void testGetPlayState() {
		Card village = new Village();
		assertEquals(village.getPlayState().getClass(), CardPlayState.class);
	}
	
	@Test
	public void testGetName() {
		Card village = new Village();
		assertEquals(village.getName(), GameConstants.VILLAGENAME);
	}
	
	@Test
	public void testGetText() {
		Card village = new Village();
		assertEquals(village.getText(), GameConstants.DEFAULTCARDTEXT);
	}
	
	@Test
	public void testGetTypeTranslationKeys() {
		Card village = new Village();
		
		ArrayList<String> expectedTranslationKeys = new ArrayList<String>();
		expectedTranslationKeys.add("cardtypeAction");
		
		assertEquals(village.getTypeTranslationKeys(), expectedTranslationKeys);
	}

}
