package states;

import java.util.ArrayList;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cards.Copper;
import cards.Gold;
import cards.Silver;
import gameComponents.Player;
import gameComponents.Supply;

public class BanditPlayStateTest {
	Turn turn;
	Player player;
	Supply supply;
	ArrayList<Player> list;

	@Before
	public void setup() {
		player = EasyMock.mock(Player.class);
		supply = EasyMock.mock(Supply.class);
		list = new ArrayList<Player>();
		list.add(EasyMock.mock(Player.class));

		turn = new Turn(player, supply, list);
		turn.state = new BanditPlayState();
	}

	@After
	public void tearDown() {
		EasyMock.verify(supply, list, player);
		for (Player player2 : list) {
			EasyMock.verify(player2);
		}
	}

	@Test
	public void testBanditFirstTreasure() {

		supply.decrementPile(new Gold());
		player.gainCard(new Gold(), supply);
		for (Player player2 : list) {
			Copper copper = new Copper();
			EasyMock.expect(player.drawACardAndReturn()).andReturn(new Silver());
			EasyMock.expect(player.drawACardAndReturn()).andReturn(new Copper());
			player2.gainCardToHand(copper);
			player2.discardCardFromHand(Copper.class);
		}

		EasyMock.replay(player, supply);
		for (Player player2 : list) {
			EasyMock.replay(player2);
		}
		turn.run();
	}

	@Test
	public void testBanditSecondTreasure() {

		EasyMock.replay(player, supply, list);
		for (Player player2 : list) {
			EasyMock.replay(player2);
		}
		turn.run();

	}

	@Test
	public void testBanditBothTreasure() {

		EasyMock.replay(player, supply, list);
		for (Player player2 : list) {
			EasyMock.replay(player2);
		}
		turn.run();

	}

	@Test
	public void testBanditBothCopper() {

		EasyMock.replay(player, supply, list);
		for (Player player2 : list) {
			EasyMock.replay(player2);
		}
		turn.run();

	}

}
