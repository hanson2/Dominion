
public class Game {
	Player[] players;
	int currentPlayer;
	
	
	public Game(int playerCount){
		players = new Player[playerCount];
		for (int i = 0; i < players.length; i++) {
			players[i] = new Player(""+i);
		}
	}

	public String endGame() {
		int maxPoints = 0;
		String winner= null;
		
		for (int i = 0; i < this.players.length; i++) {
			if (players[i].points>maxPoints) {
				maxPoints = players[i].points;
			} 
		}
		for (int i = 0; i < players.length; i++) {
			if (players[i].points==maxPoints && winner==null) {
				winner = players[i].name;
			} else if (i==this.currentPlayer && this.players[i].points == maxPoints) {
				winner = players[i].name;
			}
			else if (players[i].points==maxPoints) {
				winner = winner + "&&" + players[i].name; 
			}
			
		}
		return winner;
		
	}

	public void endTurn() {
		this.currentPlayer++;
		this.currentPlayer = this.currentPlayer % this.players.length;
	}

}
