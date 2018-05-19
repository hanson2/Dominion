import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;
import java.util.Optional;

import org.easymock.EasyMock;
import org.junit.Test;

public class TestTurn {

	@Test
	public void testInitialStateSetup() {
		Player player = EasyMock.mock(Player.class);
		Supply supply = EasyMock.mock(Supply.class);
		Turn turn = new Turn(player, supply);

		assertEquals(TurnActionState.class, turn.getCurrentStateType());
	}

	@Test
	public void testFinalState() {
		Player player = EasyMock.mock(Player.class);
		Supply supply = EasyMock.mock(Supply.class);
		Card card = EasyMock.mock(Card.class);
		Turn turn = new Turn(player, supply);

		EasyMock.expect(player.playCard()).andReturn(card);
		EasyMock.expect(card.getActionsAdded()).andReturn(0);
		EasyMock.expect(card.getBuysAdded()).andReturn(0);
		EasyMock.expect(card.getCoinsAdded()).andReturn(0);
		EasyMock.expect(card.getType()).andReturn(this.getCardTypeSet(CardType.ACTION));
		EasyMock.expect(card.getPlayState()).andReturn(new CardPlayState());
		EasyMock.expect(player.buy()).andReturn(Optional.empty());
		player.discardHand();
		player.drawNewHand();

		EasyMock.replay(player, card);

		turn.run();

		assertEquals(TurnCleanupState.class, turn.getCurrentStateType());
	}

	private Set<CardType> getCardTypeSet(CardType type) {
		Set<CardType> toReturn = new HashSet<CardType>();
		toReturn.add(type);
		return toReturn;
	}

}
