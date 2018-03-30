import java.util.Set;
import java.util.TreeSet;

public class Curse extends Card {

	@Override
	public int getVictoryValue() {
		return -1;
	}

	@Override
	public int getCost() {
		return 0;
	}

	@Override
	public CardPlayState getPlayState() {
		return new CursePlayState();
	}

	@Override
	public Set<CardType> getType() {
		Set<CardType> toReturn = new TreeSet<CardType>();
		toReturn.add(CardType.CURSE);
		return toReturn;
	}

}
