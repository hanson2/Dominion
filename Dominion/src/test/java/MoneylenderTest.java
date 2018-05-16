import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.Test;

public class MoneylenderTest {

	@Test
	public void testGetType() {
		Card card = new Moneylender();

		assertTrue(card.getType().contains(CardType.ACTION));
	}

	@Test
	public void testGetCost() {
		Card card = new Moneylender();

		assertEquals(card.getCost(), GameConstants.MONEYLENDERCOST);
	}

	@Test
	public void testGetCoinsAdded() {
		Card card = new Moneylender();

		assertEquals(card.getCoinsAdded(), GameConstants.DEFAULTCARDATTRIBUTE);
	}

	@Test
	public void testGetActionsAdded() {
		Card card = new Moneylender();

		assertEquals(card.getActionsAdded(), GameConstants.DEFAULTCARDATTRIBUTE);
	}

	@Test
	public void testGetBuysAdded() {
		Card card = new Moneylender();

		assertEquals(card.getBuysAdded(), GameConstants.DEFAULTCARDATTRIBUTE);
	}

	@Test
	public void testGetCardsAdded() {
		Card card = new Moneylender();

		assertEquals(card.getCardsAdded(), GameConstants.DEFAULTCARDATTRIBUTE);
	}

	@Test
	public void testGetVictoryValue() {
		Card card = new Moneylender();

		assertEquals(card.getVictoryValue(), GameConstants.DEFAULTCARDATTRIBUTE);
	}

	@Test
	public void testGetPlayState() {
		Card card = new Moneylender();

		assertEquals(card.getPlayState().getClass(), MoneylenderPlayState.class);
	}

	@Test
	public void testPlayStateDoActionCopperInHandYes() {
		Player player = EasyMock.partialMockBuilder(Player.class).withConstructor("test").addMockedMethod("promptYesNo")
				.createMock();
		Turn turn = new Turn(player);
		player.drawNewHand();

		EasyMock.expect(player.promptYesNo("Would you like to trash a Copper card from your hand for 3 coins?"))
				.andReturn(true);

		EasyMock.replay(player);

		MoneylenderPlayState state = new MoneylenderPlayState();

		state.run(turn);

		assertEquals(player.sizeOfHand(), 4);
		assertEquals(turn.coins, 3);

		EasyMock.verify(player);
	}

	@Test
	public void testPlayStateDoActionCopperNotInHandYes() {
		Player player = EasyMock.partialMockBuilder(Player.class).withConstructor("test").addMockedMethod("promptYesNo")
				.createMock();
		Turn turn = new Turn(player);
		player.gainCard(new Silver());
		player.drawACard();

		EasyMock.expect(player.promptYesNo("Would you like to trash a Copper card from your hand for 3 coins?"))
				.andReturn(true);

		player.trashCardFromHand(Copper.class);

		EasyMock.replay(player);

		MoneylenderPlayState state = new MoneylenderPlayState();

		state.run(turn);

		assertEquals(player.sizeOfHand(), 1);
		assertEquals(turn.coins, 0);

		EasyMock.verify(player);
	}
	
	@Test
	public void testPlayStateDoActionCopperInHandNo() {
		Player player = EasyMock.partialMockBuilder(Player.class).withConstructor("test").addMockedMethod("promptYesNo")
				.createMock();
		Turn turn = new Turn(player);
		player.drawNewHand();

		EasyMock.expect(player.promptYesNo("Would you like to trash a Copper card from your hand for 3 coins?"))
				.andReturn(false);

		EasyMock.replay(player);

		MoneylenderPlayState state = new MoneylenderPlayState();

		state.run(turn);

		assertEquals(player.sizeOfHand(), 5);
		assertEquals(turn.coins, 0);

		EasyMock.verify(player);
	}
	
	@Test
	public void testPlayStateDoActionCopperNotInHandNo() {
		Player player = EasyMock.partialMockBuilder(Player.class).withConstructor("test").addMockedMethod("promptYesNo")
				.createMock();
		Turn turn = new Turn(player);

		EasyMock.expect(player.promptYesNo("Would you like to trash a Copper card from your hand for 3 coins?"))
				.andReturn(false);

		EasyMock.replay(player);

		MoneylenderPlayState state = new MoneylenderPlayState();

		state.run(turn);

		assertEquals(player.sizeOfHand(), 0);
		assertEquals(turn.coins, 0);

		EasyMock.verify(player);
	}

}
