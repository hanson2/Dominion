package cards;

import java.util.HashSet;
import java.util.Set;

import util.CardType;
import util.GameConstants;

public class Laboratory extends Card {

	@Override
	public Set<CardType> getType() {
		Set<CardType> set = new HashSet<>();
		set.add(CardType.ACTION);
		return set;
	}

	@Override
	public int getCost() {
		return GameConstants.LABORATORYCOST;
	}

	@Override
	public int getCardsAdded() {
		return GameConstants.LABORATORYCARDSADDED;
	}

	@Override
	public int getActionsAdded() {
		return GameConstants.LABORATORYACTIONSADDED;
	}

	@Override
	public String getName() {
		return GameConstants.LABORATORYNAME;
	}

}
