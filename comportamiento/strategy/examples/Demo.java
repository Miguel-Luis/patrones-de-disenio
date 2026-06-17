package examples;

import src.*;

public class Demo {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Agregamos productos ficticios
        cart.addItem(150);
        cart.addItem(200);

        System.out.println("--- Escenario 1: Pago con Tarjeta ---");
        // El cliente elige pagar con tarjeta
        cart.checkout(new CreditCardPayment("Juan Perez", "1234-5678-9012"));

        System.out.println("\n--- Escenario 2: Pago con PayPal ---");
        // El cliente cambia de opinión y elige PayPal
        // El carrito (contexto) no necesita ser modificado para aceptar un nuevo método
        cart.checkout(new PayPalPayment("juan.perez@example.com"));
    }
}