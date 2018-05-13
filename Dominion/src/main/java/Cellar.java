import java.util.HashSet;
import java.util.Set;

public class Cellar extends Card {

	@Override
	public Set<CardType> getType() {
		HashSet<CardType> toReturn = new HashSet<CardType>();
		toReturn.add(CardType.ACTION);
		return toReturn;
	}

	@Override
	public int getCost() {
		return 2;
	}
	
	@Override
	public int getActionsAdded() {
		return 1;
	}
	
	@Override
	public CardPlayState getPlayState() {
		return new CellarPlayState();
	}

}
