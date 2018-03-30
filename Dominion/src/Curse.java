
public class Curse extends Card {

	@Override
	public String getType() {
		return "CURSE";
	}

	@Override
	public int getCoinsAdded() {
		return 0;
	}

	@Override
	public int getVictoryValue() {
		return -1;
	}

	@Override
	public int getCost() {
		return 0;
	}

}