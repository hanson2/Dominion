import java.util.Set;
import java.util.HashSet;

public class Province extends Card {

	@Override
	public int getVictoryValue() {
		return GameConstants.PROVINCEVICTORYVALUE;
	}

	@Override
	public int getCost() {
		return GameConstants.PROVINCECOST;
	}

	@Override
	public Set<CardType> getType() {
		Set<CardType> toReturn = new HashSet<CardType>();
		toReturn.add(CardType.VICTORY);
		return toReturn;
	}

	@Override
	public String getName() {
		return GameConstants.PROVINCENAME;
	}

}
