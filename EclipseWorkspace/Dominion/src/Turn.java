
public class Turn {
	Player player;
	int buys;
	int actions;

	public Turn(Player player) {
		this.player = player;
		this.buys = 1;
		this.actions = 1;
	}

	public void run() {

		// action phase
		String card = "";// eventually card object not
							// string
		// a card is played
		while (this.actions > 0) {
			card = this.player.playCard();
			this.handleCard(card);
			this.actions--;
		}
		// buy phase
		while (this.buys > 0) {
			if (!this.player.buy()) {
				this.buys = 0;
			}
			this.buys--;
		}

		// Cleanup Phase
		this.player.discardHand();
		for (int i = 0; i < 5; i++) {
			this.player.drawACard();
		}
	}

	private void handleCard(String card) {
		// TODO determine how to play cards
		if (card == "addAction") {
			this.actions++;
		} else if (card == "addBuy") {
			this.buys++;
		} else if (card == "") {
			this.actions = 0;
		}

	}

}
