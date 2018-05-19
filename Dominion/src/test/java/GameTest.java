import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.easymock.EasyMock;
import org.junit.Test;

public class GameTest {

	@Test
	public void testWinnable() {
		Player[] list = new Player[2];
		for (int i = 0; i < 2; i++) {
			list[i] = EasyMock.mock(Player.class);
			EasyMock.expect(list[i].getPoints()).andStubReturn(0);
		}

		EasyMock.replay(list);

		Game g = new Game(list);

		Set<Player> winners = new HashSet<>();
		winners.add(list[0]);
		winners.add(list[1]);

		assertEquals(winners, g.endGame());

		EasyMock.verify(list);
	}

	@Test
	public void testWinnableWPoints() {
		Player[] list = new Player[4];
		int[] points = { 5, 3, 2, 1 };
		for (int i = 0; i < 4; i++) {
			list[i] = EasyMock.mock(Player.class);
			EasyMock.expect(list[i].getPoints()).andStubReturn(points[i]);
		}

		EasyMock.replay(list);

		Game g = new Game(list);
		Set<Player> winners = new HashSet<>();
		winners.add(list[0]);

		assertEquals(winners, g.endGame());

		EasyMock.verify(list);
	}
	
	@Test
	public void testWinnableCloseGame() {
		Player[] list = new Player[4];
		int[] points = { 4, 5, 2, 1 };
		for (int i = 0; i < 4; i++) {
			list[i] = EasyMock.mock(Player.class);
			EasyMock.expect(list[i].getPoints()).andStubReturn(points[i]);
			EasyMock.replay(list[i]);
		}

		Game g = new Game(list);
		Set<Player> winners = new HashSet<>();
		winners.add(list[1]);

		assertEquals(winners, g.endGame());

		for (Player p : list) {
			EasyMock.verify(p);
		}
	}

	@Test
	public void testWinnableTieWTiebreakers() {
		Player[] list = new Player[4];
		int[] points = { 5, 5, 5, 5 };
		for (int i = 0; i < 4; i++) {
			list[i] = EasyMock.mock(Player.class);
			EasyMock.expect(list[i].getPoints()).andStubReturn(points[i]);
			EasyMock.expect(list[i].getName()).andStubReturn(String.format("%d", i));
		}

		EasyMock.replay(list);

		Set<Player> winners = new HashSet<>();
		winners.add(list[2]);
		winners.add(list[3]);

		Game g = new Game(list);
		g.endTurn();
		g.endTurn();
		assertEquals(winners, g.endGame());

		EasyMock.verify(list);
	}

	@Test
	public void testWinnableOneWinnerTiebreaker() {
		Player[] list = new Player[4];
		int[] points = { 5, 3, 3, 5 };
		for (int i = 0; i < 4; i++) {
			list[i] = EasyMock.mock(Player.class);
			EasyMock.expect(list[i].getPoints()).andStubReturn(points[i]);
		}

		EasyMock.replay(list);

		Set<Player> winners = new HashSet<Player>();
		winners.add(list[3]);

		Game g = new Game(list);
		g.endTurn();
		g.endTurn();
		assertEquals(winners, g.endGame());

		EasyMock.verify(list);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testMoreThan4Players() {
		Player[] list = new Player[5];
		for (int i = 0; i < 5; i++) {
			list[i] = EasyMock.mock(Player.class);
			EasyMock.expect(list[i].getPoints()).andStubReturn(0);
		}

		EasyMock.replay(list);

		new Game(list);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testLessThan2Players() {
		new Game(new Player[0]);
	}

}
