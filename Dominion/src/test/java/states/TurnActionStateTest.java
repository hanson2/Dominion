package states;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import org.easymock.EasyMock;
import org.junit.Test;

import cards.Card;
import gameComponents.Player;
import util.CardType;

public class TurnActionStateTest {

	@Test
	public void testTurnActionStateBaseCard() {

		Player player = EasyMock.mock(Player.class);
		Turn turn = EasyMock.mock(Turn.class);
		Card card = EasyMock.mock(Card.class);
		turn.playArea = new ArrayList<>();
		Set<CardType> type = new TreeSet<>();
		type.add(CardType.TREASURE);

		EasyMock.expect(player.chooseCardToPlay()).andReturn(Optional.of(card));
		EasyMock.expect(card.getType()).andReturn(type);
		EasyMock.expect(card.getActionsAdded()).andReturn(1);
		EasyMock.expect(card.getBuysAdded()).andReturn(1);
		EasyMock.expect(card.getCoinsAdded()).andReturn(1);
		EasyMock.expect(card.getCardsAdded()).andReturn(1);
		player.drawACard();
		EasyMock.expect(player.discardCardFromHand(card.getClass())).andReturn(false);
		EasyMock.expect(card.getPlayState()).andReturn(new CardPlayState());
		turn.run();

		EasyMock.expect(player.chooseCardToPlay()).andReturn(Optional.empty());

		turn.run();

		EasyMock.replay(player, turn, card);

		turn.actions = 1;// base value
		turn.buys = 1;
		turn.coins = 0;
		turn.player = player;

		TurnActionState state = new TurnActionState();

		state.run(turn);

		assertEquals(turn.actions, 2);
		assertEquals(turn.buys, 2);
		assertEquals(turn.coins, 1);
		EasyMock.verify(player, turn);

	}

	@Test
	public void testTurnActionStateAddNoActionTwoCards() {
		Player player = EasyMock.mock(Player.class);
		Turn turn = EasyMock.mock(Turn.class);
		Card card = EasyMock.mock(Card.class);
		Card action = EasyMock.mock(Card.class);
		turn.playArea = new ArrayList<>();
		Set<CardType> type = new TreeSet<>();
		type.add(CardType.ACTION);

		EasyMock.expect(player.chooseCardToPlay()).andReturn(Optional.of(card));
		EasyMock.expect(card.getType()).andReturn(type);
		EasyMock.expect(card.getActionsAdded()).andReturn(0);
		EasyMock.expect(card.getBuysAdded()).andReturn(0);
		EasyMock.expect(card.getCoinsAdded()).andReturn(0);
		EasyMock.expect(card.getCardsAdded()).andReturn(0);
		EasyMock.expect(player.discardCardFromHand(card.getClass())).andReturn(true);
		EasyMock.expect(card.getPlayState()).andReturn(new CardPlayState());
		turn.run();

		EasyMock.expect(player.chooseCardToPlay()).andReturn(Optional.of(action));
		EasyMock.expect(action.getType()).andReturn(type);

		EasyMock.expect(player.chooseCardToPlay()).andReturn(Optional.empty());

		turn.run();

		EasyMock.replay(player, turn, card, action);

		turn.actions = 1;// base value
		turn.player = player;

		TurnActionState state = new TurnActionState();

		state.run(turn);

		EasyMock.verify(player, turn, card, action);
	}

	@Test
	public void testTurnActionStateAddOneActionTwoCards() {
		Player player = EasyMock.mock(Player.class);
		Turn turn = EasyMock.mock(Turn.class);
		Card card = EasyMock.mock(Card.class);
		Card action = EasyMock.mock(Card.class);
		turn.playArea = new ArrayList<>();
		Set<CardType> type = new TreeSet<>();
		type.add(CardType.ACTION);

		EasyMock.expect(player.chooseCardToPlay()).andReturn(Optional.of(card));
		EasyMock.expect(card.getType()).andReturn(type);
		EasyMock.expect(card.getActionsAdded()).andReturn(1);
		EasyMock.expect(card.getBuysAdded()).andReturn(0);
		EasyMock.expect(card.getCoinsAdded()).andReturn(0);
		EasyMock.expect(card.getCardsAdded()).andReturn(0);
		EasyMock.expect(player.discardCardFromHand(card.getClass())).andReturn(true);
		EasyMock.expect(card.getPlayState()).andReturn(new CardPlayState());

		turn.run();

		EasyMock.expect(player.chooseCardToPlay()).andReturn(Optional.of(action));
		EasyMock.expect(action.getType()).andReturn(type);
		EasyMock.expect(action.getActionsAdded()).andReturn(0);
		EasyMock.expect(action.getBuysAdded()).andReturn(0);
		EasyMock.expect(action.getCoinsAdded()).andReturn(0);
		EasyMock.expect(action.getCardsAdded()).andReturn(0);
		EasyMock.expect(player.discardCardFromHand(action.getClass())).andReturn(true);
		EasyMock.expect(action.getPlayState()).andReturn(new CardPlayState());

		turn.run();

		EasyMock.expect(player.chooseCardToPlay()).andReturn(Optional.empty());

		turn.run();

		EasyMock.replay(player, turn, card, action);

		turn.actions = 1;// base value
		turn.player = player;

		TurnActionState state = new TurnActionState();

		state.run(turn);

		EasyMock.verify(player, turn, card, action);
	}

	@Test
	public void testTurnActionStatePlayTwo() {
		Player player = EasyMock.mock(Player.class);
		Turn turn = EasyMock.mock(Turn.class);
		Card coin = EasyMock.mock(Card.class);
		Card action = EasyMock.mock(Card.class);
		turn.playArea = new ArrayList<>();

		EasyMock.expect(player.chooseCardToPlay()).andReturn(Optional.of(coin));
		EasyMock.expect(coin.getActionsAdded()).andReturn(0);
		EasyMock.expect(coin.getBuysAdded()).andReturn(0);
		EasyMock.expect(coin.getCoinsAdded()).andReturn(0);
		EasyMock.expect(coin.getType()).andReturn(this.getCardTypeSet(CardType.TREASURE));
		EasyMock.expect(coin.getCardsAdded()).andReturn(0);
		EasyMock.expect(player.discardCardFromHand(coin.getClass())).andReturn(true);
		EasyMock.expect(coin.getPlayState()).andReturn(new CardPlayState());

		EasyMock.expect(player.chooseCardToPlay()).andReturn(Optional.of(action));
		EasyMock.expect(action.getActionsAdded()).andReturn(0);
		EasyMock.expect(action.getBuysAdded()).andReturn(0);
		EasyMock.expect(action.getCoinsAdded()).andReturn(0);
		EasyMock.expect(action.getType()).andReturn(this.getCardTypeSet(CardType.ACTION));
		EasyMock.expect(action.getCardsAdded()).andReturn(0);
		EasyMock.expect(player.discardCardFromHand(coin.getClass())).andReturn(true);
		EasyMock.expect(action.getPlayState()).andReturn(new CardPlayState());

		EasyMock.expect(player.chooseCardToPlay()).andReturn(Optional.empty());

		turn.run();
		turn.run();
		turn.run();

		EasyMock.replay(player, turn, coin, action);

		turn.actions = 1;// base value
		turn.player = player;

		TurnActionState state = new TurnActionState();

		state.run(turn);

		EasyMock.verify(player, turn, coin, action);
	}

	@Test
	public void testTurnActionStateSkip() {
		Player player = EasyMock.mock(Player.class);
		Turn turn = EasyMock.mock(Turn.class);
		turn.playArea = new ArrayList<>();

		EasyMock.expect(player.chooseCardToPlay()).andReturn(Optional.empty());

		turn.run();

		EasyMock.replay(player, turn);

		turn.actions = 1;
		turn.buys = 1;
		turn.player = player;

		TurnActionState state = new TurnActionState();

		state.run(turn);

		EasyMock.verify(player, turn);
	}

	@Test
	public void testAddToPlayArea() {
		Player player = EasyMock.mock(Player.class);
		Turn turn = EasyMock.mock(Turn.class);
		Card action = EasyMock.mock(Card.class);
		turn.playArea = new ArrayList<>();

		EasyMock.expect(player.chooseCardToPlay()).andReturn(Optional.of(action));
		EasyMock.expect(action.getActionsAdded()).andReturn(0);
		EasyMock.expect(action.getBuysAdded()).andReturn(0);
		EasyMock.expect(action.getCoinsAdded()).andReturn(0);
		EasyMock.expect(action.getType()).andReturn(this.getCardTypeSet(CardType.ACTION));
		EasyMock.expect(action.getCardsAdded()).andReturn(0);
		EasyMock.expect(player.discardCardFromHand(action.getClass())).andReturn(true);
		EasyMock.expect(action.getPlayState()).andReturn(new CardPlayState());

		EasyMock.expect(player.chooseCardToPlay()).andReturn(Optional.empty());

		turn.run();
		turn.run();

		EasyMock.replay(player, turn, action);

		turn.actions = 1;
		turn.buys = 1;
		turn.player = player;

		TurnActionState state = new TurnActionState();
		state.run(turn);

		assertTrue(turn.playArea.contains(action));

		EasyMock.verify(player, turn, action);
	}

	@Test
	public void testNoSelectedCard() {
		Player player = EasyMock.mock(Player.class);
		Turn turn = EasyMock.mock(Turn.class);
		turn.playArea = new ArrayList<>();

		EasyMock.expect(player.chooseCardToPlay()).andReturn(Optional.empty());

		turn.run();

		EasyMock.replay(player, turn);

		turn.actions = 1;
		turn.player = player;

		TurnActionState state = new TurnActionState();
		state.run(turn);

		EasyMock.verify(turn);
	}

	private Set<CardType> getCardTypeSet(CardType type) {
		Set<CardType> toReturn = new HashSet<CardType>();
		toReturn.add(type);
		return toReturn;
	}

}
