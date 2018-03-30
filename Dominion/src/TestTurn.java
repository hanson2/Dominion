import static org.junit.Assert.*;

import org.easymock.EasyMock;
import org.junit.Test;

public class TestTurn {

	@Test
	public void testTurnAllPass() {

		Player player = EasyMock.mock(Player.class);

		EasyMock.expect(player.buy()).andReturn(false);// buy phase

		player.discardHand();

		player.drawACard();
		player.drawACard();
		player.drawACard();
		player.drawACard();
		player.drawACard();

		EasyMock.replay(player);

		Turn turn = new Turn(player);
		turn.run();

		EasyMock.verify(player);

	}

	@Test
	public void testTurnAllPlay() {
		Player player = EasyMock.mock(Player.class);
		Card cardToPlay = EasyMock.mock(Card.class);
		EasyMock.expect(cardToPlay.getBuysAdded()).andReturn(1);
		EasyMock.expect(cardToPlay.getBuysAdded()).andReturn(0);

		EasyMock.expect(player.playCard()).andReturn(cardToPlay);

		EasyMock.expect(player.buy()).andReturn(true);
		EasyMock.expect(player.buy()).andReturn(true);

		player.discardHand();

		player.drawACard();
		player.drawACard();
		player.drawACard();
		player.drawACard();
		player.drawACard();

		EasyMock.replay(player);
		EasyMock.replay(cardToPlay);

		Turn turn = new Turn(player);
		turn.run();

		EasyMock.verify(player);
		EasyMock.verify(cardToPlay);
	}

	@Test
	public void testTurnPassBuy() {
		Player player = EasyMock.mock(Player.class);
		Card cardToPlay = EasyMock.mock(Card.class);
		EasyMock.expect(cardToPlay.getBuysAdded()).andReturn(1);

		EasyMock.expect(player.playCard()).andReturn(cardToPlay);

		EasyMock.expect(player.buy()).andReturn(false);

		player.discardHand();

		player.drawACard();
		player.drawACard();
		player.drawACard();
		player.drawACard();
		player.drawACard();

		EasyMock.replay(player);
		EasyMock.replay(cardToPlay);

		Turn turn = new Turn(player);
		turn.run();

		EasyMock.verify(player);
		EasyMock.verify(cardToPlay);
	}

	@Test
	public void testAdd1Action() {
		Player player = EasyMock.mock(Player.class);
		Card cardToPlay = EasyMock.mock(Card.class);
		EasyMock.expect(cardToPlay.getActionsAdded()).andReturn(1);
		EasyMock.expect(cardToPlay.getBuysAdded()).andReturn(0);

		EasyMock.expect(player.playCard()).andReturn(cardToPlay);

		EasyMock.expect(player.buy()).andReturn(true);// buy phase

		player.discardHand();

		player.drawACard();
		player.drawACard();
		player.drawACard();
		player.drawACard();
		player.drawACard();

		EasyMock.replay(player);
		EasyMock.replay(cardToPlay);

		Turn turn = new Turn(player);
		turn.run();

		EasyMock.verify(player);
		EasyMock.verify(cardToPlay);
	}

	@Test
	public void testAddManyAction() {
		Player player = EasyMock.mock(Player.class);
		Card cardToPlay = EasyMock.mock(Card.class);
		EasyMock.expect(cardToPlay.getActionsAdded()).andReturn(3);
		EasyMock.expect(cardToPlay.getActionsAdded()).andReturn(0);
		EasyMock.expect(cardToPlay.getActionsAdded()).andReturn(0);
		EasyMock.expect(cardToPlay.getActionsAdded()).andReturn(0);
		EasyMock.expect(cardToPlay.getBuysAdded()).andReturn(0);
		EasyMock.expect(cardToPlay.getBuysAdded()).andReturn(0);
		EasyMock.expect(cardToPlay.getBuysAdded()).andReturn(0);
		EasyMock.expect(cardToPlay.getBuysAdded()).andReturn(0);

		EasyMock.expect(player.playCard()).andReturn(cardToPlay);
		EasyMock.expect(player.playCard()).andReturn(cardToPlay);
		EasyMock.expect(player.playCard()).andReturn(cardToPlay);
		EasyMock.expect(player.playCard()).andReturn(cardToPlay);

		EasyMock.expect(player.buy()).andReturn(true);// buy phase

		player.discardHand();

		player.drawACard();
		player.drawACard();
		player.drawACard();
		player.drawACard();
		player.drawACard();

		EasyMock.replay(player);
		EasyMock.replay(cardToPlay);

		Turn turn = new Turn(player);
		turn.run();

		EasyMock.verify(player);
		EasyMock.verify(cardToPlay);
	}

	@Test
	public void testInitialStateSetup() {
		Player player = EasyMock.mock(Player.class);

		Turn turn = new Turn(player);
		assertTrue(turn.getCurrentStateType().equals("ACTION"));

		EasyMock.verify(player);
	}

	@Test
	public void testCheckStateAfterOneRun() {
		Player player = EasyMock.mock(Player.class);

		Turn turn = new Turn(player);
		turn.run();
		assertTrue(turn.getCurrentStateType().equals("BUY"));

		EasyMock.verify(player);
	}
}
