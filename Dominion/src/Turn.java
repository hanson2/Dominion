
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
		this.handleActions();
		this.handleBuys();
		this.handleCleanup();
	}
	
	void handleActions(){
		while (this.actions > 0) {
			Card card = this.player.playCard();
			if(card == null){
				break;
			}
			this.handleCard(card);
			this.actions--;
		}
	}
	
	void handleBuys(){
		while (this.buys > 0) {
			if (!this.player.buy()) {
				this.buys = 0;
			}
			this.buys--;
		}
	}
	
	void handleCleanup(){
		this.player.discardHand();
		for (int i = 0; i < 5; i++) {
			this.player.drawACard();
		}
	}

	void handleCard(Card card) {
		this.actions += card.getActionsAdded();
		this.buys += card.getBuysAdded();
	}

	public String getCurrentStateType() {
		return "ACTION";
	}

}
