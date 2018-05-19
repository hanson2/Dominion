import java.util.HashSet;
import java.util.Set;

public class Laboratory extends Card {

	@Override
	public Set<CardType> getType() {
		Set<CardType> set = new HashSet<>();
		set.add(CardType.ACTION);
		return set;
	}

	@Override
	public int getCost() {
		return GameConstants.LABORATORYCOST;
	}
	
	@Override
	public int getCardsAdded() {
		return GameConstants.LABORATORYCARDSADDED;
	}
	
	@Override
	public int getActionsAdded() {
		return GameConstants.LABORATORYACTIONSADDED;
	}

}
