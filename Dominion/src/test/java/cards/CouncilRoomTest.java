package cards;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import states.CouncilRoomPlayState;
import util.CardType;
import util.GameConstants;

public class CouncilRoomTest {
	CouncilRoom card;

	@Before
	public void setup() {
		card = new CouncilRoom();
	}

	@Test
	public void testGetType() {
		assertTrue(card.getType().contains(CardType.ACTION));
	}

	@Test
	public void testGetCost() {
		assertEquals(card.getCost(), GameConstants.COUNCILROOMCOST);
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
		assertEquals(card.getBuysAdded(), GameConstants.COUNCILROOMBUYS);
	}

	@Test
	public void testGetCardsAdded() {
		assertEquals(card.getCardsAdded(), GameConstants.COUNCILROOMCARDSADDED);
	}

	@Test
	public void testGetVictoryValue() {
		assertEquals(card.getVictoryValue(), GameConstants.DEFAULTCARDATTRIBUTE);
	}

	@Test
	public void testGetPlayState() {
		assertEquals(card.getPlayState().getClass(), CouncilRoomPlayState.class);
	}

	@Test
	public void testGetName() {
		assertEquals(card.getName(), GameConstants.COUNCILROOMNAME);
	}

	@Test
	public void testGetText() {
		assertEquals(card.getText(), GameConstants.COUNCILROOMTEXT);
	}
}
