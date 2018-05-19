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

	public static void main(String[] arg0){
		GUI gui = new GUI();
	}
	
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
		//StartButtonHandler startBH = new StartButtonHandler(this);
		startB.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0){ 
				pane.removeAll();
				init();
			}
		});

		BorderLayout layout = new BorderLayout();
		pane.setLayout(layout);

		pane.add(startB, layout.CENTER);
		//
		// Adds QuitButton
		pane.add(quitB, layout.PAGE_END);

		setSize(400, 300);
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
		two.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0){ 
				naming(2);
			}
		});
		JButton three = new JButton("3");
		three.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0){ 
				naming(3);
			}
		});
		JButton four = new JButton("4");
		four.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0){ 
				naming(4);
			}
		});

		pane.add(two);
		pane.add(three);
		pane.add(four);

		pane.repaint();
	}

	public void naming(int players){
		pane.removeAll();
		GridLayout layout = new GridLayout(players+1,0);
		pane.setLayout(layout);
		setTitle("Players' Names");
		
		JTextField p1 = new JTextField("Player name"),p2 = new JTextField("Player name"),p3 = new JTextField("Player name"),p4 = new JTextField("Player name"); 
		String[] names = new String[players];
		
		pane.add(p1, layout);
		pane.add(p2, layout);
		if(players>2){
		pane.add(p3, layout);
		}
		if(players>3){
		pane.add(p4, layout);
		}
		
		JButton next = new JButton("DONE");
		next.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				names[0] = p1.getText();
				names[1] = p2.getText();
				if(players>2);
				names[2] = p3.getText();
				if(players>3);
				names[3] = p4.getText();
				retNames(names);
			}
			
		});
		pane.add(next, layout);
		
		pane.validate();
		pane.repaint();
	}
	
	public String[] retNames(String[] names){
		return names;
	}
	
	public void game(int players) {
		pane.removeAll();
		setTitle("DOMINION W/ " + players + " PLAYERS");
		setSize(500, 500);
		setVisible(true);

		SpringLayout Spring = new SpringLayout();
		pane.setLayout(Spring);

		JButton endTurnB = new JButton("End Turn");
		EndTurnButtonHandler endTurnBH = new EndTurnButtonHandler();
		endTurnB.addActionListener(endTurnBH);
		
		// Adds QuitButton
		pane.add(quitB);
		Spring.putConstraint(SpringLayout.NORTH, quitB, 0, SpringLayout.NORTH, pane);
		Spring.putConstraint(SpringLayout.EAST, quitB, 0, SpringLayout.EAST, pane);

		pane.repaint();
	}
	
	private void addTurns(){
		pane.add(endTurnB);
		Spring.putConstraint(SpringLayout.SOUTH, endTurnB, 0, SpringLayout.SOUTH, pane);
		Spring.putConstraint(SpringLayout.NORTH, endTurnB, 400, SpringLayout.NORTH, pane);
		Spring.putConstraint(SpringLayout.WEST, endTurnB, 210, SpringLayout.WEST, pane);
	}
	

}
