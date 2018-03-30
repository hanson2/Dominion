
public class Province extends Card {

	@Override
	public String getType() {
		return "VICTORY";
	}

	@Override
	public int getVictoryValue() {
		return 6;
	}

	@Override
	public int getCost() {
		return 8;
	}

	@Override
	public TurnState getPlayState() {
		return new ProvincePlayState();
	}

}
