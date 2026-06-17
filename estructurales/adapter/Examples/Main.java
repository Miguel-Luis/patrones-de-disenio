

public class Main {
    public static void main(String[] args) {
        // Tenemos un dispositivo con enchufe europeo
        EuropeanPlug europeanDevice = new EuropeanPlug();

        // El cliente espera trabajar con enchufes americanos
        AmericanPlug adaptedDevice = new PlugAdapter(europeanDevice);

        // Conectamos el dispositivo a la toma americana usando el adaptador
        adaptedDevice.connectToAmericanSocket();
    }
}

