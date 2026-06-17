package src;

public class CreditCardPayment implements PaymentStrategy {
    private String name;
    private String cardNumber;

    public CreditCardPayment(String name, String cardNumber) {
        this.name = name;
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + " pagados con tarjeta de crédito.");
        System.out.println("Titular: " + name + " [Cerrando transacción...]");
    }
}