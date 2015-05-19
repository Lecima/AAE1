package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.BorderLayout;

import javax.swing.JTextArea;

import java.awt.Toolkit;

import javax.swing.JPanel;

import java.awt.FlowLayout;

import javax.swing.JLabel;

import java.awt.Font;

public class SecondWindowTest implements IView {

	public JFrame frmAaeTp;
	private JTextArea txtrActions;
	private JPanel panel;
	private JLabel lblinfTp;
	private JPanel panel_1;
	private JLabel lblPublisherSubscriberUsing;

	/**
	 * Create the application.
	 */
	public SecondWindowTest() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		frmAaeTp = new JFrame();
		frmAaeTp.setIconImage(Toolkit.getDefaultToolkit().getImage(SecondWindowTest.class.getResource("/views/news.png")));
		frmAaeTp.setTitle("AAE - TP1");
		frmAaeTp.setBounds(1300, 100, 550, 550);
		frmAaeTp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel_1 = new JPanel();
		frmAaeTp.getContentPane().add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 3));
		
		lblPublisherSubscriberUsing = new JLabel("Publisher subscriber using AOP and Observer Pattern - Test 2nd view");
		lblPublisherSubscriberUsing.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(lblPublisherSubscriberUsing);
		
		panel = new JPanel();
		frmAaeTp.getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 3));
		
		lblinfTp = new JLabel("8INF853 - TP1 - Adrien Ecrepont - Anthony Amicel");
		panel.add(lblinfTp);
		
		txtrActions = new JTextArea();
		txtrActions.setEditable(false);
		txtrActions.setText("Actions");
		
		JScrollPane scrollPane = new JScrollPane(txtrActions);
		frmAaeTp.getContentPane().add(scrollPane, BorderLayout.CENTER);
	}

	@Override
	public void displayMessage(String message) {
		txtrActions.setText(txtrActions.getText().concat("\n" + message));
		
	}

}
