package src;

public class Truck implements Transport {
    @Override
    public String deliver() {
        return "entrega por tierra en un camión.";
    }
}