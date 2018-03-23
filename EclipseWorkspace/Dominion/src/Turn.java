
public class Turn {
	Player player;
	
	public Turn(Player player){
		this.player = player;	
	}
	
	public void run(){
		
		//action phase
		String card = this.player.playCard();
		
		//buy phase
		
		//Cleanup Phase
		this.player.discardHand();
		for (int i = 0; i < 5; i++) {
			this.player.drawACard();
		}
	}
	
}
