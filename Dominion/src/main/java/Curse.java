import java.util.Set;
import java.util.HashSet;

public class Curse extends Card {

	@Override
	public int getVictoryValue() {
		return GameConstants.CURSEVICTORYVALUE;
	}

	@Override
	public int getCost() {
		return GameConstants.CURSECOST;
	}

	@Override
	public Set<CardType> getType() {
		Set<CardType> toReturn = new HashSet<CardType>();
		toReturn.add(CardType.CURSE);
		return toReturn;
	}

}
