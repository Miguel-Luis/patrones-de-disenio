package src;

public abstract class Logistics {
    // El Factory Method que las subclases implementarán
    public abstract Transport createTransport();

    public String planDelivery() {
        // Se usa el factory method para obtener el transporte
        Transport transport = createTransport();
        return "Logística: Se ha iniciado la " + transport.deliver();
    }
}