// El Adapter permite que un enchufe europeo se use en una toma americana
public class PlugAdapter implements AmericanPlug {
    private EuropeanPlug europeanPlug;

    // Recibimos el enchufe europeo que queremos adaptar
    public PlugAdapter(EuropeanPlug europeanPlug) {
        this.europeanPlug = europeanPlug;
    }
    @Override
    public void connectToAmericanSocket() {
        // Aquí hacemos la "traducción" de la conexión
        System.out.println("Usando adaptador para convertir enchufe europeo a americano...");
        europeanPlug.connectToEuropeanSocket();
        System.out.println("El dispositivo ahora funciona en una toma americana (110V, clavijas planas).");
    }
}
