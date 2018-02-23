/**
 * @author Ed Dumpleton
 * @release 11/01/2018
 */
public class ConnectFour {

	public ConnectFour() {

	}

	/**
	 * Main game algorithm within this method, responsible for creating players and
	 * playing the game.
	 */
	public void playGame() {

		// Intro message
		System.out.println("Welcome to Connect 4");
		System.out.println("There are 2 players red and yellow");
		System.out.println("You are the red counter and the computer is the yellow counter");
		System.out.println("To play the game, type in the number of the column you want to drop your counter in");
		System.out.println("A player wins by connecting 4 counters in a row - vertically, horizontally or diagonally");
		System.out.println("");

		// Creates new game
		GameLogic game = new GameLogic(4);
		Board board = new Board(7, 6);

		// Creates the players and stores them in a polymorphic array
		PlayerID player[] = new PlayerID[2];
		player[0] = new HumanPlayer('r');
		player[1] = new ComputerPlayer('y');

		// stores counters in an array
		char[] counters = { player[0].getCounter(), player[1].getCounter() };

		boolean win = false;

		// Game algorithm
		while (!win) {

			// iterates through the polymorphic array until someone wins or there is a draw
			for (int x = 0; x < 2; x++) {
				boolean turn = false;
				char counter = player[x].getCounter();
				if (x == 0) {
					board.drawBoard(player[0], player[1]);
				}
				while (!turn) {
					int input = player[x].getPlayerInput();
					if (game.validateInput(input, board) == true) {
						game.placeCounter(counter, counters, input, board);
						turn = true;
					} else {
						if (x == 0) {
							System.out.println("Invalid Move, try a different column...");
							turn = false;
						} else {
							turn = false;
						}
					}
				}
				// checks to see if a player has won after there move
				if (game.checkWin(board, counter) == true) {
					board.drawBoard(player[0], player[1]);
					if (x == 0) {
						System.out.println("Congratulations, you have won!!!");
						win = true;
						x = 2;
					} else if (x == 1) {
						System.out.println("Computer has won, better luck next time.");
						win = true;
						x = 2;
					}
				}
			}
		}
	}

	/**
	 * Main method where new game object is created and then calls the play game
	 * method
	 *
	 */
	public static void main(String[] args) {
		ConnectFour connect4 = new ConnectFour();
		connect4.playGame();
	}

}
