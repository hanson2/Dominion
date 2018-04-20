import java.util.Set;

public abstract class Card {

	public abstract Set<CardType> getType();

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

	public CardPlayState getPlayState() {
		return new CardPlayState();
	}

}
