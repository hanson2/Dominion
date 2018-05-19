import static org.junit.Assert.*;

import org.easymock.EasyMock;
import org.junit.Test;

public class ChancellorPlayStateTest {

	@Test
	public void testDoAction() {
		Player player = EasyMock.mock(Player.class);
		Turn turn = EasyMock.mock(Turn.class);
		
		EasyMock.expect(player.promptYesNo("chancellorPrompt")).andReturn(true);
		
		player.discardDrawPile();
		EasyMock.expectLastCall();
		
		EasyMock.replay(player, turn);
		
		turn.player = player;
		
		ChancellorPlayState state = new ChancellorPlayState();
		
		state.run(turn);
		
		EasyMock.verify(turn, player);
	}
	
	@Test
	public void testDoNotDoAction() {
		Player player = EasyMock.mock(Player.class);
		Turn turn = EasyMock.mock(Turn.class);
		
		EasyMock.expect(player.promptYesNo("chancellorPrompt")).andReturn(false);
		
		EasyMock.replay(player, turn);
		
		turn.player = player;
		
		ChancellorPlayState state = new ChancellorPlayState();
		
		state.run(turn);
		
		EasyMock.verify(turn, player);
	}

}
