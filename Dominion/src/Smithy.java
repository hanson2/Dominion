import java.util.HashSet;
import java.util.Set;

public class Smithy extends Card {

	@Override
	public Set<CardType> getType() {
		Set<CardType> toReturn = new HashSet<CardType>();
		toReturn.add(CardType.ACTION);
		return toReturn;
	}

	@Override
	public int getCost() {
		return 4;
	}

	@Override
	public int getCardsAdded() {
		return 3;
	}

}
