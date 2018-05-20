import java.util.HashSet;
import java.util.Set;

public class Vassal extends Card {

	@Override
	public Set<CardType> getType() {
		HashSet<CardType> toReturn = new HashSet<CardType>();
		toReturn.add(CardType.ACTION);
		return toReturn;
	}

	@Override
	public int getCost() {
		return GameConstants.VASSALCOST;
	}
	
	@Override
	public int getCoinsAdded() {
		return GameConstants.VASSALCOINSADDED;
	}
	
	@Override
	public CardPlayState getPlayState() {
		return new VassalPlayState();
	}

	@Override
	public String getName() {
		return GameConstants.VASSALNAME;
	}
	
	@Override
	public String getText() {
		return GameConstants.VASSALTEXT;
	}

}
