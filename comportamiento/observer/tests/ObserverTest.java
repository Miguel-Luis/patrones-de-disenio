package tests;

import src.DataLogger;
import src.WeatherStation;

/**
 * Pruebas manuales del patrón Observer.
 * No requieren frameworks externos; cada prueba imprime PASS / FAIL.
 *
 * Ejecutar:
 *   javac -d out src/*.java tests/*.java
 *   java  -cp out tests.ObserverTest
 */
public class ObserverTest {

    private static int passed = 0;
    private static int failed = 0;

    public static void main(String[] args) {
        testSuscriptorRecibeNotificacion();
        testDesuscripcionDetieneLasNotificaciones();
        testVariosEventosIndependientes();
        testMultiplesSuscriptores();

        System.out.println("\n══════════════════════════════");
        System.out.printf("  Resultado: %d ✅  |  %d ❌%n", passed, failed);
        System.out.println("══════════════════════════════");
    }

    // ── Pruebas ────────────────────────────────────────────────────────────────

    static void testSuscriptorRecibeNotificacion() {
        DataLogger logger = new DataLogger();
        WeatherStation station = new WeatherStation();
        station.subscribe("temperature", logger);

        station.setTemperature(25.0);

        assertTrue("El logger debe tener 1 registro",
                logger.getHistory().size() == 1);
        assertTrue("El registro debe contener el valor correcto",
                logger.getHistory().get(0).contains("25.0"));
    }

    static void testDesuscripcionDetieneLasNotificaciones() {
        DataLogger logger = new DataLogger();
        WeatherStation station = new WeatherStation();
        station.subscribe("temperature", logger);

        station.setTemperature(20.0);
        station.unsubscribe("temperature", logger);
        station.setTemperature(30.0);   // logger ya no debe recibir esto

        assertTrue("Después de desuscribirse, el logger debe tener solo 1 registro",
                logger.getHistory().size() == 1);
    }

    static void testVariosEventosIndependientes() {
        DataLogger logger = new DataLogger();
        WeatherStation station = new WeatherStation();
        station.subscribe("temperature", logger);
        // logger NO está suscrito a "humidity"

        station.setTemperature(22.0);
        station.setHumidity(55.0);

        assertTrue("El logger solo debe registrar eventos de temperatura",
                logger.getHistory().size() == 1);
    }

    static void testMultiplesSuscriptores() {
        DataLogger logger1 = new DataLogger();
        DataLogger logger2 = new DataLogger();
        WeatherStation station = new WeatherStation();
        station.subscribe("temperature", logger1);
        station.subscribe("temperature", logger2);

        station.setTemperature(18.0);

        assertTrue("Ambos loggers deben recibir la notificación",
                logger1.getHistory().size() == 1 && logger2.getHistory().size() == 1);
    }

    // ── Utilidad ───────────────────────────────────────────────────────────────

    static void assertTrue(String description, boolean condition) {
        if (condition) {
            System.out.println("  ✅ PASS: " + description);
            passed++;
        } else {
            System.out.println("  ❌ FAIL: " + description);
            failed++;
        }
    }
}