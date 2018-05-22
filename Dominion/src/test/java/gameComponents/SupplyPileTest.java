package gameComponents;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

import org.easymock.EasyMock;
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
import util.BaseCards;

public class SupplyPileTest {

	Supply supply;
	int numPlayers;

	@Before
	public void setup() {
		numPlayers = 3;
		supply = new Supply(numPlayers);
		supply.makeKingdomCardList(Main.getAvailableKingdomCards(), new Random());
	}

	@Test
	public void testSupplySetup() {
		List<Stack<Card>> kingdomeCardList = supply.getKingdomCardList();
		supply.makeKingdomCardList(Main.getAvailableKingdomCards(), new Random());

		assertEquals(kingdomeCardList.size(), 10);

		assertEquals(supply.getBaseSupply(BaseCards.COPPER).size(), 60 - (7 * numPlayers));
		assertEquals(supply.getBaseSupply(BaseCards.SILVER).size(), 40);
		assertEquals(supply.getBaseSupply(BaseCards.GOLD).size(), 30);

		assertEquals(supply.getBaseSupply(BaseCards.ESTATE).size(), 24 - (3 * numPlayers));
		assertEquals(supply.getBaseSupply(BaseCards.DUCHY).size(), 12);
		assertEquals(supply.getBaseSupply(BaseCards.PROVINCE).size(), 12);
		assertEquals(supply.getBaseSupply(BaseCards.CURSE).size(), 30);
	}

	@Test
	public void testMakeKingdomCardListBase() {
		List<Card> availableCards = Main.getAvailableKingdomCards();
		Random random = EasyMock.mock(Random.class);
		for (int i = 0; i < 10; i++) {
			EasyMock.expect(random.nextInt(availableCards.size())).andReturn(i);
		}

		EasyMock.replay(random);

		supply.makeKingdomCardList(Main.getAvailableKingdomCards(), random);
		assertEquals(supply.kingdomCardList.size(), 10);
		EasyMock.verify(random);
	}

	@Test
	public void testMakeKingdomCardListOneRepeat() {
		List<Card> availableCards = Main.getAvailableKingdomCards();
		Random random = EasyMock.mock(Random.class);
		EasyMock.expect(random.nextInt(availableCards.size())).andReturn(1);
		for (int i = 0; i < 10; i++) {
			EasyMock.expect(random.nextInt(availableCards.size())).andReturn(i);
		}

		EasyMock.replay(random);

		supply.makeKingdomCardList(Main.getAvailableKingdomCards(), random);
		assertEquals(supply.kingdomCardList.size(), 10);
		EasyMock.verify(random);
	}

	@Test
	public void testMakeKingdomCardListMulitpleRepeats() {
		List<Card> availableCards = Main.getAvailableKingdomCards();
		Random random = EasyMock.mock(Random.class);
		EasyMock.expect(random.nextInt(availableCards.size())).andReturn(1);
		EasyMock.expect(random.nextInt(availableCards.size())).andReturn(1);
		EasyMock.expect(random.nextInt(availableCards.size())).andReturn(1);
		for (int i = 0; i < 10; i++) {
			EasyMock.expect(random.nextInt(availableCards.size())).andReturn(i);
		}

		EasyMock.replay(random);

		supply.makeKingdomCardList(Main.getAvailableKingdomCards(), random);
		assertEquals(supply.kingdomCardList.size(), 10);
		EasyMock.verify(random);
	}

	@Test
	public void testCopperValidity() {
		Card top = supply.getBaseSupply(BaseCards.COPPER).peek();

		assertEquals(top.getClass(), Copper.class);
		assertEquals(supply.getBaseSupply(BaseCards.COPPER), supply.getBaseSupply(BaseCards.COPPER));
	}

	@Test
	public void testSilverValidity() {
		Card top = supply.getBaseSupply(BaseCards.SILVER).peek();

		assertEquals(top.getClass(), Silver.class);
		assertEquals(supply.getBaseSupply(BaseCards.SILVER), supply.getBaseSupply(BaseCards.SILVER));
	}

	@Test
	public void testGoldValidity() {
		Card top = supply.getBaseSupply(BaseCards.GOLD).peek();

		assertEquals(top.getClass(), Gold.class);
		assertEquals(supply.getBaseSupply(BaseCards.GOLD), supply.getBaseSupply(BaseCards.GOLD));
	}

	@Test
	public void testEstateValidity() {
		Card top = supply.getBaseSupply(BaseCards.ESTATE).peek();

		assertEquals(top.getClass(), Estate.class);
		assertEquals(supply.getBaseSupply(BaseCards.ESTATE), supply.getBaseSupply(BaseCards.ESTATE));
	}

	@Test
	public void testDuchyValidity() {
		Card top = supply.getBaseSupply(BaseCards.DUCHY).peek();

		assertEquals(top.getClass(), Duchy.class);
		assertEquals(supply.getBaseSupply(BaseCards.DUCHY), supply.getBaseSupply(BaseCards.DUCHY));
	}

	@Test
	public void testProvinceValidity() {
		Card top = supply.getBaseSupply(BaseCards.PROVINCE).peek();

		assertEquals(top.getClass(), Province.class);
		assertEquals(supply.getBaseSupply(BaseCards.PROVINCE), supply.getBaseSupply(BaseCards.PROVINCE));
	}

	@Test
	public void testCurseValidity() {
		Card top = supply.getBaseSupply(BaseCards.CURSE).peek();

		assertEquals(top.getClass(), Curse.class);
		assertEquals(supply.getBaseSupply(BaseCards.CURSE), supply.getBaseSupply(BaseCards.CURSE));
	}

	@Test
	public void testDecrementCardNonEmptyBase() {
		Stack<Card> provinceSupply = supply.getBaseSupply(BaseCards.PROVINCE);

		supply.decrementPile(provinceSupply.peek());

		assertEquals(provinceSupply.size(), 11);
	}

	@Test
	public void testDecrementCardEmptyBase() {
		Stack<Card> provinceSupply = supply.getBaseSupply(BaseCards.PROVINCE);
		Card province = provinceSupply.peek();

		for (int i = 0; i < 13; i++) {
			supply.decrementPile(province);
		}

		assertTrue(provinceSupply.isEmpty());
	}

	@Test
	public void testDecrementCardNonEmptyKingdom() {
		Stack<Card> kingdom1Supply = supply.getKingdomCardList().get(1);

		supply.decrementPile(kingdom1Supply.peek());

		assertEquals(kingdom1Supply.size(), 9);
	}

	@Test
	public void testDecrementCardEmptyKingdom() {
		Stack<Card> kingdom1Supply = supply.getKingdomCardList().get(1);
		Card kingdomCard = kingdom1Supply.peek();

		for (int i = 0; i < 11; i++) {
			supply.decrementPile(kingdomCard);
		}

		assertTrue(kingdom1Supply.isEmpty());
	}

	@Test
	public void testDecrementKingdomCardInvalid() {
		List<Card> availableCards = Main.getAvailableKingdomCards();
		Random random = EasyMock.mock(Random.class);
		for (int i = 0; i < 10; i++) {
			EasyMock.expect(random.nextInt(availableCards.size())).andReturn(i);
		}

		EasyMock.replay(random);

		supply.makeKingdomCardList(Main.getAvailableKingdomCards(), random);

		supply.decrementPile(availableCards.get(10));

		for (Stack<Card> kingdomPile : supply.kingdomCardList) {
			assertEquals(kingdomPile.size(), 10);
		}

		EasyMock.verify(random);
	}

	@Test
	public void testGameOverProvinceGone() {
		Stack<Card> provinceSupply = supply.getBaseSupply(BaseCards.PROVINCE);

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
		Stack<Card> duchySupply = supply.getBaseSupply(BaseCards.DUCHY);

		for (int i = 0; i < 12; i++) {
			duchySupply.pop();
		}

		assertFalse(supply.isGameOver());
	}

	@Test
	public void testGameOverThreeBaseSupplyGoneNotProvince() {
		Stack<Card> duchySupply = supply.getBaseSupply(BaseCards.DUCHY);
		Stack<Card> goldSupply = supply.getBaseSupply(BaseCards.GOLD);
		Stack<Card> copperSupply = supply.getBaseSupply(BaseCards.COPPER);

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
		Stack<Card> duchySupply = supply.getBaseSupply(BaseCards.DUCHY);
		Stack<Card> goldSupply = supply.getBaseSupply(BaseCards.GOLD);
		Stack<Card> copperSupply = supply.getBaseSupply(BaseCards.COPPER);
		Stack<Card> silverSupply = supply.getBaseSupply(BaseCards.SILVER);

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
		Stack<Card> duchySupply = supply.getBaseSupply(BaseCards.DUCHY);
		Stack<Card> goldSupply = supply.getBaseSupply(BaseCards.GOLD);

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
		Stack<Card> duchySupply = supply.getBaseSupply(BaseCards.DUCHY);
		Stack<Card> goldSupply = supply.getBaseSupply(BaseCards.GOLD);

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
		List<Card> expectedCards = new ArrayList<Card>();

		expectedCards.add(new Copper());
		expectedCards.add(new Silver());
		expectedCards.add(new Gold());
		expectedCards.add(new Estate());
		expectedCards.add(new Duchy());
		expectedCards.add(new Province());
		expectedCards.add(new Curse());
		for (Stack<Card> kingdomPile : supply.kingdomCardList) {
			expectedCards.add(kingdomPile.peek());
		}

		List<String> expectedCardNames = new ArrayList<String>();
		for (Card card : expectedCards) {
			expectedCardNames.add(card.getName());
		}

		List<Card> actualCards = supply.getAvailableCards();
		List<String> actualCardNames = new ArrayList<String>();
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
		List<Card> expectedCards = new ArrayList<Card>();

		expectedCards.add(new Copper());
		expectedCards.add(new Silver());
		expectedCards.add(new Gold());
		expectedCards.add(new Estate());
		expectedCards.add(new Duchy());
		expectedCards.add(new Province());
		expectedCards.add(new Curse());
		for (int i = 1; i < 10; i++) {
			expectedCards.add(supply.kingdomCardList.get(i).peek());
		}

		List<String> expectedCardNames = new ArrayList<String>();
		for (Card card : expectedCards) {
			expectedCardNames.add(card.getName());
		}

		List<Card> actualCards = supply.getAvailableCards();
		List<String> actualCardNames = new ArrayList<String>();
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

		List<Card> expectedCards = new ArrayList<Card>();
		expectedCards.add(new Silver());
		expectedCards.add(new Gold());
		expectedCards.add(new Estate());
		expectedCards.add(new Duchy());
		expectedCards.add(new Province());
		expectedCards.add(new Curse());
		for (int i = 0; i < 10; i++) {
			expectedCards.add(supply.kingdomCardList.get(i).peek());
		}

		List<String> expectedCardNames = new ArrayList<String>();
		for (Card card : expectedCards) {
			expectedCardNames.add(card.getName());
		}

		List<Card> actualCards = supply.getAvailableCards();
		List<String> actualCardNames = new ArrayList<String>();
		for (Card card : actualCards) {
			actualCardNames.add(card.getName());
		}

		assertEquals(actualCardNames, expectedCardNames);
	}
}
