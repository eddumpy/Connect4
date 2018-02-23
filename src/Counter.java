/**
 * 
 * @author eddumpleton
 * @release 11/01/2018
 */
public class Counter {

	/**
	 * Method places the players counters, 
	 * similar code to the original but in a separate class
	 * @param counter
	 * @param position
	 * @param board
	 */
	
	//default constructor
	public Counter() {
		
	}
	
	public void placeCounter(char counter,char[] counters, int position, Board board) {

		char[][] gameBoard = board.getBoard();

		boolean placed = false; 
		
		if (counter == counters[0]) {
			for (int i = gameBoard.length - 1; i >= 0; i--) {
				if (!placed) {
					if (gameBoard[i][position - 1] == counters[1]) {
						// skip
						
					} else if (gameBoard[i][position - 1] != counter) {
						gameBoard[i][position - 1] = counter;
						placed = true;
					}
				}
			}
		}

		else if (counter == counters[1]) {
			for (int i = gameBoard.length - 1; i >= 0; i--) {
				if (!placed) {
					if (gameBoard[i][position - 1] == counters[0]) {
						// skip
					} else if (gameBoard[i][position - 1] != counter) {
						gameBoard[i][position - 1] = counter;
						placed = true;
					}
				}
			}
		}

	}
}
