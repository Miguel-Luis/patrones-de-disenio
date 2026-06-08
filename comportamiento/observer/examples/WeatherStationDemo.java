
import src.AlertSystem;
import src.DataLogger;
import src.DisplayPanel;
import src.WeatherStation;

/**
 * Demo del patrón Observer aplicado a una estación meteorológica.
 *
 * Escenario:
 *   - Una WeatherStation publica eventos de temperatura y humedad.
 *   - Tres suscriptores reaccionan de forma independiente:
 *       · DisplayPanel  → muestra los valores en pantalla
 *       · AlertSystem   → dispara alertas si la temperatura es crítica
 *       · DataLogger    → guarda un historial de todos los cambios
 *
 * Cómo ejecutar:
 *   javac -d out src/*.java examples/*.java
 *   java  -cp out examples.WeatherStationDemo
 */
public class WeatherStationDemo {

    public static void main(String[] args) {

        // ── 1. Crear el notificador ───────────────────────────────────────────
        WeatherStation station = new WeatherStation();

        // ── 2. Crear suscriptores ─────────────────────────────────────────────
        DisplayPanel mainDisplay   = new DisplayPanel("Pantalla Principal");
        DisplayPanel secondDisplay = new DisplayPanel("Pantalla Secundaria");
        AlertSystem  alertSystem   = new AlertSystem(35.0);   // umbral: 35 °C
        DataLogger   logger        = new DataLogger();

        // ── 3. Registrar suscriptores en los eventos de interés ───────────────
        station.subscribe("temperature", mainDisplay);
        station.subscribe("temperature", secondDisplay);
        station.subscribe("temperature", alertSystem);
        station.subscribe("temperature", logger);
        station.subscribe("humidity",    mainDisplay);
        station.subscribe("humidity",    logger);

        // ── 4. Simular cambios en la estación ─────────────────────────────────
        System.out.println("\n═══════════════════════════════════════");
        System.out.println("  Inicio de la simulación meteorológica");
        System.out.println("═══════════════════════════════════════");

        station.setTemperature(22.5);
        station.setHumidity(60.0);
        station.setTemperature(38.1);   // ← supera umbral → AlertSystem reacciona
        station.setHumidity(45.0);

        // ── 5. Desuscribir pantalla secundaria y continuar ─────────────────────
        System.out.println("\n--- Desuscribiendo Pantalla Secundaria de 'temperature' ---");
        station.unsubscribe("temperature", secondDisplay);

        station.setTemperature(40.0);   // secondDisplay ya no recibe este evento

        // ── 6. Mostrar historial del logger ───────────────────────────────────
        System.out.println("\n═══════════════════════════════════════");
        System.out.println("  Historial registrado por DataLogger");
        System.out.println("═══════════════════════════════════════");
        logger.getHistory().forEach(System.out::println);
    }
}