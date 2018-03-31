import java.util.Set;
import java.util.HashSet;

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
		Set<CardType> toReturn = new HashSet<CardType>();
		toReturn.add(CardType.TREASURE);
		return toReturn;
	}

}
