package gameComponents;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import cards.Card;
import util.AvailableLocales;
import util.GameConstants;

@SuppressWarnings("serial")
public class GUI extends JFrame {
	private Container pane;
	JButton quitB;

	public GUI() {
		setTitle(GameConstants.messages.getString("guiDominionTitle"));
		pane = getContentPane();

		quitB = new JButton(GameConstants.messages.getString("guiQuit"));
		quitB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(DISPOSE_ON_CLOSE);
			}

		});
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pane.add(quitB);
	}

	public void clear() {
		this.pane.removeAll();
		this.pane.setLayout(new GridLayout(0, 3, 0, 0));
	}

	private void drawExitButton(CompletableFuture<Optional<Card>> future) {
		JButton end = new JButton();
		end.setText(GameConstants.messages.getString("guiEndPhase"));
		end.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				future.complete(Optional.empty());
			}

		});
		this.pane.add(end);

	}

	private void drawCard(Card card, CompletableFuture<Optional<Card>> future) {
		JButton box = new JButton();
		String text = this.makeText(card);
		box.setText(text);
		box.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				future.complete(Optional.of(card));
			}

		});
		this.pane.add(box);// add at the end
	}

	private String makeText(Card card) {
		StringBuilder cardText = new StringBuilder();
		cardText.append("<html>");// only way to get newline on buttons
		cardText.append(GameConstants.messages.getString(card.getName()));
		cardText.append("<br />");
		if (card.getCost() != 0) {
			cardText.append(String.format(GameConstants.messages.getString("guiCardCost"), card.getCost()));
			cardText.append("<br />");
		}
		if (card.getActionsAdded() != 0) {
			cardText.append(String.format(GameConstants.messages.getString("guiCardActions"), card.getActionsAdded()));
			cardText.append("<br />");
		}
		if (card.getBuysAdded() != 0) {
			cardText.append(String.format(GameConstants.messages.getString("guiCardBuys"), card.getBuysAdded()));
			cardText.append("<br />");
		}
		if (card.getCardsAdded() != 0) {
			cardText.append(String.format(GameConstants.messages.getString("guiCardCards"), card.getCardsAdded()));
			cardText.append("<br />");
		}
		if (card.getCoinsAdded() != 0) {
			cardText.append(String.format(GameConstants.messages.getString("guiCardCoins"), card.getCoinsAdded()));
			cardText.append("<br />");
		}
		if (card.getVictoryValue() != 0) {
			cardText.append(
					String.format(GameConstants.messages.getString("guiCardVictoryPoints"), card.getVictoryValue()));
			cardText.append("<br />");
		}
		if (card.getText().length() != 0) {
			cardText.append(String.format(GameConstants.messages.getString(card.getText())));
			cardText.append("<br />");
		}
		cardText.append("</html>");
		return cardText.toString();
	}

	public void start() {
		JButton startB = new JButton(GameConstants.messages.getString("guiStartGame"));
		StartButtonHandler startBH = new StartButtonHandler(this);
		startB.addActionListener(startBH);

		BorderLayout layout = new BorderLayout();
		pane.setLayout(layout);

		pane.add(startB, BorderLayout.CENTER);
		pane.add(quitB, BorderLayout.PAGE_END);

		setSize(300, 200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private class StartButtonHandler implements ActionListener {
		GUI gui;

		StartButtonHandler(GUI gui) {
			this.gui = gui;
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			this.gui.initNumPlayers();

		}

	}

	public CompletableFuture<AvailableLocales> chooseLocale() {
		this.setTitle(GameConstants.messages.getString("guiChooseLocale"));
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		pane.setLayout(new GridLayout(1, 2));

		CompletableFuture<AvailableLocales> localeChosenFuture = new CompletableFuture<>();

		JButton english = new JButton(GameConstants.messages.getString("languageChoiceEnglish"));
		english.addActionListener(new ChooseLocaleButtonListener(AvailableLocales.EN, localeChosenFuture));

		JButton spanish = new JButton(GameConstants.messages.getString("languageChoiceSpanish"));
		spanish.addActionListener(new ChooseLocaleButtonListener(AvailableLocales.ES, localeChosenFuture));

		pane.add(english);
		pane.add(spanish);

		this.pane.repaint();
		this.pack();
		this.setSize(GameConstants.GUIWIDTH, GameConstants.GUIHEIGHT);

		return localeChosenFuture;
	}

	private class ChooseLocaleButtonListener implements ActionListener {

		AvailableLocales localeChosen;
		CompletableFuture<AvailableLocales> localeChosenFuture;

		public ChooseLocaleButtonListener(AvailableLocales localeChosen,
				CompletableFuture<AvailableLocales> localeChosenFuture) {
			this.localeChosen = localeChosen;
			this.localeChosenFuture = localeChosenFuture;
		}

		@Override
		public void actionPerformed(ActionEvent localeButtonPressed) {
			this.localeChosenFuture.complete(this.localeChosen);
		}
	}

	public CompletableFuture<Integer> initNumPlayers() {
		this.clear();
		this.setTitle(GameConstants.messages.getString("guiNumPlayersTitle"));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		pane.setLayout(new GridLayout(0, 3));

		CompletableFuture<Integer> numPlayersFuture = new CompletableFuture<>();

		JButton two = new JButton("2");
		two.addActionListener(new InitNumPlayersButtonListener(2, numPlayersFuture));

		JButton three = new JButton("3");
		three.addActionListener(new InitNumPlayersButtonListener(3, numPlayersFuture));

		JButton four = new JButton("4");
		four.addActionListener(new InitNumPlayersButtonListener(4, numPlayersFuture));

		pane.add(two);
		pane.add(three);
		pane.add(four);

		this.setVisible(true);
		this.pane.repaint();
		this.pack();
		this.setSize(GameConstants.GUIWIDTH, GameConstants.GUIHEIGHT);

		return numPlayersFuture;
	}

	private class InitNumPlayersButtonListener implements ActionListener {

		int numPlayers;
		CompletableFuture<Integer> numPlayersFuture;

		InitNumPlayersButtonListener(int numPlayers, CompletableFuture<Integer> numPlayersFuture) {
			this.numPlayers = numPlayers;
			this.numPlayersFuture = numPlayersFuture;
		}

		@Override
		public void actionPerformed(ActionEvent buttonPress) {
			this.numPlayersFuture.complete(this.numPlayers);
		}

	}

	public CompletableFuture<String> getPlayerXName(int number) {
		this.clear();
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		CompletableFuture<String> playerXNameFuture = new CompletableFuture<>();

		String textPrompt = String.format(GameConstants.messages.getString("guiPlayerNamePrompt"), number);
		this.setTitle(textPrompt);

		JTextField textField = new JTextField(textPrompt);
		textField.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
				textField.selectAll();
			}

			@Override
			public void focusLost(FocusEvent arg0) {
			}

		});
		this.pane.add(textField);
		JButton submit = new JButton();
		submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				playerXNameFuture.complete(textField.getText());
			}

		});
		submit.setText(GameConstants.messages.getString("submit"));
		this.pane.add(submit);

		this.pack();
		this.setSize(GameConstants.GUIWIDTH, GameConstants.GUIHEIGHT);

		return playerXNameFuture;
	}

	public CompletableFuture<Boolean> getPlayAgainDisplayWinners(Set<Player> winners) {
		// TODO make this display winners and give players option to play again
		this.clear();
		this.setVisible(true);
		CompletableFuture<Boolean> playAgain = new CompletableFuture<Boolean>();

		playAgain.complete(false);

		return playAgain;
	}

	public void quitGame() {
		System.exit(DISPOSE_ON_CLOSE);
	}

	public CompletableFuture<Optional<Card>> chooseCardToPlay(List<Card> availableCards, String name) {
		// TODO make this display player's hand and allow the player to choose
		// one to play
		this.clear();
		this.pane.setLayout(new GridLayout(0, availableCards.size() + 1, 0, 0));
		this.setVisible(true);
		CompletableFuture<Optional<Card>> cardToPlay = new CompletableFuture<Optional<Card>>();
		this.setTitle(name + ": " + GameConstants.messages.getString("chooseCardToPlay"));

		for (Card card : availableCards) {
			this.drawCard(card, cardToPlay);
		}

		this.drawExitButton(cardToPlay);

		this.setVisible(true);
		this.setSize(GameConstants.GUICARDSIZE * availableCards.size(), GameConstants.GUICARDSIZE);
		this.pane.repaint();
		this.repaint();

		return cardToPlay;
	}

	public CompletableFuture<Boolean> promptYesNo(String messageKey, String name) {
		String message = GameConstants.messages.getString(messageKey);
		message = name + ": " + message;

		CompletableFuture<Boolean> response = new CompletableFuture<Boolean>();

		int ans = JOptionPane.showConfirmDialog(null, message, "", JOptionPane.YES_NO_OPTION);
		response.complete(ans == JOptionPane.YES_OPTION);

		return response;
	}

	public CompletableFuture<Card> chooseCardFromHand(List<Card> availableCards, String name) {
		this.clear();
		this.setVisible(true);
		CompletableFuture<Card> chosenCardFuture = new CompletableFuture<Card>();
		String title = GameConstants.messages.getString("chooseCardFromHand");
		title = name + ": " + title;
		this.setTitle(title);

		for (Card card : availableCards) {
			this.drawForcedCard(card, chosenCardFuture);
		}

		this.pane.repaint();
		this.repaint();

		return chosenCardFuture;
	}

	private void drawForcedCard(Card card, CompletableFuture<Card> future) {

		JButton box = new JButton();
		String text = this.makeText(card);
		box.setText(text);
		box.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				future.complete(card);
			}

		});
		this.pane.add(box, -1);// add at the end

	}

	public CompletableFuture<Optional<Card>> chooseCardToBuy(Set<Card> availableCards, String name) {
		// TODO Choose a card to buy from a list of cards or choose to stop
		// buying(return Optional.empty())
		this.clear();
		CompletableFuture<Optional<Card>> cardToBuy = new CompletableFuture<Optional<Card>>();

		String title = GameConstants.messages.getString("chooseCardToBuy");
		title = name + ": " + title;
		this.setTitle(title);

		for (Card card : availableCards) {
			this.drawCard(card, cardToBuy);
		}
		this.drawExitButton(cardToBuy);

		this.setSize(GameConstants.GUICARDSIZE * 3, GameConstants.GUICARDSIZE * 3);
		this.setVisible(true);
		this.pane.repaint();
		this.repaint();

		return cardToBuy;
	}

}
