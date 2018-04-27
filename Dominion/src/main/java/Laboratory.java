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
		return 5;
	}
	
	@Override
	public int getCardsAdded() {
		return 2;
	}
	
	@Override
	public int getActionsAdded() {
		return 1;
	}

}
