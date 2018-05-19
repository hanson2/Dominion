
import java.util.Set;
import java.util.TreeSet;

public class Remodel extends Card {

	@Override
	public Set<CardType> getType() {
		TreeSet<CardType> ans = new TreeSet<CardType>();
		ans.add(CardType.ACTION);
		return ans;
	}

	@Override
	public int getCost() {
		return GameConstants.REMODELCOST;
	}
	
	@Override
	public CardPlayState getPlayState() {
		return new RemodelPlayState();
	}

}
