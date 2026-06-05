public class EnTransito implements Estado {
    @Override
    public void venderTicket(Ruta ruta, int cantidad) {
        System.out.println("[EnTransito] NO PERMITIDO - No se pueden vender tickets mientras el autobús está en tránsito.");
    }

    @Override
    public void modificarAsiento(Ruta ruta, int asiento) {
        System.out.println("[EnTransito] NO PERMITIDO - No se pueden modificar asientos mientras el autobús está en tránsito.");
    }

    @Override
    public void iniciarAbordaje(Ruta ruta) {
        System.out.println("[EnTransito] NO PERMITIDO - No se puede iniciar el abordaje mientras el autobús está en tránsito.");
    }

    @Override
    public void iniciarViaje(Ruta ruta) {
        System.out.println("[EnTransito] El autobús ya está en tránsito.");
    }

    @Override
    public void llegarDestino(Ruta ruta) {  
        System.out.println("El autobús ha llegado a su destino.");
        ruta.setEstado(new EnEspera());
    }

    @Override
    public void ingresarMantenimiento(Ruta ruta) {
        System.out.println("[EnTransito] NO PERMITIDO - No se puede ingresar a mantenimiento mientras el autobús está en tránsito.");
    }

    @Override
    public void finalizarMantenimiento(Ruta ruta) {
        System.out.println("No aplica.");
    }

    @Override
    public String getNombre() {
        return "En Tránsito";
    }

}
