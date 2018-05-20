import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import org.junit.Before;
import org.junit.Test;

public class SupplyPileTest {

	Supply supply;

	@Before
	public void setup() {
		supply = new Supply();
	}

	@Test
	public void testSupplySetup() {
		List<Stack<Card>> kingdomeCardList = supply.getKingdomCardList();

		assertEquals(kingdomeCardList.size(), 10);

		assertEquals(supply.getBaseSupply("COPPER").size(), 60);
		assertEquals(supply.getBaseSupply("SILVER").size(), 40);
		assertEquals(supply.getBaseSupply("GOLD").size(), 30);

		assertEquals(supply.getBaseSupply("ESTATE").size(), 24);
		assertEquals(supply.getBaseSupply("DUCHY").size(), 12);
		assertEquals(supply.getBaseSupply("PROVINCE").size(), 12);
		assertEquals(supply.getBaseSupply("CURSE").size(), 30);
	}

	@Test
	public void testCopperValidity() {
		Card top = supply.getBaseSupply("COPPER").peek();

		assertEquals(top.getClass(), Copper.class);
		assertEquals(supply.getBaseSupply("COPPER"), supply.getBaseSupply("COPPER"));
	}

	@Test
	public void testSilverValidity() {
		Card top = supply.getBaseSupply("SILVER").peek();

		assertEquals(top.getClass(), Silver.class);
		assertEquals(supply.getBaseSupply("SILVER"), supply.getBaseSupply("SILVER"));
	}

	@Test
	public void testGoldValidity() {
		Card top = supply.getBaseSupply("GOLD").peek();

		assertEquals(top.getClass(), Gold.class);
		assertEquals(supply.getBaseSupply("GOLD"), supply.getBaseSupply("GOLD"));
	}

	@Test
	public void testEstateValidity() {
		Card top = supply.getBaseSupply("ESTATE").peek();

		assertEquals(top.getClass(), Estate.class);
		assertEquals(supply.getBaseSupply("ESTATE"), supply.getBaseSupply("ESTATE"));
	}

	@Test
	public void testDuchyValidity() {
		Card top = supply.getBaseSupply("DUCHY").peek();

		assertEquals(top.getClass(), Duchy.class);
		assertEquals(supply.getBaseSupply("DUCHY"), supply.getBaseSupply("DUCHY"));
	}

	@Test
	public void testProvinceValidity() {
		Card top = supply.getBaseSupply("PROVINCE").peek();

		assertEquals(top.getClass(), Province.class);
		assertEquals(supply.getBaseSupply("PROVINCE"), supply.getBaseSupply("PROVINCE"));
	}

	@Test
	public void testCurseValidity() {
		Card top = supply.getBaseSupply("CURSE").peek();

		assertEquals(top.getClass(), Curse.class);
		assertEquals(supply.getBaseSupply("CURSE"), supply.getBaseSupply("CURSE"));
	}

	@Test
	public void testGameOverProvinceGone() {
		Stack<Card> provinceSupply = supply.getBaseSupply("PROVINCE");

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
		Stack<Card> duchySupply = supply.getBaseSupply("DUCHY");

		for (int i = 0; i < 12; i++) {
			duchySupply.pop();
		}

		assertFalse(supply.isGameOver());
	}

	@Test
	public void testGameOverThreeBaseSupplyGoneNotProvince() {
		Stack<Card> duchySupply = supply.getBaseSupply("DUCHY");
		Stack<Card> goldSupply = supply.getBaseSupply("GOLD");
		Stack<Card> copperSupply = supply.getBaseSupply("COPPER");

		for (int i = 0; i < 12; i++) {
			duchySupply.pop();
		}
		for (int i = 0; i < 30; i++) {
			goldSupply.pop();
		}
		for (int i = 0; i < 60; i++) {
			copperSupply.pop();
		}

		assertTrue(supply.isGameOver());
	}

	@Test
	public void testGameOverMoreThanThreeBaseSupplyGoneNotProvince() {
		Stack<Card> duchySupply = supply.getBaseSupply("DUCHY");
		Stack<Card> goldSupply = supply.getBaseSupply("GOLD");
		Stack<Card> copperSupply = supply.getBaseSupply("COPPER");
		Stack<Card> estateSupply = supply.getBaseSupply("ESTATE");

		for (int i = 0; i < 12; i++) {
			duchySupply.pop();
		}
		for (int i = 0; i < 30; i++) {
			goldSupply.pop();
		}
		for (int i = 0; i < 60; i++) {
			copperSupply.pop();
		}
		for (int i = 0; i < 24; i++) {
			estateSupply.pop();
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
		Stack<Card> duchySupply = supply.getBaseSupply("DUCHY");
		Stack<Card> goldSupply = supply.getBaseSupply("GOLD");

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
		Stack<Card> duchySupply = supply.getBaseSupply("DUCHY");
		Stack<Card> goldSupply = supply.getBaseSupply("GOLD");

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
		for (int j = 0; j < 60; j++) {
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
