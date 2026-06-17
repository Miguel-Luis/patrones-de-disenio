package clase;
import abstractas.PrepararComida;
public class Pizza extends PrepararComida {

    @Override
    protected void prepararIngredientes() {
        System.out.println("Preparando masa, salsa de tomate y queso...");
    }

    @Override
    protected void cocinar() {
        System.out.println("Horneando la pizza a 220 grados...");
    }

    @Override
    protected void servir() {
        System.out.println("Cortando la pizza en porciones...");
    }

}
