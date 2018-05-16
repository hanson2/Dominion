import java.util.Set;
import java.util.HashSet;

public class Gold extends Card {

	@Override
	public int getCoinsAdded() {
		return GameConstants.GOLDCOINSADDED;
	}

	@Override
	public int getCost() {
		return GameConstants.GOLDCOST;
	}

	@Override
	public Set<CardType> getType() {
		Set<CardType> toReturn = new HashSet<CardType>();
		toReturn.add(CardType.TREASURE);
		return toReturn;
	}

}
