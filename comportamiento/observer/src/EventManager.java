package src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventManager {
    private final Map<String, List<Observer>> listeners = new HashMap<>();

    public void subscribe(String eventType, Observer observer) {
        listeners.computeIfAbsent(eventType, k -> new ArrayList<>()).add(observer);
        System.out.println("[EventManager] Suscrito a '" + eventType + "': " + observer.getClass().getSimpleName());
    }

    public void unsubscribe(String eventType, Observer observer) {
        List<Observer> users = listeners.get(eventType);
        if (users != null) {
            users.remove(observer);
            System.out.println("[EventManager] Desuscrito de '" + eventType + "': " + observer.getClass().getSimpleName());
        }
    }

    public void notify(String eventType, String data) {
        List<Observer> users = listeners.getOrDefault(eventType, new ArrayList<>());
        for (Observer listener : users) {
            listener.update(eventType, data);
        }
    }
}
