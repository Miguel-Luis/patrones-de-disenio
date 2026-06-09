package creacionales.singleton.tests;
public class ConfiguracionTest {

    public static void main(String[] args) {

        Configuracion config1 = Configuracion.getInstancia();
        Configuracion config2 = Configuracion.getInstancia();

        if (config1 == config2) {
            System.out.println("✅ Test exitoso");
        } else {
            System.out.println("❌ Test fallido");
        }
    }
}
