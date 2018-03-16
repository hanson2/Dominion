
public class Game {
	Player[] players;
	int currentPlayer;
	
	/**
	 * Purpose: Creates a new game 
	 * @param playerCount int number of Players in game (2-4)
	 * @throws IllegalArgumentException when playerCount is out of range
	 */
	public Game(int playerCount){
		if(playerCount>4 || playerCount<2){
			throw new IllegalArgumentException();
		}
		players = new Player[playerCount];
		for (int i = 0; i < players.length; i++) {
			players[i] = new Player(""+i);//can get names passed in eventually
		}
	}
	
	/**
	 * Purpose: Determines winner
	 * @return String containing all winners "Names"
	 */
	public String endGame() {
		int maxPoints = 0;
		String winner= null;
		
		for (int i = 0; i < this.players.length; i++) {
			if (players[i].points>maxPoints) {
				maxPoints = players[i].points;
			} 
		}
		boolean tieBreaker = false;			
		if(this.currentPlayer==0){
			tieBreaker=true;
		}
		for (int i = 0; i < players.length; i++) {
			//first winner
			if (players[i].points==maxPoints && winner==null) {
				winner = players[i].name;
			}
			//winner with fewest turns
			else if (i>=this.currentPlayer && this.players[i].points == maxPoints && !tieBreaker) {
				winner = players[i].name;
				tieBreaker = true;
			} 
			//co-winners
			else if (players[i].points==maxPoints) {
				winner = winner + "&&" + players[i].name; 
			}
			
		}
		return winner;
		
	}
	
	/**
	 * Purpose: Progress the turn counter and keep it within valid values
	 */
	public void endTurn() {
		this.currentPlayer++;
		this.currentPlayer = this.currentPlayer % this.players.length;
	}

}
