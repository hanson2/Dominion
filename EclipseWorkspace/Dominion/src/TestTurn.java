import static org.junit.Assert.*;

import org.easymock.EasyMock;
import org.junit.Test;

public class TestTurn {

	@Test
	public void testTurnAllPass() {

		Player player = EasyMock.strictMock(Player.class);

		EasyMock.expect(player.playCard()).andReturn("");//action phase
		
		EasyMock.expect(player.buy()).andReturn(true);//buy phase

		EasyMock.expect(player.discardHand()).andReturn(true);//end cycle

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
