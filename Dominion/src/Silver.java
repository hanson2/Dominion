import java.util.Set;
import java.util.TreeSet;

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
	public CardPlayState getPlayState() {
		return new SilverPlayState();
	}

	@Override
	public Set<CardType> getType() {
		Set<CardType> toReturn = new TreeSet<CardType>();
		toReturn.add(CardType.TREASURE);
		return toReturn;
	}

}
