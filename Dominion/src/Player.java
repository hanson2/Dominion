import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Stack;

public class Player {

	private String name;
	private List<Card> hand;
	private Stack<Card> drawPile;
	private Stack<Card> discardPile;

	public Player(String name) {
		this.hand = new ArrayList<Card>();
		this.drawPile = new Stack<Card>();
		this.discardPile = new Stack<Card>();
		this.addStarterCards();
		this.name = name;
	}

	public void drawACard() {
		if (this.drawPile.size() > 0) {
			this.hand.add(this.drawPile.pop());
		} else if (this.discardPile.size() > 0) {
			this.drawPile.addAll(this.discardPile);
			this.discardPile.clear();
			this.drawACard();
		}
	}

	public void drawNewHand() {
		for (int i = 0; i < 5; i++) {
			this.drawACard();
		}
	}

	public void discardHand() {
		this.discardPile.addAll(this.hand);
		this.hand.clear();
	}

	public Card playCard() {
		return null;
	}

	public boolean buy() {
		return false;
	}

	public int getPoints() {
		int totalPoints = this.addPointsFromPile(this.drawPile);
		totalPoints += this.addPointsFromPile(this.hand);
		totalPoints += this.addPointsFromPile(this.discardPile);
		return totalPoints;
	}

	public String getName() {
		return name;
	}

	public int sizeOfDrawPile() {
		return this.drawPile.size();
	}

	public int sizeOfHand() {
		return this.hand.size();
	}

	public int sizeOfDiscardPile() {
		return this.discardPile.size();
	}

	public List<Card> getHand() {
		return this.hand;
	}

	public void gainCard(Card card) {
		this.discardPile.push(card);
	}

	private void addStarterCards() {
		for (int i = 0; i < 7; i++) {
			// TODO Change Supply to include less of the starter cards based on
			// num players
			this.drawPile.push(new Copper());
		}
		for (int i = 0; i < 3; i++) {
			this.drawPile.push(new Estate());
		}
	}

	private int addPointsFromPile(Collection<Card> cards) {
		int totalPoints = 0;
		for (Card card : cards) {
			totalPoints += card.getVictoryValue();
		}
		return totalPoints;
	}
}
