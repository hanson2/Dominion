import java.util.HashSet;
import java.util.Set;

public class Moat extends Card {

	@Override
	public Set<CardType> getType() {
		HashSet<CardType> toReturn = new HashSet<CardType>();
		toReturn.add(CardType.ACTION);
		toReturn.add(CardType.REACTION);
		return toReturn;
	}

	@Override
	public int getCost() {
		return 2;
	}
	
	@Override
	public int getCardsAdded() {
		return 2;
	}

}
