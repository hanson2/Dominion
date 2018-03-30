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
}
