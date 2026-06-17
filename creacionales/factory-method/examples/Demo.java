package examples;

import src.*;

public class Demo {
    public static void main(String[] args) {
        Logistics logistics;

        System.out.println("--- Probando con Logística Terrestre ---");
        logistics = new RoadLogistics();
        clientCode(logistics);

        System.out.println("\n--- Probando con Logística Marítima ---");
        logistics = new SeaLogistics();
        clientCode(logistics);
    }

    static void clientCode(Logistics logistics) {
        System.out.println(logistics.planDelivery());
    }
}
