
public class Game {
	Player[] players;
	
	
	public Game(int playerCount){
		players = new Player[playerCount];
		for (int i = 0; i < players.length; i++) {
			players[i] = new Player();
		}
	}

	public int endGame() {
		int maxPoints = 0;
		int winner = 0;
		
		for (int i = 0; i < this.players.length; i++) {
			if (players[i].points>maxPoints) {
				winner = i;
				maxPoints = players[i].points;
			}
		}
		return winner;
		
	}

}
