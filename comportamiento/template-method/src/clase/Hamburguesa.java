package clase;

import abstractas.PrepararComida;

public class Hamburguesa extends PrepararComida {

    @Override
    protected void prepararIngredientes() {
        System.out.println("Preparando pan, carne, lechuga y tomate...");
    }

    @Override
    protected void cocinar() {
        System.out.println("Cocinando la carne en la parrilla...");
    }

    @Override
    protected void servir() {
        System.out.println("Armando la hamburguesa en el pan...");
    }

    @Override
    protected void AgregarExtras() {
        System.out.println("Agregando papas fritas como acompañamiento...");
    }
}
