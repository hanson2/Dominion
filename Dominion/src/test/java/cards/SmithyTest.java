package cards;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import states.CardPlayState;
import util.CardType;
import util.GameConstants;

public class SmithyTest {

	@Test
	public void testSmithyType() {
		Card card = new Smithy();
		
		assertTrue(card.getType().contains(CardType.ACTION));
	}
	
	@Test
	public void testSmithyPlayState() {
		Card card = new Smithy();
		
		assertEquals(card.getPlayState().getClass(), CardPlayState.class);
	}

	@Test
	public void testSmithyCoinsAdded() {
		Card card = new Smithy();
		
		assertEquals(card.getCoinsAdded(), GameConstants.DEFAULTCARDATTRIBUTE);
	}
	
	@Test
	public void testSmithyActionsAdded() {
		Card card = new Smithy();
		
		assertEquals(card.getActionsAdded(), GameConstants.DEFAULTCARDATTRIBUTE);
	}
	
	@Test
	public void testSmithyBuysAdded() {
		Card card = new Smithy();
		
		assertEquals(card.getBuysAdded(), GameConstants.DEFAULTCARDATTRIBUTE);
	}
	
	@Test
	public void testSmithyCardsAdded() {
		Card card = new Smithy();
		
		assertEquals(card.getCardsAdded(), GameConstants.SMITHYCARDSADDED);
	}
	
	@Test
	public void testSmithyVictoryValue() {
		Card card = new Smithy();
		
		assertEquals(card.getVictoryValue(), GameConstants.DEFAULTCARDATTRIBUTE);
	}
	
	@Test
	public void testSmithyCost() {
		Card card = new Smithy();
		
		assertEquals(card.getCost(), GameConstants.SMITHYCOST);
	}
	
	@Test
	public void testSmithyName() {
		Card card = new Smithy();
		
		assertEquals(card.getName(), GameConstants.SMITHYNAME);
	}
	
	@Test
	public void testSmithyText() {
		Card card = new Smithy();
		
		assertEquals(card.getText(), GameConstants.DEFAULTCARDTEXT);
	}
	
	@Test
	public void testSmithyTypeTranslationKeys() {
		Card card = new Smithy();
		
		ArrayList<String> expectedTranslationKeys = new ArrayList<String>();
		expectedTranslationKeys.add("cardtypeAction");
		
		assertEquals(card.getTypeTranslationKeys(), expectedTranslationKeys);
	}
}
