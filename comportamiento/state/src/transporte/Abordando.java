public class Abordando implements Estado {
    @Override
    public void venderTicket(Ruta ruta, int cantidad) {
        if (ruta.getAsientosDisponibles() >= cantidad) {
            ruta.setAsientosDisponibles(ruta.getAsientosDisponibles() - cantidad);
            System.out.println("Venta de últimos tickets (" + cantidad + ") durante abordaje. Quedan " + ruta.getAsientosDisponibles());
        } else {
            System.out.println("No hay asientos libres para venta de última hora.");
        }
    }


     @Override
    public void modificarAsiento(Ruta ruta, int asiento) {
        System.out.println("Modificación de asiento " + asiento + " permitida en Abordando.");
    }

    @Override
    public void iniciarAbordaje(Ruta ruta) {
        System.out.println("Ya se está abordando.");
    }

    @Override
    public void iniciarViaje(Ruta ruta) {
        System.out.println("El autobús parte ahora...");
        ruta.setEstado(new EnTransito());
    }

    @Override
    public void llegarDestino(Ruta ruta) {
        System.out.println("No se puede llegar a destino sin iniciar el viaje.");
    }

    @Override
    public void ingresarMantenimiento(Ruta ruta) {
        System.out.println("[Abordando] No se puede ingresar a mantenimiento mientras se está abordando.");
    }

    @Override
    public void finalizarMantenimiento(Ruta ruta) {
        System.out.println("No aplica.");
    }

    @Override
    public String getNombre() {
        return "Abordando";
    }

}
