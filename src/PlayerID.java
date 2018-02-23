/**
 * Abstract class has been created so human and computer player can inherit
 * these classes, and allows us to use polymorphism in the ConnectN class.
 * @author eddumpleton
 * @release 11/01/2018
 */
public abstract class PlayerID {

	public char counter;
	
	public abstract int getPlayerInput();

	public char getCounter() {
		return counter;
	}

	public void setCounter(char counter) {
		this.counter = counter;
	}
	
}