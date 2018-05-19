import static org.junit.Assert.*;

import org.junit.Test;

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

}
