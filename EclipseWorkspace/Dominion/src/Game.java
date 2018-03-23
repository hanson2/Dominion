
public class Game {
	private Player[] players;
	private int currentPlayer;

	/**
	 * Purpose: Creates a new game
	 * 
	 * @param playerCount
	 *            int number of Players in game (2-4)
	 * @throws IllegalArgumentException
	 *             when playerCount is out of range
	 */
	public Game(Player... players) throws IllegalArgumentException {
		if (players.length > 4 || players.length < 2) {
			throw new IllegalArgumentException();
		}
		this.players = players;
	}

	/**
	 * Purpose: Determines winner
	 * 
	 * @return String containing all winners "Names"
	 */
	public String endGame() {
		int maxPoints = 0;
		String winner = null;

		for (int i = 0; i < this.players.length; i++) {
			if (players[i].getPoints() > maxPoints) {
				maxPoints = players[i].getPoints();
			}
		}
		boolean tieBreaker = false;
		if (this.currentPlayer == 0) {
			tieBreaker = true;
		}
		for (int i = 0; i < players.length; i++) {
			// first winner
			if (players[i].getPoints() == maxPoints && winner == null) {
				winner = players[i].getName();
			}
			// winner with fewest turns
			else if (i >= this.currentPlayer && this.players[i].getPoints() == maxPoints && !tieBreaker) {
				winner = players[i].getName();
				tieBreaker = true;
			}
			// co-winners
			else if (players[i].getPoints() == maxPoints) {
				winner = winner + "&&" + players[i].getName();
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
