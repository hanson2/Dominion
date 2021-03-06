package cards;

import java.util.HashSet;
import java.util.Set;

import util.CardType;
import util.GameConstants;

public class Woodcutter extends Card {

	@Override
	public Set<CardType> getType() {
		Set<CardType> toReturn = new HashSet<CardType>();
		toReturn.add(CardType.ACTION);
		return toReturn;
	}

	@Override
	public int getCost() {
		return GameConstants.WOODCUTTERCOST;
	}

	@Override
	public int getCoinsAdded() {
		return GameConstants.WOODCUTTERCOINSADDED;
	}

	@Override
	public int getBuysAdded() {
		return GameConstants.WOODCUTTERBUYSADDED;
	}

	@Override
	public String getName() {
		return GameConstants.WOODCUTTERNAME;
	}
}
