import java.util.Set;
import java.util.HashSet;

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
	public Set<CardType> getType() {
		Set<CardType> toReturn = new HashSet<CardType>();
		toReturn.add(CardType.VICTORY);
		return toReturn;
	}
}
