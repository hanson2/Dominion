
public class Silver extends Card {

	@Override
	public int getCoinsAdded() {
		return 2;
	}

	@Override
	public String getType() {
		return "TREASURE";
	}

	@Override
	public int getCost() {
		return 3;
	}

	@Override
	public CardPlayState getPlayState() {
		return new SilverPlayState();
	}

}
