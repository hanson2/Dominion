import static org.junit.Assert.*;

import org.easymock.EasyMock;
import org.junit.Test;

public class TestTurn {

	@Test
	public void testInitialStateSetup() {
		Player player = new Player("John");
		Turn turn = new Turn(player);

		assertEquals(new TurnActionState(player, turn).getClass(), turn.getCurrentStateType());
	}

	@Test
	public void testFinalState() {
		Player player = new Player("John");
		Turn turn = new Turn(player);

		turn.run();

		assertEquals(new TurnCleanupState(player).getClass(), turn.getCurrentStateType());
	}

}
