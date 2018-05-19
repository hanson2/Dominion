
public class MoneylenderPlayState extends CardPlayState {

	@Override
	public void run(Turn turn){
		Player player = turn.player;
		boolean response = player.promptYesNo("moneylenderPrompt");
		
		if(response && player.trashCardFromHand(Copper.class)){
			turn.coins += 3;
		}
	}
	
}
