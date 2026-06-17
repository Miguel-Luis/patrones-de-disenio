
import handlers.Handler;
import handlers.LevelOneSupport;
import handlers.LevelTwoSupport;
import handlers.Manager;
import model.Request;

/*
 * Prueba básica del patrón Chain of Responsibility.
 *
 * Se verifican los tres casos:
 * - Prioridad baja
 * - Prioridad media
 * - Prioridad alta
 *
 * Cada solicitud debe ser atendida por el responsable
 * correspondiente dentro de la cadena.
 */

public class TestChainOfResponsibility {

    public static void main(String[] args) {

        Handler levelOne = new LevelOneSupport();
        Handler levelTwo = new LevelTwoSupport();
        Handler manager = new Manager();

        levelOne.setNextHandler(levelTwo);
        levelTwo.setNextHandler(manager);

        System.out.println("=== PRUEBA PRIORIDAD BAJA ===");
        levelOne.handleRequest(new Request("baja"));

        System.out.println();

        System.out.println("=== PRUEBA PRIORIDAD MEDIA ===");
        levelOne.handleRequest(new Request("media"));

        System.out.println();

        System.out.println("=== PRUEBA PRIORIDAD ALTA ===");
        levelOne.handleRequest(new Request("alta"));
    }
}
