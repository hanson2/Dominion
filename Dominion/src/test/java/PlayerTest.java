import static org.junit.Assert.*;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

public class PlayerTest {
	
	Player player;
	
	@Before
	public void setup() {
		player = new Player("test");
	}

	@Test
	public void testPlayerSetup() {
		assertEquals(player.sizeOfDrawPile(), 10);
		assertEquals(player.sizeOfHand(), 0);
		assertEquals(player.sizeOfDiscardPile(), 0);
	}

	@Test
	public void testDrawCard() {
		player.drawACard();

		assertEquals(player.sizeOfDrawPile(), 9);
		assertEquals(player.sizeOfHand(), 1);
		assertEquals(player.sizeOfDiscardPile(), 0);
	}

	@Test
	public void testDrawManyCardsEmptyDiscard() {
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
		player.discardHand();

		assertEquals(player.sizeOfDrawPile(), 10);
		assertEquals(player.sizeOfHand(), 0);
		assertEquals(player.sizeOfDiscardPile(), 0);
	}

	@Test
	public void testDiscardHandOneCard() {
		player.drawACard();
		player.discardHand();

		assertEquals(player.sizeOfDrawPile(), 9);
		assertEquals(player.sizeOfHand(), 0);
		assertEquals(player.sizeOfDiscardPile(), 1);
	}
	
	@Test
	public void testDiscardDrawPileEmpty() {
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
		assertEquals(player.getPoints(), 3);
	}

	@Test
	public void testGetPointsOneEstateAdded() {
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
		player.drawACard();

		assertTrue(player.getHand().get(0).getClass().equals(Copper.class)
				|| player.getHand().get(0).getClass().equals(Estate.class));
	}

	@Test
	public void testContentsOfHandTwoCards() {
		player.drawACard();
		player.drawACard();

		assertTrue(player.getHand().get(0).getClass().equals(Copper.class)
				|| player.getHand().get(0).getClass().equals(Estate.class));
		assertTrue(player.getHand().get(1).getClass().equals(Copper.class)
						|| player.getHand().get(1).getClass().equals(Estate.class));
	}

	@Test
	public void testContentsOfStarterHand() {
		player.drawNewHand();

		for (Card card : player.getHand()) {
			assertTrue(card.getClass().equals(Copper.class) || card.getClass().equals(Estate.class));
		}
	}

	@Test
	public void testContentsOfHandNoCards() {
		assertTrue(player.getHand().isEmpty());
	}

	@Test
	public void testGainCard() {
		int discardPileSizeBefore = player.sizeOfDiscardPile();
		player.gainCard(new Estate());

		assertEquals(player.sizeOfDiscardPile(), discardPileSizeBefore + 1);
	}
	
	@Test
	public void testTrashCardInHand() {
		player.drawNewHand();
		
		assertTrue(player.trashCardFromHand(Copper.class));
		assertEquals(player.sizeOfHand(), 4);
	}
	
	@Test
	public void testTrashCardNotInHand(){
		player.drawNewHand();
		
		assertFalse(player.trashCardFromHand(Silver.class));
		assertEquals(player.sizeOfHand(), 5);
	}
	
	@Test
	public void testDiscardCardInHand() {
		Player player = new Player("John");
		
		player.drawNewHand();
		
		assertTrue(player.discardCardFromHand(Copper.class));
		assertEquals(player.sizeOfHand(), 4);
		assertEquals(player.sizeOfDiscardPile(), 1);
	}
	
	@Test
	public void testDiscardCardNotInHand(){
		Player player = new Player("John");
		
		player.drawNewHand();
		
		assertFalse(player.discardCardFromHand(Silver.class));
		assertEquals(player.sizeOfHand(), 5);
		assertEquals(player.sizeOfDiscardPile(), 0);
	}
	
	@Test
	public void testDiscardTopCardOfDrawPile() {
		Card card = new Silver();
		player.drawPile.push(card);
		
		assertEquals(player.discardTopCardOfDrawPile().get(), card);
	}
	
	@Test
	public void testDiscardTopCardOfDrawPileEmpty() {
		player.drawNewHand();
		player.drawNewHand();
		
		assertFalse(player.discardTopCardOfDrawPile().isPresent());
	}
	
	@Test
	public void testDiscardTopCardOfDrawPileNonEmpty() {
		assertTrue(player.discardTopCardOfDrawPile().isPresent());
		assertEquals(player.sizeOfDiscardPile(), 1);
	}
	
	@Test
	public void testDiscardTopCardOfDrawPileEmptyWithFullDiscardPile() {
		player.drawNewHand();
		player.discardHand();
		player.drawNewHand();
		
		assertTrue(player.discardTopCardOfDrawPile().isPresent());
		assertEquals(player.sizeOfDiscardPile(), 1);
	}
	
}
