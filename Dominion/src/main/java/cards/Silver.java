package cards;

import java.util.HashSet;
import java.util.Set;

import util.CardType;
import util.GameConstants;

public class Silver extends Card {

	@Override
	public int getCoinsAdded() {
		return GameConstants.SILVERCOINSADDED;
	}

	@Override
	public int getCost() {
		return GameConstants.SILVERCOST;
	}

	@Override
	public Set<CardType> getType() {
		Set<CardType> toReturn = new HashSet<CardType>();
		toReturn.add(CardType.TREASURE);
		return toReturn;
	}

	@Override
	public String getName() {
		return GameConstants.SILVERNAME;
	}

}
