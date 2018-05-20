import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SpringLayout;

@SuppressWarnings("serial")
public class GUI extends JFrame {
	private Container pane;
	JButton quitB;

	public GUI() {
		setTitle(GameConstants.messages.getString("guiDominionTitle"));
		pane = getContentPane();

		quitB = new JButton(GameConstants.messages.getString("guiQuit"));
		QuitButtonHandler quitBH = new QuitButtonHandler();
		quitB.addActionListener(quitBH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pane.add(quitB);
	}

	private class QuitButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.exit(DISPOSE_ON_CLOSE);
		}

	}

	public CompletableFuture<Card> displayCards(ArrayList<Card> supply, String message, String name) {
		this.setTitle(message);
		CompletableFuture<Card> ans = new CompletableFuture<Card>();
		int supplySize = supply.size();

		for (int i = 0; i < supplySize; i++) {
			drawCard(supply.get(i), ans);
		}
		drawExitButton(ans);
		return ans;
	}

	private void drawExitButton(CompletableFuture<Card> future) {
		JButton end = new JButton();
		end.setText(GameConstants.messages.getString("guiEndPhase"));
		end.addActionListener(new EndTurnListener(future));

	}

	private void drawCard(Card card, CompletableFuture<Card> future) {
		JButton box = new JButton();
		String text = this.makeText(card);
		box.setText(text);
		box.addActionListener(new CardListener(future, card));
		this.pane.add(box, -1);// add at the end
	}

	private class EndTurnListener implements ActionListener {
		CompletableFuture<Card> future;

		public EndTurnListener(CompletableFuture<Card> future) {
			this.future = future;
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			future.cancel(true);

		}

	}

	private class CardListener implements ActionListener {
		CompletableFuture<Card> future;
		Card card;

		public CardListener(CompletableFuture<Card> future, Card card) {
			this.future = future;
			this.card = card;
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			this.future.complete(card);
		}

	}

	private String makeText(Card card) {
		StringBuilder cardText = new StringBuilder();
		if (card.getCost() != 0) {
			cardText.append(String.format(GameConstants.messages.getString("guiCardCost"), card.getCost()));
			cardText.append(System.lineSeparator());
		}
		if (card.getActionsAdded() != 0) {
			cardText.append(String.format(GameConstants.messages.getString("guiCardActions"), card.getActionsAdded()));
			cardText.append(System.lineSeparator());
		}
		if (card.getBuysAdded() != 0) {
			cardText.append(String.format(GameConstants.messages.getString("guiCardBuys"), card.getBuysAdded()));
			cardText.append(System.lineSeparator());
		}
		if (card.getCardsAdded() != 0) {
			cardText.append(String.format(GameConstants.messages.getString("guiCardCards"), card.getCardsAdded()));
			cardText.append(System.lineSeparator());
		}
		if (card.getCoinsAdded() != 0) {
			cardText.append(String.format(GameConstants.messages.getString("guiCardCoins"), card.getCoinsAdded()));
			cardText.append(System.lineSeparator());
		}
		if (card.getVictoryValue() != 0) {
			cardText.append(
					String.format(GameConstants.messages.getString("guiCardVictoryPoints"), card.getVictoryValue()));
			cardText.append(System.lineSeparator());
		}
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
		this.setSize(300, 300);
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

		pane.repaint();

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
		this.setTitle(GameConstants.messages.getString("guiNumPlayersTitle"));
		this.setSize(300, 300);
		this.setVisible(true);
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

		pane.repaint();

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
		this.setVisible(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		CompletableFuture<String> playerXNameFuture = new CompletableFuture<>();

		String textPrompt = String.format(GameConstants.messages.getString("guiPlayerNamePrompt"), number);
		playerXNameFuture.complete((String) JOptionPane.showInputDialog(null, textPrompt));

		return playerXNameFuture;
	}

	public void game(int numPlayers) {
		String title = String.format(GameConstants.messages.getString("guiGameTitle"), numPlayers);
		setTitle(title);
		setSize(500, 500);
		setVisible(true);

		SpringLayout Spring = new SpringLayout();
		pane.setLayout(Spring);

		JButton endTurnB = new JButton("End Turn");
		EndTurnButtonHandler endTurnBH = new EndTurnButtonHandler();
		endTurnB.addActionListener(endTurnBH);

		// Adds TurnButton
		pane.add(endTurnB);
		Spring.putConstraint(SpringLayout.SOUTH, endTurnB, 0, SpringLayout.SOUTH, pane);
		Spring.putConstraint(SpringLayout.NORTH, endTurnB, 400, SpringLayout.NORTH, pane);
		Spring.putConstraint(SpringLayout.WEST, endTurnB, 210, SpringLayout.WEST, pane);

		// Adds QuitButton
		pane.add(quitB);
		Spring.putConstraint(SpringLayout.NORTH, quitB, 0, SpringLayout.NORTH, pane);
		Spring.putConstraint(SpringLayout.EAST, quitB, 0, SpringLayout.EAST, pane);

		pane.repaint();
	}

	private class EndTurnButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}

	}

	public CompletableFuture<Boolean> getPlayAgainDisplayWinners(Set<Player> winners) {
		// TODO make this display winners and give players option to play again
		CompletableFuture<Boolean> playAgain = new CompletableFuture<Boolean>();

		playAgain.complete(false);

		return playAgain;
	}

	public void quitGame() {
		System.exit(DISPOSE_ON_CLOSE);
	}

	public CompletableFuture<Optional<Card>> chooseCardToPlay(List<Card> availableCards) {
		// TODO make this display player's hand and allow the player to choose
		// one to play
		CompletableFuture<Optional<Card>> cardToPlay = new CompletableFuture<Optional<Card>>();

		cardToPlay.complete(Optional.empty());

		return cardToPlay;
	}

	public CompletableFuture<Boolean> promptYesNo(String messageKey) {
		// TODO create a yes/no box(i18n yes no) with the message provided;
		String message = GameConstants.messages.getString(messageKey);
		CompletableFuture<Boolean> response = new CompletableFuture<Boolean>();

		response.complete(false);

		return response;
	}

	public CompletableFuture<Card> chooseCardFromHand(List<Card> availableCards) {
		// TODO Prompt the player to choose a card from their hand(notice they must
		// choose)
		CompletableFuture<Card> chosenCardFuture = new CompletableFuture<Card>();

		chosenCardFuture.complete(new Copper());

		return chosenCardFuture;
	}

	public CompletableFuture<Optional<Card>> chooseCardToBuy(Set<Card> availableCards) {
		// TODO Choose a card to buy from a list of cards or choose to stop
		// buying(return Optional.empty())
		CompletableFuture<Optional<Card>> cardToBuy = new CompletableFuture<Optional<Card>>();

		cardToBuy.complete(Optional.empty());

		return cardToBuy;
	}

}
