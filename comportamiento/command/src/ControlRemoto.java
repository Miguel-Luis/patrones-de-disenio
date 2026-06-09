import java.util.Stack;

//Emisor (Invocador): Control Remoto
public class ControlRemoto {
    private Comando comandoActual;
    private Stack<Comando> historial;  // pila para deshacer
    
    public ControlRemoto() {
        historial = new Stack<>();
    }
    
    public void asignarComando(Comando comando) {
        this.comandoActual = comando;
    }
    
    public void presionarBoton() {
        if (comandoActual != null) {
            comandoActual.ejecutar();
            historial.push(comandoActual);
        }
    }
    
    public void presionarDeshacer() {
        if (!historial.isEmpty()) {
            Comando ultimoComando = historial.pop();
            System.out.println("Deshaciendo última acción");
            ultimoComando.deshacer();            
        } else {
            System.out.println("No hay acciones para deshacer");
        }
    }
}
