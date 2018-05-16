import java.util.ResourceBundle;

public class ChancellorPlayState extends CardPlayState {
	
	@Override
	public void run(Turn turn){
		Player player = turn.player;
		ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle");
		boolean response = player.promptYesNo(messages.getString("chancellorPrompt"));
		
		if(response){
			player.discardDrawPile();
		}
	}

}
