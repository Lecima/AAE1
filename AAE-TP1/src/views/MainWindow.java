package views;

import java.awt.EventQueue;

import javax.swing.JFrame;

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

import java.awt.Toolkit;

import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;

import observer.Category;
import observer.Message;
import observer.Publisher;
import observer.Subscriber;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.Font;

public class MainWindow {

	private JFrame frmAaeTp;
	private JTextField txtPublisher;
	private JTextField txtSubscriber;
	private JTextField txtMessage;
	private JTextArea txtrActions;
	private DListModel listPub = new DListModel();
	private DListModel listSub = new DListModel();
	private DListModel listCat = new DListModel();
	private DListModel listCat2 = new DListModel();
	public static MainWindow mw;
	private JTextField txtCategory;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frmAaeTp.setVisible(true);
					mw = window;
					mw.defaultValues();
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
		BorderLayout borderLayout = (BorderLayout) frmAaeTp.getContentPane().getLayout();
		borderLayout.setVgap(5);
		borderLayout.setHgap(10);
		frmAaeTp.setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindow.class.getResource("/views/news.png")));
		frmAaeTp.setResizable(false);
		frmAaeTp.setTitle("AAE - TP1");
		frmAaeTp.setBounds(100, 100, 1000, 750);
		frmAaeTp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel_10 = new JPanel();
		frmAaeTp.getContentPane().add(panel_10, BorderLayout.SOUTH);
		FlowLayout fl_panel_10 = new FlowLayout(FlowLayout.RIGHT, 5, 3);
		panel_10.setLayout(fl_panel_10);
		
		JLabel lblNewLabel_2 = new JLabel("8INF853 - Architecture des applications d'entreprise - TP1 - Adrien Ecrepont - Anthony Amicel");
		panel_10.add(lblNewLabel_2);
		
		JPanel panel_9 = new JPanel();
		frmAaeTp.getContentPane().add(panel_9, BorderLayout.CENTER);
		panel_9.setLayout(new BoxLayout(panel_9, BoxLayout.Y_AXIS));
		
		txtrActions = new JTextArea();
		txtrActions.setText("Actions");
		panel_9.add(txtrActions);
		txtrActions.setEditable(false);
		
		JScrollPane scrollPane_2 = new JScrollPane(txtrActions);
		panel_9.add(scrollPane_2);
		
		JPanel panel_6 = new JPanel();
		frmAaeTp.getContentPane().add(panel_6, BorderLayout.NORTH);
		panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.Y_AXIS));
		
		JPanel panel_5 = new JPanel();
		panel_6.add(panel_5);
		FlowLayout flowLayout = (FlowLayout) panel_5.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		
		JLabel lblNewLabel_1 = new JLabel("Publisher subscriber using AOP and Observer Pattern");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
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
		btnAddPublisher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!txtPublisher.getText().equals("")){
					addPublisher(txtPublisher.getText());
					txtPublisher.setText("");
				}
			}
		});
		panel.add(btnAddPublisher);
		
		JSeparator separator_1 = new JSeparator();
		panel_6.add(separator_1);
		
		JPanel panel_4 = new JPanel();
		panel_6.add(panel_4);
		panel_4.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lblAddACategory = new JLabel("Add a category");
		panel_4.add(lblAddACategory);
		
		txtCategory = new JTextField();
		txtCategory.setToolTipText("Name");
		txtCategory.setColumns(10);
		panel_4.add(txtCategory);
		
		JButton button = new JButton("Add");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!txtCategory.getText().equals("")){
					addCategory(txtCategory.getText());
					txtCategory.setText("");
				}
			}
		});
		panel_4.add(button);
		
		JSeparator separator_4 = new JSeparator();
		panel_6.add(separator_4);
		
		JPanel panel_1 = new JPanel();
		panel_6.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lblAddASubscriber = new JLabel("Add a subscriber");
		panel_1.add(lblAddASubscriber);
		
		txtSubscriber = new JTextField();
		txtSubscriber.setToolTipText("Name");
		txtSubscriber.setColumns(10);
		panel_1.add(txtSubscriber);
		
		JButton btnAddSubscriber = new JButton("Add");
		btnAddSubscriber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!txtSubscriber.getText().equals("")){
					addSubscriber(txtSubscriber.getText());
					txtSubscriber.setText("");
				}
			}
		});
		panel_1.add(btnAddSubscriber);
		
		JSeparator separator_3 = new JSeparator();
		panel_6.add(separator_3);
		
		JPanel panel_2 = new JPanel();
		panel_6.add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lblSubscribe = new JLabel("Subscribe");
		panel_2.add(lblSubscribe);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(listSub);
		comboBox_1.setMaximumRowCount(300);
		panel_2.add(comboBox_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(listCat);
		comboBox.setMaximumRowCount(300);
		panel_2.add(comboBox);
		
		JButton btnSubscribe = new JButton("Subscribe");
		btnSubscribe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem() != null && comboBox_1.getSelectedItem() != null){
					addSubscribe((Category)comboBox.getSelectedItem(), (Subscriber)comboBox_1.getSelectedItem());
				}
			}
		});
		panel_2.add(btnSubscribe);
		
		JButton btnUnsubscribe = new JButton("Unsubscribe");
		btnUnsubscribe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem() != null && comboBox_1.getSelectedItem() != null){
					removeSubscribe((Category)comboBox.getSelectedItem(), (Subscriber)comboBox_1.getSelectedItem());
				}
			}
		});
		panel_2.add(btnUnsubscribe);
		
		JSeparator separator_2 = new JSeparator();
		panel_6.add(separator_2);
		
		JPanel panel_3 = new JPanel();
		panel_6.add(panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lblSendAMessage = new JLabel("Send a message");
		panel_3.add(lblSendAMessage);
		
		JComboBox comboBoxPublisher = new JComboBox();
		comboBoxPublisher.setModel(listPub);
		comboBoxPublisher.setMaximumRowCount(300);
		panel_3.add(comboBoxPublisher);
		
		JComboBox comboBoxCategory = new JComboBox();
		comboBoxCategory.setModel(listCat2);
		comboBoxCategory.setMaximumRowCount(300);
		panel_3.add(comboBoxCategory);
		
		txtMessage = new JTextField();
		txtMessage.setToolTipText("Message");
		txtMessage.setColumns(10);
		panel_3.add(txtMessage);
		
		JButton btnSendMessage = new JButton("Send");
		btnSendMessage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!txtMessage.getText().equals("") && comboBoxPublisher.getSelectedItem() != null
						 && comboBoxCategory.getSelectedItem() != null){
					sendMessage(txtMessage.getText(), (Publisher)comboBoxPublisher.getSelectedItem(), (Category)comboBoxCategory.getSelectedItem());
					txtMessage.setText("");
				}
			}
		});
		panel_3.add(btnSendMessage);
		
		JPanel panel_7 = new JPanel();
		frmAaeTp.getContentPane().add(panel_7, BorderLayout.WEST);
		panel_7.setLayout(new BoxLayout(panel_7, BoxLayout.Y_AXIS));
		
		JList listPublisher2 = new JList();
		panel_7.add(listPublisher2);
		listPublisher2.setBorder(new TitledBorder(null, "Publishers", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		listPublisher2.setVisibleRowCount(20);
		listPublisher2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listPublisher2.setModel(listPub);
		
		JScrollPane scrollPane = new JScrollPane(listPublisher2);
		panel_7.add(scrollPane);
		
		JPanel panel_8 = new JPanel();
		frmAaeTp.getContentPane().add(panel_8, BorderLayout.EAST);
		panel_8.setLayout(new BoxLayout(panel_8, BoxLayout.Y_AXIS));
		
		JList listSubscriber = new JList();
		panel_8.add(listSubscriber);
		listSubscriber.setBorder(new TitledBorder(null, "Subscribers", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		listSubscriber.setVisibleRowCount(20);
		listSubscriber.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listSubscriber.setModel(listSub);
		
		JScrollPane scrollPane_1 = new JScrollPane(listSubscriber);
		panel_8.add(scrollPane_1);
	}
	
	public void displayMessage(String message){
		txtrActions.setText(txtrActions.getText().concat("\n" + message));
	}
	
	public void addPublisher(String name){
		listPub.addElement(new Publisher(name));
	}
	
	public void addSubscriber(String name){
		listSub.addElement(new Subscriber(name));
	}
	
	public void addCategory(String name){
		Category c = new Category(name);
		listCat.addElement(c);
		listCat2.addElement(c);
	}
	
	public void sendMessage(String message, Publisher publisher, Category cat){
		publisher.sendMessage(new Message(publisher, cat, message));
	}
	
	public void addSubscribe(Category c, Subscriber s){
		s.addCategory(c);
		listSub.addElement(null);
		listSub.removeElement(null);
	}
	
	public void removeSubscribe(Category c, Subscriber s){
		s.removeCategory(c);
	}
	
	private void defaultValues(){
		addPublisher("New York Times");
		addPublisher("USA Today");
		addPublisher("Chicago Tribune");
		addPublisher("La Voix du Nord");
		addSubscriber("Michel Poutou");
		addSubscriber("Guy Lamiche");
		addSubscriber("Patrick Caddy");
		addCategory("Politics");
		addCategory("World");
		addCategory("Business");
		addCategory("Science");
		addCategory("Sports");
		
	}

}
