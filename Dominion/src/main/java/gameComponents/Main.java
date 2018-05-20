package gameComponents;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;

import util.AvailableLocales;
import util.GameConstants;

public class Main {

	static GUI gui;

	public static void main(String[] args) {
		gui = new GUI();

		chooseLocale();

		int numPlayers = getNumPlayers();
		Player[] players = new Player[numPlayers];
		for (int i = 0; i < numPlayers; ++i) {
			players[i] = createPlayer(i + 1);
		}

		Game game = new Game(players);

		Set<Player> winners = game.runGame();
	}

	static int getNumPlayers() {
		return gui.initNumPlayers().join();
	}

	static Player createPlayer(int number) {
		String name = gui.getPlayerXName(number).join();
		return new Player(name, gui);
	}

	static void chooseLocale() {
		AvailableLocales chosenLocale = gui.chooseLocale().join();
		Locale locale;

		if (chosenLocale.equals(AvailableLocales.EN)) {
			locale = new Locale("en");
		} else {
			locale = new Locale("es");
		}

		GameConstants.messages = ResourceBundle.getBundle("MessagesBundle", locale);
	}

}
