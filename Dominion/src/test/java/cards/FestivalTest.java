package cards;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import states.CardPlayState;
import util.CardType;
import util.GameConstants;

public class FestivalTest {

	@Test
	public void testFestivalType() {
		Card card = new Festival();
		
		assertTrue(card.getType().contains(CardType.ACTION));
	}
	
	@Test
	public void testFestivalPlayState() {
		Card card = new Festival();
		
		assertEquals(card.getPlayState().getClass(), CardPlayState.class);
	}
	
	@Test
	public void testFestivalCoinsAdded() {
		Card card = new Festival();
		
		assertEquals(card.getCoinsAdded(), GameConstants.FESTIVALCOINSADDED);
	}
	
	@Test
	public void testFestivalActionsAdded() {
		Card card = new Festival();
		
		assertEquals(card.getActionsAdded(), GameConstants.FESTIVALACTIONSADDED);
	}
	
	@Test
	public void testFestivalBuysAdded() {
		Card card = new Festival();
		
		assertEquals(card.getBuysAdded(), GameConstants.FESTIVALBUYSADDED);
	}
	
	@Test
	public void testFestivalCardsAdded() {
		Card card = new Festival();
		
		assertEquals(card.getCardsAdded(), GameConstants.DEFAULTCARDATTRIBUTE);
	}
	
	@Test
	public void testFestivalVictoryValue() {
		Card card = new Festival();
		
		assertEquals(card.getVictoryValue(), GameConstants.DEFAULTCARDATTRIBUTE);
	}
	
	@Test
	public void testFestivalCost() {
		Card card = new Festival();
		
		assertEquals(card.getCost(), GameConstants.FESTIVALCOST);
	}
	
	@Test
	public void testFestivalName() {
		Card card = new Festival();
		
		assertEquals(card.getName(), GameConstants.FESTIVALNAME);
	}
	
	@Test
	public void testFestivalText() {
		Card card = new Festival();
		
		assertEquals(card.getText(), GameConstants.DEFAULTCARDTEXT);
	}
	
	@Test
	public void testFestivalTypeTranslationKeys() {
		Card card = new Festival();
		
		ArrayList<String> expectedTranslationKeys = new ArrayList<String>();
		expectedTranslationKeys.add("cardtypeAction");
		
		assertEquals(card.getTypeTranslationKeys(), expectedTranslationKeys);
	}

}
