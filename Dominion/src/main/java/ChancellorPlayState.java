import java.util.ResourceBundle;

public class ChancellorPlayState extends CardPlayState {
	
	@Override
	public void run(Turn turn){
		Player player = turn.player;
		boolean response = player.promptYesNo("chancellorPrompt");
		
		if(response){
			player.discardDrawPile();
		}
	}

}
