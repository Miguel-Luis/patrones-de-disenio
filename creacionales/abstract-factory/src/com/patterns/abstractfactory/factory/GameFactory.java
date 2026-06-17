package com.patterns.abstractfactory.factory;

import com.patterns.abstractfactory.products.character.Character;
import com.patterns.abstractfactory.products.weapon.Weapon;
import com.patterns.abstractfactory.products.mount.Mount;

/**
 * Abstract Factory: GameFactory
 *
 * Es el corazón del patrón. Declara los métodos de creación
 * para cada producto abstracto de la familia.
 *
 * REGLA CLAVE: ningún método retorna una clase concreta.
 * Todos retornan interfaces (Character, Weapon, Mount).
 * Esto garantiza que el cliente nunca depende de detalles
 * de implementación — solo de contratos abstractos.
 *
 * Cada fábrica concreta implementa esta interfaz
 * y produce una familia coherente de objetos.
 */
public interface GameFactory {

    /**
     * Crea el personaje correspondiente a esta familia.
     */
    Character createCharacter();

    /**
     * Crea el arma correspondiente a esta familia.
     */
    Weapon createWeapon();

    /**
     * Crea la montura correspondiente a esta familia.
     */
    Mount createMount();
}
