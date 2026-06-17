public class Logistica {
    public static void main(String[] args) {
        Ruta rutaBarcelona = new Ruta("Barcelona-Valencia", 20);

        System.out.println("Estado inicial: " + rutaBarcelona.getEstadoActual().getNombre());
        rutaBarcelona.venderTicket(5);
        rutaBarcelona.modificarAsiento(3);

        System.out.println("\nIntentando iniciar viaje sin abordar");
        rutaBarcelona.iniciarViaje();

        System.out.println("\nIniciando abordaje");
        rutaBarcelona.iniciarAbordaje();

        System.out.println("\nIntentando vender tickets durante el abordaje:");
        rutaBarcelona.venderTicket(3);

        System.out.println("\nIntentando ingresar a mantenimiento durante el abordaje:");
        rutaBarcelona.ingresarMantenimiento();

        System.out.println("\nIniciando viaje");
        rutaBarcelona.iniciarViaje();
        
        System.out.println("\nIntentando modificar asiento durante el viaje");
        rutaBarcelona.modificarAsiento(2);

        System.out.println("\nIntentando vender tickets durante el viaje");
        rutaBarcelona.venderTicket(2);

        System.out.println("\nIntentando ingresar a mantenimiento durante el viaje");
        rutaBarcelona.ingresarMantenimiento();

        System.out.println("\nFinalizando viaje y volviendo a EnEspera");
        System.out.println("\nFinalizando viaje...");   
        rutaBarcelona.llegarDestino();
        

    }

}
