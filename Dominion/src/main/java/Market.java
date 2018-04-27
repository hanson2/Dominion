import java.util.HashSet;
import java.util.Set;

public class Market extends Card {

	@Override
	public Set<CardType> getType() {
		Set<CardType> toReturn = new HashSet<CardType>();
		toReturn.add(CardType.ACTION);
		return toReturn;
	}

	@Override
	public int getCost() {
		return 5;
	}

	@Override
	public int getCoinsAdded() {
		return 1;
	}

	@Override
	public int getActionsAdded() {
		return 1;
	}

	@Override
	public int getBuysAdded() {
		return 1;
	}

	@Override
	public int getCardsAdded() {
		return 1;
	}
}
