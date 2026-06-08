package src;

public class DisplayPanel implements Observer {
    private final String panelName;

    public DisplayPanel(String panelName) {
        this.panelName = panelName;
    }

    @Override
    public void update(String eventType, String data) {
        System.out.println("  [" + panelName + "] Mostrando " + eventType + ": " + data);
    }
}
