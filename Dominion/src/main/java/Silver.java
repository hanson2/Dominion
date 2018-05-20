import java.util.Set;
import java.util.HashSet;

public class Silver extends Card {

	@Override
	public int getCoinsAdded() {
		return GameConstants.SILVERCOINSADDED;
	}

	@Override
	public int getCost() {
		return GameConstants.SILVERCOST;
	}

	@Override
	public Set<CardType> getType() {
		Set<CardType> toReturn = new HashSet<CardType>();
		toReturn.add(CardType.TREASURE);
		return toReturn;
	}

	@Override
	public String getName() {
		return GameConstants.SILVERNAME;
	}

}
