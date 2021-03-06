package gameComponents;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Set;

import cards.Artisan;
import cards.Card;
import cards.Cellar;
import cards.Chancellor;
import cards.Chapel;
import cards.Feast;
import cards.CouncilRoom;
import cards.Festival;
import cards.Gardens;
import cards.Laboratory;
import cards.Market;
import cards.Militia;
import cards.Moat;
import cards.Moneylender;
import cards.Remodel;
import cards.Smithy;
import cards.ThroneRoom;
import cards.Vassal;
import cards.Village;
import cards.Woodcutter;
import cards.Workshop;
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

			Supply supply = new Supply(numPlayers);
			supply.makeKingdomCardList(Main.getAvailableKingdomCards(), new Random());

			Game game = new Game(supply, players);

			Set<Player> winners = game.runGame();

			playAgain = promptPlayAgainDisplayWinners(gui, winners);
			gui.clear();
			gui.setVisible(false);
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
		String name = gui.getPlayerXName(number).join();
		return new Player(name, gui);
	}

	static Locale chooseLocale(GUI gui) {
		AvailableLocales chosenLocale = gui.chooseLocale().join();
		Locale locale;

		if (chosenLocale.equals(AvailableLocales.EN)) {
			locale = new Locale("en");
		} else if (chosenLocale.equals(AvailableLocales.ES)) {
			locale = new Locale("es");
		} else {
			locale = new Locale("en");
		}

		return locale;
	}

	static List<Card> getAvailableKingdomCards() {
		List<Card> availableKingdomCards = new ArrayList<Card>();

		availableKingdomCards.add(new Cellar());
		availableKingdomCards.add(new Chancellor());
		availableKingdomCards.add(new Chapel());
		availableKingdomCards.add(new Festival());
		availableKingdomCards.add(new Market());
		availableKingdomCards.add(new Laboratory());
		availableKingdomCards.add(new Moat());
		availableKingdomCards.add(new Moneylender());
		availableKingdomCards.add(new Smithy());
		availableKingdomCards.add(new ThroneRoom());
		availableKingdomCards.add(new Vassal());
		availableKingdomCards.add(new Village());
		availableKingdomCards.add(new Woodcutter());
		availableKingdomCards.add(new Remodel());
		availableKingdomCards.add(new Artisan());
		availableKingdomCards.add(new Feast());
		availableKingdomCards.add(new CouncilRoom());
		availableKingdomCards.add(new Gardens());
		availableKingdomCards.add(new Workshop());
		availableKingdomCards.add(new Militia());

		return availableKingdomCards;
	}
}
