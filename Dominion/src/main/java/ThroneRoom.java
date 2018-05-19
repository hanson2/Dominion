import java.util.HashSet;
import java.util.Set;

public class ThroneRoom extends Card {

	@Override
	public Set<CardType> getType() {
		HashSet<CardType> toReturn = new HashSet<CardType>();
		toReturn.add(CardType.ACTION);
		return toReturn;
	}

	@Override
	public int getCost() {
		return GameConstants.THRONEROOMCOST;
	}

	@Override
	public CardPlayState getPlayState() {
		return new ThroneRoomPlayState();
	}

}
