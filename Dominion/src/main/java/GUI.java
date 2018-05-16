import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Graphical User Interface implementation for the game Dominion.
 * 
 * @author bakerne, hanson2
 */

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

		start();
	}

	private class QuitButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			System.exit(DISPOSE_ON_CLOSE);
		}

	}

	public Card displayCards(List supply, String message, String name) {
		return null;
		// TODO: have it draw each card and return a completable future card to
		// the player
	}

	private void drawCard(Card card, Point point) {
		// TODO: draw a card with the top right corner as the point
	}

	public void start() {
		JButton startB = new JButton("START THE GAME OF DOMINION");
		StartButtonHandler startBH = new StartButtonHandler(this);
		startB.addActionListener(startBH);

		BorderLayout layout = new BorderLayout();
		pane.setLayout(layout);

		pane.add(startB, layout.CENTER);
		//
		// Adds QuitButton
		pane.add(quitB, layout.PAGE_END);

		setSize(300, 200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
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

}
