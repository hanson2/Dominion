import java.util.Set;
import java.util.TreeSet;

public class Gold extends Card {

	@Override
	public int getCoinsAdded() {
		return 3;
	}

	@Override
	public int getCost() {
		return 6;
	}

	@Override
	public CardPlayState getPlayState() {
		return new GoldPlayState();
	}

	@Override
	public Set<CardType> getType() {
		Set<CardType> toReturn = new TreeSet<CardType>();
		toReturn.add(CardType.TREASURE);
		return toReturn;
	}

}
