package states;

import static org.junit.Assert.assertEquals;

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

		turn.actions = 1;
		turn.buys = 1;
		turn.coins = 0;
		turn.player = player;

		EasyMock.expect(player.chooseCardToPlay("guiActionPhase", turn.actions, turn.buys, turn.coins))
				.andReturn(Optional.of(card));
		EasyMock.expect(card.getType()).andReturn(type);
		EasyMock.expect(card.getActionsAdded()).andReturn(1);
		EasyMock.expect(card.getBuysAdded()).andReturn(1);
		EasyMock.expect(card.getCoinsAdded()).andReturn(1);
		EasyMock.expect(card.getCardsAdded()).andReturn(1);
		player.drawACard();
		EasyMock.expect(player.playCard(card, turn.playArea)).andReturn(turn.playArea);
		EasyMock.expect(card.getPlayState()).andReturn(new CardPlayState());
		turn.run();

		EasyMock.expect(player.chooseCardToPlay("guiActionPhase", turn.actions + 1, turn.buys + 1, turn.coins + 1))
				.andReturn(Optional.empty());

		turn.run();

		EasyMock.replay(player, turn, card);

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

		turn.actions = 1;
		turn.player = player;

		EasyMock.expect(player.chooseCardToPlay("guiActionPhase", turn.actions, turn.buys, turn.coins))
				.andReturn(Optional.of(card));
		EasyMock.expect(card.getType()).andReturn(type);
		EasyMock.expect(card.getActionsAdded()).andReturn(0);
		EasyMock.expect(card.getBuysAdded()).andReturn(0);
		EasyMock.expect(card.getCoinsAdded()).andReturn(0);
		EasyMock.expect(card.getCardsAdded()).andReturn(0);
		EasyMock.expect(player.playCard(card, turn.playArea)).andReturn(turn.playArea);
		EasyMock.expect(card.getPlayState()).andReturn(new CardPlayState());
		turn.run();

		EasyMock.expect(player.chooseCardToPlay("guiActionPhase", turn.actions - 1, turn.buys, turn.coins))
				.andReturn(Optional.of(action));
		EasyMock.expect(action.getType()).andReturn(type);

		EasyMock.expect(player.chooseCardToPlay("guiActionPhase", turn.actions - 1, turn.buys, turn.coins))
				.andReturn(Optional.empty());

		turn.run();

		EasyMock.replay(player, turn, card, action);

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

		turn.actions = 1;
		turn.player = player;

		EasyMock.expect(player.chooseCardToPlay("guiActionPhase", turn.actions, turn.buys, turn.coins))
				.andReturn(Optional.of(card));
		EasyMock.expect(card.getType()).andReturn(type);
		EasyMock.expect(card.getActionsAdded()).andReturn(1);
		EasyMock.expect(card.getBuysAdded()).andReturn(0);
		EasyMock.expect(card.getCoinsAdded()).andReturn(0);
		EasyMock.expect(card.getCardsAdded()).andReturn(0);
		EasyMock.expect(player.playCard(card, turn.playArea)).andReturn(turn.playArea);
		EasyMock.expect(card.getPlayState()).andReturn(new CardPlayState());

		turn.run();

		EasyMock.expect(player.chooseCardToPlay("guiActionPhase", turn.actions, turn.buys, turn.coins))
				.andReturn(Optional.of(action));
		EasyMock.expect(action.getType()).andReturn(type);
		EasyMock.expect(action.getActionsAdded()).andReturn(0);
		EasyMock.expect(action.getBuysAdded()).andReturn(0);
		EasyMock.expect(action.getCoinsAdded()).andReturn(0);
		EasyMock.expect(action.getCardsAdded()).andReturn(0);
		EasyMock.expect(player.playCard(action, turn.playArea)).andReturn(turn.playArea);
		EasyMock.expect(action.getPlayState()).andReturn(new CardPlayState());

		turn.run();

		EasyMock.expect(player.chooseCardToPlay("guiActionPhase", turn.actions - 1, turn.buys, turn.coins))
				.andReturn(Optional.empty());

		turn.run();

		EasyMock.replay(player, turn, card, action);

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

		turn.actions = 1;
		turn.player = player;

		EasyMock.expect(player.chooseCardToPlay("guiActionPhase", turn.actions, turn.buys, turn.coins))
				.andReturn(Optional.of(coin));
		EasyMock.expect(coin.getActionsAdded()).andReturn(0);
		EasyMock.expect(coin.getBuysAdded()).andReturn(0);
		EasyMock.expect(coin.getCoinsAdded()).andReturn(0);
		EasyMock.expect(coin.getType()).andReturn(this.getCardTypeSet(CardType.TREASURE));
		EasyMock.expect(coin.getCardsAdded()).andReturn(0);
		EasyMock.expect(player.playCard(coin, turn.playArea)).andReturn(turn.playArea);
		EasyMock.expect(coin.getPlayState()).andReturn(new CardPlayState());

		EasyMock.expect(player.chooseCardToPlay("guiActionPhase", turn.actions, turn.buys, turn.coins))
				.andReturn(Optional.of(action));
		EasyMock.expect(action.getActionsAdded()).andReturn(0);
		EasyMock.expect(action.getBuysAdded()).andReturn(0);
		EasyMock.expect(action.getCoinsAdded()).andReturn(0);
		EasyMock.expect(action.getType()).andReturn(this.getCardTypeSet(CardType.ACTION));
		EasyMock.expect(action.getCardsAdded()).andReturn(0);
		EasyMock.expect(player.playCard(action, turn.playArea)).andReturn(turn.playArea);
		EasyMock.expect(action.getPlayState()).andReturn(new CardPlayState());

		EasyMock.expect(player.chooseCardToPlay("guiActionPhase", turn.actions - 1, turn.buys, turn.coins))
				.andReturn(Optional.empty());

		turn.run();
		turn.run();
		turn.run();

		EasyMock.replay(player, turn, coin, action);

		TurnActionState state = new TurnActionState();

		state.run(turn);

		EasyMock.verify(player, turn, coin, action);
	}

	@Test
	public void testTurnActionStateSkip() {
		Player player = EasyMock.mock(Player.class);
		Turn turn = EasyMock.mock(Turn.class);
		turn.playArea = new ArrayList<>();

		turn.actions = 1;
		turn.buys = 1;
		turn.player = player;

		EasyMock.expect(player.chooseCardToPlay("guiActionPhase", turn.actions, turn.buys, turn.coins))
				.andReturn(Optional.empty());

		turn.run();

		EasyMock.replay(player, turn);

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

		turn.actions = 1;
		turn.buys = 1;
		turn.player = player;

		EasyMock.expect(player.chooseCardToPlay("guiActionPhase", turn.actions, turn.buys, turn.coins))
				.andReturn(Optional.of(action));
		EasyMock.expect(action.getActionsAdded()).andReturn(0);
		EasyMock.expect(action.getBuysAdded()).andReturn(0);
		EasyMock.expect(action.getCoinsAdded()).andReturn(0);
		EasyMock.expect(action.getType()).andReturn(this.getCardTypeSet(CardType.ACTION));
		EasyMock.expect(action.getCardsAdded()).andReturn(0);
		EasyMock.expect(player.playCard(action, turn.playArea)).andReturn(turn.playArea);
		EasyMock.expect(action.getPlayState()).andReturn(new CardPlayState());

		EasyMock.expect(player.chooseCardToPlay("guiActionPhase", turn.actions - 1, turn.buys, turn.coins))
				.andReturn(Optional.empty());

		turn.run();
		turn.run();

		EasyMock.replay(player, turn, action);

		TurnActionState state = new TurnActionState();
		state.run(turn);

		EasyMock.verify(player, turn, action);
	}

	@Test
	public void testNoSelectedCard() {
		Player player = EasyMock.mock(Player.class);
		Turn turn = EasyMock.mock(Turn.class);
		turn.playArea = new ArrayList<>();

		turn.actions = 1;
		turn.player = player;

		EasyMock.expect(player.chooseCardToPlay("guiActionPhase", turn.actions, turn.buys, turn.coins))
				.andReturn(Optional.empty());

		turn.run();

		EasyMock.replay(player, turn);

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
