
public class Player {

	private int points;// replace with a tallying function eventually
	private String name;

	public Player(String name) {
		this.points = 0;
		this.name = name;
	}

	public int getPoints() {
		return points;
	}

	public String getName() {
		return name;
	}

}
