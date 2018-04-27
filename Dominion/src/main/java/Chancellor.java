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
		return 3;
	}
	
	@Override
	public int getCoinsAdded() {
		return 2;
	}
	
	@Override
	public CardPlayState getPlayState() {
		return new ChancellorPlayState();
	}

}
