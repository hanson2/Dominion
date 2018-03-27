import static org.junit.Assert.*;

import java.util.List;
import java.util.Stack;

import org.junit.Test;

public class SupplyPileTest {

	@Test
	public void testSupplySetup() {
		Supply supply = new Supply();
		List kingdomeCardList = supply.getKingdomCardList();
		
		assertTrue(kingdomeCardList.size() == 10);
		
		assertTrue(supply.getBaseSupply("COPPER").size() == 60);
		assertTrue(supply.getBaseSupply("SILVER").size() == 40);
		assertTrue(supply.getBaseSupply("GOLD").size() == 30);
		
		assertTrue(supply.getBaseSupply("ESTATE").size() == 24);
		assertTrue(supply.getBaseSupply("DUCHY").size() == 12);
		assertTrue(supply.getBaseSupply("PROVINCE").size() == 12);
		assertTrue(supply.getBaseSupply("CURSE").size() == 30);
	}
	
	@Test
	public void testCopperValidity(){
		Supply supply = new Supply();
		Card top = supply.getBaseSupply("COPPER").pop();
		
		assertTrue(top.getType().equals("TREASURE"));
		assertTrue(top.getCoinsAdded() == 1);
		assertTrue(top.getActionsAdded() == 0);
		assertTrue(top.getBuysAdded() == 0);
		assertTrue(top.getCardsAdded() == 0);
		assertTrue(top.getVictoryValue() == 0);
		assertTrue(top.getCost() == 0);
		assertTrue(supply.getBaseSupply("COPPER") == supply.getBaseSupply("COPPER"));
	}
	
	@Test
	public void testSilverValidity(){
		Supply supply = new Supply();
		Card top = supply.getBaseSupply("SILVER").pop();
		
		assertTrue(top.getType().equals("TREASURE"));
		assertTrue(top.getCoinsAdded() == 2);
		assertTrue(top.getActionsAdded() == 0);
		assertTrue(top.getBuysAdded() == 0);
		assertTrue(top.getCardsAdded() == 0);
		assertTrue(top.getVictoryValue() == 0);
		assertTrue(top.getCost() == 3);
		assertTrue(supply.getBaseSupply("SILVER") == supply.getBaseSupply("SILVER"));
	}
	
	@Test
	public void testGoldValidity(){
		Supply supply = new Supply();
		Card top = supply.getBaseSupply("GOLD").pop();
		
		assertTrue(top.getType().equals("TREASURE"));
		assertTrue(top.getCoinsAdded() == 3);
		assertTrue(top.getActionsAdded() == 0);
		assertTrue(top.getBuysAdded() == 0);
		assertTrue(top.getCardsAdded() == 0);
		assertTrue(top.getVictoryValue() == 0);
		assertTrue(top.getCost() == 6);
		assertTrue(supply.getBaseSupply("GOLD") == supply.getBaseSupply("GOLD"));
	}
	
	@Test
	public void testEstateValidity(){
		Supply supply = new Supply();
		Card top = supply.getBaseSupply("ESTATE").pop();
		
		assertTrue(top.getType().equals("VICTORY"));
		assertTrue(top.getCoinsAdded() == 0);
		assertTrue(top.getActionsAdded() == 0);
		assertTrue(top.getBuysAdded() == 0);
		assertTrue(top.getCardsAdded() == 0);
		assertTrue(top.getVictoryValue() == 1);
		assertTrue(top.getCost() == 2);
		assertTrue(supply.getBaseSupply("ESTATE") == supply.getBaseSupply("ESTATE"));
	}
	
	@Test
	public void testDuchyValidity(){
		Supply supply = new Supply();
		Card top = supply.getBaseSupply("DUCHY").pop();
		
		assertTrue(top.getType().equals("VICTORY"));
		assertTrue(top.getCoinsAdded() == 0);
		assertTrue(top.getActionsAdded() == 0);
		assertTrue(top.getBuysAdded() == 0);
		assertTrue(top.getCardsAdded() == 0);
		assertTrue(top.getVictoryValue() == 3);
		assertTrue(top.getCost() == 5);
		assertTrue(supply.getBaseSupply("DUCHY") == supply.getBaseSupply("DUCHY"));
	}
	
	@Test
	public void testProvinceValidity(){
		Supply supply = new Supply();
		Card top = supply.getBaseSupply("PROVINCE").pop();
		
		assertTrue(top.getType().equals("VICTORY"));
		assertTrue(top.getCoinsAdded() == 0);
		assertTrue(top.getActionsAdded() == 0);
		assertTrue(top.getBuysAdded() == 0);
		assertTrue(top.getCardsAdded() == 0);
		assertTrue(top.getVictoryValue() == 6);
		assertTrue(top.getCost() == 8);
		assertTrue(supply.getBaseSupply("PROVINCE") == supply.getBaseSupply("PROVINCE"));
	}
	
	@Test
	public void testCurseValidity(){
		Supply supply = new Supply();
		Card top = supply.getBaseSupply("CURSE").pop();
		
		assertTrue(top.getType().equals("CURSE"));
		assertTrue(top.getCoinsAdded() == 0);
		assertTrue(top.getActionsAdded() == 0);
		assertTrue(top.getBuysAdded() == 0);
		assertTrue(top.getCardsAdded() == 0);
		assertTrue(top.getVictoryValue() == -1);
		assertTrue(top.getCost() == 0);
		assertTrue(supply.getBaseSupply("CURSE") == supply.getBaseSupply("CURSE"));
	}
	
	@Test
	public void testGameOverProvinceGone(){
		Supply supply = new Supply();
		Stack<Card> provinceSupply = supply.getBaseSupply("PROVINCE");
		
		for(int i = 0; i < 12; i++){
			provinceSupply.pop();
		}
		
		assertTrue(supply.isGameOver());
	}
	
	@Test
	public void testGameOverNoPilesGone(){
		Supply supply = new Supply();
		assertFalse(supply.isGameOver());
	}
	
	@Test
	public void testGameOverOneBaseSupplyGoneNotProvince(){
		Supply supply = new Supply();
		Stack<Card> duchySupply = supply.getBaseSupply("DUCHY");
		
		for(int i = 0; i < 12; i++){
			duchySupply.pop();
		}
		
		assertFalse(supply.isGameOver());
	}
	
	@Test
	public void testGameOverThreeBaseSupplyGoneNotProvince(){
		Supply supply = new Supply();
		Stack<Card> duchySupply = supply.getBaseSupply("DUCHY");
		Stack<Card> goldSupply = supply.getBaseSupply("GOLD");
		Stack<Card> copperSupply = supply.getBaseSupply("COPPER");
		
		for(int i = 0; i < 12; i++){
			duchySupply.pop();
		}
		for(int i = 0; i < 30; i++){
			goldSupply.pop();
		}
		for(int i = 0; i < 60; i++){
			copperSupply.pop();
		}
		
		assertTrue(supply.isGameOver());
	}
	
	@Test 
	public void testGameOverMoreThanThreeBaseSupplyGoneNotProvince(){
		Supply supply = new Supply();
		Stack<Card> duchySupply = supply.getBaseSupply("DUCHY");
		Stack<Card> goldSupply = supply.getBaseSupply("GOLD");
		Stack<Card> copperSupply = supply.getBaseSupply("COPPER");
		Stack<Card> estateSupply = supply.getBaseSupply("ESTATE");
		
		for(int i = 0; i < 12; i++){
			duchySupply.pop();
		}
		for(int i = 0; i < 30; i++){
			goldSupply.pop();
		}
		for(int i = 0; i < 60; i++){
			copperSupply.pop();
		}
		for(int i = 0; i < 24; i++){
			estateSupply.pop();
		}
		
		assertTrue(supply.isGameOver());
	}
	
	@Test
	public void testGameOverThreeKingdomSupplyGone(){
		Supply supply = new Supply();
		
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 10; j++){
				supply.getKingdomCardList().get(i).pop();
			}
		}
		
		assertTrue(supply.isGameOver());
	}
	
	@Test
	public void testGameOverFourKingdomSupplyGone(){
		Supply supply = new Supply();
		
		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 10; j++){
				supply.getKingdomCardList().get(i).pop();
			}
		}
		
		assertTrue(supply.isGameOver());
	}
	
	@Test
	public void testGameOverOneKingdomSupplyGone(){
		Supply supply = new Supply();
		
		for(int j = 0; j < 10; j++){
			supply.getKingdomCardList().get(0).pop();
		}
		
		assertFalse(supply.isGameOver());
	}
	
	@Test
	public void testGameOverMixedThreeSupplyGone(){
		Supply supply = new Supply();
		Stack<Card> duchySupply = supply.getBaseSupply("DUCHY");
		Stack<Card> goldSupply = supply.getBaseSupply("GOLD");
		
		for(int j = 0; j < 10; j++){
			supply.getKingdomCardList().get(0).pop();
		}
		for(int i = 0; i < 12; i++){
			duchySupply.pop();
		}
		for(int i = 0; i < 30; i++){
			goldSupply.pop();
		}
		
		assertTrue(supply.isGameOver());
	}
	
	@Test
	public void testGameOverMixedFourSupplyGone(){
		Supply supply = new Supply();
		Stack<Card> duchySupply = supply.getBaseSupply("DUCHY");
		Stack<Card> goldSupply = supply.getBaseSupply("GOLD");
		
		for(int i = 0; i < 2; i++){
			for(int j = 0; j < 10; j++){
				supply.getKingdomCardList().get(i).pop();
			}
		}
		for(int i = 0; i < 12; i++){
			duchySupply.pop();
		}
		for(int i = 0; i < 30; i++){
			goldSupply.pop();
		}
		
		assertTrue(supply.isGameOver());
	}
}
