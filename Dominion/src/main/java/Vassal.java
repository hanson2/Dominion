
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

}
