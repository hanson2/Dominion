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
		assertTrue(supply.getCopperSupply().pop().getType().equals("TREASURE"));
		assertTrue(supply.getCopperSupply().pop().getCoinValue() == 1);
		assertTrue(supply.getCopperSupply() == supply.getCopperSupply());
	}
}
