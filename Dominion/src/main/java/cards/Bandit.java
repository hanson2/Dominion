package cards;

import java.util.Set;
import java.util.TreeSet;

import states.BanditPlayState;
import util.CardType;
import util.GameConstants;

public class Bandit extends Card {

	@Override
	public Set<CardType> getType() {
		Set<CardType> types = new TreeSet<CardType>();
		types.add(CardType.ACTION);
		types.add(CardType.ATTACK);
		return types;
	}

	@Override
	public int getCost() {
		return GameConstants.BANDITCOST;
	}

	@Override
	public String getName() {
		return GameConstants.BANDITNAME;
	}

	public String getText() {
		return GameConstants.BANDITTEXT;
	}

	public BanditPlayState getPlayState() {
		return new BanditPlayState();
	}

}
