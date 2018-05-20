import java.util.Set;
import java.util.TreeSet;

public class Artisan extends Card {

	@Override
	public Set<CardType> getType() {
		TreeSet<CardType> ans = new TreeSet<CardType>();
		ans.add(CardType.ACTION);
		return ans;
	}

	@Override
	public int getCost() {
		// TODO Auto-generated method stub
		return GameConstants.ARTISANCOST;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return GameConstants.ARTISANNAME;
	}
	
	public String getText() {
		return GameConstants.ARTISANTEXT;
	}
	
	public CardPlayState getPlayState(){
		return new ArtisanPlayState();
	}

}
