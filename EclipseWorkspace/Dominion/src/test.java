import static org.junit.Assert.*;

import org.junit.Test;

public class test {

	@Test
	public void testWinnable() {
		Game g = new Game(1);
		assertEquals(0,g.endGame());
	}
	@Test
	public void testWinnableWPoints(){
		Game g = new Game(4);
		g.players[0].points = 5;
		g.players[1].points = 3;
		g.players[2].points = 2;
		g.players[3].points = 1;
		assertEquals(0,g.endGame());
	}

}
