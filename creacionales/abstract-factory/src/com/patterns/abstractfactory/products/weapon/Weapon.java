package com.patterns.abstractfactory.products.weapon;

/**
 * Producto Abstracto: Weapon
 *
 * Define el contrato que todas las armas deben cumplir.
 * Un Character usa una Weapon, pero ninguno de los dos
 * conoce las clases concretas del otro.
 *
 * Esto garantiza que los productos de la misma familia
 * son siempre compatibles entre sí.
 */
public interface Weapon {

    /**
     * Retorna el nombre del arma.
     */
    String getName();

    /**
     * Ejecuta el uso del arma en combate.
     */
    void use();

    /**
     * Retorna el nivel de daño base del arma.
     */
    int getDamage();
}
