package observer;

import java.util.ArrayList;
import java.util.List;

public class Subscriber extends AbstractPubSub{

	private Category lastCategory;
	private List<Category> listCategory;
    
    
    public Subscriber(String name) {
		super(name);
		this.listCategory = new ArrayList<Category>();
	}
    
    public void getMessage(Message m){
    	setLastMessage(m);
    }
    
    @Override
    public String toString() {
    	String cats = "(";
    	int i = 0;
    	for(Category cat : listCategory){
    		cats += cat + ", ";
    		if(i > 1){
    			cats += ".....";
    			break;
    		}
    		i++;
    	}
    	if(cats.length() > 1){
    		cats = cats.substring(0, cats.length()-2);
    	}
    	cats += ")";
    	return super.toString() + (cats.length() == 2 ? "" : " " + cats);
    }
    
    public void addCategory(Category c){
    	if(!listCategory.contains(c)){
    		listCategory.add(c);
    		lastCategory = c;
     	}
    }
    
    public void removeCategory(Category c){
    	if(listCategory.contains(c)){
    		listCategory.remove(c);
    		lastCategory = c;
     	}
    }
    
    public boolean hasCat(Category c){
    	return listCategory.contains(c);
    }

	public Category getLastCategory() {
		return lastCategory;
	}
    
}
