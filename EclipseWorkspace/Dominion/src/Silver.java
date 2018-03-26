
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
	public int getVictoryValue() {
		return 0;
	}

	@Override
	public int getCost() {
		return 3;
	}

}
