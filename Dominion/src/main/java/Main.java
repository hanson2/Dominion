
public class Main {

	static GUI gui;
	
	public static void main(String[] args) {
		gui = new GUI();
		
		int numPlayers = getNumPlayers();
		Player[] players = new Player[numPlayers]; 
		for(int i = 0; i < numPlayers; ++i) {
			players[i] = createPlayer(i + 1);
		}
	}
	
	static int getNumPlayers() {
		return gui.initNumPlayers().join();
	}

	static Player createPlayer(int number) {
		String name = gui.getPlayerXName(number).join();
		return new Player(name, gui);
	}

}
