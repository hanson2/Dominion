package cards;

import java.util.Set;
import java.util.TreeSet;

import states.CardPlayState;
import states.MilitiaPlayState;
import util.CardType;
import util.GameConstants;

public class Militia extends Card {

	@Override
	public Set<CardType> getType() {
		Set<CardType> set = new TreeSet<CardType>();
		set.add(CardType.ACTION);
		set.add(CardType.ATTACK);
		return set;
	}

	@Override
	public int getCost() {
		return GameConstants.MILITIACOST;
	}

	@Override
	public String getName() {
		return GameConstants.MILITIANAME;
	}

	public int getCoinsAdded() {
		return GameConstants.MILITIACOINSADDED;
	}

	public String getText() {
		return GameConstants.MILITIATEXT;
	}

	public CardPlayState getPlayState() {
		return new MilitiaPlayState();
	}

}
