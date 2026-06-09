// El Memento guarda el contenido del documento en un momento específico
public class Memento {
    private final String contenido;

    public Memento(String contenido) {
        this.contenido = contenido;
    }

    public String getContenido() {
        return contenido;
    }
}
