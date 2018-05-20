package cards;

import java.util.HashSet;
import java.util.Set;

import util.CardType;
import util.GameConstants;

public class Moat extends Card {

	@Override
	public Set<CardType> getType() {
		HashSet<CardType> toReturn = new HashSet<CardType>();
		toReturn.add(CardType.ACTION);
		toReturn.add(CardType.REACTION);
		return toReturn;
	}

	@Override
	public int getCost() {
		return GameConstants.MOATCOST;
	}

	@Override
	public int getCardsAdded() {
		return GameConstants.MOATCARDSADDED;
	}

	@Override
	public String getName() {
		return GameConstants.MOATNAME;
	}

	@Override
	public String getText() {
		return GameConstants.MOATTEXT;
	}

}
