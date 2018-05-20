import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class MoatTest {
	
	Card card;
	
	@Before
	public void setup() {
		card = new Moat();
	}

	@Test
	public void testGetType() {
		assertTrue(card.getType().contains(CardType.ACTION));
		assertTrue(card.getType().contains(CardType.REACTION));
	}
	
	@Test
	public void testGetCost() {
		assertEquals(card.getCost(), GameConstants.MOATCOST);
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
		assertEquals(card.getCardsAdded(), GameConstants.MOATCARDSADDED);
	}

	@Test
	public void testGetVictoryValue() {
		assertEquals(card.getVictoryValue(), GameConstants.DEFAULTCARDATTRIBUTE);
	}
	
	@Test
	public void testGetPlayState() {
		assertEquals(card.getPlayState().getClass(), CardPlayState.class);
	}
	
	@Test
	public void testGetName() {
		assertEquals(card.getName(), GameConstants.MOATNAME);
	}
	
	@Test
	public void testGetText() {
		assertEquals(card.getText(), GameConstants.MOATTEXT);
	}
	
	@Test
	public void testTypeTranslationKeys() {
		ArrayList<String> expectedTranslationKeys = new ArrayList<String>();
		expectedTranslationKeys.add("cardtypeAction");
		expectedTranslationKeys.add("cardtypeReaction");
		
		assertEquals(card.getTypeTranslationKeys(), expectedTranslationKeys);
	}

}
