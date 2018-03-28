
public class Copper extends Card {

	@Override
	public int getCoinsAdded() {
		return 1;
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
		return 0;
	}

}
