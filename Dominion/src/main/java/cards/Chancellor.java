package cards;

import java.util.HashSet;
import java.util.Set;

import states.CardPlayState;
import states.ChancellorPlayState;
import util.CardType;
import util.GameConstants;

public class Chancellor extends Card {

	@Override
	public Set<CardType> getType() {
		HashSet<CardType> toReturn = new HashSet<CardType>();
		toReturn.add(CardType.ACTION);
		return toReturn;
	}

	@Override
	public int getCost() {
		return GameConstants.CHANCELLORCOST;
	}
	
	@Override
	public int getCoinsAdded() {
		return GameConstants.CHANCELLORCOINSADDED;
	}
	
	@Override
	public CardPlayState getPlayState() {
		return new ChancellorPlayState();
	}

	@Override
	public String getName() {
		return GameConstants.CHANCELLORNAME;
	}
	
	@Override
	public String getText() {
		return GameConstants.CHANCELLORTEXT;
	}

}
