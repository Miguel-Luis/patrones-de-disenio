package src;

public class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + " pagados usando PayPal.");
        System.out.println("Cuenta: " + email + " [Redirigiendo a PayPal...]");
    }
}