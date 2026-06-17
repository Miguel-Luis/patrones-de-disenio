public class EnEspera implements Estado {
    @Override
    public void venderTicket(Ruta ruta, int cantidad) {
        if (cantidad <= ruta.getAsientosDisponibles()) {
            ruta.setAsientosDisponibles(ruta.getAsientosDisponibles() - cantidad);
            System.out.println("[EnEspera] Vendió " + cantidad + " ticket(s). Asientos restantes: " + ruta.getAsientosDisponibles());
        } else {
            System.out.println("[EnEspera] No hay suficientes asientos disponibles para vender " + cantidad + " ticket(s).");
        }
    }

    @Override
    public void modificarAsiento(Ruta ruta, int asiento) {
        System.out.println("Modificación de asiento " + asiento + " permitida en estado EnEspera.");
    }

    @Override
    public void iniciarAbordaje(Ruta ruta) {
        System.out.println("Iniciando abordaje...");
        ruta.setEstado(new Abordando());
    }

    @Override
    public void iniciarViaje(Ruta ruta) {
        System.out.println("No se puede iniciar viaje sin antes iniciar el abordaje.");
    }

    @Override
    public void llegarDestino(Ruta ruta) {
        System.out.println("No se puede llegar a destino sin iniciar el viaje.");
    }

    @Override
    public void ingresarMantenimiento(Ruta ruta) {
        System.out.println("Pasando a mantenimiento desde EnEspera.");
        ruta.setEstado(new Mantenimiento());
    }

     @Override
    public void finalizarMantenimiento(Ruta ruta) {
        System.out.println("No estaba en mantenimiento.");
    }
    @Override
    public String getNombre() {
        return "En Espera";
    }

}
