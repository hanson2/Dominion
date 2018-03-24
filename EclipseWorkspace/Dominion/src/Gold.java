
public class Gold extends Card {

	@Override
	public int getCoinsAdded() {
		return 3;
	}

	@Override
	public String getType() {
		return "TREASURE";
	}

	@Override
	public int getVictoryValue() {
		return 0;
	}

}
