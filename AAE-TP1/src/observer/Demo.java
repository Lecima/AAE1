package observer;

import java.awt.EventQueue;

import views.ConsoleView;
import views.MainWindow;
import views.SecondWindowTest;

public class Demo {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsoleView cv = new ConsoleView();
					SecondWindowTest scdw = new SecondWindowTest();
					scdw.frmAaeTp.setVisible(true);
					MainWindow window = new MainWindow();
					window.frmAaeTp.setVisible(true);
					window.defaultValues();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
