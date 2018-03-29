import static org.junit.Assert.*;

import org.easymock.EasyMock;
import org.junit.Test;

public class TestTurn {

	@Test
	public void testTurnAllPass() {

		Player player = EasyMock.strictMock(Player.class);

		EasyMock.expect(player.playCard()).andReturn("");// action phase

		EasyMock.expect(player.buy()).andReturn(false);// buy phase

		EasyMock.expect(player.discardHand()).andReturn(false);// end cycle

		EasyMock.expect(player.drawACard()).andReturn(true);
		EasyMock.expect(player.drawACard()).andReturn(true);
		EasyMock.expect(player.drawACard()).andReturn(true);
		EasyMock.expect(player.drawACard()).andReturn(true);
		EasyMock.expect(player.drawACard()).andReturn(true);

		EasyMock.replay(player);

		Turn turn = new Turn(player);
		turn.run();

		EasyMock.verify(player);

	}

	@Test
	public void testTurnAllPlay() {
		Player player = EasyMock.strictMock(Player.class);

		EasyMock.expect(player.playCard()).andReturn("addBuy");// action phase

		EasyMock.expect(player.buy()).andReturn(true);// buy phase
		EasyMock.expect(player.buy()).andReturn(true);

		EasyMock.expect(player.discardHand()).andReturn(false);// end cycle

		EasyMock.expect(player.drawACard()).andReturn(true);
		EasyMock.expect(player.drawACard()).andReturn(true);
		EasyMock.expect(player.drawACard()).andReturn(true);
		EasyMock.expect(player.drawACard()).andReturn(true);
		EasyMock.expect(player.drawACard()).andReturn(true);

		EasyMock.replay(player);

		Turn turn = new Turn(player);
		turn.run();

		EasyMock.verify(player);
	}

	@Test
	public void testTurnPassBuy() {
		Player player = EasyMock.strictMock(Player.class);

		EasyMock.expect(player.playCard()).andReturn("addBuy");// action phase

		EasyMock.expect(player.buy()).andReturn(false);// buy phase

		EasyMock.expect(player.discardHand()).andReturn(false);// end cycle

		EasyMock.expect(player.drawACard()).andReturn(true);
		EasyMock.expect(player.drawACard()).andReturn(true);
		EasyMock.expect(player.drawACard()).andReturn(true);
		EasyMock.expect(player.drawACard()).andReturn(true);
		EasyMock.expect(player.drawACard()).andReturn(true);

		EasyMock.replay(player);

		Turn turn = new Turn(player);
		turn.run();

		EasyMock.verify(player);
	}

	@Test
	public void testAdd1Action() {
		Player player = EasyMock.strictMock(Player.class);

		EasyMock.expect(player.playCard()).andReturn("addAction");// action
																	// phase
		EasyMock.expect(player.playCard()).andReturn("");

		EasyMock.expect(player.buy()).andReturn(true);// buy phase

		EasyMock.expect(player.discardHand()).andReturn(false);// end cycle

		EasyMock.expect(player.drawACard()).andReturn(true);
		EasyMock.expect(player.drawACard()).andReturn(true);
		EasyMock.expect(player.drawACard()).andReturn(true);
		EasyMock.expect(player.drawACard()).andReturn(true);
		EasyMock.expect(player.drawACard()).andReturn(true);

		EasyMock.replay(player);

		Turn turn = new Turn(player);
		turn.run();

		EasyMock.verify(player);
	}

	@Test
	public void testAddManyAction() {
		Player player = EasyMock.strictMock(Player.class);

		EasyMock.expect(player.playCard()).andReturn("addAction");// action
																	// phase
		EasyMock.expect(player.playCard()).andReturn("addAction");
		EasyMock.expect(player.playCard()).andReturn("addAction");
		EasyMock.expect(player.playCard()).andReturn("addAction");
		EasyMock.expect(player.playCard()).andReturn("");

		EasyMock.expect(player.buy()).andReturn(true);// buy phase

		EasyMock.expect(player.discardHand()).andReturn(false);// end cycle

		EasyMock.expect(player.drawACard()).andReturn(true);
		EasyMock.expect(player.drawACard()).andReturn(true);
		EasyMock.expect(player.drawACard()).andReturn(true);
		EasyMock.expect(player.drawACard()).andReturn(true);
		EasyMock.expect(player.drawACard()).andReturn(true);

		EasyMock.replay(player);

		Turn turn = new Turn(player);
		turn.run();

		EasyMock.verify(player);
	}
	
	@Test
	public void testInitialStateSetup() {
		Player player = EasyMock.strictMock(Player.class);
		
		Turn turn = new Turn(player);
		assertTrue(turn.getCurrentStateType().equals("ACTION"));
	}
}
