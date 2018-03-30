import java.util.Set;
import java.util.TreeSet;

public class Estate extends Card {

	@Override
	public int getVictoryValue() {
		return 1;
	}

	@Override
	public int getCost() {
		return 2;
	}

	@Override
	public CardPlayState getPlayState() {
		return new EstatePlayState();
	}

	@Override
	public Set<CardType> getType() {
		Set<CardType> toReturn = new TreeSet<CardType>();
		toReturn.add(CardType.VICTORY);
		return toReturn;
	}
}
