package start;

import presentation.MainFrame;

public class Main {
	public static MainFrame mainFrame;

	public static void main(String args[]) {
		mainFrame = new MainFrame();
		new Refresh().start();
	}
}
