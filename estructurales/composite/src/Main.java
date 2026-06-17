
public class Main {

    public static void main(String[] args) {

        Empleado dev1 =
                new Desarrollador("Juan");

        Empleado dev2 =
                new Desarrollador("Pedro");

        Gerente gerente =
                new Gerente("Carlos");

        gerente.agregarEmpleado(dev1);
        gerente.agregarEmpleado(dev2);

        gerente.mostrarDetalles();
    }
}