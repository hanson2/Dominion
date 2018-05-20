package cards;

import java.util.HashSet;
import java.util.Set;

import states.CardPlayState;
import states.ThroneRoomPlayState;
import util.CardType;
import util.GameConstants;

public class ThroneRoom extends Card {

	@Override
	public Set<CardType> getType() {
		HashSet<CardType> toReturn = new HashSet<CardType>();
		toReturn.add(CardType.ACTION);
		return toReturn;
	}

	@Override
	public int getCost() {
		return GameConstants.THRONEROOMCOST;
	}

	@Override
	public CardPlayState getPlayState() {
		return new ThroneRoomPlayState();
	}

	@Override
	public String getName() {
		return GameConstants.THRONEROOMNAME;
	}

	@Override
	public String getText() {
		return GameConstants.THRONEROOMTEXT;
	}

}
