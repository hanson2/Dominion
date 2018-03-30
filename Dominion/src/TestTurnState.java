import static org.junit.Assert.*;

import org.easymock.EasyMock;
import org.junit.Test;

public class TestTurnState {

	@Test
	public void testTurnActionStateBaseCard() {

		Player player = EasyMock.mock(Player.class);
		Turn turn = EasyMock.mock(Turn.class);

		EasyMock.expect(player.playCard()).andReturn(new Copper());
		turn.run();

		EasyMock.replay(player, turn);

		turn.actions = 1;// base value

		TurnActionState state = new TurnActionState(turn);

		state.run();

		EasyMock.verify(player, turn);

	}

	@Test
	public void testTurnActionStateAddOneAction() {
		Player player = EasyMock.mock(Player.class);
		Turn turn = EasyMock.mock(Turn.class);
		Card card = EasyMock.mock(Card.class);

		EasyMock.expect(player.playCard()).andReturn(card);
		EasyMock.expect(card.getActionsAdded()).andReturn(1);
		EasyMock.expect(card.getBuysAdded()).andReturn(0);
		EasyMock.expect(player.playCard()).andReturn(new Copper());

		turn.run();

		EasyMock.replay(player, turn, card);

		turn.actions = 1;// base value

		TurnActionState state = new TurnActionState(turn);

		state.run();

		EasyMock.verify(player, turn);
	}

	@Test
	public void testTurnActionStateAddTwoActions() {
		Player player = EasyMock.mock(Player.class);
		Turn turn = EasyMock.mock(Turn.class);
		Card card = EasyMock.mock(Card.class);

		EasyMock.expect(player.playCard()).andReturn(card);
		EasyMock.expect(card.getActionsAdded()).andReturn(2);
		EasyMock.expect(card.getBuysAdded()).andReturn(0);
		EasyMock.expect(player.playCard()).andReturn(new Copper());
		EasyMock.expect(player.playCard()).andReturn(new Copper());

		turn.run();

		EasyMock.replay(player, turn, card);

		turn.actions = 1;// base value

		TurnActionState state = new TurnActionState(turn);

		state.run();

		EasyMock.verify(player, turn);
	}

	@Test
	public void testTurnBuyStateBase() {
		Player player = EasyMock.mock(Player.class);
		Turn turn = EasyMock.mock(Turn.class);

		EasyMock.expect(player.buy()).andReturn(true);

		turn.run();

		EasyMock.replay(player, turn);

		turn.buys = 1;

		TurnBuyState state = new TurnBuyState(turn);

		state.run();

		EasyMock.verify(player, turn);
	}

	@Test
	public void testTurnBuyStateMultipleBuys() {
		Player player = EasyMock.mock(Player.class);
		Turn turn = EasyMock.mock(Turn.class);

		EasyMock.expect(player.buy()).andReturn(true);
		EasyMock.expect(player.buy()).andReturn(true);

		turn.run();

		EasyMock.replay(player, turn);

		turn.buys = 2;

		TurnBuyState state = new TurnBuyState(turn);

		state.run();

		EasyMock.verify(player, turn);
	}

	@Test
	public void testTurnBuyStateExitBuyEarly() {
		Player player = EasyMock.mock(Player.class);
		Turn turn = EasyMock.mock(Turn.class);

		EasyMock.expect(player.buy()).andReturn(false);

		turn.run();

		EasyMock.replay(player, turn);

		turn.buys = 2;

		TurnBuyState state = new TurnBuyState(turn);

		state.run();

		EasyMock.verify(player, turn);
	}

	@Test
	public void testTurnCleanupState() {
		Player player = EasyMock.mock(Player.class);
		Turn turn = new Turn(player);

		player.discardHand();

		player.drawACard();
		player.drawACard();
		player.drawACard();
		player.drawACard();
		player.drawACard();

		EasyMock.replay(player);

		TurnCleanupState state = new TurnCleanupState(turn);

		state.run();

		EasyMock.verify(player);
	}

}
