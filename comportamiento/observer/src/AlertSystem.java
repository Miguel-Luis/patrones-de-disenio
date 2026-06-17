package src;

public class AlertSystem implements Observer {
    private final double threshold;

    public AlertSystem(double threshold) {
        this.threshold = threshold;
    }

    @Override
    public void update(String eventType, String data) {
        if ("temperature".equals(eventType)) {
            double value = Double.parseDouble(data);
            if (value > threshold) {
                System.out.println("  [ALERTA] Temperatura critica: " + value + "C (umbral: " + threshold + "C)");
            }
        }
    }
}
