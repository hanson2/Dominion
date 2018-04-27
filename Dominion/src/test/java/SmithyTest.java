import static org.junit.Assert.*;

import org.junit.Test;

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
		
		assertEquals(card.getCoinsAdded(), 0);
	}
	
	@Test
	public void testSmithyActionsAdded() {
		Card card = new Smithy();
		
		assertEquals(card.getActionsAdded(), 0);
	}
	
	@Test
	public void testSmithyBuysAdded() {
		Card card = new Smithy();
		
		assertEquals(card.getBuysAdded(), 0);
	}
	
	@Test
	public void testSmithyCardsAdded() {
		Card card = new Smithy();
		
		assertEquals(card.getCardsAdded(), 3);
	}
	
	@Test
	public void testSmithyVictoryValue() {
		Card card = new Smithy();
		
		assertEquals(card.getVictoryValue(), 0);
	}
	
	@Test
	public void testSmithyCost() {
		Card card = new Smithy();
		
		assertEquals(card.getCost(), 4);
	}
}
