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
		borderLayout.setVgap(1);
		borderLayout.setHgap(1);
		frmAaeTp.setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindow.class.getResource("/views/news.png")));
		frmAaeTp.setResizable(false);
		frmAaeTp.setTitle("AAE - TP1");
		frmAaeTp.setBounds(100, 100, 658, 482);
		frmAaeTp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		txtrActions = new JTextArea();
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
		
		JList listPublisher2 = new JList();
		frmAaeTp.getContentPane().add(listPublisher2, BorderLayout.WEST);
		listPublisher2.setBorder(new TitledBorder(null, "Publishers", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		listPublisher2.setVisibleRowCount(20);
		listPublisher2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listPublisher2.setModel(listPub);
		
		JList listSubscriber = new JList();
		frmAaeTp.getContentPane().add(listSubscriber, BorderLayout.EAST);
		listSubscriber.setBorder(new TitledBorder(null, "Subscribers", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		listSubscriber.setVisibleRowCount(20);
		listSubscriber.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listSubscriber.setModel(listSub);
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
	}
	
	public void removeSubscribe(Category c, Subscriber s){
		s.removeCategory(c);
	}

}
