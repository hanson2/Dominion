
public class MoneylenderPlayState extends CardPlayState {

	@Override
	public void run(Turn turn){
		Player player = turn.player;
		boolean response = player.promptYesNo("Would you like to trash a Copper card from your hand for 3 coins?");
		
		if(response){
			player.trashCardFromHand(Copper.class);
			turn.coins += 3;
		}
	}
	
}
