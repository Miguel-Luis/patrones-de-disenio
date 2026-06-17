package com.patterns.abstractfactory.products.character;

/**
 * Producto Concreto: Soldier
 *
 * Pertenece a la familia Sci-Fi (Futurista).
 * Implementa el contrato de Character con comportamiento
 * propio del mundo ciencia ficción.
 *
 * El cliente NUNCA instancia esta clase directamente.
 * La crea SciFiFactory y la retorna como Character.
 */
public class Soldier implements Character {

    private static final String NAME = "Soldier";

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void attack() {
        System.out.println("[Soldier] Fires a burst of plasma rounds from cover!");
    }

    @Override
    public void defend() {
        System.out.println("[Soldier] Activates the energy barrier on his exo-suit.");
    }
}
