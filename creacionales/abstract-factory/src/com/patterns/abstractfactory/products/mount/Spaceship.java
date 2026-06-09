package com.patterns.abstractfactory.products.mount;

/**
 * Producto Concreto: Spaceship
 *
 * Pertenece a la familia Sci-Fi (Futurista).
 * Es la montura compatible con Soldier y LaserGun.
 */
public class Spaceship implements Mount {

    private static final String NAME = "Spaceship";
    private static final int BASE_SPEED = 120;

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void move() {
        System.out.println("[Spaceship] Engages hyperdrive and tears through the void at warp speed.");
    }

    @Override
    public int getSpeed() {
        return BASE_SPEED;
    }
}
