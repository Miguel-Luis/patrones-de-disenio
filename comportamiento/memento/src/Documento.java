// El Originator es el editor de documentos
public class Documento {
    private String contenido;

    public void escribir(String texto) {
        this.contenido = texto;
        System.out.println("Documento actualizado: " + contenido);
    }

    public String leer() {
        return contenido;
    }

    // Guardar el estado actual en un Memento
    public Memento guardar() {
        System.out.println("Guardando versión del documento...");
        return new Memento(contenido);
    }

    // Restaurar el estado desde un Memento
    public void restaurar(Memento m) {
        this.contenido = m.getContenido();
        System.out.println("Documento restaurado: " + contenido);
    }
}
