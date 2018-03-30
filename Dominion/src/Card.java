
public abstract class Card {

	public abstract String getType();

	public int getCoinsAdded() {
		return 0;
	}

	public int getActionsAdded() {
		return 0;
	}

	public int getBuysAdded() {
		return 0;
	}

	public int getCardsAdded() {
		return 0;
	}

	public int getVictoryValue() {
		return 0;
	}

	public abstract int getCost();

}
