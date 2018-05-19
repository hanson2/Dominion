import org.easymock.EasyMock;
import org.junit.Test;

public class TurnCleanupStateTest {

	@Test
	public void testTurnCleanupState() {
		Player player = EasyMock.mock(Player.class);
		Turn turn = EasyMock.mock(Turn.class);

		player.discardHand();

		player.drawNewHand();

		EasyMock.replay(player, turn);

		turn.player = player;// base value

		TurnCleanupState state = new TurnCleanupState();

		state.run(turn);

		EasyMock.verify(player, turn);
	}

}
