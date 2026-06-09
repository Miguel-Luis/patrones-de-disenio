package Demo;

import handlers.Handler;
import handlers.LevelOneSupport;
import handlers.LevelTwoSupport;
import handlers.Manager;
import model.Request;

public class Demo {

    public static void main(String[] args) {

        Handler levelOne = new LevelOneSupport();
        Handler levelTwo = new LevelTwoSupport();
        Handler manager = new Manager();

        levelOne.setNextHandler(levelTwo);
        levelTwo.setNextHandler(manager);

        System.out.println("Solicitud de prioridad BAJA:");
        levelOne.handleRequest(new Request("baja"));

        System.out.println();

        System.out.println("Solicitud de prioridad MEDIA:");
        levelOne.handleRequest(new Request("media"));

        System.out.println();

        System.out.println("Solicitud de prioridad ALTA:");
        levelOne.handleRequest(new Request("alta"));
    }
}