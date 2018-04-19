import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Graphical User Interface implementation for the 
 * game Dominion.
 * 
 * @author bakerne
 */
public class GUI extends JFrame{
//	private JLabel lengthLabel,widthLabel,areaLabel;
//	private JTextField lengthText,widthText,areaText;
//	private JButton calculateButton,exitButton;
	private Container pane;
	JButton quitB;
	
	public GUI(){
		setTitle("DOMINION");
		pane = getContentPane();
		
		quitB = new JButton("QUIT");
		QuitButtonHandler quitBH = new QuitButtonHandler();
		quitB.addActionListener(quitBH);
		
		start();
	}
	
	private class StartButtonHandler implements ActionListener
	{
		GUI gui;
		public StartButtonHandler(GUI g){
			gui = g;
		}
		public void actionPerformed(ActionEvent e){
			pane.removeAll();
			gui.init();
		}	
	}
	
	private class QuitButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e){
			System.exit(0);
		}	
	}
	
	private class EndTurnButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e){
			
		}	
	}
	
	private class InitButtonHandler implements ActionListener
	{
		GUI gui;
		int num;
		public InitButtonHandler(GUI g,int p){
			gui = g;
			num = p;
		}
		public void actionPerformed(ActionEvent e){
			pane.removeAll();
			gui.game(num);
		}	
	}
	
	
	public void start(){
		JButton startB = new JButton("START THE GAME OF DOMINION");
		StartButtonHandler startBH = new StartButtonHandler(this);
		startB.addActionListener(startBH);
		
		BorderLayout layout = new BorderLayout();
		pane.setLayout(layout);
		
		//Adds StartButton
		pane.add(startB,layout.CENTER);
//		
		//Adds QuitButton
		pane.add(quitB,layout.PAGE_END);
		
		setSize(300,200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void init(){
		setTitle("# OF PLAYERS?");
		setSize(300,300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		pane.setLayout(new GridLayout(0,3));
		
		JButton two = new JButton("2");
		two.addActionListener(new InitButtonHandler(this,2));
		JButton three = new JButton("3");
		three.addActionListener(new InitButtonHandler(this,3));
		JButton four = new JButton("4");
		four.addActionListener(new InitButtonHandler(this,4));
		
		pane.add(two);
		pane.add(three);
		pane.add(four);
		
		pane.repaint();
	}
	
	public void game(int players){
		setTitle("DOMINION W/ " + players + " PLAYERS");
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		SpringLayout Spring = new SpringLayout();
		pane.setLayout(Spring);
		
		JButton endTurnB = new JButton("End Turn");
		EndTurnButtonHandler endTurnBH = new EndTurnButtonHandler();
		endTurnB.addActionListener(endTurnBH);
		
		//Adds TurnButton
		pane.add(endTurnB);
		Spring.putConstraint(SpringLayout.SOUTH, endTurnB,
				0, SpringLayout.SOUTH, pane);
		Spring.putConstraint(SpringLayout.NORTH, endTurnB,
				400, SpringLayout.NORTH, pane);
		Spring.putConstraint(SpringLayout.WEST, endTurnB,
				210, SpringLayout.WEST, pane);
		
		//Adds QuitButton
		pane.add(quitB);
		Spring.putConstraint(SpringLayout.NORTH, quitB,
				0, SpringLayout.NORTH, pane);
		Spring.putConstraint(SpringLayout.EAST, quitB,
				0, SpringLayout.EAST, pane);
		
		pane.repaint();
	}
	
	public static void main(String[] args){
		GUI gui = new GUI();
	}
}
