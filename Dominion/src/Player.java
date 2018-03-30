
public class Player {

	private int points;// replace with a tallying function eventually
	private String name;

	public Player(String name) {
		this.points = 0;
		this.name = name;
	}

	public void drawACard() {
		
	}

	public void discardHand() {
		
	}

	public Card playCard() {
		return null;
	}

	public boolean buy() {
		return false;
	}

	public int getPoints() {
		return points;
	}

	public String getName() {
		return name;
	}

}
