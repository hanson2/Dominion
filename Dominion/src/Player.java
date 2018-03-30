
public class Player {

	private int points;// replace with a tallying function eventually
	private String name;
	private int sizeOfDrawPile;
	private int sizeOfHand;
	private int sizeOfDiscardPile;

	public Player(String name) {
		this.sizeOfDrawPile = 10;
		this.sizeOfHand = 0;
		this.sizeOfDiscardPile = 0;
		this.points = 0;
		this.name = name;
	}

	public void drawACard() {
		if(this.sizeOfDrawPile > 0){
			this.sizeOfDrawPile--;
			this.sizeOfHand++;			
		}
	}

	public void discardHand() {
		while(this.sizeOfHand > 0){
			this.sizeOfDiscardPile++;
			this.sizeOfHand--;
		}
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

	public int sizeOfDrawPile() {
		return this.sizeOfDrawPile;
	}

	public int sizeOfHand() {
		return this.sizeOfHand;
	}

	public int sizeOfDiscardPile() {
		return this.sizeOfDiscardPile;
	}

}
