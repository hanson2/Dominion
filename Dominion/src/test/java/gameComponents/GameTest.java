package gameComponents;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.easymock.EasyMock;
import org.junit.Test;

import states.Turn;
import states.TurnCreator;

public class GameTest {

	@Test
	public void testWinnable() {
		Player[] list = new Player[2];
		for (int i = 0; i < 2; i++) {
			list[i] = EasyMock.mock(Player.class);
			EasyMock.expect(list[i].getPoints()).andStubReturn(0);
		}

		EasyMock.replay(list);

		Game game = new Game(list);

		Set<Player> winners = new HashSet<>();
		winners.add(list[0]);
		winners.add(list[1]);

		assertEquals(winners, game.endGame());

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

		Game game = new Game(list);
		Set<Player> winners = new HashSet<>();
		winners.add(list[0]);

		assertEquals(winners, game.endGame());

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

		Game game = new Game(list);
		Set<Player> winners = new HashSet<>();
		winners.add(list[1]);

		assertEquals(winners, game.endGame());

		EasyMock.verify(list);
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

		Game game = new Game(list);
		game.endTurn();
		game.endTurn();
		assertEquals(winners, game.endGame());

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

		Game game = new Game(list);
		game.endTurn();
		game.endTurn();
		assertEquals(winners, game.endGame());

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

	@Test
	public void testRunGameProperlyBreaksLoopFirstTime() {
		Player[] list = new Player[4];
		int[] points = { 5, 3, 2, 1 };
		for (int i = 0; i < 4; i++) {
			list[i] = EasyMock.mock(Player.class);
		}
		Supply supplyPiles = EasyMock.mock(Supply.class);
		Game game = EasyMock.partialMockBuilder(Game.class).addMockedMethod("makeNewTurn").createMock();
		Turn turn = EasyMock.mock(Turn.class);
		for (int i = 0; i < list.length; i++) {
			list[i].drawNewHand();
		}

		EasyMock.expect(game.makeNewTurn()).andReturn(turn);
		turn.run();

		EasyMock.expect(supplyPiles.isGameOver()).andReturn(true);

		for (int i = 0; i < 4; i++) {
			EasyMock.expect(list[i].getPoints()).andStubReturn(points[i]);
		}

		EasyMock.replay(list);
		EasyMock.replay(supplyPiles, game, turn);

		game.supplyPiles = supplyPiles;
		game.players = list;
		Set<Player> winners = new HashSet<>();
		winners.add(list[0]);

		assertEquals(winners, game.runGame());
		assertEquals(game.currentPlayer, 0);

		EasyMock.verify(list);
		EasyMock.verify(supplyPiles, game, turn);
	}

	@Test
	public void testRunGameProperlyBreaksLoopSecondTime() {
		Player[] list = new Player[4];
		int[] points = { 5, 3, 2, 1 };
		for (int i = 0; i < 4; i++) {
			list[i] = EasyMock.mock(Player.class);
		}
		Supply supplyPiles = EasyMock.mock(Supply.class);
		Game game = EasyMock.partialMockBuilder(Game.class).addMockedMethod("makeNewTurn").createMock();
		for (int i = 0; i < list.length; i++) {
			list[i].drawNewHand();
		}
		Turn turn = EasyMock.mock(Turn.class);

		EasyMock.expect(game.makeNewTurn()).andReturn(turn);
		turn.run();

		EasyMock.expect(supplyPiles.isGameOver()).andReturn(false);

		EasyMock.expect(game.makeNewTurn()).andReturn(turn);
		turn.run();

		EasyMock.expect(supplyPiles.isGameOver()).andReturn(true);
		for (int i = 0; i < 4; i++) {
			EasyMock.expect(list[i].getPoints()).andStubReturn(points[i]);
		}

		EasyMock.replay(list);
		EasyMock.replay(supplyPiles, game, turn);

		game.supplyPiles = supplyPiles;
		game.players = list;
		Set<Player> winners = new HashSet<>();
		winners.add(list[0]);

		assertEquals(winners, game.runGame());
		assertEquals(game.currentPlayer, 1);

		EasyMock.verify(list);
		EasyMock.verify(supplyPiles, game, turn);
	}

	@Test
	public void testRunGameProperlyBreaksLoopAfterRollover() {
		Player[] list = new Player[2];
		int[] points = { 5, 3 };
		for (int i = 0; i < 2; i++) {
			list[i] = EasyMock.mock(Player.class);
		}
		Supply supplyPiles = EasyMock.mock(Supply.class);
		Game game = EasyMock.partialMockBuilder(Game.class).addMockedMethod("makeNewTurn").createMock();
		Turn turn = EasyMock.mock(Turn.class);
		for (int i = 0; i < list.length; i++) {
			list[i].drawNewHand();
		}

		EasyMock.expect(game.makeNewTurn()).andReturn(turn);
		turn.run();

		EasyMock.expect(supplyPiles.isGameOver()).andReturn(false);

		EasyMock.expect(game.makeNewTurn()).andReturn(turn);
		turn.run();

		EasyMock.expect(supplyPiles.isGameOver()).andReturn(false);

		EasyMock.expect(game.makeNewTurn()).andReturn(turn);
		turn.run();

		EasyMock.expect(supplyPiles.isGameOver()).andReturn(true);

		for (int i = 0; i < 2; i++) {
			EasyMock.expect(list[i].getPoints()).andStubReturn(points[i]);
		}

		EasyMock.replay(list);
		EasyMock.replay(supplyPiles, game, turn);

		game.supplyPiles = supplyPiles;
		game.players = list;
		Set<Player> winners = new HashSet<>();
		winners.add(list[0]);

		assertEquals(winners, game.runGame());
		assertEquals(game.currentPlayer, 0);

		EasyMock.verify(list);
		EasyMock.verify(supplyPiles, game, turn);
	}

	@Test
	public void testMakeNewTurn() {
		Player[] list = new Player[2];
		Game game = new Game(list);
		Turn turn = game.makeNewTurn();

		assertEquals(TurnCreator.getPlayer(turn), list[game.currentPlayer]);
		assertEquals(TurnCreator.getSupply(turn), game.supplyPiles);
	}
}
