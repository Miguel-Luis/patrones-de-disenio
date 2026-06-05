public interface Estado {
    void venderTicket(Ruta ruta, int cantidad);
    void iniciarAbordaje(Ruta ruta);
    void modificarAsiento(Ruta ruta, int asiento);
    void iniciarViaje(Ruta ruta);
    void ingresarMantenimiento(Ruta ruta);
    void finalizarMantenimiento(Ruta ruta);
    String getNombre();

}
