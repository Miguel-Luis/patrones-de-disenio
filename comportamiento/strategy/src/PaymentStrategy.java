package src;

public interface PaymentStrategy {
    // El método que todas las estrategias deben implementar
    void pay(int amount);
}