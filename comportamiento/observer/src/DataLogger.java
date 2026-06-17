package src;

import java.util.ArrayList;
import java.util.List;

public class DataLogger implements Observer {
    private final List<String> history = new ArrayList<>();

    @Override
    public void update(String eventType, String data) {
        String record = "[LOG] " + eventType + " = " + data;
        history.add(record);
        System.out.println("  " + record);
    }

    public List<String> getHistory() {
        return history;
    }
}
