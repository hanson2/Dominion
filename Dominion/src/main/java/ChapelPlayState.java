
public class ChapelPlayState extends CardPlayState {

	@Override
	public void run(Turn turn) {
		boolean response;
		for (int i = 0; i < 4; i++) {
			response = turn.player.promptYesNo("Would you like to trash a card from your hand?");
			if (response) {
				Card toTrash = turn.player.chooseCardFromHand();
				turn.player.trashCardFromHand(toTrash.getClass());
			} else {
				break;
			}
		}
	}

}
