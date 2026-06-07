package clase;
import abstractas.PrepararComida;
public class Ensalada extends PrepararComida {

    @Override
    protected void prepararIngredientes() {
        System.out.println("Lavando y cortando verduras frescas...");
    }

    @Override
    protected void cocinar() {
        System.out.println("Mezclando los ingredientes en un bol...");
    }

    @Override
    protected void servir() {
        System.out.println("Sirviendo la ensalada en un plato...");
    }

}
