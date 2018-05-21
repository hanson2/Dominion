package states;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.easymock.EasyMock;
import org.junit.Test;

import gameComponents.Player;
import gameComponents.PlayerCreator;
import gameComponents.Supply;
import util.CardType;

public class TurnTest {

	@Test
	public void testInitialStateSetup() {
		Player player = EasyMock.mock(Player.class);
		Supply supply = EasyMock.mock(Supply.class);
		Turn turn = new Turn(player, supply);

		EasyMock.replay(player);

		assertEquals(TurnActionState.class, turn.getCurrentStateType());

		EasyMock.verify(player);
	}

	@Test
	public void testFinalState() {
		Player player = PlayerCreator.makeMockedPlayer();
		Supply supply = EasyMock.mock(Supply.class);
		Turn turn = new Turn(player, supply);
		turn.playArea = new ArrayList<>();

		EasyMock.expect(player.chooseCardToPlay()).andReturn(Optional.empty());
		EasyMock.expect(player.buy(turn.supplyPiles)).andReturn(Optional.empty());
		player.cleanup(turn.playArea);

		EasyMock.replay(player);

		turn.run();

		assertEquals(TurnCleanupState.class, turn.getCurrentStateType());
	}

	private Set<CardType> getCardTypeSet(CardType type) {
		Set<CardType> toReturn = new HashSet<CardType>();
		toReturn.add(type);
		return toReturn;
	}

}
