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
}
