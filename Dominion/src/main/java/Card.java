import java.util.Set;

public abstract class Card {

	public abstract Set<CardType> getType();

	public int getCoinsAdded() {
		return GameConstants.DEFAULTCARDATTRIBUTE;
	}

	public int getActionsAdded() {
		return GameConstants.DEFAULTCARDATTRIBUTE;
	}

	public int getBuysAdded() {
		return GameConstants.DEFAULTCARDATTRIBUTE;
	}

	public int getCardsAdded() {
		return GameConstants.DEFAULTCARDATTRIBUTE;
	}

	public int getVictoryValue() {
		return GameConstants.DEFAULTCARDATTRIBUTE;
	}

	public abstract int getCost();

	public CardPlayState getPlayState() {
		return new CardPlayState();
	}

}
