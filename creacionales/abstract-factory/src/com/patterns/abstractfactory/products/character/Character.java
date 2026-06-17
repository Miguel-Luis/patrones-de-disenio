package com.patterns.abstractfactory.products.character;

/**
 * Producto Abstracto: Character
 *
 * Define el contrato que todos los personajes del juego deben cumplir,
 * independientemente del mundo al que pertenezcan.
 *
 * El cliente interactúa únicamente con esta interfaz, nunca con
 * Knight ni Soldier directamente. Eso es el desacoplamiento que
 * ofrece Abstract Factory.
 */
public interface Character {

    /**
     * Retorna el nombre del personaje.
     */
    String getName();

    /**
     * Ejecuta la acción de ataque del personaje.
     * Cada familia implementa esto de forma diferente.
     */
    void attack();

    /**
     * Ejecuta la acción de defensa del personaje.
     */
    void defend();
}
