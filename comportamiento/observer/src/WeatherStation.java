package src;

public class WeatherStation implements Subject {
    public final EventManager events;
    private double temperature;
    private double humidity;

    public WeatherStation() {
        this.events = new EventManager();
    }

    @Override
    public void subscribe(String eventType, Observer observer) {
        events.subscribe(eventType, observer);
    }

    @Override
    public void unsubscribe(String eventType, Observer observer) {
        events.unsubscribe(eventType, observer);
    }

    @Override
    public void notifyObservers(String eventType, String data) {
        events.notify(eventType, data);
    }

    public void setTemperature(double newTemperature) {
        System.out.println("\n[Estacion] Temperatura actualizada: " + newTemperature + "C");
        this.temperature = newTemperature;
        events.notify("temperature", String.valueOf(newTemperature));
    }

    public void setHumidity(double newHumidity) {
        System.out.println("\n[Estacion] Humedad actualizada: " + newHumidity + "%");
        this.humidity = newHumidity;
        events.notify("humidity", String.valueOf(newHumidity));
    }

    public double getTemperature() { return temperature; }
    public double getHumidity()    { return humidity; }
}
