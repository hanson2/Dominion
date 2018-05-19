import java.util.Optional;

public class VassalPlayState extends CardPlayState {

	@Override
	public void run(Turn turn) {
		Optional<Card> cardPossibility = turn.player.discardTopCardOfDrawPile();

		if (!cardPossibility.isPresent()) {
			return;
		} else {
			Card card = cardPossibility.get();
			if (card.getType().contains(CardType.ACTION)) {
				boolean response = turn.player.promptYesNo("vassalPrompt");
				if (response) {
					turn.state = card.getPlayState();
					turn.run();
				} else {
					return;
				}
			} else {
				return;
			}
		}
	}

}
