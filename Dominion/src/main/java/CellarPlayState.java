
public class CellarPlayState extends CardPlayState {
	
	@Override
	public void run(Turn turn){
		int numCardsToAdd = 0;
		Player player = turn.player;
		
		int handSize = player.sizeOfHand();
		
		while(handSize > 0) {
			boolean response = player.promptYesNo("cellarPrompt");
			if(response) {
				Card card = player.chooseCardFromHand();
				player.discardCardFromHand(card.getClass());
				numCardsToAdd++;
			}
			else{
				break;
			}
			handSize = player.sizeOfHand();			
		}
		
		for(int i = 0; i < numCardsToAdd; i++) {
			player.drawACard();
		}
	}

}
