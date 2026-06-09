package creacionales.singleton.examples;
import Src.Configuracion;
public class Demo {

    public static void main(String[] args) {

        System.out.println("Módulo de Autenticación");

        Configuracion config1 = Configuracion.getInstancia();
        config1.mostrarMensaje();

        System.out.println("\nMódulo de Reportes");

        Configuracion config2 = Configuracion.getInstancia();
        config2.mostrarMensaje();

        System.out.println("\n¿Ambas referencias son iguales?");
        System.out.println(config1 == config2);
    }
}
