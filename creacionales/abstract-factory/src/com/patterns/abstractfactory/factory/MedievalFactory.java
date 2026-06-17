package com.patterns.abstractfactory.factory;

import com.patterns.abstractfactory.products.character.Character;
import com.patterns.abstractfactory.products.character.Knight;
import com.patterns.abstractfactory.products.weapon.Weapon;
import com.patterns.abstractfactory.products.weapon.Sword;
import com.patterns.abstractfactory.products.mount.Mount;
import com.patterns.abstractfactory.products.mount.Horse;

/**
 * Fábrica Concreta: MedievalFactory
 *
 * Produce exclusivamente objetos de la familia Medieval:
 * Knight + Sword + Horse.
 *
 * Garantiza que todos los productos creados son
 * compatibles entre sí — tienen sentido juntos dentro
 * del mundo medieval del juego.
 *
 * NOTA: los métodos retornan los tipos abstractos
 * (Character, Weapon, Mount), aunque internamente
 * instancian las clases concretas. El cliente
 * recibe interfaces, no implementaciones.
 */
public class MedievalFactory implements GameFactory {

    @Override
    public Character createCharacter() {
        return new Knight();
    }

    @Override
    public Weapon createWeapon() {
        return new Sword();
    }

    @Override
    public Mount createMount() {
        return new Horse();
    }
}
