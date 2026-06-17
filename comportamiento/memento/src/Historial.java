import java.util.ArrayList;
import java.util.List;

// El Caretaker administra los mementos (versiones del documento)
public class Historial {
    private final List<Memento> versiones = new ArrayList<>();

    public void agregar(Memento m) {
        versiones.add(m);
    }

    public Memento obtener(int indice) {
        return versiones.get(indice);
    }

    public int totalVersiones() {
        return versiones.size();
    }
}

