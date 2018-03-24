import static org.junit.Assert.*;

import org.junit.Test;

public class SupplyPileTest {

	@Test
	public void testSupplySetup() {
		Supply supply = new Supply();
		
		assertTrue(supply.getKingdomCardList().size() == 10);
		
		assertTrue(supply.getCopperSupply().size() == 60);
		assertTrue(supply.getSilverSupply().size() == 40);
		assertTrue(supply.getGoldSupply().size() == 30);
		
		assertTrue(supply.getEstateSupply().size() == 24);
		assertTrue(supply.getDuchieSupply().size() == 12);
		assertTrue(supply.getProvinceSupply().size() == 12);
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
		assertTrue(supply.getEstateSupply() == supply.getEstateSupply());
	}
}
