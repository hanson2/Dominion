import static org.junit.Assert.*;

import org.easymock.EasyMock;
import org.junit.Test;

public class PlayerTest {

	@Test
	public void testPlayerSetup() {
		Player player = new Player("John");

		assertEquals(player.sizeOfDrawPile(), 10);
		assertEquals(player.sizeOfHand(), 0);
		assertEquals(player.sizeOfDiscardPile(), 0);
	}

	@Test
	public void testDrawCard() {
		Player player = new Player("John");

		player.drawACard();

		assertEquals(player.sizeOfDrawPile(), 9);
		assertEquals(player.sizeOfHand(), 1);
		assertEquals(player.sizeOfDiscardPile(), 0);
	}

	@Test
	public void testDrawManyCardsEmptyDiscard() {
		Player player = new Player("John");

		for (int i = 0; i < 12; i++) {
			player.drawACard();
		}

		assertEquals(player.sizeOfDrawPile(), 0);
		assertEquals(player.sizeOfHand(), 10);
		assertEquals(player.sizeOfDiscardPile(), 0);
	}
	
	@Test
	public void testDrawCardsEmptyDrawFullDiscard() {
		Player player = new Player("John");
		
		player.drawNewHand();
		player.discardHand();
		player.drawNewHand();
		player.drawACard();
		
		assertEquals(player.sizeOfDrawPile(), 4);
		assertEquals(player.sizeOfHand(), 6);
		assertEquals(player.sizeOfDiscardPile(), 0);	
	}

	@Test
	public void testDiscardHandEmpty() {
		Player player = new Player("John");

		player.discardHand();

		assertEquals(player.sizeOfDrawPile(), 10);
		assertEquals(player.sizeOfHand(), 0);
		assertEquals(player.sizeOfDiscardPile(), 0);
	}

	@Test
	public void testDiscardHandOneCard() {
		Player player = new Player("John");

		player.drawACard();
		player.discardHand();

		assertEquals(player.sizeOfDrawPile(), 9);
		assertEquals(player.sizeOfHand(), 0);
		assertEquals(player.sizeOfDiscardPile(), 1);
	}
	
	@Test
	public void testDiscardDrawPileEmpty() {
		Player player = new Player("John");
		
		for(int i = 0; i < 10; i++){
			player.drawACard();
		}
		
		player.discardDrawPile();
		
		assertEquals(player.sizeOfDiscardPile(), 0);
		assertEquals(player.sizeOfDrawPile(), 0);
		assertEquals(player.sizeOfHand(), 10);
	}
	
	@Test
	public void testDiscardDrawPileOneCard() {
		Player player = new Player("John");
		
		for(int i = 0; i < 9; i++){
			player.drawACard();
		}
		
		player.discardDrawPile();
		
		assertEquals(player.sizeOfDiscardPile(), 1);
		assertEquals(player.sizeOfDrawPile(), 0);
		assertEquals(player.sizeOfHand(), 9);
	}

	@Test
	public void testDrawManyCardsNonEmptyDiscard() {
		Player player = new Player("John");

		player.drawACard();
		player.discardHand();
		for (int i = 0; i < 11; i++) {
			player.drawACard();
		}

		assertEquals(player.sizeOfDrawPile(), 0);
		assertEquals(player.sizeOfHand(), 10);
		assertEquals(player.sizeOfDiscardPile(), 0);
	}

	@Test
	public void testGetPointsStarter() {
		Player player = new Player("John");

		assertEquals(player.getPoints(), 3);
	}

	@Test
	public void testGetPointsOneEstateAdded() {
		Player player = new Player("John");

		player.gainCard(new Estate());

		assertEquals(player.getPoints(), 4);
	}
	
	@Test
	public void testGetPointsAllCardsInHand() {
		Player player = new Player("John");
		
		player.drawNewHand();
		player.drawNewHand();
		
		assertEquals(player.getPoints(), 3);
	}
	
	@Test
	public void testGetPointsAllCardInDiscard() {
		Player player = new Player("John");
		
		player.drawNewHand();
		player.drawNewHand();
		player.discardHand();
		
		assertEquals(player.getPoints(), 3);
	}

	@Test
	public void testContentsOfHandOneCard() {
		Player player = new Player("John");

		player.drawACard();

		assertTrue(player.getHand().get(0).getClass().equals(Copper.class)
				|| player.getHand().get(0).getClass().equals(Estate.class));
	}

	@Test
	public void testContentsOfHandTwoCards() {
		Player player = new Player("John");

		player.drawACard();
		player.drawACard();

		assertTrue(player.getHand().get(0).getClass().equals(Copper.class)
				|| player.getHand().get(0).getClass().equals(Estate.class));
		assertTrue(player.getHand().get(1).getClass().equals(Copper.class)
						|| player.getHand().get(1).getClass().equals(Estate.class));
	}

	@Test
	public void testContentsOfStarterHand() {
		Player player = new Player("John");

		player.drawNewHand();

		for (Card card : player.getHand()) {
			assertTrue(card.getClass().equals(Copper.class) || card.getClass().equals(Estate.class));
		}
	}

	@Test
	public void testContentsOfHandNoCards() {
		Player player = new Player("John");

		assertTrue(player.getHand().isEmpty());
	}

	@Test
	public void testGainCard() {
		Player player = new Player("John");

		int discardPileSizeBefore = player.sizeOfDiscardPile();
		player.gainCard(new Estate());

		assertEquals(player.sizeOfDiscardPile(), discardPileSizeBefore + 1);
	}
	
	@Test
	public void testTrashCardInHand() {
		Player player = new Player("John");
		
		player.drawNewHand();
		
		assertTrue(player.trashCardFromHand(Copper.class));
	}
	
	@Test
	public void testTrashCardNotInHand(){
		Player player = new Player("John");
		
		player.drawNewHand();
		
		assertFalse(player.trashCardFromHand(Silver.class));
	}
}
