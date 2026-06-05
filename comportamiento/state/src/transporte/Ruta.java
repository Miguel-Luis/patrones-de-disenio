public class Ruta {
    private String nombre;
    private Estado estadoActual;
    private int asientosDisponibles;

    public Ruta(String nombre, int asientos) {
        this.nombre = nombre;
        this.asientosDisponibles = asientos;
        this.estadoActual = new EnEspera(); // estado inicial
    }

    public void setEstado(Estado nuevoEstado) {
        this.estadoActual = nuevoEstado;
        System.out.println("[Ruta " + nombre + "] Cambió a estado: " + nuevoEstado.getNombre());
    }

    public Estado getEstadoActual() {
        return estadoActual;
    }

    public int getAsientosDisponibles() {
        return asientosDisponibles;
    }

    public void setAsientosDisponibles(int asientos) {
        this.asientosDisponibles = asientos;
    }

    public String getNombre() {
        return nombre;
    }

    // Delegación de comportamientos al estado actual
    public void venderTicket(int cantidad) {
        estadoActual.venderTicket(this, cantidad);
    }

    public void modificarAsiento(int asiento) {
        estadoActual.modificarAsiento(this, asiento);
    }

    public void iniciarAbordaje() { 
        estadoActual.iniciarAbordaje(this); 
    }

    public void iniciarViaje() {
        estadoActual.iniciarViaje(this);
    }

    public void ingresarMantenimiento() {
        estadoActual.ingresarMantenimiento(this);
    }

    public void finalizarMantenimiento() {
        estadoActual.finalizarMantenimiento(this);
    }

}