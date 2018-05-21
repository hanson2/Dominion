package gameComponents;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;

import util.AvailableLocales;
import util.GameConstants;

public class Main {

	public static void main(String[] args) {
		boolean playAgain = true;
		GUI gui = new GUI();
		while (playAgain) {
			gui = new GUI();

			GameConstants.messages = ResourceBundle.getBundle("MessagesBundle", chooseLocale(gui));

			int numPlayers = getNumPlayers(gui);
			Player[] players = new Player[numPlayers];
			for (int i = 0; i < numPlayers; ++i) {
				players[i] = createPlayer(gui, i + 1);
			}

			Game game = new Game(players);

			Set<Player> winners = game.runGame();

			playAgain = promptPlayAgainDisplayWinners(gui, winners);
		}
		closeGUI(gui);
	}

	static void closeGUI(GUI gui) {
		gui.quitGame();
	}

	static boolean promptPlayAgainDisplayWinners(GUI gui, Set<Player> winners) {
		return gui.getPlayAgainDisplayWinners(winners).join();
	}

	static int getNumPlayers(GUI gui) {
		return gui.initNumPlayers().join();
	}

	static Player createPlayer(GUI gui, int number) {
		gui.clear();
		String name = gui.getPlayerXName(number).join();
		return new Player(name, gui);
	}

	static Locale chooseLocale(GUI gui) {
		AvailableLocales chosenLocale = gui.chooseLocale().join();
		Locale locale;

		if (chosenLocale.equals(AvailableLocales.EN)) {
			locale = new Locale("en");
		} else {
			locale = new Locale("es");
		}

		return locale;
	}

}
