package observer;

import java.util.ArrayList;
import java.util.List;

public class Subscriber extends AbstractPubSub{

	private Category lastCategory;
	private List<Category> listCategory;
    
    
    public Subscriber(String name) {
		super(name);
		this.listCategory = new ArrayList<Category>();
		//sendGUIMessage(this.getName() + " has been created");
	}
    
    public void getMessage(Message m){
    	setLastMessage(m);
    	//sendGUIMessage(this.getName() + " has received a new message  : " + this.lastMessage + " from " + this.lastPublisher.getName());
    }
    
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return super.toString();
    }
    
    public void addCategory(Category c){
    	if(!listCategory.contains(c)){
    		listCategory.add(c);
    		lastCategory = c;
    		//sendGUIMessage(this.getName() + " has a new subscription  : " + this.lastPublisher);
     	}
    }
    
    public void removeCategory(Category c){
    	if(listCategory.contains(c)){
    		listCategory.remove(c);
    		lastCategory = c;
    		//sendGUIMessage(this.getName() + " has a new subscription  : " + this.lastPublisher);
     	}
    }
    
    public boolean hasCat(Category c){
    	return listCategory.contains(c);
    }

	public Category getLastCategory() {
		return lastCategory;
	}
    
}
