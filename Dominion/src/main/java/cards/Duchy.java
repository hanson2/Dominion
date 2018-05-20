package cards;

import java.util.HashSet;
import java.util.Set;

import util.CardType;
import util.GameConstants;

public class Duchy extends Card {

	@Override
	public int getVictoryValue() {
		return GameConstants.DUCHYVICTORYVALUE;
	}

	@Override
	public int getCost() {
		return GameConstants.DUCHYCOST;
	}

	@Override
	public Set<CardType> getType() {
		Set<CardType> toReturn = new HashSet<CardType>();
		toReturn.add(CardType.VICTORY);
		return toReturn;
	}

	@Override
	public String getName() {
		return GameConstants.DUCHYNAME;
	}

}
