package observer;

import java.util.ArrayList;
import java.util.List;
import org.aspectj.lang.Signature;
import views.IView;

aspect ObserverAspectImpl extends ObserverAspect {
	private List<Publisher> listPublisher = new ArrayList<>();
	private List<Subscriber> listSubscriber = new ArrayList<>();

	declare parents: Publisher implements Subject;
    public Object Publisher.getData() { return this; }
    
    declare parents: Subscriber implements Observer;
    public void Subscriber.update(Object o) {
    	Message m = ((Publisher)((Subject)o).getData()).getLastMessage();
    	if(hasCat(m.getCategory())){
    		getMessage(m);
    	}
    }
    
    declare parents: ObserverAspectImpl implements Subject;
    public Object ObserverAspectImpl.getData() { return this; }
    
    declare parents: IView implements Observer;
    public void IView.update(Object o) {
    	String m = ((ObserverAspectImpl)((Subject)o).getData()).getLastGUIMessage();
    	displayMessage(m);
    }
    
    pointcut stateChanges(Subject s):
        target(s) &&
        call(void Publisher.sendMessage(..));
    
    pointcut stateChanges2(Subject s):
        target(s) &&
        call(void ObserverAspectImpl.setLastGUIMessage(..));
    
    pointcut newSubscribe(Subscriber s):
    	target(s) &&
    	call(void Subscriber.addCategory(Category)) &&
    	!within(SubjectObserverProtocolImpl);
    after(Subscriber s): newSubscribe(s){
    	for(Publisher p : listPublisher){
    		if(p.hasCat(s.getLastCategory())){
    			p.addObserver(s);
    		}
    	}
    }
    
    pointcut newCatPublisher(Publisher p):
    	target(p) &&
    	call(void Publisher.addCat(Category)) &&
    	!within(SubjectObserverProtocolImpl);
    after(Publisher p): newCatPublisher(p){
    	for(Subscriber s : listSubscriber){
    		if(s.hasCat(p.getLastCategory())){
    			p.addObserver(s);
    		}
    	}
    }
    
    pointcut newView(IView v):
    	initialization(IView.new(..)) &&
    	target(v) &&
    	!within(SubjectObserverProtocolImpl);
    after(IView v): newView(v){
    	this.addObserver(v);
    }

    pointcut newPublisher(Publisher p):
    	initialization(Publisher.new(..)) &&
    	target(p) &&
    	!within(SubjectObserverProtocolImpl);
    after(Publisher p): newPublisher(p){
    	listPublisher.add(p);
    }
    
    pointcut removePublisher(Publisher p):
    	target(p) &&
    	call(void Publisher.removeMe()) &&
    	!within(SubjectObserverProtocolImpl);
    after(Publisher p): removePublisher(p){
    	listPublisher.remove(p);
    }
    
    pointcut removeCategory(Category c):
    	target(c) &&
    	call(void Category.removeMe()) &&
    	!within(SubjectObserverProtocolImpl);
    after(Category c): removeCategory(c){
    	for(Subscriber s : listSubscriber){
    		if(s.hasCat(c)){
    			s.removeCategory(c);
    		}
    	}
    }
    
    pointcut removeSubscriber(Subscriber s):
    	target(s) &&
    	call(void Subscriber.removeMe()) &&
    	!within(SubjectObserverProtocolImpl);
    after(Subscriber s): removeSubscriber(s){
    	for(Publisher p : listPublisher){
    		p.removeObserver(s);
    	}
    	listSubscriber.remove(s);
    }
    
    pointcut newSubscriber(Subscriber s):
    	initialization(Subscriber.new(..)) &&
    	target(s) &&
    	!within(SubjectObserverProtocolImpl);
    after(Subscriber s): newSubscriber(s){
    	listSubscriber.add(s);
    }
    
    private String lastGUIMessage = "";
    pointcut wantToDisplayMessage(AbstractPubSub m):
    	target(m) &&
    	!within(SubjectObserverProtocolImpl);
    after(AbstractPubSub m): wantToDisplayMessage(m){
    	Signature sig = thisJoinPointStaticPart.getSignature();
    	String message = "";
    	if(sig.getName().equals("<init>")){
    		message = "+++ " + m.getName() + " has been created.";
    	} else if(sig.getName().equals("sendMessage")){
    		message = ">>> " + m.getName() + " sent a new message : " + m.getLastMessage() + " (" + m.getLastMessage().getCategory() + ")";
    	} else if(sig.getName().equals("getMessage")){
    		message = "< " + m.getName() + " has received a new message  : " + m.getLastMessage() + " (" + m.getLastMessage().getCategory() + ")";
    	} else if(sig.getName().equals("addCategory")){
    		message = "+ " + m.getName() + " subscribed : " + ((Subscriber)m).getLastCategory();
    	} else if(sig.getName().equals("removeCategory")){
    		message = "- " + m.getName() + " unsubscribed : " + ((Subscriber)m).getLastCategory();
    	} else if(sig.getName().equals("removeMe")){
    		message = "--- " + m.getName() + " has been removed.";
    	}
    	if(!message.equals("") && !message.equals(lastGUIMessage)){
    		setLastGUIMessage(message);
    	}
    }

	public void setLastGUIMessage(String lastGUIMessage) {
		this.lastGUIMessage = lastGUIMessage;
	}

	public String getLastGUIMessage() {
		return lastGUIMessage;
	}
    	
}
