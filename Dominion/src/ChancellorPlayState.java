
public class ChancellorPlayState extends CardPlayState {
	
	@Override
	public void run(Turn turn){
		Player player = turn.player;
		boolean response = player.promptYesNo("Would you like to discard you draw pile?");
		
		if(response){
			player.discardDrawPile();
		}
	}

}
