package views;

public class ConsoleView implements IView {

	@Override
	public void displayMessage(String message) {
		System.out.println(message);
	}

}
