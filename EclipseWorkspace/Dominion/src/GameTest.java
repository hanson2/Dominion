import static org.junit.Assert.*;

import org.junit.Test;

public class GameTest {

	@Test
	public void testWinnable() {
		Game g = new Game(2);
		assertEquals("0&&1",g.endGame());
	}
	@Test
	public void testWinnableWPoints(){
		Game g = new Game(4);
		g.players[0].points = 5;
		g.players[1].points = 3;
		g.players[2].points = 2;
		g.players[3].points = 1;
		assertEquals("0",g.endGame());
	}

	@Test
	public void testWinnableTieWTiebreakers(){
		Game g = new Game(4);
		g.endTurn();
		g.endTurn();
		g.players[0].points = 5;
		g.players[1].points = 5;
		g.players[2].points = 5;
		g.players[3].points = 5;
		assertEquals("2&&3",g.endGame());
	}
	@Test
	public void testWinnableOneWinnerTiebreaker(){
		Game g = new Game(4);
		g.endTurn();
		g.endTurn();
		g.players[0].points = 5;
		g.players[1].points = 3;
		g.players[2].points = 3;
		g.players[3].points = 5;
		assertEquals("3",g.endGame());
	}
	@Test(expected=IllegalArgumentException.class)
	public void testMoreThan4Players(){
		Game g = new Game(5);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testLessThan2Players(){
		Game g = new Game(0);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testLessThan0Players(){
		Game g = new Game(-1);
	}

}
