import java.util.Set;
import java.util.HashSet;

public class Silver extends Card {

	@Override
	public int getCoinsAdded() {
		return 2;
	}

	@Override
	public int getCost() {
		return 3;
	}

	@Override
	public Set<CardType> getType() {
		Set<CardType> toReturn = new HashSet<CardType>();
		toReturn.add(CardType.TREASURE);
		return toReturn;
	}

}
