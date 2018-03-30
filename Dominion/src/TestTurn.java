import static org.junit.Assert.*;

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
		Player player = new Player("John");
		Turn turn = new Turn(player);

		turn.run();

		assertEquals(TurnCleanupState.class, turn.getCurrentStateType());
	}

}
