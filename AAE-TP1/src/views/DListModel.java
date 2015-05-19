package views;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

import observer.AbstractPubSub;

public class DListModel extends DefaultComboBoxModel<AbstractPubSub> {

	private static final long serialVersionUID = 1L;
	
	public void addElement(AbstractPubSub a){
		super.addElement(a);
	}

}
