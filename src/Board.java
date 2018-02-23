/**
 * 
 * @author Ed Dumpleton
 * @release 11/01/2018
 */
public class Board {

	private char[][] board;
	private int rows;
	private int columns;

	/**
	 * Board constructor
	 * 
	 * @param row
	 * @param col
	 */
	public Board(int row, int col) {
		board = new char[col][row];
		setRows(row);
		setColumns(col);
	}

	public char[][] getBoard() {
		return board;
	}

	public void setBoard(char[][] board) {
		this.board = board;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

	/**
	 * Method draws board to the console
	 */
	public void drawBoard(PlayerID player, PlayerID player2) {

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == player.getCounter()) {
					System.out.print("| " + player.getCounter() + " ");
				} else if (board[i][j] == player2.getCounter()) {
					System.out.print("| " + player2.getCounter() + " ");
				} else {
					System.out.print("|   ");
				}
			}
			System.out.println("|");
		}
		System.out.println("  1   2   3   4   5   6   7");
	}

}
