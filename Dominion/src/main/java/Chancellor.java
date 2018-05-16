import java.util.HashSet;
import java.util.Set;

public class Chancellor extends Card {

	@Override
	public Set<CardType> getType() {
		HashSet<CardType> toReturn = new HashSet<CardType>();
		toReturn.add(CardType.ACTION);
		return toReturn;
	}

	@Override
	public int getCost() {
		return GameConstants.CHANCELLORCOST;
	}
	
	@Override
	public int getCoinsAdded() {
		return GameConstants.CHANCELLORCOINSADDED;
	}
	
	@Override
	public CardPlayState getPlayState() {
		return new ChancellorPlayState();
	}

}
