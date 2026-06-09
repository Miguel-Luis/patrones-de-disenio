public class Main {
    public static void main(String[] args) {
        Librero miLibrero = new Librero();

        miLibrero.agregarLibro(new Libro("Cien años de Soledad"));
        miLibrero.agregarLibro(new Libro("Don Quijote de la Mancha"));
        miLibrero.agregarLibro(new Libro("El Amor en los Tiempos del Cólera"));
        
        Iterador asistente = miLibrero.crearIterador();

        System.out.println("Recorrriendo el Librero");

        //El ciclo se ejecuta mientras el asistente diga que qeudan libros por leer

        while(asistente.hasSigue()){
            Libro libroActual = asistente.getSigue();
            System.out.println("Libro: " + libroActual.getTitulo());
        }
    }
}
