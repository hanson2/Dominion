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
		
		assertEquals(card.getCoinsAdded(), 2);
	}
	
	@Test
	public void testFestivalActionsAdded() {
		Card card = new Festival();
		
		assertEquals(card.getActionsAdded(), 2);
	}
	
	@Test
	public void testFestivalBuysAdded() {
		Card card = new Festival();
		
		assertEquals(card.getBuysAdded(), 1);
	}
	
	@Test
	public void testFestivalCardsAdded() {
		Card card = new Festival();
		
		assertEquals(card.getCardsAdded(), 0);
	}
	
	@Test
	public void testFestivalVictoryValue() {
		Card card = new Festival();
		
		assertEquals(card.getVictoryValue(), 0);
	}
	
	@Test
	public void testFestivalCost() {
		Card card = new Festival();
		
		assertEquals(card.getCost(), 5);
	}

}
