package src;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Integer> items = new ArrayList<>();

    public void addItem(int price) {
        this.items.add(price);
    }

    public void checkout(PaymentStrategy paymentMethod) {
        int total = 0;
        for (int price : items) {
            total += price;
        }
        // Delegamos la ejecución del pago a la estrategia que nos pasen
        paymentMethod.pay(total);
    }
}