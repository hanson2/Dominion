package cards;

import java.util.HashSet;
import java.util.Set;

import util.CardType;
import util.GameConstants;

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

	@Override
	public String getName() {
		return GameConstants.MARKETNAME;
	}
}
