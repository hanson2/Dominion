package gameComponents;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.EmptyStackException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import org.junit.Before;
import org.junit.Test;

import cards.Card;
import cards.Copper;
import cards.Curse;
import cards.Duchy;
import cards.Estate;
import cards.Gold;
import cards.Province;
import cards.Silver;
import util.Cards;

public class SupplyPileTest {

	Supply supply;
	int numPlayers;

	@Before
	public void setup() {
		numPlayers = 3;
		supply = new Supply(numPlayers, Main.getAvailableKingdomCards());
	}

	@Test
	public void testSupplySetup() {
		List<Stack<Card>> kingdomeCardList = supply.getKingdomCardList();

		assertEquals(kingdomeCardList.size(), 10);

		assertEquals(supply.getBaseSupply(Cards.COPPER).size(), 60 - (7 * numPlayers));
		assertEquals(supply.getBaseSupply(Cards.SILVER).size(), 40);
		assertEquals(supply.getBaseSupply(Cards.GOLD).size(), 30);

		assertEquals(supply.getBaseSupply(Cards.ESTATE).size(), 24 - (3 * numPlayers));
		assertEquals(supply.getBaseSupply(Cards.DUCHY).size(), 12);
		assertEquals(supply.getBaseSupply(Cards.PROVINCE).size(), 12);
		assertEquals(supply.getBaseSupply(Cards.CURSE).size(), 30);
	}

	@Test
	public void testCopperValidity() {
		Card top = supply.getBaseSupply(Cards.COPPER).peek();

		assertEquals(top.getClass(), Copper.class);
		assertEquals(supply.getBaseSupply(Cards.COPPER), supply.getBaseSupply(Cards.COPPER));
	}

	@Test
	public void testSilverValidity() {
		Card top = supply.getBaseSupply(Cards.SILVER).peek();

		assertEquals(top.getClass(), Silver.class);
		assertEquals(supply.getBaseSupply(Cards.SILVER), supply.getBaseSupply(Cards.SILVER));
	}

	@Test
	public void testGoldValidity() {
		Card top = supply.getBaseSupply(Cards.GOLD).peek();

		assertEquals(top.getClass(), Gold.class);
		assertEquals(supply.getBaseSupply(Cards.GOLD), supply.getBaseSupply(Cards.GOLD));
	}

	@Test
	public void testEstateValidity() {
		Card top = supply.getBaseSupply(Cards.ESTATE).peek();

		assertEquals(top.getClass(), Estate.class);
		assertEquals(supply.getBaseSupply(Cards.ESTATE), supply.getBaseSupply(Cards.ESTATE));
	}

	@Test
	public void testDuchyValidity() {
		Card top = supply.getBaseSupply(Cards.DUCHY).peek();

		assertEquals(top.getClass(), Duchy.class);
		assertEquals(supply.getBaseSupply(Cards.DUCHY), supply.getBaseSupply(Cards.DUCHY));
	}

	@Test
	public void testProvinceValidity() {
		Card top = supply.getBaseSupply(Cards.PROVINCE).peek();

		assertEquals(top.getClass(), Province.class);
		assertEquals(supply.getBaseSupply(Cards.PROVINCE), supply.getBaseSupply(Cards.PROVINCE));
	}

	@Test
	public void testCurseValidity() {
		Card top = supply.getBaseSupply(Cards.CURSE).peek();

		assertEquals(top.getClass(), Curse.class);
		assertEquals(supply.getBaseSupply(Cards.CURSE), supply.getBaseSupply(Cards.CURSE));
	}

	@Test
	public void testDecrementCardNonEmptyBase() {
		Stack<Card> provinceSupply = supply.getBaseSupply(Cards.PROVINCE);

		supply.decrementPile(provinceSupply.peek());

		assertEquals(provinceSupply.size(), 11);
	}

	@Test(expected = EmptyStackException.class)
	public void testDecrementCardEmptyBase() {
		Stack<Card> provinceSupply = supply.getBaseSupply(Cards.PROVINCE);
		Card province = provinceSupply.peek();

		supply.decrementPile(province);
		supply.decrementPile(province);
		supply.decrementPile(province);
		supply.decrementPile(province);
		supply.decrementPile(province);
		supply.decrementPile(province);
		supply.decrementPile(province);
		supply.decrementPile(province);
		supply.decrementPile(province);
		supply.decrementPile(province);
		supply.decrementPile(province);
		supply.decrementPile(province);
		supply.decrementPile(province);
	}

	@Test
	public void testDecrementCardNonEmptyKingdom() {
		Stack<Card> kingdom0Supply = supply.getKingdomCardList().get(0);

		supply.decrementPile(kingdom0Supply.peek());

		assertEquals(kingdom0Supply.size(), 9);
	}

	@Test(expected = EmptyStackException.class)
	public void testDecrementCardEmptyKingdom() {
		Stack<Card> kingdom0Supply = supply.getKingdomCardList().get(0);
		Card kingdomCard = kingdom0Supply.peek();

		supply.decrementPile(kingdomCard);
		supply.decrementPile(kingdomCard);
		supply.decrementPile(kingdomCard);
		supply.decrementPile(kingdomCard);
		supply.decrementPile(kingdomCard);
		supply.decrementPile(kingdomCard);
		supply.decrementPile(kingdomCard);
		supply.decrementPile(kingdomCard);
		supply.decrementPile(kingdomCard);
		supply.decrementPile(kingdomCard);
		supply.decrementPile(kingdomCard);
	}

	@Test
	public void testGameOverProvinceGone() {
		Stack<Card> provinceSupply = supply.getBaseSupply(Cards.PROVINCE);

		for (int i = 0; i < 12; i++) {
			provinceSupply.pop();
		}

		assertTrue(supply.isGameOver());
	}

	@Test
	public void testGameOverNoPilesGone() {
		assertFalse(supply.isGameOver());
	}

	@Test
	public void testGameOverOneBaseSupplyGoneNotProvince() {
		Stack<Card> duchySupply = supply.getBaseSupply(Cards.DUCHY);

		for (int i = 0; i < 12; i++) {
			duchySupply.pop();
		}

		assertFalse(supply.isGameOver());
	}

	@Test
	public void testGameOverThreeBaseSupplyGoneNotProvince() {
		Stack<Card> duchySupply = supply.getBaseSupply(Cards.DUCHY);
		Stack<Card> goldSupply = supply.getBaseSupply(Cards.GOLD);
		Stack<Card> copperSupply = supply.getBaseSupply(Cards.COPPER);

		for (int i = 0; i < 12; i++) {
			duchySupply.pop();
		}
		for (int i = 0; i < 30; i++) {
			goldSupply.pop();
		}
		for (int i = 0; i < 60 - (7 * numPlayers); i++) {
			copperSupply.pop();
		}

		assertTrue(supply.isGameOver());
	}

	@Test
	public void testGameOverMoreThanThreeBaseSupplyGoneNotProvince() {
		Stack<Card> duchySupply = supply.getBaseSupply(Cards.DUCHY);
		Stack<Card> goldSupply = supply.getBaseSupply(Cards.GOLD);
		Stack<Card> copperSupply = supply.getBaseSupply(Cards.COPPER);
		Stack<Card> silverSupply = supply.getBaseSupply(Cards.SILVER);

		for (int i = 0; i < 12; i++) {
			duchySupply.pop();
		}
		for (int i = 0; i < 30; i++) {
			goldSupply.pop();
		}
		for (int i = 0; i < 60 - (7 * numPlayers); i++) {
			copperSupply.pop();
		}
		for (int i = 0; i < 40; i++) {
			silverSupply.pop();
		}

		assertTrue(supply.isGameOver());
	}

	@Test
	public void testGameOverThreeKingdomSupplyGone() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 10; j++) {
				supply.getKingdomCardList().get(i).pop();
			}
		}

		assertTrue(supply.isGameOver());
	}

	@Test
	public void testGameOverFourKingdomSupplyGone() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 10; j++) {
				supply.getKingdomCardList().get(i).pop();
			}
		}

		assertTrue(supply.isGameOver());
	}

	@Test
	public void testGameOverOneKingdomSupplyGone() {
		for (int j = 0; j < 10; j++) {
			supply.getKingdomCardList().get(0).pop();
		}

		assertFalse(supply.isGameOver());
	}

	@Test
	public void testGameOverMixedThreeSupplyGone() {
		Stack<Card> duchySupply = supply.getBaseSupply(Cards.DUCHY);
		Stack<Card> goldSupply = supply.getBaseSupply(Cards.GOLD);

		for (int j = 0; j < 10; j++) {
			supply.getKingdomCardList().get(0).pop();
		}
		for (int i = 0; i < 12; i++) {
			duchySupply.pop();
		}
		for (int i = 0; i < 30; i++) {
			goldSupply.pop();
		}

		assertTrue(supply.isGameOver());
	}

	@Test
	public void testGameOverMixedFourSupplyGone() {
		Stack<Card> duchySupply = supply.getBaseSupply(Cards.DUCHY);
		Stack<Card> goldSupply = supply.getBaseSupply(Cards.GOLD);

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 10; j++) {
				supply.getKingdomCardList().get(i).pop();
			}
		}
		for (int i = 0; i < 12; i++) {
			duchySupply.pop();
		}
		for (int i = 0; i < 30; i++) {
			goldSupply.pop();
		}

		assertTrue(supply.isGameOver());
	}

	@Test
	public void testGetAvailableCardsNoPilesGone() {
		Set<Card> expectedCards = new HashSet<Card>();
		for (Stack<Card> kingdomPile : supply.kingdomCardList) {
			expectedCards.add(kingdomPile.peek());
		}
		expectedCards.add(new Copper());
		expectedCards.add(new Silver());
		expectedCards.add(new Gold());
		expectedCards.add(new Estate());
		expectedCards.add(new Duchy());
		expectedCards.add(new Province());
		expectedCards.add(new Curse());

		Set<String> expectedCardNames = new HashSet<String>();
		for (Card card : expectedCards) {
			expectedCardNames.add(card.getName());
		}

		Set<Card> actualCards = supply.getAvailableCards();
		Set<String> actualCardNames = new HashSet<String>();
		for (Card card : actualCards) {
			actualCardNames.add(card.getName());
		}

		assertEquals(actualCardNames, expectedCardNames);
	}

	@Test
	public void testGetAvailableCardKingdomPileGone() {
		for (int j = 0; j < 10; j++) {
			supply.getKingdomCardList().get(0).pop();
		}

		Set<Card> expectedCards = new HashSet<Card>();
		for (int i = 1; i < 10; i++) {
			expectedCards.add(supply.kingdomCardList.get(i).peek());
		}
		expectedCards.add(new Copper());
		expectedCards.add(new Silver());
		expectedCards.add(new Gold());
		expectedCards.add(new Estate());
		expectedCards.add(new Duchy());
		expectedCards.add(new Province());
		expectedCards.add(new Curse());

		Set<String> expectedCardNames = new HashSet<String>();
		for (Card card : expectedCards) {
			expectedCardNames.add(card.getName());
		}

		Set<Card> actualCards = supply.getAvailableCards();
		Set<String> actualCardNames = new HashSet<String>();
		for (Card card : actualCards) {
			actualCardNames.add(card.getName());
		}

		assertEquals(actualCardNames, expectedCardNames);
	}

	@Test
	public void testGetAvailableCardBasePileGone() {
		for (int j = 0; j < 60 - (7 * numPlayers); j++) {
			supply.copperSupply.pop();
		}

		Set<Card> expectedCards = new HashSet<Card>();
		for (int i = 0; i < 10; i++) {
			expectedCards.add(supply.kingdomCardList.get(i).peek());
		}
		expectedCards.add(new Silver());
		expectedCards.add(new Gold());
		expectedCards.add(new Estate());
		expectedCards.add(new Duchy());
		expectedCards.add(new Province());
		expectedCards.add(new Curse());

		Set<String> expectedCardNames = new HashSet<String>();
		for (Card card : expectedCards) {
			expectedCardNames.add(card.getName());
		}

		Set<Card> actualCards = supply.getAvailableCards();
		Set<String> actualCardNames = new HashSet<String>();
		for (Card card : actualCards) {
			actualCardNames.add(card.getName());
		}

		assertEquals(actualCardNames, expectedCardNames);
	}
}
