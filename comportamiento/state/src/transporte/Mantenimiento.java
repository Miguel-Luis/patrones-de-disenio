public class Mantenimiento implements Estado {
    @Override
    public void venderTicket(Ruta ruta, int cantidad) {
        System.out.println("[Mantenimiento] NO PERMITIDO - No se pueden vender tickets mientras el autobús está en mantenimiento.");
    }

    @Override
    public void modificarAsiento(Ruta ruta, int asiento) {
        System.out.println("[Mantenimiento] NO PERMITIDO - No se pueden modificar asientos mientras el autobús está en mantenimiento.");
    }
    
    @Override
    public void iniciarAbordaje(Ruta ruta) {    
        System.out.println("[Mantenimiento] NO PERMITIDO - No se puede iniciar el abordaje mientras el autobús está en mantenimiento.");
    }

    @Override
    public void iniciarViaje(Ruta ruta) {
        System.out.println("[Mantenimiento] NO PERMITIDO - No se puede iniciar un viaje mientras el autobús está en mantenimiento.");
    }

    @Override
    public void ingresarMantenimiento(Ruta ruta) {
        System.out.println("[Mantenimiento] El autobús ya está en mantenimiento.");
    }

    @Override
    public void finalizarMantenimiento(Ruta ruta) {
        System.out.println("Finalizando mantenimiento. Volviendo a estado EnEspera.");
        ruta.setEstado(new EnEspera());
    }

    @Override
    public String getNombre() {
        return "En Mantenimiento";
    }

}
