package cards;

import java.util.Set;
import java.util.TreeSet;

import states.CardPlayState;
import states.RemodelPlayState;
import util.CardType;
import util.GameConstants;

public class Remodel extends Card {

	@Override
	public Set<CardType> getType() {
		TreeSet<CardType> ans = new TreeSet<CardType>();
		ans.add(CardType.ACTION);
		return ans;
	}

	@Override
	public int getCost() {
		return GameConstants.REMODELCOST;
	}

	@Override
	public CardPlayState getPlayState() {
		return new RemodelPlayState();
	}

	@Override
	public String getName() {
		return GameConstants.REMODELNAME;
	}

	@Override
	public String getText() {
		return GameConstants.REMODELTEXT;
	}

}
