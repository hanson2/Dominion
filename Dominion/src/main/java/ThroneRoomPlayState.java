
public class ThroneRoomPlayState extends CardPlayState {

	@Override
	public void run(Turn turn) {
		boolean response;

		response = turn.player.promptYesNo("Would you like to play an Action card from your hand twice?");

		if (response) {
			Card card = turn.player.chooseCardFromHand();
			if (card.getType().contains(CardType.ACTION)) {
				CardPlayState state = card.getPlayState();
				turn.state = state;
				turn.run();
				turn.run();
			}
		}
	}

}
