package cards;

import java.util.HashSet;
import java.util.Set;

import util.CardType;
import util.GameConstants;

public class Village extends Card {

	@Override
	public Set<CardType> getType() {
		Set<CardType> s = new HashSet<>();
		s.add(CardType.ACTION);
		return s;
	}

	@Override
	public int getCost() {
		return GameConstants.VILLAGECOST;
	}

	public int getActionsAdded() {
		return GameConstants.VILLAGEACTIONSADDED;
	}

	public int getCardsAdded() {
		return GameConstants.VILLAGECARDSADDED;
	}

	@Override
	public String getName() {
		return GameConstants.VILLAGENAME;
	}

}
