package cards;

import java.util.Set;
import java.util.TreeSet;

import states.CardPlayState;
import states.WorkshopPlayState;
import util.CardType;
import util.GameConstants;

public class Workshop extends Card {

	@Override
	public Set<CardType> getType() {
		TreeSet<CardType> ans = new TreeSet<CardType>();
		ans.add(CardType.ACTION);
		return ans;
	}

	@Override
	public int getCost() {
		return GameConstants.WORKSHOPCOST;
	}

	@Override
	public String getName() {
		return GameConstants.WORKSHOPNAME;
	}

	public String getText() {
		return GameConstants.WORKSHOPTEXT;
	}

	public CardPlayState getPlayState() {
		return new WorkshopPlayState();
	}
}
