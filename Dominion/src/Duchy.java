import java.util.Set;
import java.util.TreeSet;

public class Duchy extends Card {

	@Override
	public int getVictoryValue() {
		return 3;
	}

	@Override
	public int getCost() {
		return 5;
	}

	@Override
	public CardPlayState getPlayState() {
		return new DuchyPlayState();
	}

	@Override
	public Set<CardType> getType() {
		Set<CardType> toReturn = new TreeSet<CardType>();
		toReturn.add(CardType.VICTORY);
		return toReturn;
	}

}
