package states;

import java.util.ArrayList;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gameComponents.Player;

public class CouncilRoomPlayStateTest {
	Turn turn;
	ArrayList<Player> subsequentPlayers;

	@Before
	public void setup() {
		subsequentPlayers = new ArrayList<Player>();
		subsequentPlayers.add(EasyMock.mock(Player.class));

		turn = new Turn(null, null, subsequentPlayers);
		turn.state = new CouncilRoomPlayState();
	}

	@After
	public void tearDown() {
		for (Player player2 : subsequentPlayers) {
			EasyMock.verify(player2);
		}
	}

	@Test
	public void testCouncilRoomPlayState2players() {

		for (Player player : subsequentPlayers) {
			player.drawACard();
		}

		for (Player player2 : subsequentPlayers) {
			EasyMock.replay(player2);
		}
		turn.run();
	}

	@Test
	public void testCouncilRoomPlayState3players() {
		subsequentPlayers.add(EasyMock.mock(Player.class));
		for (Player player : subsequentPlayers) {
			player.drawACard();
		}

		for (Player player2 : subsequentPlayers) {
			EasyMock.replay(player2);
		}
		turn.run();
	}

	@Test
	public void testCouncilRoomPlayState4players() {
		subsequentPlayers.add(EasyMock.mock(Player.class));
		subsequentPlayers.add(EasyMock.mock(Player.class));

		for (Player player : subsequentPlayers) {
			player.drawACard();
		}

		for (Player player2 : subsequentPlayers) {
			EasyMock.replay(player2);
		}
		turn.run();
	}
}
