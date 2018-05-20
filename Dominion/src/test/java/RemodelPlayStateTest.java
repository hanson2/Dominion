import java.util.Optional;

import org.easymock.EasyMock;
import org.junit.Test;

public class RemodelPlayStateTest {

	@Test
	public void testBaseCase() {
		Player player = EasyMock.strictMock(Player.class);
		Turn turn = EasyMock.strictMock(Turn.class);

		EasyMock.expect(player.chooseCardFromHand()).andReturn(new Curse());
		EasyMock.expect(player.trashCardFromHand(Curse.class)).andReturn(true);
		Card card = new Copper();
		EasyMock.expect(player.forcedBuy(2)).andReturn(card);
		
		player.gainCard(card);

		EasyMock.replay(turn, player);
		
		turn.player = player;
		RemodelPlayState state = new RemodelPlayState();
		state.run(turn);

		EasyMock.verify(turn, player);
	}
	@Test
	public void testExactCostBuy(){
		Player player = EasyMock.strictMock(Player.class);
		Turn turn = EasyMock.strictMock(Turn.class);

		EasyMock.expect(player.chooseCardFromHand()).andReturn(new Curse());
		EasyMock.expect(player.trashCardFromHand(Curse.class)).andReturn(true);
		Card card = new Estate();
		EasyMock.expect(player.forcedBuy(2)).andReturn(card);
		
		player.gainCard(card);

		EasyMock.replay(turn, player);
		
		turn.player = player;
		RemodelPlayState state = new RemodelPlayState();
		state.run(turn);

		EasyMock.verify(turn, player);
	}
	@Test
	public void testBadPurchase(){
		Player player = EasyMock.mock(Player.class);
		Turn turn = EasyMock.mock(Turn.class);

		EasyMock.expect(player.chooseCardFromHand()).andReturn(new Curse());
		EasyMock.expect(player.trashCardFromHand(Curse.class)).andReturn(true);
		EasyMock.expect(player.forcedBuy(2)).andReturn(new Gold());
		Card card = new Copper();
		EasyMock.expect(player.forcedBuy(2)).andReturn(card);

		player.gainCard(card);

		EasyMock.replay(turn, player);
		
		turn.player = player;
		RemodelPlayState state = new RemodelPlayState();
		state.run(turn);

		EasyMock.verify(turn, player);
	}
}
