
public class Player {

	private int points;// replace with a tallying function eventually
	private String name;

	public Player(String name) {
		this.points = 0;
		this.name = name;
	}

	public boolean drawACard() {
		return false;
		// TODO Auto-generated method stub
	}

	public boolean discardHand() {
		return false;
		// TODO Auto-generated method stub
	}

	public String playCard() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean buy() {
		// TODO Auto-generated method stub
		return false;
	}

	public int getPoints() {
		return points;
	}

	public String getName() {
		return name;
	}

}
