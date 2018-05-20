import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MainTest {
	
	GUI gui;
	
	@Before
	public void setup() {
		gui = EasyMock.mock(GUI.class);
	}
	
	@After
	public void tearDown() {
		EasyMock.verify(gui);
	}

	@Test
	public void testCloseGUI() {
		gui.quitGame();
		
		EasyMock.replay(gui);
		
		Main.closeGUI(gui);
	}

	@Test
	public void testPromptPlayAgainDisplayWinners() {
		Set<Player> winners = new HashSet<Player>();
		CompletableFuture<Boolean> response = new CompletableFuture<Boolean>();
		response.complete(false);
		Player winner = EasyMock.mock(Player.class);
		winners.add(winner);
		
		EasyMock.expect(gui.getPlayAgainDisplayWinners(winners)).andReturn(response);
		
		EasyMock.replay(gui, winner);
		
		assertFalse(Main.promptPlayAgainDisplayWinners(gui, winners));
		
		EasyMock.verify(winner);
	}

	@Test
	public void testGetNumPlayers() {
		CompletableFuture<Integer> response = new CompletableFuture<Integer>();
		response.complete(2);
		
		EasyMock.expect(gui.initNumPlayers()).andReturn(response);
		
		EasyMock.replay(gui);
		
		assertEquals(Main.getNumPlayers(gui), 2);
	}

	@Test
	public void testCreatePlayer() {
		CompletableFuture<String> response = new CompletableFuture<String>();
		response.complete("test");
		
		EasyMock.expect(gui.getPlayerXName(1)).andReturn(response);
		
		EasyMock.replay(gui);
		
		Player player = Main.createPlayer(gui, 1);
		
		assertEquals(player.getName(), "test");
	}

	@Test
	public void testChooseLocaleEN() {
		Locale expected = new Locale("en");
		CompletableFuture<AvailableLocales> response = new CompletableFuture<AvailableLocales>();
		response.complete(AvailableLocales.EN);
		
		EasyMock.expect(gui.chooseLocale()).andReturn(response);
		
		EasyMock.replay(gui);
		
		assertEquals(Main.chooseLocale(gui), expected);
	}
	
	@Test
	public void testChooseLocaleES() {
		Locale expected = new Locale("es");
		CompletableFuture<AvailableLocales> response = new CompletableFuture<AvailableLocales>();
		response.complete(AvailableLocales.ES);
		
		EasyMock.expect(gui.chooseLocale()).andReturn(response);
		
		EasyMock.replay(gui);
		
		assertEquals(Main.chooseLocale(gui), expected);
	}

}
