import java.util.Set;
import java.util.TreeSet;

public class Workshop extends Card {

	@Override
	public Set<CardType> getType() {
		TreeSet<CardType> ans = new TreeSet<CardType>();
		ans.add(CardType.ACTION);
		return ans;
	}

	@Override
	public int getCost() {
		return GameConstants.WORKSHOPCOST;
	}

	@Override
	public String getName() {
		return GameConstants.WORKSHOPNAME;
	}
	
	public String getText() {
		return GameConstants.WORKSHOPTEXT;
	}

}
