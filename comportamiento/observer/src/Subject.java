package src;

public interface Subject {
    void subscribe(String eventType, Observer observer);
    void unsubscribe(String eventType, Observer observer);
    void notifyObservers(String eventType, String data);
}
