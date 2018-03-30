
public class TurnActionState extends TurnState {

	private Turn turn;
	private Player player;

	public TurnActionState(Player player, Turn turn) {
		this.turn = turn;
		this.player = player;
	}

	@Override
	public void run() {

		while (this.turn.actions > 0) {
			Card card = this.player.playCard();
			if (card == null) {
				break;
			}
			this.handleCard(card);
			this.turn.actions--;
			
		}
	}
	
	
	private void handleCard(Card card) {
		
		this.turn.actions += card.getActionsAdded();
		this.turn.buys += card.getBuysAdded();
		
	}

}
