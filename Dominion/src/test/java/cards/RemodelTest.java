package cards;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import states.RemodelPlayState;
import util.CardType;
import util.GameConstants;

public class RemodelTest {
	Card card;

	@Before
	public void setup() {
		card = new Remodel();
	}

	@Test
	public void testGetType() {
		assertTrue(card.getType().contains(CardType.ACTION));
	}

	@Test
	public void testGetCost() {
		assertEquals(card.getCost(), GameConstants.REMODELCOST);
	}

	@Test
	public void testGetCoinsAdded() {
		assertEquals(card.getCoinsAdded(), GameConstants.DEFAULTCARDATTRIBUTE);
	}

	@Test
	public void testGetActionsAdded() {
		assertEquals(card.getActionsAdded(), GameConstants.DEFAULTCARDATTRIBUTE);
	}

	@Test
	public void testGetBuysAdded() {
		assertEquals(card.getBuysAdded(), GameConstants.DEFAULTCARDATTRIBUTE);
	}

	@Test
	public void testGetCardsAdded() {
		assertEquals(card.getCardsAdded(), GameConstants.DEFAULTCARDATTRIBUTE);
	}

	@Test
	public void testGetVictoryValue() {
		assertEquals(card.getVictoryValue(), GameConstants.DEFAULTCARDATTRIBUTE);
	}

	@Test
	public void testGetPlayState() {
		assertEquals(card.getPlayState().getClass(), RemodelPlayState.class);
	}

	@Test
	public void testGetName() {
		assertEquals(card.getName(), GameConstants.REMODELNAME);
	}

	@Test
	public void testGetText() {
		assertEquals(card.getText(), GameConstants.REMODELTEXT);
	}
}
