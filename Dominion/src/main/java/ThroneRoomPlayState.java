
public class ThroneRoomPlayState extends CardPlayState {

	@Override
	public void run(Turn turn) {
		Player player = turn.player;
		
		if (player.promptYesNo("throneroomPrompt")) {
			Card card = player.chooseCardFromHand();
			if (card.getType().contains(CardType.ACTION)) {
				CardPlayState state = card.getPlayState();
				turn.state = state;
				turn.run();
				turn.run();
			}
		}
	}

}
