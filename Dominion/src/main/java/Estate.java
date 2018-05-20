import java.util.Set;
import java.util.HashSet;

public class Estate extends Card {

	@Override
	public int getVictoryValue() {
		return GameConstants.ESTATEVICTORYVALUE;
	}

	@Override
	public int getCost() {
		return GameConstants.ESTATECOST;
	}

	@Override
	public Set<CardType> getType() {
		Set<CardType> toReturn = new HashSet<CardType>();
		toReturn.add(CardType.VICTORY);
		return toReturn;
	}

	@Override
	public String getName() {
		return GameConstants.ESTATENAME;
	}
}
