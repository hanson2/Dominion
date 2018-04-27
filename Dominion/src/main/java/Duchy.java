import java.util.Set;
import java.util.HashSet;

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
	public Set<CardType> getType() {
		Set<CardType> toReturn = new HashSet<CardType>();
		toReturn.add(CardType.VICTORY);
		return toReturn;
	}

}
