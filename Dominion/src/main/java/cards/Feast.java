package cards;

import java.util.HashSet;
import java.util.Set;

import states.CardPlayState;
import states.FeastPlayState;
import util.CardType;
import util.GameConstants;

public class Feast extends Card {

	@Override
	public Set<CardType> getType() {
		Set<CardType> toReturn = new HashSet<CardType>();
		toReturn.add(CardType.ACTION);
		return toReturn;
	}

	@Override
	public int getCost() {
		return 4;
	}

	@Override
	public String getName() {
		return GameConstants.FEASTNAME;
	}

	@Override
	public String getText() {
		return GameConstants.FEASTTEXT;
	}

	@Override
	public CardPlayState getPlayState() {
		return new FeastPlayState();
	}

}
