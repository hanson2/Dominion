package cards;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import states.CardPlayState;
import util.CardType;
import util.GameConstants;

public class LaboratoryTest {

	@Test
	public void testGetType() {
		Card lab = new Laboratory();
		assertTrue(lab.getType().contains(CardType.ACTION));
	}

	@Test
	public void testGetCost() {
		Card lab = new Laboratory();
		assertEquals(lab.getCost(), GameConstants.LABORATORYCOST);
	}

	@Test
	public void testGetCoinsAdded() {
		Card lab = new Laboratory();
		assertEquals(lab.getCoinsAdded(), GameConstants.DEFAULTCARDATTRIBUTE);
	}

	@Test
	public void testGetActionsAdded() {
		Card lab = new Laboratory();
		assertEquals(lab.getActionsAdded(), GameConstants.LABORATORYACTIONSADDED);
	}

	@Test
	public void testGetBuysAdded() {
		Card lab = new Laboratory();
		assertEquals(lab.getBuysAdded(), GameConstants.DEFAULTCARDATTRIBUTE);
	}

	@Test
	public void testGetCardsAdded() {
		Card lab = new Laboratory();
		assertEquals(lab.getCardsAdded(), GameConstants.LABORATORYCARDSADDED);
	}

	@Test
	public void testGetVictoryValue() {
		Card lab = new Laboratory();
		assertEquals(lab.getVictoryValue(), GameConstants.DEFAULTCARDATTRIBUTE);
	}

	@Test
	public void testGetPlayState() {
		Card lab = new Laboratory();
		assertEquals(lab.getPlayState().getClass(), CardPlayState.class);
	}
	
	@Test
	public void testGetName() {
		Card lab = new Laboratory();
		assertEquals(lab.getName(), GameConstants.LABORATORYNAME);
	}
	
	@Test
	public void testGetText() {
		Card lab = new Laboratory();
		assertEquals(lab.getText(), GameConstants.DEFAULTCARDTEXT);
	}
	
	@Test
	public void testGetTypeTranslationKeys() {
		Card lab = new Laboratory();
		
		ArrayList<String> expectedTranslationKeys = new ArrayList<String>();
		expectedTranslationKeys.add("cardtypeAction");
		
		assertEquals(lab.getTypeTranslationKeys(), expectedTranslationKeys);
	}

}
