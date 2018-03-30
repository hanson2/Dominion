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
}
