package com.patterns.abstractfactory.products.weapon;

/**
 * Producto Concreto: LaserGun
 *
 * Pertenece a la familia Sci-Fi (Futurista).
 * Es el arma compatible con Soldier.
 * Mezclar LaserGun con Knight sería incoherente
 * con el mundo del juego — Abstract Factory lo previene.
 */
public class LaserGun implements Weapon {

    private static final String NAME = "LaserGun";
    private static final int BASE_DAMAGE = 75;

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void use() {
        System.out.println("[LaserGun] Fires a high-energy beam that scorches everything in its path!");
    }

    @Override
    public int getDamage() {
        return BASE_DAMAGE;
    }
}
