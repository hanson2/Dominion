package cards;

import java.util.HashSet;
import java.util.Set;

import states.CardPlayState;
import states.VassalPlayState;
import util.CardType;
import util.GameConstants;

public class Vassal extends Card {

	@Override
	public Set<CardType> getType() {
		HashSet<CardType> toReturn = new HashSet<CardType>();
		toReturn.add(CardType.ACTION);
		return toReturn;
	}

	@Override
	public int getCost() {
		return GameConstants.VASSALCOST;
	}

	@Override
	public int getCoinsAdded() {
		return GameConstants.VASSALCOINSADDED;
	}

	@Override
	public CardPlayState getPlayState() {
		return new VassalPlayState();
	}

	@Override
	public String getName() {
		return GameConstants.VASSALNAME;
	}

	@Override
	public String getText() {
		return GameConstants.VASSALTEXT;
	}

}
