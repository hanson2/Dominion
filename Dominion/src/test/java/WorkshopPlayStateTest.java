import java.util.Optional;

import org.easymock.EasyMock;
import org.junit.Test;

public class WorkshopPlayStateTest {
	@Test
	public void testBaseCase() {
		Player player = EasyMock.strictMock(Player.class);
		Turn turn = EasyMock.strictMock(Turn.class);
		Card card = new Copper();
		EasyMock.expect(player.buy()).andReturn(Optional.of(card));
		player.gainCard(card);
		
		EasyMock.replay(turn, player);
		
		turn.player = player;
		WorkshopPlayState state = new WorkshopPlayState();
		state.run(turn);

		EasyMock.verify(turn, player);
	}
	@Test
	public void testExactCostBuy(){
		Player player = EasyMock.strictMock(Player.class);
		Turn turn = EasyMock.strictMock(Turn.class);
		Card card = new Moneylender();
		EasyMock.expect(player.buy()).andReturn(Optional.of(card));
		player.gainCard(card);
		
		EasyMock.replay(turn, player);
		
		turn.player = player;
		WorkshopPlayState state = new WorkshopPlayState();
		state.run(turn);

		EasyMock.verify(turn, player);
	}
	@Test
	public void testBadPurchase(){
		Player player = EasyMock.strictMock(Player.class);
		Turn turn = EasyMock.strictMock(Turn.class);
		Card card = new Market();
		EasyMock.expect(player.buy()).andReturn(Optional.of(card));
		card = new Copper();
		EasyMock.expect(player.buy()).andReturn(Optional.of(card));
		player.gainCard(card);
		
		EasyMock.replay(turn, player);
		
		turn.player = player;
		WorkshopPlayState state = new WorkshopPlayState();
		state.run(turn);

		EasyMock.verify(turn, player);
	}

}
