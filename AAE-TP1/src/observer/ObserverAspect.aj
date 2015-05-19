package observer;

import java.util.Vector;

abstract aspect ObserverAspect {

    abstract pointcut stateChanges(Subject s);

    after(Subject s): stateChanges(s) {
        for (int i = 0; i < s.getObservers().size(); i++) {
            ((Observer)s.getObservers().elementAt(i)).update(s);
        }
    }

    private Vector Subject.observers = new Vector();
    public void   Subject.addObserver(Observer obs) {
    	if(!observers.contains(obs)){
	        observers.addElement(obs);
	        obs.setSubject(this);
    	}
    }
    public void   Subject.removeObserver(Observer obs) {
    	if(observers.contains(obs)){
	        observers.removeElement(obs);
	        obs.setSubject(null);
    	}
    }
    public Vector Subject.getObservers() { return observers; }

    private Subject Observer.subject = null;
    public void     Observer.setSubject(Subject s) { subject = s; }
    public Subject  Observer.getSubject() { return subject; }
}
