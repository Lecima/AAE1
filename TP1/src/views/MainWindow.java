package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSplitPane;

import java.awt.BorderLayout;

import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JList;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

import java.awt.Component;
import java.awt.Toolkit;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;

public class MainWindow {

	private JFrame frmAaeTp;
	private JTextField txtPublisher;
	private JTextField txtSubscriber;
	private JTextField txtMessage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frmAaeTp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
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
		frmAaeTp.setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindow.class.getResource("/views/news.png")));
		frmAaeTp.setResizable(false);
		frmAaeTp.setTitle("AAE - TP1");
		frmAaeTp.setBounds(100, 100, 658, 482);
		frmAaeTp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTextArea txtrActions = new JTextArea();
		frmAaeTp.getContentPane().add(txtrActions, BorderLayout.CENTER);
		txtrActions.setText("Actions");
		txtrActions.setEditable(false);
		
		JPanel panel_6 = new JPanel();
		frmAaeTp.getContentPane().add(panel_6, BorderLayout.NORTH);
		panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.Y_AXIS));
		
		JPanel panel_5 = new JPanel();
		panel_6.add(panel_5);
		FlowLayout flowLayout = (FlowLayout) panel_5.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		
		JLabel lblNewLabel_1 = new JLabel("Publisher subscriber using AOP and Observer Pattern");
		panel_5.add(lblNewLabel_1);
		
		JSeparator separator = new JSeparator();
		panel_6.add(separator);
		
		JPanel panel = new JPanel();
		panel_6.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Add a publisher");
		panel.add(lblNewLabel);
		
		txtPublisher = new JTextField();
		txtPublisher.setToolTipText("Name");
		panel.add(txtPublisher);
		txtPublisher.setColumns(10);
		
		JButton btnAddPublisher = new JButton("Add");
		panel.add(btnAddPublisher);
		
		JSeparator separator_1 = new JSeparator();
		panel_6.add(separator_1);
		
		JPanel panel_1 = new JPanel();
		panel_6.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lblAddASubscriber = new JLabel("Add a subscriber");
		panel_1.add(lblAddASubscriber);
		
		txtSubscriber = new JTextField();
		txtSubscriber.setToolTipText("Name");
		txtSubscriber.setColumns(10);
		panel_1.add(txtSubscriber);
		
		JList listPublisher = new JList();
		listPublisher.setBorder(new TitledBorder(null, "Publishers", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		listPublisher.setModel(new AbstractListModel() {
			String[] values = new String[] {"New York Times", "La Voix du Nord", "Le Monde"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listPublisher.setVisibleRowCount(5);
		panel_1.add(listPublisher);
		
		JButton btnAddSubscriber = new JButton("Add");
		panel_1.add(btnAddSubscriber);
		
		JSeparator separator_2 = new JSeparator();
		panel_6.add(separator_2);
		
		JPanel panel_3 = new JPanel();
		panel_6.add(panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lblSendAMessage = new JLabel("Send a message");
		panel_3.add(lblSendAMessage);
		
		JComboBox comboBoxPublisher = new JComboBox();
		comboBoxPublisher.setModel(new DefaultComboBoxModel(new String[] {"New York Times", "La Voix du Nord", "Le Monde"}));
		comboBoxPublisher.setMaximumRowCount(300);
		panel_3.add(comboBoxPublisher);
		
		txtMessage = new JTextField();
		txtMessage.setToolTipText("Message");
		txtMessage.setColumns(10);
		panel_3.add(txtMessage);
		
		JButton btnSendMessage = new JButton("Send");
		panel_3.add(btnSendMessage);
		
		JList listPublisher2 = new JList();
		frmAaeTp.getContentPane().add(listPublisher2, BorderLayout.WEST);
		listPublisher2.setBorder(new TitledBorder(null, "Publishers", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		listPublisher2.setVisibleRowCount(5);
		listPublisher2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listPublisher2.setModel(new AbstractListModel() {
			String[] values = new String[] {"New York Times", "La Voix du Nord", "Le Monde"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		JList listSubscriber = new JList();
		frmAaeTp.getContentPane().add(listSubscriber, BorderLayout.EAST);
		listSubscriber.setBorder(new TitledBorder(null, "Subscribers", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		listSubscriber.setVisibleRowCount(5);
		listSubscriber.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listSubscriber.setModel(new AbstractListModel() {
			String[] values = new String[] {"Michel Poutou", "Guy Legueu", "Fernand Dupux", "Ren\u00E9 Mouchi"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
	}

}
