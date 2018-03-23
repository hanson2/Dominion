import static org.junit.Assert.*;

import org.easymock.EasyMock;
import org.junit.Test;

public class TestTurn {

	@Test
	public void testTurn() {

		Player player = EasyMock.strictMock(Player.class);

		EasyMock.expect(player.discardHand()).andReturn(true);

		EasyMock.expect(player.drawACard()).andReturn(true);
		EasyMock.expect(player.drawACard()).andReturn(true);
		EasyMock.expect(player.drawACard()).andReturn(true);
		EasyMock.expect(player.drawACard()).andReturn(true);
		EasyMock.expect(player.drawACard()).andReturn(true);

		EasyMock.replay(player);
		
		Turn turn = new Turn(player);
		turn.run();
		
		EasyMock.verify(player);

	}

}
