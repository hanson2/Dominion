
public class Estate extends Card {

	@Override
	public String getType() {
		return "VICTORY";
	}

	@Override
	public int getVictoryValue() {
		return 1;
	}

	@Override
	public int getCost() {
		return 2;
	}

	@Override
	public CardPlayState getPlayState() {
		return new EstatePlayState();
	}
}
