import static org.junit.Assert.*;

import org.easymock.EasyMock;
import org.junit.Test;

public class ChapelPlayStateTest {

	@Test
	public void testTrashNoCards() {
		ChapelPlayState state = new ChapelPlayState();
		Player player = EasyMock.mock(Player.class);
		Turn turn = EasyMock.mock(Turn.class);
		turn.player = player;
		turn.state = state;
		
		EasyMock.expect(player.promptYesNo("Would you like to trash a card from your hand?")).andReturn(false);
		
		EasyMock.replay(player, turn);
		
		state.run(turn);
		
		EasyMock.verify(player, turn);		
	}
	
	@Test
	public void testTrashOneCard() {
		ChapelPlayState state = new ChapelPlayState();
		Card cardToTrash = new Copper();
		Player player = EasyMock.mock(Player.class);
		Turn turn = EasyMock.mock(Turn.class);
		turn.player = player;
		turn.state = state;
		
		EasyMock.expect(player.promptYesNo("Would you like to trash a card from your hand?")).andReturn(true);
		EasyMock.expect(player.chooseCardFromHand()).andReturn(cardToTrash);
		EasyMock.expect(player.trashCardFromHand(cardToTrash.getClass())).andReturn(true);
		
		EasyMock.expect(player.promptYesNo("Would you like to trash a card from your hand?")).andReturn(false);
		
		EasyMock.replay(player, turn);
		
		state.run(turn);
		
		EasyMock.verify(player, turn);		
	}
	
	@Test
	public void testTrashTwoCards() {
		ChapelPlayState state = new ChapelPlayState();
		Card cardToTrash = new Copper();
		Player player = EasyMock.mock(Player.class);
		Turn turn = EasyMock.mock(Turn.class);
		turn.player = player;
		turn.state = state;
		
		EasyMock.expect(player.promptYesNo("Would you like to trash a card from your hand?")).andReturn(true);
		EasyMock.expect(player.chooseCardFromHand()).andReturn(cardToTrash);
		EasyMock.expect(player.trashCardFromHand(cardToTrash.getClass())).andReturn(true);
		
		EasyMock.expect(player.promptYesNo("Would you like to trash a card from your hand?")).andReturn(true);
		EasyMock.expect(player.chooseCardFromHand()).andReturn(cardToTrash);
		EasyMock.expect(player.trashCardFromHand(cardToTrash.getClass())).andReturn(true);
		
		EasyMock.expect(player.promptYesNo("Would you like to trash a card from your hand?")).andReturn(false);
		
		EasyMock.replay(player, turn);
		
		state.run(turn);
		
		EasyMock.verify(player, turn);	
	}
	
	@Test
	public void testTrashThreeCards() {
		ChapelPlayState state = new ChapelPlayState();
		Card cardToTrash = new Copper();
		Player player = EasyMock.mock(Player.class);
		Turn turn = EasyMock.mock(Turn.class);
		turn.player = player;
		turn.state = state;
		
		EasyMock.expect(player.promptYesNo("Would you like to trash a card from your hand?")).andReturn(true);
		EasyMock.expect(player.chooseCardFromHand()).andReturn(cardToTrash);
		EasyMock.expect(player.trashCardFromHand(cardToTrash.getClass())).andReturn(true);
		
		EasyMock.expect(player.promptYesNo("Would you like to trash a card from your hand?")).andReturn(true);
		EasyMock.expect(player.chooseCardFromHand()).andReturn(cardToTrash);
		EasyMock.expect(player.trashCardFromHand(cardToTrash.getClass())).andReturn(true);
		
		EasyMock.expect(player.promptYesNo("Would you like to trash a card from your hand?")).andReturn(true);
		EasyMock.expect(player.chooseCardFromHand()).andReturn(cardToTrash);
		EasyMock.expect(player.trashCardFromHand(cardToTrash.getClass())).andReturn(true);
		
		EasyMock.expect(player.promptYesNo("Would you like to trash a card from your hand?")).andReturn(false);
		
		EasyMock.replay(player, turn);
		
		state.run(turn);
		
		EasyMock.verify(player, turn);	
	}
	
	@Test
	public void testTrashFourCards() {
		ChapelPlayState state = new ChapelPlayState();
		Card cardToTrash = new Copper();
		Player player = EasyMock.mock(Player.class);
		Turn turn = EasyMock.mock(Turn.class);
		turn.player = player;
		turn.state = state;
		
		EasyMock.expect(player.promptYesNo("Would you like to trash a card from your hand?")).andReturn(true);
		EasyMock.expect(player.chooseCardFromHand()).andReturn(cardToTrash);
		EasyMock.expect(player.trashCardFromHand(cardToTrash.getClass())).andReturn(true);
		
		EasyMock.expect(player.promptYesNo("Would you like to trash a card from your hand?")).andReturn(true);
		EasyMock.expect(player.chooseCardFromHand()).andReturn(cardToTrash);
		EasyMock.expect(player.trashCardFromHand(cardToTrash.getClass())).andReturn(true);
		
		EasyMock.expect(player.promptYesNo("Would you like to trash a card from your hand?")).andReturn(true);
		EasyMock.expect(player.chooseCardFromHand()).andReturn(cardToTrash);
		EasyMock.expect(player.trashCardFromHand(cardToTrash.getClass())).andReturn(true);
		
		EasyMock.expect(player.promptYesNo("Would you like to trash a card from your hand?")).andReturn(true);
		EasyMock.expect(player.chooseCardFromHand()).andReturn(cardToTrash);
		EasyMock.expect(player.trashCardFromHand(cardToTrash.getClass())).andReturn(true);
		
		EasyMock.replay(player, turn);
		
		state.run(turn);
		
		EasyMock.verify(player, turn);	
	}

}
