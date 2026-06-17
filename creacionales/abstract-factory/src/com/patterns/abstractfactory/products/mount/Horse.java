package com.patterns.abstractfactory.products.mount;

/**
 * Producto Concreto: Horse
 *
 * Pertenece a la familia Medieval.
 * Es la montura compatible con Knight y Sword.
 */
public class Horse implements Mount {

    private static final String NAME = "Horse";
    private static final int BASE_SPEED = 30;

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void move() {
        System.out.println("[Horse] Gallops across the battlefield, hooves thundering on the ground.");
    }

    @Override
    public int getSpeed() {
        return BASE_SPEED;
    }
}
