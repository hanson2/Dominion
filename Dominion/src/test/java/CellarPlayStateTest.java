import static org.junit.Assert.*;

import org.easymock.EasyMock;
import org.junit.Test;

public class CellarPlayStateTest {

	@Test
	public void testDiscardNoCards() {
		CellarPlayState state = new CellarPlayState();
		Player player = EasyMock.mock(Player.class);
		Turn turn = EasyMock.mock(Turn.class);
		turn.player = player;
		turn.state = state;
		
		EasyMock.expect(player.sizeOfHand()).andReturn(5);
		EasyMock.expect(player.promptYesNo("Would you like to discard a card from your hand for +1 Card?")).andReturn(false);
		
		EasyMock.replay(player, turn);
		
		state.run(turn);
		
		EasyMock.verify(player, turn);
	}
	
	@Test
	public void testDiscardCardWithEmptyHand() {
		CellarPlayState state = new CellarPlayState();
		Player player = EasyMock.mock(Player.class);
		Turn turn = EasyMock.mock(Turn.class);
		turn.player = player;
		turn.state = state;		
		
		EasyMock.expect(player.sizeOfHand()).andReturn(0);
		
		EasyMock.replay(player, turn);
		
		state.run(turn);
		
		EasyMock.verify(player, turn);
	}
	
	@Test
	public void testDiscardLastCard() {
		CellarPlayState state = new CellarPlayState();
		Player player = EasyMock.mock(Player.class);
		Turn turn = EasyMock.mock(Turn.class);
		Card card = EasyMock.mock(Card.class);
		turn.player = player;
		turn.state = state;
		
		EasyMock.expect(player.sizeOfHand()).andReturn(1);
		EasyMock.expect(player.promptYesNo("Would you like to discard a card from your hand for +1 Card?")).andReturn(true);
		EasyMock.expect(player.chooseCardFromHand()).andReturn(card);
		EasyMock.expect(player.discardCardFromHand(card.getClass())).andReturn(true);
		
		EasyMock.expect(player.sizeOfHand()).andReturn(0);
		
		player.drawACard();
		EasyMock.expectLastCall();
		
		EasyMock.replay(player, turn);
		
		state.run(turn);
		
		EasyMock.verify(player, turn);
	}
	
	@Test
	public void testDiscardOneCardNotLast() {
		CellarPlayState state = new CellarPlayState();
		Player player = EasyMock.mock(Player.class);
		Turn turn = EasyMock.mock(Turn.class);
		Card card = EasyMock.mock(Card.class);
		turn.player = player;
		turn.state = state;
		
		EasyMock.expect(player.sizeOfHand()).andReturn(2);
		EasyMock.expect(player.promptYesNo("Would you like to discard a card from your hand for +1 Card?")).andReturn(true);
		EasyMock.expect(player.chooseCardFromHand()).andReturn(card);
		EasyMock.expect(player.discardCardFromHand(card.getClass())).andReturn(true);
		
		EasyMock.expect(player.sizeOfHand()).andReturn(1);
		EasyMock.expect(player.promptYesNo("Would you like to discard a card from your hand for +1 Card?")).andReturn(false);
		
		player.drawACard();
		EasyMock.expectLastCall();
		
		EasyMock.replay(player, turn);
		
		state.run(turn);
		
		EasyMock.verify(player, turn);
	}
	
	@Test
	public void testDiscardMultipleCardsLast() {
		CellarPlayState state = new CellarPlayState();
		Player player = EasyMock.mock(Player.class);
		Turn turn = EasyMock.mock(Turn.class);
		Card card = EasyMock.mock(Card.class);
		turn.player = player;
		turn.state = state;
		
		EasyMock.expect(player.sizeOfHand()).andReturn(2);
		EasyMock.expect(player.promptYesNo("Would you like to discard a card from your hand for +1 Card?")).andReturn(true);
		EasyMock.expect(player.chooseCardFromHand()).andReturn(card);
		EasyMock.expect(player.discardCardFromHand(card.getClass())).andReturn(true);
		
		EasyMock.expect(player.sizeOfHand()).andReturn(1);
		EasyMock.expect(player.promptYesNo("Would you like to discard a card from your hand for +1 Card?")).andReturn(true);
		EasyMock.expect(player.chooseCardFromHand()).andReturn(card);
		EasyMock.expect(player.discardCardFromHand(card.getClass())).andReturn(true);
		
		EasyMock.expect(player.sizeOfHand()).andReturn(0);
		
		player.drawACard();
		EasyMock.expectLastCall();
		player.drawACard();
		EasyMock.expectLastCall();
		
		EasyMock.replay(player, turn);
		
		state.run(turn);
		
		EasyMock.verify(player, turn);		
	}
	
	@Test
	public void testDiscardMultipleCardsNotLast() {
		CellarPlayState state = new CellarPlayState();
		Player player = EasyMock.mock(Player.class);
		Turn turn = EasyMock.mock(Turn.class);
		Card card = EasyMock.mock(Card.class);
		turn.player = player;
		turn.state = state;
		
		EasyMock.expect(player.sizeOfHand()).andReturn(5);
		EasyMock.expect(player.promptYesNo("Would you like to discard a card from your hand for +1 Card?")).andReturn(true);
		EasyMock.expect(player.chooseCardFromHand()).andReturn(card);
		EasyMock.expect(player.discardCardFromHand(card.getClass())).andReturn(true);
		
		EasyMock.expect(player.sizeOfHand()).andReturn(4);
		EasyMock.expect(player.promptYesNo("Would you like to discard a card from your hand for +1 Card?")).andReturn(true);
		EasyMock.expect(player.chooseCardFromHand()).andReturn(card);
		EasyMock.expect(player.discardCardFromHand(card.getClass())).andReturn(true);
		
		EasyMock.expect(player.sizeOfHand()).andReturn(3);
		EasyMock.expect(player.promptYesNo("Would you like to discard a card from your hand for +1 Card?")).andReturn(false);
		
		player.drawACard();
		EasyMock.expectLastCall();
		player.drawACard();
		EasyMock.expectLastCall();
		
		EasyMock.replay(player, turn);
		
		state.run(turn);
		
		EasyMock.verify(player, turn);		
	}

}
