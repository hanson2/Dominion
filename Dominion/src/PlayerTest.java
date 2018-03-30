import static org.junit.Assert.*;

import org.easymock.EasyMock;
import org.junit.Test;

public class PlayerTest {
	
	@Test
	public void testPlayerSetup(){
		Player player = new Player("John");
		
		assertTrue(player.sizeOfDrawPile() == 10);
		assertTrue(player.sizeOfHand() == 0);
		assertTrue(player.sizeOfDiscardPile() == 0);
	}
	
	@Test
	public void testDrawCard(){
		Player player = new Player("John");
		
		player.drawACard();
		
		assertTrue(player.sizeOfDrawPile() == 9);
		assertTrue(player.sizeOfHand() == 1);
		assertTrue(player.sizeOfDiscardPile() == 0);
	}
	
	@Test
	public void testDrawManyCardsEmptyDiscard(){
		Player player = new Player("John");
		
		for(int i = 0; i < 12; i++){
			player.drawACard();
		}
		
		assertTrue(player.sizeOfDrawPile() == 0);
		assertTrue(player.sizeOfHand() == 10);
		assertTrue(player.sizeOfDiscardPile() == 0);
	}
	
	@Test
	public void testDiscardHandEmpty(){
		Player player = new Player("John");
		
		player.discardHand();
		
		assertTrue(player.sizeOfDrawPile() == 10);
		assertTrue(player.sizeOfHand() == 0);
		assertTrue(player.sizeOfDiscardPile() == 0);
	}
	
	@Test
	public void testDiscardHandOneCard(){
		Player player = new Player("John");
		
		player.drawACard();
		player.discardHand();
		
		assertTrue(player.sizeOfDrawPile() == 9);
		assertTrue(player.sizeOfHand() == 0);
		assertTrue(player.sizeOfDiscardPile() == 1);
	}
	
	@Test
	public void testDrawManyCardsNonEmptyDiscard(){
		Player player = new Player("John");
		
		player.drawACard();
		player.discardHand();
		for(int i = 0; i < 11; i++){
			player.drawACard();
		}
		
		assertTrue(player.sizeOfDrawPile() == 0);
		assertTrue(player.sizeOfHand() == 10);
		assertTrue(player.sizeOfDiscardPile() == 0);
	}
	
	@Test
	public void testGetPointsStarter(){
		Player player = new Player("John");
		
		assertEquals(player.getPoints(), 3);
	}
}
