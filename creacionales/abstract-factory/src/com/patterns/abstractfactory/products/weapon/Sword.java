package com.patterns.abstractfactory.products.weapon;

/**
 * Producto Concreto: Sword
 *
 * Pertenece a la familia Medieval.
 * Es el arma compatible con Knight.
 * Mezclar Sword con Soldier (familia SciFi) sería
 * un error de dominio — Abstract Factory lo previene.
 */
public class Sword implements Weapon {

    private static final String NAME = "Sword";
    private static final int BASE_DAMAGE = 45;

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void use() {
        System.out.println("[Sword] Slashes through the air with a sharp metallic ring!");
    }

    @Override
    public int getDamage() {
        return BASE_DAMAGE;
    }
}
