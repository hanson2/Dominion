import java.util.Set;
import java.util.HashSet;

public class Copper extends Card {

	@Override
	public int getCoinsAdded() {
		return 1;
	}

	@Override
	public Set<CardType> getType() {
		Set<CardType> toReturn = new HashSet<CardType>();
		toReturn.add(CardType.TREASURE);
		return toReturn;
	}

	@Override
	public int getCost() {
		return 0;
	}

	@Override
	public CardPlayState getPlayState() {
		return new CopperPlayState();
	}

}
