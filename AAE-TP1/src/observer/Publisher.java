package observer;

import java.util.ArrayList;
import java.util.List;

public class Publisher extends AbstractPubSub{
	private Category lastCategory;
	public Category getLastCategory() {
		return lastCategory;
	}

	private List<Category> listCat;
    
    public Publisher(String name) {
		super(name);
		//sendGUIMessage(this.getName() + " has been created");
		listCat = new ArrayList<>();
	}
    
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return super.toString();
    }
    
    public void sendMessage(Message message){
    	this.setLastMessage(message);
    	if(!listCat.contains(message.getCategory())){
    		addCat(message.getCategory());
    	}
    	//sendGUIMessage(this.getName() + " sent a new message : " + this.lastMessage);
    }
    
    public void addCat(Category c){
    	if(!listCat.contains(c)){
    		listCat.add(c);
    		lastCategory = c;
    	}
    }
    
    public boolean hasCat(Category c){
    	return listCat.contains(c);
    }
}
