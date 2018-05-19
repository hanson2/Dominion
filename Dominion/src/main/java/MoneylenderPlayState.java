
public class MoneylenderPlayState extends CardPlayState {

	@Override
	public void run(Turn turn){
		Player player = turn.player;
		
		if(player.promptYesNo("moneylenderPrompt") && player.trashCardFromHand(Copper.class)){
			turn.coins += 3;
		}
	}
	
}
