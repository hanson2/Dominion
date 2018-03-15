import static org.junit.Assert.*;

import org.junit.Test;

public class test {

	@Test
	public void testWinnable() {
		Game g = new Game();
		assertEquals(1,g.endGame());
	}

}
