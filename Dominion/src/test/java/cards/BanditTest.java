package cards;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import states.BanditPlayState;
<<<<<<< HEAD

=======
>>>>>>> 890b5b6578573bd456891d2c6ba588395026b04f
import util.CardType;
import util.GameConstants;

public class BanditTest {
	Card card;

	@Before
	public void setup() {
		card = new Bandit();
	}

	@Test
	public void testGetType() {
		assertTrue(card.getType().contains(CardType.ACTION));
		assertTrue(card.getType().contains(CardType.ATTACK));
	}

	@Test
	public void testGetCost() {
		assertEquals(card.getCost(), GameConstants.BANDITCOST);
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
		assertEquals(card.getPlayState().getClass(), BanditPlayState.class);
<<<<<<< HEAD

=======
>>>>>>> 890b5b6578573bd456891d2c6ba588395026b04f
	}

	@Test
	public void testGetName() {
		assertEquals(card.getName(), GameConstants.BANDITNAME);
	}

	@Test
	public void testGetText() {
		assertEquals(card.getText(), GameConstants.BANDITTEXT);
	}
}
