
public abstract class Card {

	public abstract String getType();

	public abstract int getCoinsAdded();

	public int getActionsAdded() {
		return 0;
	}

	public int getBuysAdded() {
		return 0;
	}

	public int getCardsAdded() {
		return 0;
	}

	public abstract int getVictoryValue();
	
}
