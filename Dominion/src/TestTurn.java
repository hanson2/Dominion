import static org.junit.Assert.*;

import org.easymock.EasyMock;
import org.junit.Test;

public class TestTurn {

	@Test
	public void testInitialStateSetup() {
		Player player = new Player("John");
		Turn turn = new Turn(player);

		assertEquals(TurnActionState.class, turn.getCurrentStateType());
	}

	@Test
	public void testFinalState() {
		Player player = EasyMock.mock(Player.class);

		Turn turn = new Turn(player);

		EasyMock.expect(player.playCard()).andReturn(new Copper());
		EasyMock.expect(player.buy()).andReturn(true);
		player.discardHand();
		player.drawNewHand();

		EasyMock.replay(player);

		turn.run();

		assertEquals(TurnCleanupState.class, turn.getCurrentStateType());
	}

}
