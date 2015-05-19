package observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.aspectj.lang.Signature;

import views.DListModel;
import views.MainWindow;

aspect SubjectObserverProtocolImpl extends SubjectObserverProtocol {
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
    
    pointcut stateChanges(Subject s):
        target(s) &&
        call(void Publisher.sendMessage(..));
    
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
    			System.out.println(p.getLastCategory());
    			p.addObserver(s);
    		}
    	}
    }

    pointcut newPublisher(Publisher p):
    	initialization(Publisher.new(..)) &&
    	target(p) &&
    	!within(SubjectObserverProtocolImpl);
    after(Publisher p): newPublisher(p){
    	listPublisher.add(p);
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
    		message = m.getName() + " has been created.";
    	} else if(sig.getName().equals("sendMessage")){
    		message = m.getName() + " sent a new message : " + m.getLastMessage() + " (" + m.getLastMessage().getCategory() + ")";
    	} else if(sig.getName().equals("getMessage")){
    		message = m.getName() + " has received a new message  : " + m.getLastMessage() + " (" + m.getLastMessage().getCategory() + ")";
    	} else if(sig.getName().equals("addCategory")){
    		message = m.getName() + " has a new subscription : " + ((Subscriber)m).getLastCategory();
    	} else if(sig.getName().equals("removeCategory")){
    		message = m.getName() + " unsubscribe : " + ((Subscriber)m).getLastCategory();
    	}
    	if(!message.equals("") && !message.equals(lastGUIMessage)){
    		MainWindow.mw.displayMessage(message);
    		lastGUIMessage = message;
    	}
    }
    	
}
