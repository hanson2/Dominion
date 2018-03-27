import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class SupplyPileTest {

	@Test
	public void testSupplySetup() {
		Supply supply = new Supply();
		List kingdomeCardList = supply.getKingdomCardList();
		
		assertTrue(kingdomeCardList.size() == 10);
		
		assertTrue(supply.getCopperSupply().size() == 60);
		assertTrue(supply.getSilverSupply().size() == 40);
		assertTrue(supply.getGoldSupply().size() == 30);
		
		assertTrue(supply.getEstateSupply().size() == 24);
		assertTrue(supply.getDuchySupply().size() == 12);
		assertTrue(supply.getProvinceSupply().size() == 12);
		assertTrue(supply.getCurseSupply().size() == 30);
	}
	
	@Test
	public void testCopperValidity(){
		Supply supply = new Supply();
		Card top = supply.getCopperSupply().pop();
		
		assertTrue(top.getType().equals("TREASURE"));
		assertTrue(top.getCoinsAdded() == 1);
		assertTrue(top.getActionsAdded() == 0);
		assertTrue(top.getBuysAdded() == 0);
		assertTrue(top.getCardsAdded() == 0);
		assertTrue(top.getVictoryValue() == 0);
		assertTrue(top.getCost() == 0);
		assertTrue(supply.getCopperSupply() == supply.getCopperSupply());
	}
	
	@Test
	public void testSilverValidity(){
		Supply supply = new Supply();
		Card top = supply.getSilverSupply().pop();
		
		assertTrue(top.getType().equals("TREASURE"));
		assertTrue(top.getCoinsAdded() == 2);
		assertTrue(top.getActionsAdded() == 0);
		assertTrue(top.getBuysAdded() == 0);
		assertTrue(top.getCardsAdded() == 0);
		assertTrue(top.getVictoryValue() == 0);
		assertTrue(top.getCost() == 3);
		assertTrue(supply.getSilverSupply() == supply.getSilverSupply());
	}
	
	@Test
	public void testGoldValidity(){
		Supply supply = new Supply();
		Card top = supply.getGoldSupply().pop();
		
		assertTrue(top.getType().equals("TREASURE"));
		assertTrue(top.getCoinsAdded() == 3);
		assertTrue(top.getActionsAdded() == 0);
		assertTrue(top.getBuysAdded() == 0);
		assertTrue(top.getCardsAdded() == 0);
		assertTrue(top.getVictoryValue() == 0);
		assertTrue(top.getCost() == 6);
		assertTrue(supply.getGoldSupply() == supply.getGoldSupply());
	}
	
	@Test
	public void testEstateValidity(){
		Supply supply = new Supply();
		Card top = supply.getEstateSupply().pop();
		
		assertTrue(top.getType().equals("VICTORY"));
		assertTrue(top.getCoinsAdded() == 0);
		assertTrue(top.getActionsAdded() == 0);
		assertTrue(top.getBuysAdded() == 0);
		assertTrue(top.getCardsAdded() == 0);
		assertTrue(top.getVictoryValue() == 1);
		assertTrue(top.getCost() == 2);
		assertTrue(supply.getEstateSupply() == supply.getEstateSupply());
	}
	
	@Test
	public void testDuchyValidity(){
		Supply supply = new Supply();
		Card top = supply.getDuchySupply().pop();
		
		assertTrue(top.getType().equals("VICTORY"));
		assertTrue(top.getCoinsAdded() == 0);
		assertTrue(top.getActionsAdded() == 0);
		assertTrue(top.getBuysAdded() == 0);
		assertTrue(top.getCardsAdded() == 0);
		assertTrue(top.getVictoryValue() == 3);
		assertTrue(top.getCost() == 5);
		assertTrue(supply.getDuchySupply() == supply.getDuchySupply());
	}
	
	@Test
	public void testProvinceValidity(){
		Supply supply = new Supply();
		Card top = supply.getProvinceSupply().pop();
		
		assertTrue(top.getType().equals("VICTORY"));
		assertTrue(top.getCoinsAdded() == 0);
		assertTrue(top.getActionsAdded() == 0);
		assertTrue(top.getBuysAdded() == 0);
		assertTrue(top.getCardsAdded() == 0);
		assertTrue(top.getVictoryValue() == 6);
		assertTrue(top.getCost() == 8);
		assertTrue(supply.getProvinceSupply() == supply.getProvinceSupply());
	}
	
	@Test
	public void testCurseValidity(){
		Supply supply = new Supply();
		Card top = supply.getCurseSupply().pop();
		
		assertTrue(top.getType().equals("CURSE"));
		assertTrue(top.getCoinsAdded() == 0);
		assertTrue(top.getActionsAdded() == 0);
		assertTrue(top.getBuysAdded() == 0);
		assertTrue(top.getCardsAdded() == 0);
		assertTrue(top.getVictoryValue() == -1);
		assertTrue(top.getCost() == 0);
		assertTrue(supply.getCurseSupply() == supply.getCurseSupply());
	}
	
	@Test
	public void testGameOverProvinceGone(){
		Supply supply = new Supply();
		
		for(int i = 0; i < 12; i++){
			supply.getProvinceSupply().pop();
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
		for(int i = 0; i < 12; i++){
			supply.getDuchySupply().pop();
		}
		assertFalse(supply.isGameOver());
	}
	
	@Test
	public void testGameOverThreeBaseSupplyGoneNotProvince(){
		Supply supply = new Supply();
		for(int i = 0; i < 12; i++){
			supply.getDuchySupply().pop();
		}
		for(int i = 0; i < 30; i++){
			supply.getGoldSupply().pop();
		}
		for(int i = 0; i < 60; i++){
			supply.getCopperSupply().pop();
		}
		assertTrue(supply.isGameOver());
	}
	
	@Test 
	public void testGameOverMoreThanThreeBaseSupplyGoneNotProvince(){
		Supply supply = new Supply();
		for(int i = 0; i < 12; i++){
			supply.getDuchySupply().pop();
		}
		for(int i = 0; i < 30; i++){
			supply.getGoldSupply().pop();
		}
		for(int i = 0; i < 60; i++){
			supply.getCopperSupply().pop();
		}
		for(int i = 0; i < 24; i++){
			supply.getEstateSupply().pop();
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
		for(int j = 0; j < 10; j++){
			supply.getKingdomCardList().get(0).pop();
		}
		for(int i = 0; i < 12; i++){
			supply.getDuchySupply().pop();
		}
		for(int i = 0; i < 30; i++){
			supply.getGoldSupply().pop();
		}
		assertTrue(supply.isGameOver());
	}
	
	@Test
	public void testGameOverMixedFourSupplyGone(){
		Supply supply = new Supply();
		for(int i = 0; i < 2; i++){
			for(int j = 0; j < 10; j++){
				supply.getKingdomCardList().get(i).pop();
			}
		}
		for(int i = 0; i < 12; i++){
			supply.getDuchySupply().pop();
		}
		for(int i = 0; i < 30; i++){
			supply.getGoldSupply().pop();
		}
		assertTrue(supply.isGameOver());
	}
}
