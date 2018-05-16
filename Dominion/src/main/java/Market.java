import java.util.HashSet;
import java.util.Set;

public class Market extends Card {

	@Override
	public Set<CardType> getType() {
		Set<CardType> toReturn = new HashSet<CardType>();
		toReturn.add(CardType.ACTION);
		return toReturn;
	}

	@Override
	public int getCost() {
		return GameConstants.MARKETCOST;
	}

	@Override
	public int getCoinsAdded() {
		return GameConstants.MARKETCOINSADDED;
	}

	@Override
	public int getActionsAdded() {
		return GameConstants.MARKETACTIONSADDED;
	}

	@Override
	public int getBuysAdded() {
		return GameConstants.MARKETBUYSADDED;
	}

	@Override
	public int getCardsAdded() {
		return GameConstants.MARKETCARDSADDED;
	}
}
