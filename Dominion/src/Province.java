import java.util.Set;
import java.util.TreeSet;

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
	public CardPlayState getPlayState() {
		return new ProvincePlayState();
	}

	@Override
	public Set<CardType> getType() {
		Set<CardType> toReturn = new TreeSet<CardType>();
		toReturn.add(CardType.VICTORY);
		return toReturn;
	}

}
