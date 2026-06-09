import java.util.ArrayList;
import java.util.List;


public class Gerente implements Empleado {

    private String nombre;

    private List<Empleado> empleados =
            new ArrayList<>();

    public Gerente(String nombre) {
        this.nombre = nombre;
    }

    public void agregarEmpleado(
            Empleado empleado) {

        empleados.add(empleado);
    }

    @Override
    public void mostrarDetalles() {

        System.out.println(
                "Gerente: " + nombre);

        for (Empleado empleado : empleados) {

            empleado.mostrarDetalles();

        }
    }
}