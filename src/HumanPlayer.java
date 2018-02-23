import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Inherits methods from PlayerID
 * @author Ed Dumpleton
 * @release 11/01/2018
 * @see PlayerID.java
 *
 */
public class HumanPlayer extends PlayerID {

	private BufferedReader input;

	public HumanPlayer(char c) {
		setCounter(c);
	}

	public int getPlayerInput() {
		
		while (true) {
			try {
				input = new BufferedReader(new InputStreamReader(System.in));
				System.out.print("Enter Move: ");
				String userInput = input.readLine();
				int move = Integer.parseInt(userInput);
				return move;
			} catch (NumberFormatException e) {
				System.out.println("Enter number between 1-7 to play Connect Four. Try again...");
			} catch (Exception e) {
				System.out.println(e.getMessage() + " Invalid move");
			}
		}
	}


}
