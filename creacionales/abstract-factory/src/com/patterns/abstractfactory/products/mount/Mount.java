package com.patterns.abstractfactory.products.mount;

/**
 * Producto Abstracto: Mount
 *
 * Tercer miembro de cada familia de productos.
 * Su inclusión refuerza el concepto central del patrón:
 * Abstract Factory no crea un solo objeto, crea una
 * FAMILIA de objetos relacionados y compatibles entre sí.
 *
 * Un Knight monta un Horse. Un Soldier pilota un Spaceship.
 * Ambos implementan Mount — el cliente los usa igual.
 */
public interface Mount {

    /**
     * Retorna el nombre de la montura.
     */
    String getName();

    /**
     * Ejecuta el desplazamiento de la montura.
     */
    void move();

    /**
     * Retorna la velocidad base de la montura.
     */
    int getSpeed();
}
