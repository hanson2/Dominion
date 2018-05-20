package cards;

import java.util.HashSet;
import java.util.Set;

import states.CardPlayState;
import states.ChapelPlayState;
import util.CardType;
import util.GameConstants;

public class Chapel extends Card {

	@Override
	public Set<CardType> getType() {
		HashSet<CardType> toReturn = new HashSet<CardType>();
		toReturn.add(CardType.ACTION);
		return toReturn;
	}

	@Override
	public int getCost() {
		return GameConstants.CHAPELCOST;
	}
	
	@Override
	public CardPlayState getPlayState(){
		return new ChapelPlayState();
	}

	@Override
	public String getName() {
		return GameConstants.CHAPELNAME;
	}
	
	@Override
	public String getText() {
		return GameConstants.CHAPELTEXT;
	}

}
