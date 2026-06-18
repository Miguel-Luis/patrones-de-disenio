import abstractas.PrepararComida;
import clase.Ensalada;  
import clase.Hamburguesa;
import clase.Pizza;
public class Main {

    public static void main(String[] args) {
        PrepararComida comida1 = new Hamburguesa();
        comida1.prepararPlato();

        System.out.println("----------------");

        PrepararComida comida2 = new Pizza();
        comida2.prepararPlato();

        System.out.println("----------------");

        PrepararComida comida3 = new Ensalada();
        comida3.prepararPlato();
    }
}
