import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

@SuppressWarnings("serial")
public class GUI extends JFrame {
	private Container pane;
	JButton quitB;

	public GUI() {
		setTitle("DOMINION");
		pane = getContentPane();

		quitB = new JButton("QUIT");
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
		end.setText("Do Nothing");
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
		@SuppressWarnings("rawtypes")
		CompletableFuture future;
		Card card;

		public CardListener(CompletableFuture<Card> future, Card card) {
			this.future = future;
			this.card = card;
		}

		@SuppressWarnings("unchecked")
		@Override
		public void actionPerformed(ActionEvent arg0) {
			this.future.complete(card);
		}

	}

	private String makeText(Card card) {
		String ans = "";
		if (card.getCost() != 0) {
			ans = "Cost = " + card.getCost() + '\n';
		}
		if (card.getActionsAdded() != 0) {
			ans = "Actions +" + card.getActionsAdded() + '\n';
		}
		if (card.getBuysAdded() != 0) {
			ans = "Buys +" + card.getBuysAdded() + '\n';
		}
		if (card.getCardsAdded() != 0) {
			ans = "Draw +" + card.getCardsAdded() + '\n';
		}
		if (card.getCoinsAdded() != 0) {
			ans = "Coins +" + card.getCoinsAdded() + '\n';
		}
		if (card.getVictoryValue() != 0) {
			ans = "Victory Points = " + card.getVictoryValue() + '\n';
		}
		return ans;
	}

	public void start() {
		JButton startB = new JButton("START THE GAME OF DOMINION");
		StartButtonHandler startBH = new StartButtonHandler(this);
		startB.addActionListener(startBH);

		BorderLayout layout = new BorderLayout();
		pane.setLayout(layout);

		pane.add(startB, BorderLayout.CENTER);
		//
		// Adds QuitButton
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
			this.gui.init();

		}

	}

	public void init() {
		setTitle("# OF PLAYERS?");
		setSize(300, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		pane.setLayout(new GridLayout(0, 3));

		JButton two = new JButton("2");
		two.addActionListener(new InitButtonHandler(this, 2));
		JButton three = new JButton("3");
		three.addActionListener(new InitButtonHandler(this, 3));
		JButton four = new JButton("4");
		four.addActionListener(new InitButtonHandler(this, 4));

		pane.add(two);
		pane.add(three);
		pane.add(four);

		pane.repaint();
	}

	private class InitButtonHandler implements ActionListener {

		GUI gui;
		int numPlayers;

		InitButtonHandler(GUI gui, int numPlayers) {
			this.gui = gui;
			this.numPlayers = numPlayers;
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub

		}

	}

	public void game(int players) {
		setTitle("DOMINION W/ " + players + " PLAYERS");
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

}
