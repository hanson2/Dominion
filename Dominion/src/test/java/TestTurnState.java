import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;
import org.easymock.EasyMock;
import org.junit.Test;

public class TestTurnState {

	@Test
	public void testTurnActionStateBaseCard() {

		Player player = EasyMock.mock(Player.class);
		Turn turn = EasyMock.mock(Turn.class);
		Card card = EasyMock.mock(Card.class);

		EasyMock.expect(player.playCard()).andReturn(card);
		EasyMock.expect(card.getActionsAdded()).andReturn(0);
		EasyMock.expect(card.getBuysAdded()).andReturn(0);
		EasyMock.expect(card.getCoinsAdded()).andReturn(0);
		EasyMock.expect(card.getType()).andReturn(this.getCardTypeSet(CardType.ACTION));
		EasyMock.expect(card.getPlayState()).andReturn(new CardPlayState());

		turn.run();
		turn.run();

		EasyMock.replay(player, turn, card);

		turn.actions = 1;// base value
		turn.player = player;

		TurnActionState state = new TurnActionState();

		state.run(turn);

		EasyMock.verify(player, turn);

	}

	@Test
	public void testTurnActionStateAddOneAction() {
		Player player = EasyMock.mock(Player.class);
		Turn turn = EasyMock.mock(Turn.class);
		Card card = EasyMock.mock(Card.class);
		Card action = EasyMock.mock(Card.class);

		EasyMock.expect(player.playCard()).andReturn(card);
		EasyMock.expect(card.getActionsAdded()).andReturn(1);
		EasyMock.expect(card.getBuysAdded()).andReturn(0);
		EasyMock.expect(card.getCoinsAdded()).andReturn(0);
		EasyMock.expect(card.getType()).andReturn(this.getCardTypeSet(CardType.ACTION));
		EasyMock.expect(card.getPlayState()).andReturn(new CardPlayState());

		EasyMock.expect(player.playCard()).andReturn(action);
		EasyMock.expect(action.getActionsAdded()).andReturn(0);
		EasyMock.expect(action.getBuysAdded()).andReturn(0);
		EasyMock.expect(action.getCoinsAdded()).andReturn(0);
		EasyMock.expect(action.getType()).andReturn(this.getCardTypeSet(CardType.ACTION));
		EasyMock.expect(action.getPlayState()).andReturn(new CardPlayState());

		turn.run();
		turn.run();
		turn.run();

		EasyMock.replay(player, turn, card, action);

		turn.actions = 1;// base value
		turn.player = player;

		TurnActionState state = new TurnActionState();

		state.run(turn);

		EasyMock.verify(player, turn, card, action);
	}

	@Test
	public void testTurnActionStateAddTwoActions() {
		Player player = EasyMock.mock(Player.class);
		Turn turn = EasyMock.mock(Turn.class);
		Card card = EasyMock.mock(Card.class);
		Card action = EasyMock.mock(Card.class);

		EasyMock.expect(player.playCard()).andReturn(card);
		EasyMock.expect(card.getActionsAdded()).andReturn(2);
		EasyMock.expect(card.getBuysAdded()).andReturn(0);
		EasyMock.expect(card.getCoinsAdded()).andReturn(0);
		EasyMock.expect(card.getType()).andReturn(this.getCardTypeSet(CardType.ACTION));
		EasyMock.expect(card.getPlayState()).andReturn(new CardPlayState());

		EasyMock.expect(player.playCard()).andReturn(action);
		EasyMock.expect(action.getActionsAdded()).andReturn(0);
		EasyMock.expect(action.getBuysAdded()).andReturn(0);
		EasyMock.expect(action.getCoinsAdded()).andReturn(0);
		EasyMock.expect(action.getType()).andReturn(this.getCardTypeSet(CardType.ACTION));
		EasyMock.expect(action.getPlayState()).andReturn(new CardPlayState());

		EasyMock.expect(player.playCard()).andReturn(action);
		EasyMock.expect(action.getActionsAdded()).andReturn(0);
		EasyMock.expect(action.getBuysAdded()).andReturn(0);
		EasyMock.expect(action.getCoinsAdded()).andReturn(0);
		EasyMock.expect(action.getType()).andReturn(this.getCardTypeSet(CardType.ACTION));
		EasyMock.expect(action.getPlayState()).andReturn(new CardPlayState());

		turn.run();
		turn.run();
		turn.run();
		turn.run();

		EasyMock.replay(player, turn, card, action);

		turn.actions = 1;// base value
		turn.player = player;

		TurnActionState state = new TurnActionState();

		state.run(turn);

		EasyMock.verify(player, turn, card, action);
	}

	@Test
	public void testTurnActionStatePlayCoin() {
		Player player = EasyMock.mock(Player.class);
		Turn turn = EasyMock.mock(Turn.class);
		Card coin = EasyMock.mock(Card.class);
		Card action = EasyMock.mock(Card.class);

		EasyMock.expect(player.playCard()).andReturn(coin);
		EasyMock.expect(coin.getActionsAdded()).andReturn(0);
		EasyMock.expect(coin.getBuysAdded()).andReturn(0);
		EasyMock.expect(coin.getCoinsAdded()).andReturn(1);
		EasyMock.expect(coin.getType()).andReturn(this.getCardTypeSet(CardType.TREASURE));
		EasyMock.expect(coin.getPlayState()).andReturn(new CardPlayState());

		EasyMock.expect(player.playCard()).andReturn(action);
		EasyMock.expect(action.getActionsAdded()).andReturn(0);
		EasyMock.expect(action.getBuysAdded()).andReturn(0);
		EasyMock.expect(action.getCoinsAdded()).andReturn(0);
		EasyMock.expect(action.getType()).andReturn(this.getCardTypeSet(CardType.ACTION));
		EasyMock.expect(action.getPlayState()).andReturn(new CardPlayState());

		turn.run();
		turn.run();
		turn.run();

		EasyMock.replay(player, turn, coin, action);

		turn.actions = 1;// base value
		turn.coins = 0;
		turn.player = player;

		TurnActionState state = new TurnActionState();

		state.run(turn);
		
		assertEquals(turn.coins, 1);

		EasyMock.verify(player, turn, coin, action);
	}
	
	@Test
	public void testTurnActionStatePlayBuy() {
		Player player = EasyMock.mock(Player.class);
		Turn turn = EasyMock.mock(Turn.class);
		Card coin = EasyMock.mock(Card.class);
		Card action = EasyMock.mock(Card.class);

		EasyMock.expect(player.playCard()).andReturn(action);
		EasyMock.expect(action.getActionsAdded()).andReturn(0);
		EasyMock.expect(action.getBuysAdded()).andReturn(1);
		EasyMock.expect(action.getCoinsAdded()).andReturn(0);
		EasyMock.expect(action.getType()).andReturn(this.getCardTypeSet(CardType.ACTION));
		EasyMock.expect(action.getPlayState()).andReturn(new CardPlayState());

		turn.run();
		turn.run();

		EasyMock.replay(player, turn, coin, action);

		turn.actions = 1;
		turn.buys = 1;
		turn.player = player;

		TurnActionState state = new TurnActionState();

		state.run(turn);

		assertEquals(turn.buys, 2);
		EasyMock.verify(player, turn, coin, action);
	}

	@Test
	public void testTurnBuyStateBase() {
		Player player = EasyMock.mock(Player.class);
		Turn turn = EasyMock.mock(Turn.class);

		EasyMock.expect(player.buy()).andReturn(true);

		turn.run();

		EasyMock.replay(player, turn);

		turn.buys = 1;// base value
		turn.player = player;

		TurnBuyState state = new TurnBuyState();

		state.run(turn);

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

		turn.buys = 2;// base value
		turn.player = player;

		TurnBuyState state = new TurnBuyState();

		state.run(turn);

		EasyMock.verify(player, turn);
	}

	@Test
	public void testTurnBuyStateExitBuyEarly() {
		Player player = EasyMock.mock(Player.class);
		Turn turn = EasyMock.mock(Turn.class);

		EasyMock.expect(player.buy()).andReturn(false);

		turn.run();

		EasyMock.replay(player, turn);

		turn.buys = 2;// base value
		turn.player = player;

		TurnBuyState state = new TurnBuyState();

		state.run(turn);

		EasyMock.verify(player, turn);
	}

	@Test
	public void testTurnCleanupState() {
		Player player = EasyMock.mock(Player.class);
		Turn turn = new Turn(player);

		player.discardHand();

		player.drawNewHand();

		EasyMock.replay(player);

		turn.player = player;// base value

		TurnCleanupState state = new TurnCleanupState();

		state.run(turn);

		EasyMock.verify(player);
	}

	private Set<CardType> getCardTypeSet(CardType type) {
		Set<CardType> toReturn = new HashSet<CardType>();
		toReturn.add(type);
		return toReturn;
	}

}
