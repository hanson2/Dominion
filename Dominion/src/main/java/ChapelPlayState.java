
public class ChapelPlayState extends CardPlayState {

	@Override
	public void run(Turn turn) {
		Player player = turn.player;
		
		for (int i = 0; i < 4; i++) {
			boolean response = player.promptYesNo("chapelPrompt");
			if (response) {
				Card toTrash = player.chooseCardFromHand();
				player.trashCardFromHand(toTrash.getClass());
			} else {
				break;
			}
		}
	}

}
