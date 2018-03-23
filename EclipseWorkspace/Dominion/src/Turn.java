
public class Turn {
	Player player;
	int buys;

	public Turn(Player player) {
		this.player = player;
		this.buys = 1;
	}

	public void run() {

		// action phase
		String card = this.player.playCard();// eventually card object not
												// string
		// a card is played
		if (card == "addBuy") {
			this.handleCard(card);
		}
		// buy phase
		while(this.buys>0){
			if(!this.player.buy()){
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
		this.buys++;

	}

}
