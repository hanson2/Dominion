import java.util.Optional;

public class VassalPlayState extends CardPlayState {

	@Override
	public void run(Turn turn) {
		Player player = turn.player;
		Optional<Card> cardPossibility = player.discardTopCardOfDrawPile();

		if (!cardPossibility.isPresent()) {
			return;
		} else {
			Card card = cardPossibility.get();
			if (card.getType().contains(CardType.ACTION)) {
				boolean response = player.promptYesNo("vassalPrompt");
				if (response) {
					turn.state = card.getPlayState();
					turn.run();
				}
			}
		}
	}

}
