package src;

public class Ship implements Transport {
    @Override
    public String deliver() {
        return "entrega por mar en un barco.";
    }
}