import java.util.Set;
import java.util.HashSet;

public class Province extends Card {

	@Override
	public int getVictoryValue() {
		return 6;
	}

	@Override
	public int getCost() {
		return 8;
	}

	@Override
	public Set<CardType> getType() {
		Set<CardType> toReturn = new HashSet<CardType>();
		toReturn.add(CardType.VICTORY);
		return toReturn;
	}

}
