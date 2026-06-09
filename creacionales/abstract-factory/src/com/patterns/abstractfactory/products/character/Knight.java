package com.patterns.abstractfactory.products.character;

/**
 * Producto Concreto: Knight
 *
 * Pertenece a la familia Medieval.
 * Implementa el contrato de Character con comportamiento
 * propio del mundo medieval.
 *
 * El cliente NUNCA instancia esta clase directamente.
 * La crea MedievalFactory y la retorna como Character.
 */
public class Knight implements Character {

    private static final String NAME = "Knight";

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void attack() {
        System.out.println("[Knight] Charges forward with a battle cry, swinging his sword!");
    }

    @Override
    public void defend() {
        System.out.println("[Knight] Raises his iron shield to block the incoming blow.");
    }
}
