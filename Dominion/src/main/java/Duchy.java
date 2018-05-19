import java.util.Set;
import java.util.HashSet;

public class Duchy extends Card {

	@Override
	public int getVictoryValue() {
		return GameConstants.DUCHYVICTORYVALUE;
	}

	@Override
	public int getCost() {
		return GameConstants.DUCHYCOST;
	}

	@Override
	public Set<CardType> getType() {
		Set<CardType> toReturn = new HashSet<CardType>();
		toReturn.add(CardType.VICTORY);
		return toReturn;
	}

}
