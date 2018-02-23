/**
 * 
 * @author eddumpleton
 * @release 11/01/2018
 * @see Counter.java
 */
public class GameLogic extends Counter{

	private int count = 0;
	private int winNum;

	// GameLogic constructor
	public GameLogic(int win) {
		setWinNum(win);
	}

	/**
	 * Method checks the board to see if there are any winning counters either
	 * horizontally, vertically or diagonally
	 * 
	 * @param board
	 * @param counter
	 * @return boolean
	 */
	public boolean checkWin(Board board, char counter) {

		char[][] winBoard = board.getBoard();
		boolean hasWon = false;

		// check horizontally
		for (int i = 0; i < winBoard.length; i++) {
			for (int j = 0; j < winBoard[i].length; j++) {
				if (winBoard[i][j] == counter) {
					count++;
					if (count >= winNum) {
						hasWon = true;
					}
				} else {
					count = 0;
				}
			}
			count = 0;
		}

		// check vertically
		for (int i = 0; i < winBoard[0].length; i++) {
			for (int j = 0; j < winBoard.length; j++) {
				if (winBoard[j][i] == counter) {
					count++;
					if (count >= winNum) {
						hasWon = true;
					}
				} else {
					count = 0;
				}
			}
			count = 0;
		}

		// check diagonally /
		for (int i = winBoard.length - 1; i >= winBoard.length - 3; i--) {
			for (int j = 0; j < winBoard[0].length - 3; j++) {
				if (winBoard[i][j] == counter) {
					count++;
					while (count != 0) {
						if (winBoard[i - count][j + count] == counter) {
							count++;
							if (count >= winNum) {
								hasWon = true;
							}
						} else {
							count = 0;
						}
					}
				} else {
					count = 0;
				}
			}
		}

		// check diagonally \
		for (int i = 0; i < winBoard.length - 3; i++) {
			for (int j = 0; j <= winBoard[0].length - 3; j++) {
				if (winBoard[i][j] == 'r') {
					count++;
					while (count != 0) {
						if (winBoard[i + count][j + count] == 'r') {
							count++;
							if (count >= winNum) {
								hasWon = true;
							}
						} else {
							count = 0;
						}
					}
				} else {
					count = 0;
				}
			}
		}
		return hasWon;
	}

	/**
	 * Method checks columns on the board to see if there is space to place a
	 * counter there, if not it returns false and the player has to enter a new
	 * input until it is validated
	 * 
	 * @param input
	 * @param board
	 * @return boolean
	 */
	public boolean validateInput(int input, Board board) {

		char[][] checkBoard = board.getBoard();
		boolean valid = false;
		while (true) {
			try {
				if (checkBoard[0][input - 1] == 'r') {
					if (checkDraw(checkBoard) == true) {
						System.out.println("Game is a draw!!!");
					}
					valid = false;

				} else if (checkBoard[0][input - 1] == 'y') {
					if (checkDraw(checkBoard) == true) {
						System.out.println("Game is a draw!!!");
					}
				} else {
					valid = true;
				}

				return valid;
			} catch (ArrayIndexOutOfBoundsException e) {
				return false;
			}
		}

	}

	/**
	 * Method checks to see if game is a draw returns boolean depending on result
	 * 
	 * @param checkBoard
	 * @return
	 */
	private boolean checkDraw(char[][] checkBoard) {
		boolean draw = false;

		for (int i = 0; i < checkBoard.length; i++) {
			for (int j = 0; j < checkBoard[i].length; j++) {
				if (checkBoard[i][j] != ('r' | 'y')) {
					draw = false;
				} else {
					draw = true;
				}
			}
		}
		return draw;

	}

	/**
	 * getters and setters for winning number
	 * 
	 * @return
	 */
	public int getWinNum() {
		return winNum;
	}

	public void setWinNum(int winNum) {
		this.winNum = winNum;
	}
}
