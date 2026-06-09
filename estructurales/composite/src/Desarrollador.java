public class Desarrollador implements Empleado {

    private String nombre;

    public Desarrollador(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println(
                "Desarrollador: " + nombre);
    }
}