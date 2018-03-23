import static org.junit.Assert.*;

import org.easymock.EasyMock;
import org.junit.Test;

public class GameTest {

	@Test
	public void testWinnable() {
		Player[] list = new Player[2];
		for (int i = 0; i < 2; i++) {
			list[i] = EasyMock.mock(Player.class);
			EasyMock.expect(list[i].getPoints()).andStubReturn(0);
			EasyMock.expect(list[i].getName()).andStubReturn(String.format("%d", i));
			EasyMock.replay(list[i]);
		}

		Game g = new Game(list);
		assertEquals("0&&1", g.endGame());

		for (Player p : list) {
			EasyMock.verify(p);
		}
	}

	@Test
	public void testWinnableWPoints() {
		Player[] list = new Player[4];
		int[] points = { 5, 3, 2, 1 };
		for (int i = 0; i < 4; i++) {
			list[i] = EasyMock.mock(Player.class);
			EasyMock.expect(list[i].getPoints()).andStubReturn(points[i]);
			EasyMock.expect(list[i].getName()).andStubReturn(String.format("%d", i));
			EasyMock.replay(list[i]);
		}

		Game g = new Game(list);
		assertEquals("0", g.endGame());

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
			EasyMock.replay(list[i]);
		}

		Game g = new Game(list);
		g.endTurn();
		g.endTurn();
		assertEquals("2&&3", g.endGame());

		for (Player p : list) {
			EasyMock.verify(p);
		}
	}

	@Test
	public void testWinnableOneWinnerTiebreaker() {
		Player[] list = new Player[4];
		int[] points = { 5, 3, 3, 5 };
		for (int i = 0; i < 4; i++) {
			list[i] = EasyMock.mock(Player.class);
			EasyMock.expect(list[i].getPoints()).andStubReturn(points[i]);
			EasyMock.expect(list[i].getName()).andStubReturn(String.format("%d", i));
			EasyMock.replay(list[i]);
		}

		Game g = new Game(list);
		g.endTurn();
		g.endTurn();
		assertEquals("3", g.endGame());

		for (Player p : list) {
			EasyMock.verify(p);
		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void testMoreThan4Players() {
		Player[] list = new Player[5];
		for (int i = 0; i < 5; i++) {
			list[i] = EasyMock.mock(Player.class);
			EasyMock.expect(list[i].getPoints()).andStubReturn(0);
			EasyMock.expect(list[i].getName()).andStubReturn(String.format(" %d", i));
			EasyMock.replay(list[i]);
		}

		Game g = new Game(list);

		for (Player p : list) {
			EasyMock.verify(p);
		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void testLessThan2Players() {
		Game g = new Game(new Player[0]);
	}

}
