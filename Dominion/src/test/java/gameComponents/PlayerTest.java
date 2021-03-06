package gameComponents;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cards.Card;
import cards.Copper;
import cards.Estate;
import cards.Gardens;
import cards.Province;
import cards.Silver;

public class PlayerTest {

	GUI gui;
	Player player;

	@Before
	public void setup() {
		gui = EasyMock.mock(GUI.class);
		player = new Player("Test", gui);
		EasyMock.replay(gui);
	}

	@After
	public void tearDown() {
		EasyMock.verify(gui);
	}

	@Test
	public void testGetName() {
		assertEquals(player.getName(), "Test");
	}

	@Test
	public void testPlayerSetup() {
		assertEquals(player.sizeOfDrawPile(), 10);
		assertEquals(player.sizeOfHand(), 0);
		assertEquals(player.sizeOfDiscardPile(), 0);
	}

	@Test
	public void testDrawCard() {
		player.drawACard();

		assertEquals(player.sizeOfDrawPile(), 9);
		assertEquals(player.sizeOfHand(), 1);
		assertEquals(player.sizeOfDiscardPile(), 0);
	}

	@Test
	public void testDrawManyCardsEmptyDiscard() {
		for (int i = 0; i < 12; i++) {
			player.drawACard();
		}

		assertEquals(player.sizeOfDrawPile(), 0);
		assertEquals(player.sizeOfHand(), 10);
		assertEquals(player.sizeOfDiscardPile(), 0);
	}

	@Test
	public void testDrawCardsEmptyDrawFullDiscard() {
		player.drawNewHand();
		player.discardHand();
		player.drawNewHand();
		player.drawACard();

		assertEquals(player.sizeOfDrawPile(), 4);
		assertEquals(player.sizeOfHand(), 6);
		assertEquals(player.sizeOfDiscardPile(), 0);
	}

	@Test
	public void testDiscardHandEmpty() {
		player.discardHand();

		assertEquals(player.sizeOfDrawPile(), 10);
		assertEquals(player.sizeOfHand(), 0);
		assertEquals(player.sizeOfDiscardPile(), 0);
	}

	@Test
	public void testDiscardHandOneCard() {
		player.drawACard();
		player.discardHand();

		assertEquals(player.sizeOfDrawPile(), 9);
		assertEquals(player.sizeOfHand(), 0);
		assertEquals(player.sizeOfDiscardPile(), 1);
	}

	@Test
	public void testDiscardDrawPileEmpty() {
		for (int i = 0; i < 10; i++) {
			player.drawACard();
		}

		player.discardDrawPile();

		assertEquals(player.sizeOfDiscardPile(), 0);
		assertEquals(player.sizeOfDrawPile(), 0);
		assertEquals(player.sizeOfHand(), 10);
	}

	@Test
	public void testDiscardDrawPileOneCard() {
		for (int i = 0; i < 9; i++) {
			player.drawACard();
		}

		player.discardDrawPile();

		assertEquals(player.sizeOfDiscardPile(), 1);
		assertEquals(player.sizeOfDrawPile(), 0);
		assertEquals(player.sizeOfHand(), 9);
	}

	@Test
	public void testDrawManyCardsNonEmptyDiscard() {
		player.drawACard();
		player.discardHand();
		for (int i = 0; i < 11; i++) {
			player.drawACard();
		}

		assertEquals(player.sizeOfDrawPile(), 0);
		assertEquals(player.sizeOfHand(), 10);
		assertEquals(player.sizeOfDiscardPile(), 0);
	}

	@Test
	public void testGetPointsStarter() {
		assertEquals(player.getPoints(), 3);
	}

	@Test
	public void testGetPointsOneEstateAdded() {
		player.gainCard(new Estate());

		assertEquals(player.getPoints(), 4);
	}

	@Test
	public void testGetPointsAllCardsInHand() {
		player.drawNewHand();
		player.drawNewHand();

		assertEquals(player.getPoints(), 3);
	}

	@Test
	public void testGetPointsAllCardInDiscard() {
		player.drawNewHand();
		player.drawNewHand();
		player.discardHand();

		assertEquals(player.getPoints(), 3);
	}

	@Test
	public void testGetPointsWithTenGardens() {
		for (int i = 0; i < 10; i++) {
			player.gainCard(new Gardens());
		}

		assertEquals(player.getPoints(), 23);
	}

	@Test
	public void testContentsOfHandOneCard() {
		player.drawACard();

		assertTrue(player.getHand().get(0).getClass().equals(Copper.class)
				|| player.getHand().get(0).getClass().equals(Estate.class));
	}

	@Test
	public void testContentsOfHandTwoCards() {
		player.drawACard();
		player.drawACard();

		assertTrue(player.getHand().get(0).getClass().equals(Copper.class)
				|| player.getHand().get(0).getClass().equals(Estate.class));
		assertTrue(player.getHand().get(1).getClass().equals(Copper.class)
				|| player.getHand().get(1).getClass().equals(Estate.class));
	}

	@Test
	public void testContentsOfStarterHand() {
		player.drawNewHand();

		for (Card card : player.getHand()) {
			assertTrue(
					card.getClass().equals(Copper.class) || card.getClass().equals(Estate.class));
		}
	}

	@Test
	public void testContentsOfHandNoCards() {
		assertTrue(player.getHand().isEmpty());
	}

	@Test
	public void testGainCard() {
		int discardPileSizeBefore = player.sizeOfDiscardPile();
		player.gainCard(new Estate());

		assertEquals(player.sizeOfDiscardPile(), discardPileSizeBefore + 1);
	}

	@Test
	public void testTrashCardInHand() {
		player.drawNewHand();

		assertTrue(player.trashCardFromHand(Copper.class));
		assertEquals(player.sizeOfHand(), 4);
	}

	@Test
	public void testTrashCardNotInHand() {
		player.drawNewHand();

		assertFalse(player.trashCardFromHand(Silver.class));
		assertEquals(player.sizeOfHand(), 5);
	}

	@Test
	public void testDiscardCardInHand() {
		player.drawNewHand();

		assertTrue(player.discardCardFromHand(Copper.class));
		assertEquals(player.sizeOfHand(), 4);
		assertEquals(player.sizeOfDiscardPile(), 1);
	}

	@Test
	public void testDiscardCardNotInHand() {
		player.drawNewHand();

		assertFalse(player.discardCardFromHand(Silver.class));
		assertEquals(player.sizeOfHand(), 5);
		assertEquals(player.sizeOfDiscardPile(), 0);
	}

	@Test
	public void testDiscardTopCardOfDrawPile() {
		Card card = new Silver();
		player.drawPile.push(card);

		assertEquals(player.discardTopCardOfDrawPile().get(), card);
	}

	@Test
	public void testDiscardTopCardOfDrawPileEmpty() {
		player.drawNewHand();
		player.drawNewHand();

		assertFalse(player.discardTopCardOfDrawPile().isPresent());
	}

	@Test
	public void testDiscardTopCardOfDrawPileNonEmpty() {
		assertTrue(player.discardTopCardOfDrawPile().isPresent());
		assertEquals(player.sizeOfDiscardPile(), 1);
	}

	@Test
	public void testDiscardTopCardOfDrawPileEmptyWithFullDiscardPile() {
		player.drawNewHand();
		player.discardHand();
		player.drawNewHand();

		assertTrue(player.discardTopCardOfDrawPile().isPresent());
		assertEquals(player.sizeOfDiscardPile(), 1);
	}

	@Test
	public void testChooseCardToPlayEmpty() {
		EasyMock.reset(gui);
		CompletableFuture<Optional<Card>> response = new CompletableFuture<Optional<Card>>();
		Optional<Card> potentialCardToPlay = Optional.empty();
		response.complete(potentialCardToPlay);

		EasyMock.expect(gui.chooseCardToPlay(player.getHand(), "Test", "", 0, 0, 0,
				player.discardPile.size(), player.drawPile.size())).andReturn(response);

		EasyMock.replay(gui);

		assertEquals(player.chooseCardToPlay("", 0, 0, 0), potentialCardToPlay);
	}

	@Test
	public void testChooseCardToPlayNotEmpty() {
		EasyMock.reset(gui);
		CompletableFuture<Optional<Card>> response = new CompletableFuture<Optional<Card>>();
		Card cardReturned = EasyMock.mock(Card.class);
		Optional<Card> potentialCardToPlay = Optional.of(cardReturned);
		response.complete(potentialCardToPlay);

		EasyMock.expect(gui.chooseCardToPlay(player.getHand(), "Test", "", 0, 0, 0,
				player.discardPile.size(), player.drawPile.size())).andReturn(response);

		EasyMock.replay(gui, cardReturned);

		assertEquals(player.chooseCardToPlay("", 0, 0, 0), potentialCardToPlay);

		EasyMock.verify(cardReturned);
	}

	@Test
	public void testBuyEndBuys() {
		EasyMock.reset(gui);
		CompletableFuture<Optional<Card>> response = new CompletableFuture<Optional<Card>>();
		Optional<Card> potentialCardToBuy = Optional.empty();
		response.complete(potentialCardToBuy);
		List<Card> availableCards = new ArrayList<Card>();
		Supply supplyPiles = EasyMock.mock(Supply.class);

		EasyMock.expect(supplyPiles.getAvailableCards()).andReturn(availableCards).anyTimes();
		EasyMock.expect(gui.chooseCardToBuy(availableCards, "Test", "", 0, 0, 0,
				player.discardPile.size(), player.drawPile.size())).andReturn(response);

		EasyMock.replay(gui, supplyPiles);

		assertEquals(player.buy(supplyPiles, "", 0, 0, 0), potentialCardToBuy);

		EasyMock.verify(supplyPiles);
	}

	@Test
	public void testBuyCard() {
		EasyMock.reset(gui);
		CompletableFuture<Optional<Card>> response = new CompletableFuture<Optional<Card>>();
		Card cardToBuy = EasyMock.mock(Card.class);
		Optional<Card> potentialCardToBuy = Optional.of(cardToBuy);
		response.complete(potentialCardToBuy);
		List<Card> availableCards = new ArrayList<Card>();
		availableCards.add(cardToBuy);
		Supply supplyPiles = EasyMock.mock(Supply.class);

		EasyMock.expect(supplyPiles.getAvailableCards()).andReturn(availableCards).anyTimes();
		EasyMock.expect(gui.chooseCardToBuy(availableCards, "Test", "", 0, 0, 0,
				player.discardPile.size(), player.drawPile.size())).andReturn(response);

		EasyMock.replay(gui, supplyPiles);

		assertEquals(player.buy(supplyPiles, "", 0, 0, 0), potentialCardToBuy);

		EasyMock.verify(supplyPiles);
	}

	@Test
	public void testForceBuy() {
		EasyMock.reset(gui);
		CompletableFuture<Card> response = new CompletableFuture<Card>();
		Card cardToBuy = EasyMock.mock(Card.class);
		response.complete(cardToBuy);
		List<Card> availableCards = new ArrayList<Card>();
		availableCards.add(cardToBuy);
		Supply supplyPiles = EasyMock.mock(Supply.class);

		EasyMock.expect(supplyPiles.getAvailableCards()).andReturn(availableCards).anyTimes();
		EasyMock.expect(gui.forceCardToBuy(availableCards, "Test", "", 0,
				player.sizeOfDiscardPile(), player.sizeOfDrawPile())).andReturn(response);

		EasyMock.replay(gui, supplyPiles);

		assertEquals(player.forcedBuy(supplyPiles, "", 0), cardToBuy);

		EasyMock.verify(supplyPiles);
	}

	@Test
	public void testChooseCardFromHand() {
		EasyMock.reset(gui);
		CompletableFuture<Card> chosenCardFuture = new CompletableFuture<Card>();
		Card cardReturned = EasyMock.mock(Card.class);
		chosenCardFuture.complete(cardReturned);

		EasyMock.expect(gui.chooseCardFromHand(player.hand, "Test", "", 0, 0, 0,
				player.discardPile.size(), player.drawPile.size())).andReturn(chosenCardFuture);

		EasyMock.replay(gui, cardReturned);

		assertEquals(player.chooseCardFromHand("", 0, 0, 0), cardReturned);

		EasyMock.verify(cardReturned);
	}

	@Test
	public void testPromptYesNoAffirmative() {
		EasyMock.reset(gui);
		CompletableFuture<Boolean> response = new CompletableFuture<Boolean>();
		response.complete(true);

		EasyMock.expect(gui.promptYesNo("throneroomPrompt", "Test")).andReturn(response);

		EasyMock.replay(gui);

		assertTrue(player.promptYesNo("throneroomPrompt"));
	}

	@Test
	public void testPromptYesNoNegative() {
		EasyMock.reset(gui);
		CompletableFuture<Boolean> response = new CompletableFuture<Boolean>();
		response.complete(false);

		EasyMock.expect(gui.promptYesNo("throneroomPrompt", "Test")).andReturn(response);

		EasyMock.replay(gui);

		assertFalse(player.promptYesNo("throneroomPrompt"));
	}

	@Test
	public void testCleanupHand() {
		player.drawNewHand();
		List<Card> playArea = new ArrayList<>();
		Card[] cardList = new Card[5];
		player.hand.toArray(cardList);

		player.cleanup(playArea);

		assertEquals(player.hand.size(), 5);
		assertTrue(player.discardPile.containsAll(Arrays.asList(cardList)));
	}

	@Test
	public void testCleanupPlayAreaAndHand() {
		player.drawNewHand();
		List<Card> playArea = new ArrayList<>();
		List<Card> cards = new ArrayList<>();

		for (Card c : player.hand) {
			playArea.add(c);
			cards.add(c);
		}

		player.cleanup(playArea);

		assertTrue(playArea.isEmpty());
		assertTrue(player.discardPile.containsAll(cards));
	}

	@Test
	public void testCleanupPlayArea() {
		Card[] cardList = { EasyMock.mock(Card.class), EasyMock.mock(Card.class) };
		List<Card> playArea = new ArrayList<>();
		playArea.addAll(Arrays.asList(cardList));

		player.cleanup(playArea);

		assertTrue(playArea.isEmpty());
		assertTrue(player.discardPile.containsAll(Arrays.asList(cardList)));
	}

	@Test
	public void testPlayCardIsInHand() {
		Card card = EasyMock.mock(Card.class);
		EasyMock.replay(card);
		player.hand.add(card);

		List<Card> playArea = new ArrayList<Card>();
		List<Card> expectedPlayArea = new ArrayList<Card>();
		expectedPlayArea.add(card);

		playArea = player.playCard(card, playArea);

		assertTrue(playArea.contains(card));
		assertFalse(player.hand.contains(card));
		assertEquals(playArea, expectedPlayArea);

		EasyMock.verify(card);
	}

	@Test
	public void testPlayCardNotInHand() {
		Card card = EasyMock.mock(Card.class);
		Card action = EasyMock.mock(Card.class);
		EasyMock.replay(card, action);
		player.hand.add(action);

		List<Card> playArea = new ArrayList<Card>();
		List<Card> expectedPlayArea = new ArrayList<Card>();
		expectedPlayArea.add(action);

		playArea = player.playCard(card, playArea);
		playArea = player.playCard(action, playArea);

		assertTrue(playArea.contains(action));
		assertFalse(playArea.contains(card));
		assertFalse(player.hand.contains(card));
		assertFalse(player.hand.contains(action));
		assertEquals(playArea, expectedPlayArea);

		EasyMock.verify(card, action);
	}

	@Test
	public void testGainCardToHand() {
		Card card = EasyMock.mock(Card.class);

		EasyMock.replay(card);

		player.gainCardToHand(card);

		assertTrue(player.hand.contains(card));

		EasyMock.verify(card);
	}

	@Test
	public void testPlaceCardOnDrawPile() {
		Card card = EasyMock.mock(Card.class);

		EasyMock.replay(card);

		player.placeOnDrawPile(card);

		assertEquals(player.drawPile.peek(), card);

		EasyMock.verify(card);
	}

	@Test
	public void testHasCardInHandTrue() {
		Card card = new Copper();

		player.hand.add(card);

		assertTrue(player.hasCardInHand(Copper.class));
	}

	@Test
	public void testHasCardInHandFalse() {
		assertFalse(player.hasCardInHand(Province.class));
	}

}
