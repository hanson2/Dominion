package util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import cards.Artisan;
import cards.Card;
import cards.Cellar;
import cards.Chancellor;
import cards.Chapel;
import cards.Copper;
import cards.CouncilRoom;
import cards.Curse;
import cards.Duchy;
import cards.Estate;
import cards.Festival;
import cards.Gold;
import cards.Laboratory;
import cards.Market;
import cards.Moat;
import cards.Moneylender;
import cards.Province;
import cards.Remodel;
import cards.Silver;
import cards.Smithy;
import cards.ThroneRoom;
import cards.Vassal;
import cards.Village;
import cards.Woodcutter;

public class CardFactoryTest {

	@Test
	public void testCopper() {
		assertEquals(Copper.class, CardFactory.makeCard(Copper.class).getClass());
	}

	@Test
	public void testSilver() {
		assertEquals(Silver.class, CardFactory.makeCard(Silver.class).getClass());
	}

	@Test
	public void testGold() {
		assertEquals(Gold.class, CardFactory.makeCard(Gold.class).getClass());
	}

	@Test
	public void testEstate() {
		assertEquals(Estate.class, CardFactory.makeCard(Estate.class).getClass());
	}

	@Test
	public void testDuchy() {
		assertEquals(Duchy.class, CardFactory.makeCard(Duchy.class).getClass());
	}

	@Test
	public void testProvince() {
		assertEquals(Province.class, CardFactory.makeCard(Province.class).getClass());
	}

	@Test
	public void testCurse() {
		assertEquals(Curse.class, CardFactory.makeCard(Curse.class).getClass());
	}

	@Test
	public void testCellar() {
		assertEquals(Cellar.class, CardFactory.makeCard(Cellar.class).getClass());
	}

	@Test
	public void testChancellor() {
		assertEquals(Chancellor.class, CardFactory.makeCard(Chancellor.class).getClass());
	}

	@Test
	public void testChapel() {
		assertEquals(Chapel.class, CardFactory.makeCard(Chapel.class).getClass());
	}

	@Test
	public void testFestival() {
		assertEquals(Festival.class, CardFactory.makeCard(Festival.class).getClass());
	}

	@Test
	public void testLaboratory() {
		assertEquals(Laboratory.class, CardFactory.makeCard(Laboratory.class).getClass());
	}

	@Test
	public void testMarket() {
		assertEquals(Market.class, CardFactory.makeCard(Market.class).getClass());
	}

	@Test
	public void testMoat() {
		assertEquals(Moat.class, CardFactory.makeCard(Moat.class).getClass());
	}

	@Test
	public void testMoneylender() {
		assertEquals(Moneylender.class, CardFactory.makeCard(Moneylender.class).getClass());
	}

	@Test
	public void testSmithy() {
		assertEquals(Smithy.class, CardFactory.makeCard(Smithy.class).getClass());
	}

	@Test
	public void testThroneRoom() {
		assertEquals(ThroneRoom.class, CardFactory.makeCard(ThroneRoom.class).getClass());
	}

	@Test
	public void testVassal() {
		assertEquals(Vassal.class, CardFactory.makeCard(Vassal.class).getClass());
	}

	@Test
	public void testVillage() {
		assertEquals(Village.class, CardFactory.makeCard(Village.class).getClass());
	}

	@Test
	public void testWoodcutter() {
		assertEquals(Woodcutter.class, CardFactory.makeCard(Woodcutter.class).getClass());
	}

	@Test
	public void testRemodel() {
		assertEquals(Remodel.class, CardFactory.makeCard(Remodel.class).getClass());
	}

	@Test
	public void testArtisan() {
		assertEquals(Artisan.class, CardFactory.makeCard(Artisan.class).getClass());
	}

	@Test
	public void testCouncilRoom() {
		assertEquals(CouncilRoom.class, CardFactory.makeCard(CouncilRoom.class).getClass());
	}

	@Test
	public void testUnimplemented() {
		assertEquals(Copper.class, CardFactory.makeCard(Card.class).getClass());
	}
}
