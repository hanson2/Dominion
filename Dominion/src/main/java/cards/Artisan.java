package cards;

import java.util.Set;
import java.util.TreeSet;

import states.ArtisanPlayState;
import states.CardPlayState;
import util.CardType;
import util.GameConstants;

public class Artisan extends Card {

	@Override
	public Set<CardType> getType() {
		TreeSet<CardType> ans = new TreeSet<CardType>();
		ans.add(CardType.ACTION);
		return ans;
	}

	@Override
	public int getCost() {
		return GameConstants.ARTISANCOST;
	}

	@Override
	public String getName() {
		return GameConstants.ARTISANNAME;
	}

	public String getText() {
		return GameConstants.ARTISANTEXT;
	}

	public CardPlayState getPlayState() {
		return new ArtisanPlayState();
	}

}
