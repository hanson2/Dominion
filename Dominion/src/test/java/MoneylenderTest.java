import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.easymock.EasyMock;
import org.junit.Test;

public class MoneylenderTest {

	@Test
	public void testGetType() {
		Card card = new Moneylender();

		assertTrue(card.getType().contains(CardType.ACTION));
	}

	@Test
	public void testGetCost() {
		Card card = new Moneylender();

		assertEquals(card.getCost(), GameConstants.MONEYLENDERCOST);
	}

	@Test
	public void testGetCoinsAdded() {
		Card card = new Moneylender();

		assertEquals(card.getCoinsAdded(), GameConstants.DEFAULTCARDATTRIBUTE);
	}

	@Test
	public void testGetActionsAdded() {
		Card card = new Moneylender();

		assertEquals(card.getActionsAdded(), GameConstants.DEFAULTCARDATTRIBUTE);
	}

	@Test
	public void testGetBuysAdded() {
		Card card = new Moneylender();

		assertEquals(card.getBuysAdded(), GameConstants.DEFAULTCARDATTRIBUTE);
	}

	@Test
	public void testGetCardsAdded() {
		Card card = new Moneylender();

		assertEquals(card.getCardsAdded(), GameConstants.DEFAULTCARDATTRIBUTE);
	}

	@Test
	public void testGetVictoryValue() {
		Card card = new Moneylender();

		assertEquals(card.getVictoryValue(), GameConstants.DEFAULTCARDATTRIBUTE);
	}

	@Test
	public void testGetPlayState() {
		Card card = new Moneylender();

		assertEquals(card.getPlayState().getClass(), MoneylenderPlayState.class);
	}

}
