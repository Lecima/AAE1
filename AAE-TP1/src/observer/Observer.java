package observer;

public interface Observer {
    void setSubject(Subject s);
    Subject getSubject();
    void update(Object o);
}
