package states;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Optional;

import org.easymock.EasyMock;
import org.junit.Test;

import gameComponents.Player;
import gameComponents.PlayerCreator;
import gameComponents.Supply;

public class TurnTest {

	@Test
	public void testInitialStateSetup() {
		Player player = EasyMock.mock(Player.class);
		Supply supply = EasyMock.mock(Supply.class);
		ArrayList<Player> subsequentPlayers = new ArrayList<Player>();
		Turn turn = new Turn(player, supply, subsequentPlayers);

		EasyMock.replay(player);

		assertEquals(TurnActionState.class, turn.getCurrentStateType());

		EasyMock.verify(player);
	}

	@Test
	public void testFinalState() {
		Player player = PlayerCreator.makeMockedPlayer();
		Supply supply = EasyMock.mock(Supply.class);
		ArrayList<Player> subsequentPlayers = new ArrayList<Player>();
		Turn turn = new Turn(player, supply, subsequentPlayers);
		turn.playArea = new ArrayList<>();

		EasyMock.expect(player.chooseCardToPlay("guiActionPhase", turn.actions, turn.buys, turn.coins))
				.andReturn(Optional.empty());
		EasyMock.expect(player.buy(turn.supplyPiles, "guiBuyPhase", turn.actions, turn.buys, turn.coins))
				.andReturn(Optional.empty());
		player.cleanup(turn.playArea);

		EasyMock.replay(player);

		turn.run();

		assertEquals(TurnCleanupState.class, turn.getCurrentStateType());
	}

}
