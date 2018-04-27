import java.util.HashSet;
import java.util.Set;

public class Village extends Card {

	@Override
	public Set<CardType> getType() {
		Set<CardType> s = new HashSet<>();
		s.add(CardType.ACTION);
		return s;
	}

	@Override
	public int getCost() {
		return 3;
	}
	
	public int getActionsAdded() {
		return 2;
	}
	
	public int getCardsAdded() {
		return 1;
	}

}
