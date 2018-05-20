package cards;

import java.util.HashSet;
import java.util.Set;

import states.CardPlayState;
import states.CellarPlayState;
import util.CardType;
import util.GameConstants;

public class Cellar extends Card {

	@Override
	public Set<CardType> getType() {
		HashSet<CardType> toReturn = new HashSet<CardType>();
		toReturn.add(CardType.ACTION);
		return toReturn;
	}

	@Override
	public int getCost() {
		return GameConstants.CELLARCOST;
	}
	
	@Override
	public int getActionsAdded() {
		return GameConstants.CELLARACTIONSADDED;
	}
	
	@Override
	public CardPlayState getPlayState() {
		return new CellarPlayState();
	}

	@Override
	public String getName() {
		return GameConstants.CELLARNAME;
	}
	
	@Override
	public String getText() {
		return GameConstants.CELLARTEXT;
	}
	
}
